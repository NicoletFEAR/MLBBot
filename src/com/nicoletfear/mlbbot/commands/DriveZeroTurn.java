/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nicoletfear.mlbbot.commands;

import com.nicoletfear.mlbbot.xbox.Axes;

/**
 *
 * @author fear
 */
public class DriveZeroTurn extends CommandBase {
    
    public DriveZeroTurn() {
        requires(driveTrain);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double rightWheel = oi.driveStick.getRawAxis(Axes.RightControlStickY);
        
        double leftWheel = oi.driveStick.getRawAxis(Axes.leftControlStickY);
        
        driveTrain.driveWheelsZeroTurn(leftWheel, rightWheel);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
