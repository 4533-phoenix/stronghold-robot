package org.first.team4533.robot.subsystems;

import org.first.team4533.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class PivotSystem extends Subsystem {
	private static PivotSystem INSTANCE;
	private AnalogPotentiometer pivotpot;
    private CANTalon pivotmotor;
    private static final double DEFAULT_PIVOT_STOP_VALUE = 0.0;
	private static final double DEFAULT_PIVOT_IN_VALUE = 0.40;
	private static final double DEFAULT_PIVOT_OUT_VALUE = -0.40;
	private static final double MAX_UP_VALUE = 2200;				//Change at first test
	private static final double MIN_DOWN_VALUE = 1000;			//Change at first test
    
	private PivotSystem() {
		pivotmotor = new CANTalon(RobotMap.MOTOR_PIVOT);
		//pivotpot = new AnalogPotentiometer(RobotMap.POTENTIOMETER_PIVOT, 3600, 0.0); //Change at first test
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
		/*if(this.pivotpot.get() < MAX_UP_VALUE) {
			pivotmotor.set(DEFAULT_PIVOT_IN_VALUE);
		}*/
		pivotmotor.set(DEFAULT_PIVOT_IN_VALUE);
		//System.out.println("Value: " + pivotpot.get());
	}

	public void out() {
		/*if(this.pivotpot.get() > MIN_DOWN_VALUE) {
			pivotmotor.set(DEFAULT_PIVOT_OUT_VALUE);
		}*/
		pivotmotor.set(DEFAULT_PIVOT_OUT_VALUE);
		//System.out.println("Value: " + pivotpot.get());
	}

	public void stop() {
		pivotmotor.set(DEFAULT_PIVOT_STOP_VALUE);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

