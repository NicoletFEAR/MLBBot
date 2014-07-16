/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nicoletfear.mlbbot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.nicoletfear.mlbbot.commands.Drive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
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
        leftWheel = new Victor(1);
        rightWheel = new Victor(2);
    }
    public void initDefaultCommand() {
    setDefaultCommand(new Drive());       
// Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void driveWheels(double left, double right){
       double lastRight = -rightWheel.get();//undo negatives from setting motors
        double newVelo = calculateNewVelocity(right, lastRight);
      
       rightWheel.set(-newVelo);
       double lastLeft = -leftWheel.get();
        newVelo = calculateNewVelocity(left, lastLeft);
       leftWheel.set(-newVelo);//wheels would run backwards without negative.
       System.out.println(lastLeft + "," + newVelo);
    }

    /**
     * makes sure we don't go over a max accel so we dont rip up grass.
     * @param joyStick -the acceleration speed increase
     * @param last -the last recored speed increase
     * @return the new velocity
     */
    private double calculateNewVelocity(double joyStick, double last) {
        double maxAcc = 0.1;
        double change = joyStick - last;
        double newVelo = 0.0;
        if (change <= -maxAcc){
            newVelo = last -maxAcc;
        }
        else if (change >= maxAcc){
            newVelo = last +maxAcc;
        }
        else{
            newVelo = last + change;
        } return newVelo;
    }
   
    
}
