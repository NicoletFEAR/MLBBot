/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nicoletfear.mlbbot.commands;

/**
 *
 * @author fear
 */
public class TurnShootingLightsOff extends SingleActionCommandBase {
    
    public TurnShootingLightsOff() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(lights);
    }

    protected void doAction() {
        lights.turnOffShootingLights();
    }
}
