package com.nicoletfear.mlbbot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static final int leftMotor = 1;
    // public static final int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
    public static final int leftWheelPort = 1;
    public static final int rightWheelPort = 2;
    public static final int loadSolenoidPort = 1;
    public static final int clutchRelayPort = 7;
    public static final int reloadSolenoidPort = 2;
    
    
    public static final int lightsModule = 1;
    public static final int readyRelay = 1;
    public static final int aimRelay = 2;
    public static final int fireRelay = 3;
    public static final int runningLightsRelay = 4;
    
    public static final int pressureSwitchChannel = 1;
    public static final int compressorRelayChannel = 8;
}