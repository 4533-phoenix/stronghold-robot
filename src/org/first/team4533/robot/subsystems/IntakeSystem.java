package org.first.team4533.robot.subsystems;

import org.first.team4533.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeSystem extends Subsystem {
    
    private static IntakeSystem INSTANCE;
    private Spark intakemotor;										//Motor controller used for the motor in this system
    private static final double DEFAULT_INTAKE_STOP_VALUE = 0.0;	//value used to stop the motor, always 0
	private static final double DEFAULT_INTAKE_IN_VALUE = 0.5;		//value used when taking the ball in
	private static final double DEFAULT_INTAKE_OUT_VALUE = -1.0;	//motor value used when spitting the ball out
	
	private IntakeSystem() {
		intakemotor = new Spark(RobotMap.MOTOR_ROLLER);				//this instantiates the Spark that is used for the intake motor
	}
	
	public static IntakeSystem getInstance() {						
		return INSTANCE;											//This is a method you should never mess with
	}
	
	public static void initialize() {
		if (INSTANCE == null) {										//This is a method you should never mess with
			INSTANCE = new IntakeSystem();							//but this is important and will have to set it up
		}
	}
	
	public void in() {
		intakemotor.set(DEFAULT_INTAKE_IN_VALUE);					//command called by intakein to turn on the intake
	}

	public void out() {
		intakemotor.set(DEFAULT_INTAKE_OUT_VALUE);					//command called by intakeout to reverse the intake
	}

	public void stop() {
		intakemotor.set(DEFAULT_INTAKE_STOP_VALUE);					//command called by intakestop to stop the intake, also in intakeout
	}																//and intake in if the program is interrupted

	@Override
    protected void initDefaultCommand() {
        // Set the default command for a subsystem here.			//This is a method you should never mess with
        //setDefaultCommand(new MySpecialCommand());
    }
}

