/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nicoletfear.mlbbot.subsystems;

import com.nicoletfear.mlbbot.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author FEAR
 */
public class BallShooter extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
	private SpeedController chargingMotor;
	private Solenoid disengageClutchSolenoid;
	private Solenoid engageClutchSolenoid;
    
	public BallShooter(){
            chargingMotor = new Victor(RobotMap.chargingMotorPort);
            disengageClutchSolenoid = new Solenoid(RobotMap.disengageSolenoidPort);
            engageClutchSolenoid = new Solenoid(RobotMap.engageSoleniodPort);
        }
	public void runMotor(float speed){
            speed = Math.abs(speed);
            chargingMotor.set(-speed);
        }
	public void stopMotor(){
            chargingMotor.set(0);
        }
	public void releaseClutch(){
            disengageClutchSolenoid.set(true);
            engageClutchSolenoid.set(false);
        }
	public void engageClutch(){
            disengageClutchSolenoid.set(false);
            engageClutchSolenoid.set(true);
        }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
