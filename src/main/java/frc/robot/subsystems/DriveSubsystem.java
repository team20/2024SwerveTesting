package frc.robot.subsystems;

import static frc.robot.Constants.*;

import java.util.function.Supplier;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Transform2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.networktables.ProtobufPublisher;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
	private final SwerveModule m_frontLeft = new SwerveModule(DriveBase.kFLSteerID, DriveBase.kFLDriveID,
			DriveBase.kFLModuleOffsetRotations, DriveBase.kFLSteerInvert, DriveBase.kFLEncoderID, -0.139648);

	private final SwerveModule m_frontRight = new SwerveModule(DriveBase.kFRSteerID, DriveBase.kFRDriveID,
			DriveBase.kFRModuleOffsetRotations, DriveBase.kFRSteerInvert, DriveBase.kFREncoderID, -0.336182);

	private final SwerveModule m_backLeft = new SwerveModule(DriveBase.kBLSteerID, DriveBase.kBLDriveID,
			DriveBase.kBLModuleOffsetRotations, DriveBase.kBLSteerInvert, DriveBase.kBREncoderID, 0.262451);

	private final SwerveModule m_backRight = new SwerveModule(DriveBase.kBRSteerID, DriveBase.kBRDriveID,
			DriveBase.kBRModuleOffsetRotations, DriveBase.kBRSteerInvert, DriveBase.kBLEncoderID, -0.376709);

	private final SwerveDriveKinematics m_kinematics = new SwerveDriveKinematics(DriveBase.kFLModuleOffset,
			DriveBase.kFRModuleOffset, DriveBase.kBLModuleOffset, DriveBase.kBRModuleOffset);
	private final AHRS m_gyro = new AHRS();

	private Pose2d m_pose = new Pose2d(0, 0, new Rotation2d(Math.PI / 2));
	private Rotation2d m_heading = new Rotation2d(Math.PI / 2);
	private ProtobufPublisher<Pose2d> m_posePublisher;
	private final Field2d m_field = new Field2d();

	public DriveSubsystem() {
		SmartDashboard.putData("Field", m_field);
		m_gyro.zeroYaw();
		m_posePublisher = NetworkTableInstance.getDefault().getProtobufTopic("Pose", Pose2d.proto).publish();
	}

	@Override
	public void periodic() {
		SmartDashboard.putNumber("Angle", m_frontLeft.getModuleAngle());
	}

	public void drive(ChassisSpeeds speeds) {
		speeds = ChassisSpeeds.fromFieldRelativeSpeeds(speeds, m_heading);
		speeds = ChassisSpeeds.discretize(speeds, kModuleResponseTimeSeconds);
		var transform = new Transform2d(speeds.vxMetersPerSecond * kModuleResponseTimeSeconds,
				speeds.vyMetersPerSecond * kModuleResponseTimeSeconds, new Rotation2d(
						speeds.omegaRadiansPerSecond * kModuleResponseTimeSeconds));

		m_pose = m_pose.plus(transform);
		m_heading = m_pose.getRotation();
		m_posePublisher.set(m_pose);
		SwerveModuleState[] states = m_kinematics.toSwerveModuleStates(speeds, kBackLeftOffsetMeters);
		SwerveDriveKinematics.desaturateWheelSpeeds(states, 1);
		m_frontLeft.drive(states[0]);
		m_frontRight.drive(states[1]);
		m_backLeft.drive(states[2]);
		m_backRight.drive(states[3]);
		m_field.setRobotPose(m_pose);
	}

	public Command driveCommand(Supplier<Double> forwardSpeed, Supplier<Double> strafeSpeed,
			Supplier<Double> rotationSpeed) {
		return run(() -> {
			ChassisSpeeds speeds = new ChassisSpeeds(forwardSpeed.get() * 0.5, strafeSpeed.get() * 0.5,
					rotationSpeed.get());
			drive(speeds);
		});
	}
}