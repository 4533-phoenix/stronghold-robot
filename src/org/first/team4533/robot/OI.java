package org.first.team4533.robot;

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
	public static final int JOYSTICK_INTAKE = 1;
	public static final int JOYSTICK_REVERSE_INTAKE = 2;
	public static final int JOYSTICK_SHOOTER = 5;
	public static final int JOYSTICK_ClIMB_UP = 6;
	public static final int JOYSTICK_CLIMB_DOWN = 8;
	//public static final int JOYSTICK_GRIPPER_OPEN = 7;
	
	private OI() {
		// this.gunner = new Joystick(1);
		
		//A lot of stuff needs to go here
		
	}
	
	public static OI getInstance() {
		return INSTANCE;
	}

	public static void initialize() {
		if (INSTANCE == null) {
			INSTANCE = new OI();
		}
	}

	// public Joystick getGunnerJoystick() {
	// return gunner;
	// }

	public Joystick getDriverJoystick() {
		return driver;
	}
}

