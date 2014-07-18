/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nicoletfear.mlbbot.commands;

import com.nicoletfear.mlbbot.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;

/**
 *
 * @author FEAR
 */
public class LoadBall extends CommandBase {
    private DigitalInput limitSwitch;
    public LoadBall() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(ballShooter);
        limitSwitch = new DigitalInput(RobotMap.ballShooterLimitSwitch);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        ballShooter.engageClutch();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        ballShooter.runMotor(1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return limitSwitch.get() == true;
    }

    // Called once after isFinished returns true
    protected void end() {
        ballShooter.stopMotor();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
