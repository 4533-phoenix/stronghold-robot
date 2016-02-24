package org.first.team4533.robot.autonomous;

import org.first.team4533.robot.commands.TimedDriveBackward;
import org.first.team4533.robot.commands.TimedDriveForward;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DefaultAutonomous extends CommandGroup{
	private static final long DRIVE_FORWARD_DURATION = 0;//10000;
	private static final long DRIVE_BACKWARD_DURATION = 2000;

	public DefaultAutonomous() {
		this.addSequential(new TimedDriveForward(DRIVE_FORWARD_DURATION));
		this.addSequential(new TimedDriveBackward(DRIVE_BACKWARD_DURATION));
	}


}
