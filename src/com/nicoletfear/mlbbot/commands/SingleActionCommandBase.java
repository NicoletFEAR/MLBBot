/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nicoletfear.mlbbot.commands;

/**
 * Base class for commands that do one action and are then done.  To use, derive from this class and implement the doAction() method to do the action that needs to be done once.
 * @author fear
 */
public abstract class SingleActionCommandBase extends CommandBase {
    private boolean executed = false;

    // Called just before this Command runs the first time
    protected void initialize() {
        executed = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        doAction();
        executed = true;
    }
    
    protected abstract void doAction();

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return executed;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
