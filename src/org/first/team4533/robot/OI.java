package org.first.team4533.robot;

import org.first.team4533.robot.commands.BrakeStop;
import org.first.team4533.robot.commands.ClimbBrake;
import org.first.team4533.robot.commands.ClimbBrakeUndo;
import org.first.team4533.robot.commands.ClimbRelease;
import org.first.team4533.robot.commands.ClimbStop;
import org.first.team4533.robot.commands.ClimbUp;
import org.first.team4533.robot.commands.IntakeIn;
import org.first.team4533.robot.commands.IntakeOut;
import org.first.team4533.robot.commands.IntakeStop;
import org.first.team4533.robot.commands.PivotIn;
import org.first.team4533.robot.commands.PivotOut;
import org.first.team4533.robot.commands.PivotStop;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private Joystick driver = new Joystick(0);				//this is the joystick port for the first one plugged in, driver and the one used
	private Joystick gunner = new Joystick(1);
	/*private Joystick left = new Joystick(0);
	 private Joystick right = new Joystick(1);*/
	private static OI INSTANCE;
	
	//these are intergers that never change, they correspond to buttons on each remote
	public static final int JOYSTICK_INTAKE = 7;			//1 = X
	public static final int JOYSTICK_REVERSE_INTAKE = 8;	//2 = A
	public static final int JOYSTICK_BRAKE = 1;				//3 = B
	public static final int JOYSTICK_UNDO_BRAKE = 3;		//4 = Y
	public static final int JOYSTICK_CLIMB_UP = 4;			//5 = LB
	public static final int JOYSTICK_ClIMB_RELEASE = 2;		//6 = RB
	public static final int JOYSTICK_PIVOT_IN = 6;			//7 = LT
	public static final int JOYSTICK_PIVOT_OUT = 5;			//8 = RT
	//public static final int JOYSTICK_SHOOTER = ?;
	
	/* Controls with the Attack 3 joysticks
	 * public static final int JOYSTICK_INTAKE = ?;			
	 * public static final int JOYSTICK_REVERSE_INTAKE = ?;	
	 * public static final int JOYSTICK_BRAKE = ?;				
	 * public static final int JOYSTICK_UNDO_BRAKE = ?;		
	 * public static final int JOYSTICK_CLIMB_UP = ?;			
	 * public static final int JOYSTICK_ClIMB_RELEASE = ?;		
	 * public static final int JOYSTICK_PIVOT_IN = ?;			
	 * public static final int JOYSTICK_PIVOT_OUT = ?;			
	 */
		
	private OI() {
		
		JoystickButton intakeIn = new JoystickButton(//gunner, 
				driver, JOYSTICK_INTAKE);
		JoystickButton intakeOut = new JoystickButton(//gunner, 
				driver, JOYSTICK_REVERSE_INTAKE);
		JoystickButton pivotOut = new JoystickButton(//gunner,				These create officially each button on the driver remote
				driver, JOYSTICK_PIVOT_OUT);
		JoystickButton pivotIn = new JoystickButton(//gunner,				using the button numbers created above
				driver, JOYSTICK_PIVOT_IN);
		JoystickButton climbRelease = new JoystickButton(//gunner,
				driver, JOYSTICK_ClIMB_RELEASE);
		JoystickButton climbUp = new JoystickButton(//gunner,
				driver, JOYSTICK_CLIMB_UP);
		JoystickButton climbBrake = new JoystickButton(
				driver, JOYSTICK_BRAKE);
		JoystickButton climbUndoBrake = new JoystickButton(
				driver, JOYSTICK_UNDO_BRAKE);
		
		/*
		 * JoystickButton intakeIn = new JoystickButton(//left, 
				right, JOYSTICK_INTAKE);
		 * JoystickButton intakeOut = new JoystickButton(//left, 
				right, JOYSTICK_REVERSE_INTAKE);
		 * JoystickButton pivotOut = new JoystickButton(//left,				These create officially each button on the driver remote
				right, JOYSTICK_PIVOT_OUT);
		 * JoystickButton pivotIn = new JoystickButton(//left,				using the button numbers created above
				right, JOYSTICK_PIVOT_IN);
		 * JoystickButton climbRelease = new JoystickButton(//left,
				right, JOYSTICK_ClIMB_RELEASE);
		 * JoystickButton climbUp = new JoystickButton(//left,
				right, JOYSTICK_CLIMB_UP);
		 * JoystickButton climbBrake = new JoystickButton(//left,
				right, JOYSTICK_BRAKE);
		 * JoystickButton climbUndoBrake = new JoystickButton(//left,
				right, JOYSTICK_UNDO_BRAKE);
		 */
		
		
		intakeIn.whileHeld(new IntakeIn());			//Executes intakeIn WHILE the button is pressed
		intakeIn.whenReleased(new IntakeStop());	//executes intakestop WHEN the button is let go
		
		intakeOut.whileHeld(new IntakeOut());	
		intakeOut.whenReleased(new IntakeStop());
		
		pivotIn.whileHeld(new PivotIn());
		pivotIn.whenReleased(new PivotStop());							//These bind the buttons to a specific command
		
		pivotOut.whileHeld(new PivotOut());
		pivotOut.whenReleased(new PivotStop());
		
		climbRelease.whileHeld(new ClimbRelease());
		climbRelease.whenReleased(new ClimbStop());
		
		climbUp.whileHeld(new ClimbUp());
		climbUp.whenReleased(new ClimbStop());
		
		climbBrake.whileHeld(new ClimbBrake());
		climbBrake.whenReleased(new BrakeStop());
		
		climbUndoBrake.whileHeld(new ClimbBrakeUndo());
		climbUndoBrake.whenReleased(new BrakeStop());
	}
	
	public static OI getInstance() {						//This is a method you should never mess with
		return INSTANCE;
	}

	public static void initialize() {
		if (INSTANCE == null) {								//This is a method you should never mess with but it is different than 
			INSTANCE = new OI();						//it is originally created. This assures that there are not more than one buttons which
		}												//can cause interference
	}

    public Joystick getGunnerJoystick() {
    	return gunner;										//This is a method you should never mess with
	}

	public Joystick getDriverJoystick() {
		return driver;										//This is a method you should never mess with
	}
	
	/*
	public Joystick GetLeftJoystick() {
		return left;
	}
	public Joystick GetRightJoystick() {
		return right;
	}
	*/
}

