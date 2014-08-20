/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nicoletfear.mlbbot.subsystems;

import com.nicoletfear.mlbbot.RobotMap;
import com.nicoletfear.mlbbot.Velocities;
import com.nicoletfear.mlbbot.commands.Drive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 *
 * @author fear
 */
public class DriveTrain extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private SpeedController rightWheel;
    private SpeedController leftWheel;  
    
    public DriveTrain(){
        leftWheel = new Victor(RobotMap.leftWheelPort);
        rightWheel = new Victor(RobotMap.rightWheelPort);
    }
    public void initDefaultCommand() {
    setDefaultCommand(new Drive());       
// Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void driveWheelsZeroTurn(double left, double right){
       Velocities newVelocities = calculateNewVelocityAndAccountForDeadzone(left, right);
       Velocities correctedTurn = correctForTurningZeroTurn(newVelocities); 
        outputToWheels(correctedTurn);
    }
    
    public void driveWheels(double left, double right) {
        Velocities newVelocities = calculateNewVelocityAndAccountForDeadzone(left, right);
        Velocities correctedTurn = correctForTurning(newVelocities);
        outputToWheels(correctedTurn);
    }

    private void outputToWheels(Velocities correctedTurn) {
        rightWheel.set(-correctedTurn.getRightVelocity());
        leftWheel.set(correctedTurn.getLeftVelocity());
        System.out.println(correctedTurn.getLeftVelocity() + "," + correctedTurn.getRightVelocity());
    }

    private Velocities calculateNewVelocityAndAccountForDeadzone(double left, double right) {
        double lastRight = rightWheel.get();
        right = zeroWithinDeadzone(right);
        double newVeloRight = calculateNewVelocity(right, lastRight);
        double lastLeft = -leftWheel.get();//undo negatives from setting motors
        left = zeroWithinDeadzone(left);
        double newVeloLeft = calculateNewVelocity(left, lastLeft);
        Velocities newVelocities = new Velocities(-newVeloLeft, -newVeloRight);//wheels would run backwards without negative.
        return newVelocities;
    }
    
       
    /**
     * Returns 0 when value is within deadzone, otherwise returns the value.
     * @param value The value to check.
     * @return 0 when value is within deadzone, otherwise returns the value.
     */
    private double zeroWithinDeadzone(double value) {
        final double deadzone = .04;
        if(Math.abs(value) < deadzone) return 0;
        else return value;
    }

    /**
     * makes sure we don't go over a max accel so we dont rip up grass.
     * @param joyStick -the acceleration speed increase
     * @param last -the last recored speed increase
     * @return the new velocity
     */
    private double calculateNewVelocity(double joyStick, double last) {
        double maxAcc = SmartDashboard.getNumber("maxAcc");
        //double maxDecel = SmartDashboard.getNumber("maxDecel");
        double maxDecel = 0.1;
        double change = joyStick - last;
        double newVelo = 0.0;
        
        if (change <= 0 &&  joyStick > 0)
        {
            newVelo = last - maxDecel;//decel forward <- fast acel
        }
        else if (change <= 0 & joyStick < 0)
        {
            newVelo = last - maxAcc;//Accel back <- slow accel
        }
        else if (change >= 0 & joyStick > 0)
        {
            newVelo = last + maxAcc;//Accel foward <- slow accel
        }
        else if (change >= 0 & joyStick < 0)
        {
            newVelo = last + maxDecel;//decel back <- fast accel
        }
        else{
            newVelo = last + change;
        } return newVelo;
        
    }
   
    /**
     * The two velocities decides which direction the robot moves
     * @param leftVelocity
     * @param rightVelocity
     * @return returns the NewVelocities by keeping one the same and replacing the other with a min value.
     */
    private Velocities correctForTurningZeroTurn(Velocities velocities) {
       double leftVelocity = velocities.getLeftVelocity();
       double rightVelocity = velocities.getRightVelocity();
       double min = SmartDashboard.getNumber("minVelocity");
       if (leftVelocity > 0 && rightVelocity <= 0) {
          return new Velocities (leftVelocity, /* rightVelocity */ min);
       }
       else if (leftVelocity <= 0 && rightVelocity > 0) {
          return new Velocities (/* leftVelocity */ min, rightVelocity); 
       }
       else if (leftVelocity == 0 && rightVelocity < 0) {
           return new Velocities(/* leftVelocity */ -min, rightVelocity);
       }
       else if (leftVelocity < 0 && rightVelocity == 0) {
           return new Velocities(leftVelocity, /* rightVelocity */ -min);
       }
       else {
           return new Velocities(leftVelocity, rightVelocity); 
       }
    }
    private Velocities correctForTurning (Velocities velocities) {
        double maxDiff = SmartDashboard.getNumber("SpeedControl");
       double leftVelocity = velocities.getLeftVelocity();
       double rightVelocity = velocities.getRightVelocity();
        if(leftVelocity > 0 || rightVelocity > 0) {
            if (maxDiff < leftVelocity - rightVelocity )
            {
            return new Velocities (leftVelocity, leftVelocity - maxDiff);

            }
            else if (maxDiff < rightVelocity - leftVelocity )
            {
                return new Velocities (rightVelocity - maxDiff, rightVelocity);
            }
            else
            {
                return new Velocities(leftVelocity, rightVelocity); 
            }
        }
        else {
            if (maxDiff < leftVelocity - rightVelocity )
            {
                return new Velocities(rightVelocity + maxDiff, rightVelocity); 
            }
            else if (maxDiff < rightVelocity - leftVelocity )
            {
                return new Velocities(leftVelocity, leftVelocity + maxDiff); 
            }
            else
            {
                return new Velocities(leftVelocity, rightVelocity); 
            }
        }
    }
}
