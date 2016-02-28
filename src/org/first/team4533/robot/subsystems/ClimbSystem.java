package org.first.team4533.robot.subsystems;

import org.first.team4533.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ClimbSystem extends Subsystem {
    
	private static ClimbSystem INSTANCE;
    private CANTalon climbmotor;
    private Spark brakemotor;
    private static final double DEFAULT_CLIMB_STOP_VALUE = 0.0;
	private static final double DEFAULT_CLIMB_UP_VALUE = 0.5;
	private static final double DEFAULT_CLIMB_RELEASE_VALUE = -0.9;
	private static final double DEFAULT_MOTOR_BRAKE_VALUE = 0.8;
	private static final double DEFAULT_MOTOR_UNDO_BRAKE_VALUE = -0.5;
	
	private ClimbSystem() {
		climbmotor = new CANTalon(RobotMap.MOTOR_CLIMB);
		brakemotor = new Spark(RobotMap.MOTOR_BRAKE);
	}
	public static ClimbSystem getInstance() {
		return INSTANCE;
	}
	public static void initialize() {
		if (INSTANCE == null) {
			INSTANCE = new ClimbSystem();
		}
	}
	
	public void release() {
		climbmotor.set(DEFAULT_CLIMB_RELEASE_VALUE);
		//Figure out how this is going to work
		//What is above might not be enough, we will have to see
		//Once it is figured out we need to create the corresponding command
	}

	public void up() {
		climbmotor.set(DEFAULT_CLIMB_UP_VALUE);
	}
	
	public void up(double speed) {
		climbmotor.set(speed);
	}
	
	
	public void brake() {
		brakemotor.set(DEFAULT_MOTOR_BRAKE_VALUE);
	}
	
	public void undoBrake() {
		brakemotor.set(DEFAULT_MOTOR_UNDO_BRAKE_VALUE);
	}

	public void climbStop() {
		climbmotor.set(DEFAULT_CLIMB_STOP_VALUE);
	}
	
	public void brakeStop() {
		brakemotor.set(0.0);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

