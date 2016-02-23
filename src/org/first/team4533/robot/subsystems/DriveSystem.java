package org.first.team4533.robot.subsystems;

import org.first.team4533.robot.RobotMap;
import org.first.team4533.robot.commands.DriveWithJoystick;
import org.first.team4533.robot.subsystems.DriveSystem;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveSystem extends Subsystem {
	
	private static DriveSystem INSTANCE;
	//Below are the drive command and the 4 motor controller  
	private CANTalon leftMaster;
	private CANTalon rightMaster;
	private CANTalon leftSlave;
	private CANTalon rightSlave;
	//private RobotDrive robotDrive;
	
	//private static final double DEFAULT_SPEED_ADJUSTMENT = 0.80;
	
	private DriveSystem() {
		leftMaster = new CANTalon(RobotMap.MOTOR_LEFT_MASTER);
		rightMaster = new CANTalon(RobotMap.MOTOR_RIGHT_MASTER);

		leftSlave = new CANTalon(RobotMap.MOTOR_LEFT_SLAVE);
		leftSlave.changeControlMode(TalonControlMode.Follower);
		leftSlave.set(RobotMap.MOTOR_LEFT_MASTER);
		
		rightSlave = new CANTalon(RobotMap.MOTOR_RIGHT_SLAVE);
		rightSlave.changeControlMode(TalonControlMode.Follower);
		rightSlave.set(RobotMap.MOTOR_RIGHT_MASTER);
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
		this.drive(driver.getY(), driver.getRawAxis(3));
	}
	
	public void forward(double value) {
		this.drive(value, value);
	}

	public void drive(double left, double right) {
		this.leftMaster.set(-left);
		this.leftSlave.set(RobotMap.MOTOR_LEFT_MASTER);
		this.rightMaster.set(right);
		this.rightSlave.set(RobotMap.MOTOR_RIGHT_MASTER);
	}
	
	public void forward() {
		this.forward(1.0);
	}

	public void backward(double value) {
		this.drive(value,value);
	}

	public void backward() {
		this.backward(-1.0);
	}

	public void stop() {
		this.drive(0.0, 0.0);
	}
	
	public void turnLeft(double value1, double value2) {
		this.drive(value1, value2);
	}
	
	public void turnLeft() {
		this.turnLeft(-.5,.5);
	}
	
	public void turnRight(double value1, double value2) {
		this.drive(value1, value2);
	}
	
	public void turnRight() {
		this.turnRight(.5,-.5);
	}

    public void initDefaultCommand() {
    	this.setDefaultCommand(new DriveWithJoystick());
    }

}
