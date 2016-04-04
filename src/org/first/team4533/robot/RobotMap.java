package org.first.team4533.robot;

public class RobotMap {
		public static final int MOTOR_LEFT_MASTER = 1;	//CAN Talon SRX
		public static final int MOTOR_RIGHT_MASTER = 5;	//CAN Talon SRX
		public static final int MOTOR_LEFT_SLAVE = 2;	//CAN Talon SRX
		public static final int MOTOR_RIGHT_SLAVE = 4;	//CAN Talon SRX			These are the assignments used for motor controllers and other 
		public static final int MOTOR_PIVOT = 6;		//CAN Talon SRX			ports on the roborio so that we keep them straight using words
		public static final int MOTOR_CLIMB = 3;		//CAN Talon SRX			The ports included are CAN assignments, PWM assignments, and 
		//public static final int MOTOR_PIVOT2 = 0;		//CAN Talon SRX
		public static final int MOTOR_ROLLER = 0;		//PWM Spark?			Analog assignments
		public static final int MOTOR_BRAKE = 1;							  //CAN starts at 1, PWN starts at 0, and Analog starts at 0
		public static final int POTENTIOMETER_PIVOT = 0;	//Analog
		
		//CAN
		//RoboRio>>Left front>>Left rear>>Climber>>Right rear>>Right front>>Pivot>>PDB
		
		//For practice Bot
		/*public static final int MOTOR_LEFT_FRONT = 0;	
		public static final int MOTOR_RIGHT_FRONT = 2;	
		public static final int MOTOR_LEFT_REAR = 1;	
		public static final int MOTOR_RIGHT_REAR = 3;
		public static final int MOTOR_PIVOT = 4;
		public static final int MOTOR_INTAKE = 5;
		public static final int MOTOR_CLIMB;*/

}
