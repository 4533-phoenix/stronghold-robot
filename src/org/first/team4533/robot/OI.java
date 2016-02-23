package org.first.team4533.robot;

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
	private Joystick driver = new Joystick(0);
	private Joystick gunner = new Joystick(1);
	private static OI INSTANCE;
	
	//All below assignments are subject to change and likely will change
	public static final int JOYSTICK_INTAKE = 7;			//1 = X
	public static final int JOYSTICK_REVERSE_INTAKE = 8;	//2 = A
															//3 = B
															//4 = Y
	public static final int JOYSTICK_CLIMB_UP = 4;			//5 = LB
	public static final int JOYSTICK_ClIMB_RELEASE = 2;		//6 = RB
	public static final int JOYSTICK_PIVOT_IN = 5;			//7 = LT
	public static final int JOYSTICK_PIVOT_OUT = 6;			//8 = RT
	//public static final int JOYSTICK_SHOOTER = ?;
		
	private OI() {
		
		JoystickButton intakeIn = new JoystickButton(//gunner, 
				driver, JOYSTICK_INTAKE);
		JoystickButton intakeOut = new JoystickButton(//gunner, 
				driver, JOYSTICK_REVERSE_INTAKE);
		JoystickButton pivotOut = new JoystickButton(//gunner,
				driver, JOYSTICK_PIVOT_OUT);
		JoystickButton pivotIn = new JoystickButton(//gunner,
				driver, JOYSTICK_PIVOT_IN);
		JoystickButton climbRelease = new JoystickButton(//gunner,
				driver, JOYSTICK_ClIMB_RELEASE);
		JoystickButton climbUp = new JoystickButton(//gunner,
				driver, JOYSTICK_CLIMB_UP);
		
		intakeIn.whileHeld(new IntakeIn());
		intakeIn.whenReleased(new IntakeStop());
		
		intakeOut.whileHeld(new IntakeOut());
		intakeOut.whenReleased(new IntakeStop());
		
		pivotIn.whileHeld(new PivotIn());
		pivotIn.whenReleased(new PivotStop());
		
		pivotOut.whileHeld(new PivotOut());
		pivotOut.whenReleased(new PivotStop());
		
		climbRelease.whileHeld(new ClimbRelease());
		climbRelease.whenReleased(new ClimbStop());
		
		climbUp.whileHeld(new ClimbUp());
		climbUp.whenReleased(new ClimbStop());
		
	}
	
	public static OI getInstance() {
		return INSTANCE;
	}

	public static void initialize() {
		if (INSTANCE == null) {
			INSTANCE = new OI();
		}
	}

    public Joystick getGunnerJoystick() {
    	return gunner;
	}

	public Joystick getDriverJoystick() {
		return driver;
	}
	
	
}

