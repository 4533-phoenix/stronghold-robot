//Import statements, anything that is referenced is imported here
package org.first.team4533.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.USBCamera;

import org.first.team4533.robot.autonomous.DefaultAutonomous;
import org.first.team4533.robot.autonomous.SecondaryAutonomous;
import org.first.team4533.robot.subsystems.ClimbSystem;
import org.first.team4533.robot.subsystems.DriveSystem;
import org.first.team4533.robot.subsystems.IntakeSystem;
import org.first.team4533.robot.subsystems.PivotSystem;


/**
 * Anything with an error to the left or underlined in orange is a warning that
 * usually means that it is unused but it is there
 */
public class Robot extends IterativeRobot {

	private CommandGroup autonomousCommand;					//default name and class for autonomous
	private SendableChooser autoChooser;					//Smart Dashboard technique to choose which auto program
	//private CameraServer cameraServer;

    public void robotInit() {
    	/*USBCamera camera = new USBCamera();
    	cameraServer = CameraServer.getInstance();
        cameraServer.setQuality(50);
        cameraServer.startAutomaticCapture(camera);*/
    	
    	ClimbSystem.initialize();				//These initialize each subsystem so that we have commands to access OI
    	PivotSystem.initialize();				//This also calls the motor controllers into use
    	DriveSystem.initialize();
        IntakeSystem.initialize();
        OI.initialize();						//This class creates the remotes and assigns all of the buttons to its command
        
        
        /*autoChooser = new SendableChooser();
        autoChooser.addDefault("Default program", new DefaultAutonomous());				//This would be the set of code that allows the team to	
        autoChooser.addObject("1 Defense off program", new SecondaryAutonomous());		//pick an auto program from SMART dashboard
        //autoChooser.addObject("2 Defense of program" , new TertiaryAutonomous());
        SmartDashboard.putData("Autonomous mode chooser", autoChooser);*/
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();													//This is a method you should never mess with
	}

    public void autonomousInit() {
    	this.autonomousCommand = 														//This is the method where autonomous is initialized.
    			new DefaultAutonomous();//(CommandGroup) autoChooser.getSelected();		//The new DefaultAutonomous() makes the default auto method
        this.autonomousCommand.start();													//the method that runs, the commented out one allows choosing
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();													//This is a method you should never mess with
    }

    public void teleopInit() {
        if (autonomousCommand != null) {												//This is a method you should never mess with
        	autonomousCommand.cancel();
        }
    }


    public void disabledInit(){															//This is a method you should never mess with

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {					
        Scheduler.getInstance().run();													//This is a method you should never mess with
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {														//This is a method you should never mess with
        LiveWindow.run();
    }
}
