package org.first.team4533.robot.subsystems;

import org.first.team4533.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class PivotSystem extends Subsystem {
	private static PivotSystem INSTANCE;
	private AnalogPotentiometer pivotpot;							//Potentiometer before we removed it
    private CANTalon pivotmaster;									//CAN talon controller used to control the pivot motor
    private CANTalon pivotSlave;
    private static final double DEFAULT_PIVOT_STOP_VALUE = 0.0;		//value to stop the pivot motor
	private static final double DEFAULT_PIVOT_IN_VALUE = 0.40;		//motor value used to pull the arm in
	private static final double DEFAULT_PIVOT_OUT_VALUE = -0.40;	//motor value used to pivot the arm out
	private static final double MAX_UP_VALUE = 2200;				//value used for the potentiometer before we removed it
	private static final double MIN_DOWN_VALUE = 1000;				//value used for spring potentiometer before we removed it
    
	private PivotSystem() {
		pivotmaster = new CANTalon(RobotMap.MOTOR_PIVOT);								//instantiates the CAN Talon controller
		//pivotpot = new AnalogPotentiometer(RobotMap.POTENTIOMETER_PIVOT, 3600, 0.0); //instantiates the poteniometer
		
		/*pivotSlave = new CANTalon(RobotMap.MOTOR_PIVOT2);
		pivotSlave.changeControlMode(TalonControlMode.Follower);		//This one and the following set the back up controllers so that they do not 
		pivotSlave.set(RobotMap.MOTOR_LEFT_MASTER);*/
	}
	public static PivotSystem getInstance() {
		return INSTANCE;										//This is a method you should never mess with
	}
	public static void initialize() {
		if (INSTANCE == null) {									//This is a method you should never mess with
			INSTANCE = new PivotSystem();						//But it is important to assure that there arent two to mess it up
		}														//so it has to be set up by you
	}
	
	public void in() {
		/*if(this.pivotpot.get() < MAX_UP_VALUE) {				//This structure was used for the poteniometer to make sure the arm
			pivotmotor.set(DEFAULT_PIVOT_IN_VALUE);				//didnt go to far up or down to break the arm or robot
		}*/														//it was replaced by limit switches which do not have to be coded
		pivotmaster.set(DEFAULT_PIVOT_IN_VALUE);					//called by the pivotin method to pull the arm in
		///this.pivotSlave.set(RobotMap.MOTOR_PIVOT);
		//System.out.println("Value: " + pivotpot.get());
	}

	public void out() {
		/*if(this.pivotpot.get() > MIN_DOWN_VALUE) {			//This structure was used for the poteniometer to make sure the arm
			pivotmotor.set(DEFAULT_PIVOT_OUT_VALUE);			//didnt go to far up or down to break the arm or robot
		}*/														//it was replaced by limit switches which do not have to be coded
		pivotmaster.set(DEFAULT_PIVOT_OUT_VALUE);				//called by the pivotout method to pull the arm in
		///this.pivotSlave.set(RobotMap.MOTOR_PIVOT);
		//System.out.println("Value: " + pivotpot.get());
	}

	public void stop() {
		pivotmaster.set(DEFAULT_PIVOT_STOP_VALUE);				//this is called by pivotstop to stop the pivot arm and in the others
		//this.pivotSlave.set(RobotMap.MOTOR_PIVOT);
	}															//if the program is interrupted 

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());			//This is a method you should never mess with
    }
}

