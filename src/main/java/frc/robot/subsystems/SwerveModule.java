package frc.robot.subsystems;

import com.revrobotics.AbsoluteEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.SparkMaxAbsoluteEncoder.Type;

import edu.wpi.first.math.kinematics.SwerveModuleState;

import com.revrobotics.SparkMaxPIDController;

import frc.robot.Constants.DriveConstants;

public class SwerveModule {
	private final CANSparkMax m_steer;
	private final CANSparkMax m_drive;
	private final AbsoluteEncoder m_steerEncoder;
	private final SparkMaxPIDController m_steerController;

	public SwerveModule(int steerMotorID, int driveMotorID, double angleOffset, boolean steerInvert) {
		super();
		m_steer = new CANSparkMax(steerMotorID, MotorType.kBrushless);
		m_drive = new CANSparkMax(driveMotorID, MotorType.kBrushless);
		m_steerEncoder = m_steer.getAbsoluteEncoder(Type.kDutyCycle);
		m_steerEncoder.setZeroOffset(angleOffset);
		m_steerController = m_steer.getPIDController();
		m_steer.restoreFactoryDefaults();
		m_steer.setInverted(steerInvert);
		m_steer.setIdleMode(IdleMode.kCoast);
		m_steer.enableVoltageCompensation(12);
		m_steer.setSmartCurrentLimit(DriveConstants.kSmartCurrentLimit);

		m_drive.restoreFactoryDefaults();
		m_drive.setInverted(false);
		m_drive.setIdleMode(IdleMode.kBrake);
		m_drive.enableVoltageCompensation(12);
		m_drive.setSmartCurrentLimit(DriveConstants.kSmartCurrentLimit);
		m_steerController.setP(DriveConstants.kP);
		m_steerController.setI(DriveConstants.kI);
		m_steerController.setIZone(DriveConstants.kIz);
		m_steerController.setD(DriveConstants.kD);
		m_steerController.setPositionPIDWrappingEnabled(true);
		m_steerController.setPositionPIDWrappingMinInput(0);
		m_steerController.setPositionPIDWrappingMaxInput(360);
	}

	/**
	 * Sets the speed of the drive motor.
	 * 
	 * @param speed The percent output
	 */
	public void setDriveSpeed(double speed) {
		m_drive.set(speed);
	}

	/**
	 * Commands the steer motor to go to the specified angle.
	 * 
	 * @param degrees The target angle
	 */
	public void setModuleAngle(double degrees) {
		m_steerController.setReference(degrees, ControlType.kPosition);
	}

	public void drive(SwerveModuleState state) {
		setDriveSpeed(state.speedMetersPerSecond);
		setModuleAngle(state.angle.getDegrees());
	}
}
