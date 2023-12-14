package frc.robot.subsystems;

import static frc.robot.Constants.DriveConstants.*;

import java.util.function.Supplier;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
	private final SwerveModule m_frontLeft = new SwerveModule(kFrontLeftSteerID, kFrontLeftDriveID,
			kFrontLeftSteerOffsetDegrees, kFrontLeftSteerInvert);
	private final SwerveModule m_frontRight = new SwerveModule(kFrontRightSteerID, kFrontRightDriveID,
			kFrontRightSteerOffsetDegrees, kFrontRightSteerInvert);
	private final SwerveModule m_backLeft = new SwerveModule(kBackLeftSteerID, kBackLeftDriveID,
			kBackLeftSteerOffsetDegrees, kBackLeftSteerInvert);
	private final SwerveModule m_backRight = new SwerveModule(kBackRightSteerID, kBackRightDriveID,
			kBackRightSteerOffsetDegrees, kBackRightSteerInvert);
	private final SwerveDriveKinematics m_kinematics = new SwerveDriveKinematics(kFrontLeftOffsetMeters,
			kFrontRightOffsetMeters, kBackLeftOffsetMeters, kBackRightOffsetMeters);

	public void drive(ChassisSpeeds speeds) {
		ChassisSpeeds discreteSpeeds = ChassisSpeeds.discretize(speeds, kModuleResponseTimeSeconds);
		SwerveModuleState[] states = m_kinematics.toSwerveModuleStates(discreteSpeeds, kBackLeftOffsetMeters);
		SwerveDriveKinematics.desaturateWheelSpeeds(states, 1);
		m_frontLeft.drive(states[0]);
		m_frontRight.drive(states[1]);
		m_backLeft.drive(states[2]);
		m_backRight.drive(states[3]);
	}

	public Command driveCommand(Supplier<Double> forwardSpeed, Supplier<Double> strafeSpeed,
			Supplier<Double> rotationSpeed) {
		return run(() -> {
			ChassisSpeeds speeds = new ChassisSpeeds(forwardSpeed.get(), strafeSpeed.get(), rotationSpeed.get());
			drive(speeds);
		});
	}
}