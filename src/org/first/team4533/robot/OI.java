package org.first.team4533.robot;

import org.first.team4533.robot.commands.IntakeIn;
import org.first.team4533.robot.commands.IntakeOut;
import org.first.team4533.robot.commands.IntakeStop;
import org.first.team4533.robot.commands.PivotIn;
import org.first.team4533.robot.commands.PivotOut;
import org.first.team4533.robot.commands.PivotStop;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private Joystick driver = new Joystick(0);
	// private Joystick gunner = new Joystick(1);
	private static OI INSTANCE;
	
	//All below assignments are subject to change and likely will change
	//Please do change them
	/*public static final int JOYSTICK_INTAKE = 1;
	public static final int JOYSTICK_REVERSE_INTAKE = 2;
	public static final int JOYSTICK_PIVOT_OUT = 5;
	public static final int JOYSTICK_PIVOT_IN = 6;
	public static final int JOYSTICK_ClIMB_UP = 7;
	public static final int JOYSTICK_CLIMB_DOWN = 8;
	public static final int JOYSTICK_SHOOTER = 9;*/
	
	private OI() {
		
		/*JoystickButton intakeIn = new JoystickButton(driver, 
				JOYSTICK_INTAKE);
		JoystickButton intakeOut = new JoystickButton(driver, 
				JOYSTICK_REVERSE_INTAKE);
		JoystickButton pivotOut = new JoystickButton(driver,
				JOYSTICK_PIVOT_OUT);
		JoystickButton pivotIn = new JoystickButton(driver,
				JOYSTICK_PIVOT_IN);
		
		//A lot of stuff needs to go here
		intakeIn.whileHeld(new IntakeIn());
		intakeIn.whenReleased(new IntakeStop());
		
		intakeOut.whileHeld(new IntakeOut());
		intakeOut.whenReleased(new IntakeStop());
		
		pivotIn.whileHeld(new PivotIn());
		pivotIn.whenReleased(new PivotStop());
		
		pivotOut.whileHeld(new PivotOut());
		pivotOut.whenReleased(new PivotStop());*/
		
		
		
	}
	
	public static OI getInstance() {
		return INSTANCE;
	}

	public static void initialize() {
		if (INSTANCE == null) {
			INSTANCE = new OI();
		}
	}

    /*public Joystick getGunnerJoystick() {
    	return gunner;
	}*/

	public Joystick getDriverJoystick() {
		return driver;
	}
}

