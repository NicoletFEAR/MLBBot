/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nicoletfear.mlbbot.commands;

/**
 *
 * @author FEAR
 */
public class LoadBall extends CommandBase {
    
    public LoadBall() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(ballShooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        ballShooter.load();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
       ballShooter.disengageLoader();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
