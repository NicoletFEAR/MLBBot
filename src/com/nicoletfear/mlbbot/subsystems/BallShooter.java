/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nicoletfear.mlbbot.subsystems;

import com.nicoletfear.mlbbot.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author FEAR
 */
public class BallShooter extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private Solenoid solenoidLoad = new Solenoid(RobotMap.loadSolenoidPort);
    private Solenoid solenoidClutch = new Solenoid(RobotMap.clutchSolenoidPort);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void fire(){
        solenoidClutch.set(true);
    }
    public void load(){
        solenoidLoad.set(true);
    }
}
