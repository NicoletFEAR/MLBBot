/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nicoletfear.mlbbot;

/**
 *
 * @author FEAR
 */
public class Velocities {
    private double left;
    private double right;
    public Velocities(double leftVelocity, double rightVelocity) {
        left = leftVelocity;
        right = rightVelocity;
    }
    
    public double getLeftVelocity() {
        return left;
    }
    public double getRightVelocity() {
        return right;
    }
}
