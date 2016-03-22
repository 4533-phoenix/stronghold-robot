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
import edu.wpi.first.wpilibj.Victor;
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
	
	private SpeedController leftMotor;
	private SpeedController rightMotor;
	
	private static final double DEFAULT_SPEED_ADJUSTMENT = 0.80;
	
	private DriveSystem() {
		/*leftFront = new CANTalon(RobotMap.MOTOR_LEFT_FRONT);
		rightFront = new CANTalon(RobotMap.MOTOR_RIGHT_FRONT);
		leftRear = new CANTalon(RobotMap.MOTOR_LEFT_REAR);
		rightRear = new CANTalon(RobotMap.MOTOR_RIGHT_REAR);
		robotDrive = new RobotDrive(this.leftFront, this.leftRear,
				this.rightFront, this.rightRear);*/
		/*robotDrive.setInvertedMotor(MotorType.kFrontRight, true);
		robotDrive.setInvertedMotor(MotorType.kRearRight, true);*/
		
		//Motor controller assignments for practice bot
		leftFront = new Talon(RobotMap.MOTOR_LEFT_FRONT);
		rightFront = new Talon(RobotMap.MOTOR_RIGHT_FRONT);
		leftRear = new Talon(RobotMap.MOTOR_LEFT_REAR);
		rightRear = new Talon(RobotMap.MOTOR_RIGHT_REAR);
		
		leftMotor = new Victor(RobotMap.MOTOR_LEFT);
		rightMotor = new Talon(RobotMap.MOTOR_RIGHT);
		
	}
    
	public static void initialize() {
		if (INSTANCE == null) {
			INSTANCE = new DriveSystem();
		}
	}
	
	public static DriveSystem getInstance() {
		return INSTANCE;
	}
	
	public void drive(double left, double right) {
		/*this.leftMaster.set(-left*DEFAULT_SPEED_ADJUSTMENT);
		this.leftSlave.set(RobotMap.MOTOR_LEFT_MASTER);				//This is the actual drive method, it sets the values for each motor so that
		this.rightMaster.set(right*DEFAULT_SPEED_ADJUSTMENT);		//we move in the correct direction based on the joystick
		this.rightSlave.set(RobotMap.MOTOR_RIGHT_MASTER);*/
		this.leftMotor.set(left*DEFAULT_SPEED_ADJUSTMENT);
		this.rightMotor.set(right*DEFAULT_SPEED_ADJUSTMENT);
	}
	
	public void driveWithJoystick(Joystick driver) {
		//The most basic tank robot drive command
		this.drive(-driver.getY(), -driver.getRawAxis(3));
	}
	
	public void forward(double value) {
		this.drive(value,value);
	}

	public void forward() {
		this.forward(.75);
	}

	public void backward(double value) {
		this.drive(value,value);
	}

	public void backward() {
		this.backward(-0.75);
	}

	public void stop() {
		this.drive(0.0, 0.0);
	}

    public void initDefaultCommand() {
    	this.setDefaultCommand(new DriveWithJoystick());
    }

	private void setDefaultCommand(DriveWithJoystick driveWithJoystick) {
		// TODO Auto-generated method stub
		
	}
}
