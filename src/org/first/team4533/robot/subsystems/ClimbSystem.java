package org.first.team4533.robot.subsystems;

import org.first.team4533.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ClimbSystem extends Subsystem {
    
	private static ClimbSystem INSTANCE;
    private CANTalon climbmotor;										//This is the motor that controlled the climber
    private Spark brakemotor;											//MC that controlled the break
    private static final double DEFAULT_CLIMB_STOP_VALUE = 0.0;			//motor value used to stop the climb motor
	private static final double DEFAULT_CLIMB_UP_VALUE = 0.5;			//motor value used for the climber to go up
	private static final double DEFAULT_CLIMB_RELEASE_VALUE = -0.9;		//motor value used for the climber arms to go down
	private static final double DEFAULT_MOTOR_BRAKE_VALUE = 0.8;		//value used for the brake to brake
	private static final double DEFAULT_MOTOR_UNDO_BRAKE_VALUE = -0.5;	//value used for the brake to unbrake
	
	private ClimbSystem() {
		climbmotor = new CANTalon(RobotMap.MOTOR_CLIMB);				//instantiates the climbmotor MC
		brakemotor = new Spark(RobotMap.MOTOR_BRAKE);					//instantiates the brakemotor MC
	}
	public static ClimbSystem getInstance() {
		return INSTANCE;												//This is a method you should never mess with
	}
	public static void initialize() {
		if (INSTANCE == null) {											//This is a method you should never mess with
			INSTANCE = new ClimbSystem();								//But you have to set it up and it prevents duplication errors
		}
	}
	
	public void release() {
		climbmotor.set(DEFAULT_CLIMB_RELEASE_VALUE);					//called by climbrelease to make the climber/arms go up
	}

	public void up() {
		climbmotor.set(DEFAULT_CLIMB_UP_VALUE);							//called by climbup to make the robot go up, climber down
	}
	
	public void up(double speed) {
		climbmotor.set(speed);										//called by the timedclimbretract method, meant to pull the arms/climber
	}																//down in auto
	
	
	public void brake() {		
		brakemotor.set(DEFAULT_MOTOR_BRAKE_VALUE);					//called by the climbbrake method to activate the brake
	}
	
	public void undoBrake() {
		brakemotor.set(DEFAULT_MOTOR_UNDO_BRAKE_VALUE);				//called by the climbBrakeUndo method to undo the brake
	}

	public void climbStop() {
		climbmotor.set(DEFAULT_CLIMB_STOP_VALUE);					//called by climbstop method to stop the brake and also called in release
	}																//and up if the program is interrupted for safety
	
	public void brakeStop() {
		brakemotor.set(0.0);										//called by brakestop to stop the brake and by brake and brakeundo
	}																//if the program is interrupted for saftey
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.			//This is a method you should never mess with
        //setDefaultCommand(new MySpecialCommand());
    }
}

