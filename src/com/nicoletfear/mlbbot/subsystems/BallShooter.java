/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nicoletfear.mlbbot.subsystems;

import com.nicoletfear.mlbbot.RobotMap;
import com.nicoletfear.mlbbot.commands.EngageClutch;
import edu.wpi.first.wpilibj.Relay;
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
    private Relay relayClutch = new Relay(RobotMap.clutchRelayPort);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new EngageClutch());
    }
    
    public void fire(){
        relayClutch.set(Relay.Value.kOff);
    }
    public void load(){
        solenoidLoad.set(true);
    }
    public void engageClutch(){
        relayClutch.set(Relay.Value.kForward);
    }
}
