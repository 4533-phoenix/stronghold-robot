package org.first.team4533.robot.subsystems;

import org.first.team4533.robot.RobotMap;
import org.first.team4533.robot.commands.DriveWithJoystick;
import org.first.team4533.robot.subsystems.DriveSystem;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveSystem extends Subsystem {
	
	private static DriveSystem INSTANCE;
	//Below are the drive command and the 4 motor controller  
	private SpeedController leftFront;
	private SpeedController rightFront;
	private SpeedController leftRear;
	private SpeedController rightRear;
	private RobotDrive robotDrive;
	
	//private static final double DEFAULT_SPEED_ADJUSTMENT = 0.80;
	
	private DriveSystem() {
		leftFront = new CANTalon(RobotMap.MOTOR_LEFT_FRONT);
		rightFront = new CANTalon(RobotMap.MOTOR_RIGHT_FRONT);
		leftRear = new CANTalon(RobotMap.MOTOR_LEFT_REAR);
		rightRear = new CANTalon(RobotMap.MOTOR_RIGHT_REAR);
		robotDrive = new RobotDrive(this.leftFront, this.leftRear,
				this.rightFront, this.rightRear);
		/*robotDrive.setInvertedMotor(MotorType.kFrontRight, true);
		robotDrive.setInvertedMotor(MotorType.kRearRight, true);*/
		
		//Motor controller assignments for practice bot
		/*leftFront = new Talon(RobotMap.MOTOR_LEFT_FRONT);
		rightFront = new Talon(RobotMap.MOTOR_RIGHT_FRONT);
		leftRear = new Talon(RobotMap.MOTOR_LEFT_REAR);
		rightRear = new Talon(RobotMap.MOTOR_RIGHT_REAR);
		robotDrive = new RobotDrive(this.leftFront, this.leftRear,
				this.rightFront, this.rightRear);*/
	}
    
	public static void initialize() {
		if (INSTANCE == null) {
			INSTANCE = new DriveSystem();
		}
	}
	
	public static DriveSystem getInstance() {
		return INSTANCE;
	}
	
	public void driveWithJoystick(Joystick driver) {
		
		//The most basic tank robot drive command
		//tankDrive(double leftValue, double rightValue);
	}
	
	public void forward(double value) {
		this.robotDrive.tankDrive(0.0,0.0);
	}

	public void forward() {
		this.forward(1.0);
	}

	public void backward(double value) {
		this.robotDrive.tankDrive(0.0,0.0);
	}

	public void backward() {
		this.backward(1.0);
	}

	public void stop() {
		this.robotDrive.tankDrive(0.0, 0.0);
	}

    public void initDefaultCommand() {
    	this.setDefaultCommand(new DriveWithJoystick());
    }

	private void setDefaultCommand(DriveWithJoystick driveWithJoystick) {
		// TODO Auto-generated method stub
		
	}
}
