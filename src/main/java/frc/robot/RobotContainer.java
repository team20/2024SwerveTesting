// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandGenericHID;
import frc.robot.subsystems.DriveSubsystem;

public class RobotContainer {
	private final CommandGenericHID m_driverController = new CommandGenericHID(0);
	private final DriveSubsystem m_driveSubsystem = new DriveSubsystem();

	public RobotContainer() {
		configureBindings();
	}

	private void configureBindings() {
		m_driveSubsystem.setDefaultCommand(m_driveSubsystem.driveCommand(() -> m_driverController.getRawAxis(0),
				() -> -m_driverController.getRawAxis(1), () -> m_driverController.getRawAxis(2)));
	}

	public Command getAutonomousCommand() {
		return Commands.print("No autonomous command configured");
	}
}
