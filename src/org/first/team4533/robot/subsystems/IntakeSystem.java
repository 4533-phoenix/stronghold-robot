package org.first.team4533.robot.subsystems;

import org.first.team4533.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeSystem extends Subsystem {
    
    private static IntakeSystem INSTANCE;
    private Spark intakemotor;
    private static final double DEFAULT_INTAKE_STOP_VALUE = 0.0;
	private static final double DEFAULT_INTAKE_IN_VALUE = 0.5;
	private static final double DEFAULT_INTAKE_OUT_VALUE = -1.0;
	
	private IntakeSystem() {
		intakemotor = new Spark(RobotMap.MOTOR_ROLLER);
	}
	public static IntakeSystem getInstance() {
		return INSTANCE;
	}
	public static void initialize() {
		if (INSTANCE == null) {
			INSTANCE = new IntakeSystem();
		}
	}
	
	public void in() {
		intakemotor.set(DEFAULT_INTAKE_IN_VALUE);
	}

	public void out() {
		intakemotor.set(DEFAULT_INTAKE_OUT_VALUE);
	}

	public void stop() {
		intakemotor.set(DEFAULT_INTAKE_STOP_VALUE);
	}

	@Override
    protected void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

