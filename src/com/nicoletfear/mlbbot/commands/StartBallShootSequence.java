/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nicoletfear.mlbbot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 * @author FEAR
 */
public class StartBallShootSequence extends CommandGroup {
    
    public StartBallShootSequence() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.
        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
        addSequential(new TurnOnReadyLights());
        addSequential(new WaitCommand(1));
        addSequential(new TurnOnAimLights());
        addSequential(new WaitCommand(1));
        addParallel(new TurnOnFireLights());
        addSequential(new ShootBall());
        addSequential(new TurnShootingLightsOff());
    }
}
