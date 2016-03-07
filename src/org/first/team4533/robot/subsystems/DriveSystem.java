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
	private CANTalon rightMaster;							//These assign names and create the motor controllers using CANTalons
	private CANTalon leftSlave;								//with our design of tank drive we need 2 masters and 2 slaves
	private CANTalon rightSlave;
	//private RobotDrive robotDrive;
	
	private static final double DEFAULT_SPEED_ADJUSTMENT = 0.60;	//This is the value that determines the speed at which the robot goes
																	//So it moves at 60% of its possible power
	private DriveSystem() {
		leftMaster = new CANTalon(RobotMap.MOTOR_LEFT_MASTER);
		rightMaster = new CANTalon(RobotMap.MOTOR_RIGHT_MASTER);	//The master is the default kind of motor controller and this is the constructor
																	//class object. This means that we do not have to change it.
		leftSlave = new CANTalon(RobotMap.MOTOR_LEFT_SLAVE);
		leftSlave.changeControlMode(TalonControlMode.Follower);		//This one and the following set the back up controllers so that they do not 
		leftSlave.set(RobotMap.MOTOR_LEFT_MASTER);					//interfere with the masters
		
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
			INSTANCE = new DriveSystem();					//This is a method you should never mess with but it is different from the default
		}													//its different so that there are never 2, because it might cause interference
	}
	
	public static DriveSystem getInstance() {
		return INSTANCE;									//This is a method you should never mess with
	}
	
	public void drive(double left, double right) {
		this.leftMaster.set(-left*DEFAULT_SPEED_ADJUSTMENT);
		this.leftSlave.set(RobotMap.MOTOR_LEFT_MASTER);				//This is the actual drive method, it sets the values for each motor so that
		this.rightMaster.set(right*DEFAULT_SPEED_ADJUSTMENT);		//we move in the correct direction based on the joystick
		this.rightSlave.set(RobotMap.MOTOR_RIGHT_MASTER);
	}
	public void driveWithJoystick(Joystick driver) {
		this.drive(driver.getY(), driver.getRawAxis(3));			//This is the method that calls the DriveWithJoystick method in commands. This
	}																//was how we move, it is not precise and struggled with our tank drive config
	
	public void forward(double value) {
		this.drive(value, value);									//this is the command called in the auto forward method
	}

	public void forward() {
		this.forward(1.0);											//This isnt used
	}

	public void backward(double value) {
		this.drive(value,value);									//this is the command called in the auto backward method
	}

	public void backward() {
		this.backward(-1.0);										//not used
	}

	public void stop() {
		this.drive(0.0, 0.0);										// This is used a lot for whenever the robot has to stop
	}
	
	public void turnLeft(double value1, double value2) {			//This is used in the timedTurnLeft command,
		this.drive(value1, value2);									//Basically used for autonomous
	}
	
	public void turnLeft() {										//Basic method if we are to lazy to put in values
		this.turnLeft(-.5,.5);										//As seen here, turnLeft calls itself with the values so it goes up
	}
	
	public void turnRight(double value1, double value2) {			//This is used in the timedTurnLeft command,
		this.drive(value1, value2);									//Basically used for autonomous
	}
	
	public void turnRight() {										//Basic method if we are to lazy to put in values
		this.turnRight(.5,-.5);										//As seen here, turnLeft calls itself with the values so it goes up
	}

    public void initDefaultCommand() {
    	this.setDefaultCommand(new DriveWithJoystick());			//This is a method you should never mess with
    }

}
