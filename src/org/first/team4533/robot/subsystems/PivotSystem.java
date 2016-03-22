package org.first.team4533.robot.subsystems;

import org.first.team4533.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class PivotSystem extends Subsystem {
    
	private static PivotSystem INSTANCE;
    private CANTalon pivotmotor;
    private static final double DEFAULT_PIVOT_STOP_VALUE = 0.0;
	private static final double DEFAULT_PIVOT_IN_VALUE = 0.4;
	private static final double DEFAULT_PIVOT_OUT_VALUE = -0.4;
    
	private PivotSystem() {
		pivotmotor = new CANTalon(RobotMap.MOTOR_PIVOT);
	}
	public static PivotSystem getInstance() {
		return INSTANCE;
	}
	public static void initialize() {
		if (INSTANCE == null) {
			INSTANCE = new PivotSystem();
		}
	}
	
	public void in() {
		pivotmotor.set(DEFAULT_PIVOT_IN_VALUE);
	}

	public void out() {
		pivotmotor.set(DEFAULT_PIVOT_OUT_VALUE);
	}

	public void stop() {
		pivotmotor.set(DEFAULT_PIVOT_STOP_VALUE);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

