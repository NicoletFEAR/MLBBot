/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nicoletfear.mlbbot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.nicoletfear.mlbbot.commands.Drive;
/**
 *
 * @author fear
 */
public class DriveTrain extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    setDefaultCommand(new Drive());       
// Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
