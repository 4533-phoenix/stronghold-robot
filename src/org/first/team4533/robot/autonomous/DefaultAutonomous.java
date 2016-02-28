package org.first.team4533.robot.autonomous;

import org.first.team4533.robot.RobotMap;
import org.first.team4533.robot.commands.TimedClimbRetract;
import org.first.team4533.robot.commands.TimedDriveBackward;
import org.first.team4533.robot.commands.TimedDriveForward;
import org.first.team4533.robot.commands.TimedDriveTurnRight;
import org.first.team4533.robot.commands.TimedPivotRetract;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class DefaultAutonomous extends CommandGroup{
	private static final long DRIVE_BACKWARD_DURATION = 0;
	private static final long DRIVE_FORWARD_DURATION = 4000; 
	private static final long DRIVE_TURN_RIGHT_DURATION = 1000;
	private static final long DRIVE_FORWARD_SHOOT_DURATION = 2000;
	private static final long CLIMB_RETRACT_DURATION = 1000;
	private static final long PIVOT_RETRACT_DURATION = 2000;

	public DefaultAutonomous() {
		//this.addSequential(new TimedClimbRetract(CLIMB_RETRACT_DURATION));
		//this.addSequential(new TimedPivotRetract(PIVOT_RETRACT_DURATION));
		//this.addSequential(new TimedDriveForward(DRIVE_BACKWARD_DURATION));
		this.addSequential(new TimedDriveBackward(DRIVE_FORWARD_DURATION));
		//this.addSequential(new TimedDriveTurnRight(DRIVE_TURN_RIGHT_DURATION));
		//this.addSequential(new TimedDriveBackward(DRIVE_FORWARD_SHOOT_DURATION));
	}
	
	//5000 at -.5 for low bar
	//4000 at -.9 for rock wall
	//4000 at -.9 for rt

}
