package com.nicoletfear.mlbbot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.nicoletfear.mlbbot.OI;
import com.nicoletfear.mlbbot.subsystems.*;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author Author
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    // Create a single static instance of all of your subsystems
    public static ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
    public static DriveTrain driveTrain = new DriveTrain();
    public static BallShooter ballShooter = new BallShooter();
    public static Lights lights = new Lights();
    
    public static void init() {
        // This MUST be here. If the OI creates Commands (which it vy likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();

        // Show what command your subsystem is running on the SmartDashboard
        SmartDashboard.putData(exampleSubsystem);
        SmartDashboard.putData(driveTrain);
        SmartDashboard.putData(ballShooter);
        SmartDashboard.putData(lights);
        SmartDashboard.putData(new TurnOnAimLights());
        SmartDashboard.putData(new TurnOnFireLights());
        SmartDashboard.putData(new TurnOnReadyLights());
        SmartDashboard.putData(new TurnShootingLightsOff());
        SmartDashboard.putData(new StartBallShootSequence());
        SmartDashboard.putData(new LoadBall());
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
