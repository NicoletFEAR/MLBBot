/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nicoletfear.mlbbot.subsystems;

import com.nicoletfear.mlbbot.RobotMap;
import com.nicoletfear.mlbbot.commands.TurnOnRunningLights;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author fear
 */
public class Lights extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private Relay ready = new Relay(RobotMap.lightsModule, RobotMap.readyRelay, Relay.Direction.kForward);
    private Relay aim = new Relay(RobotMap.lightsModule, RobotMap.aimRelay, Relay.Direction.kForward);
    private Relay fire = new Relay(RobotMap.lightsModule, RobotMap.fireRelay, Relay.Direction.kForward);
    private Relay runningLights = new Relay(RobotMap.lightsModule, RobotMap.runningLightsRelay, Relay.Direction.kForward);
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new TurnOnRunningLights());
    }
    public void turnReadyLightsOn()
    {
        ready.set(Relay.Value.kOn);
    }
    public void turnAimLightsOn()
    {
        aim.set(Relay.Value.kOn);
    }
    public void turnFireLightsOn()
    {
        fire.set(Relay.Value.kOn);
    }
    public void turnRunningLightsOn()
    {
        runningLights.set(Relay.Value.kOn);
    }
    public void turnOffShootingLights()
    {
        ready.set(Relay.Value.kOff);
        aim.set(Relay.Value.kOff);
        fire.set(Relay.Value.kOff);
    }
}
