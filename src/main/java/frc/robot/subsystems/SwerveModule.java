package frc.robot.subsystems;

import com.ctre.phoenix6.configs.MagnetSensorConfigs;
import com.ctre.phoenix6.hardware.CANcoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import frc.robot.Constants.DriveConstants;

public class SwerveModule {
	private final CANSparkMax m_steer;
	private final CANSparkMax m_drive;
	private final CANcoder m_encoder;
	private final PIDController m_steerController;

	public SwerveModule(int steerMotorID, int driveMotorID, double angleOffset, boolean steerInvert, int encoderID) {
		m_steer = new CANSparkMax(steerMotorID, MotorType.kBrushless);
		m_drive = new CANSparkMax(driveMotorID, MotorType.kBrushless);
		m_encoder = new CANcoder(encoderID);
		m_steerController = new PIDController(DriveConstants.kP, DriveConstants.kI, DriveConstants.kD);

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
		m_steerController.enableContinuousInput(0, 360);
		// 5 degrees of error
		m_steerController.setTolerance(5);
		m_encoder.getConfigurator().apply(new MagnetSensorConfigs().withMagnetOffset(angleOffset));
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
		m_steer.set(MathUtil.clamp(m_steerController.calculate(getModuleAngle(), degrees), -0.5, 0.5));
	}

	/**
	 * Commands the steer motor to go to the specified angle.
	 * 
	 * @param degrees The target angle
	 */
	public double getModuleAngle() {
		return m_encoder.getAbsolutePosition().getValueAsDouble() * 360;
	}

	public boolean atSetpoint() {
		return m_steerController.atSetpoint();
	}

	public double getDriveSpeed() {
		return m_drive.getAppliedOutput();
	}

	public double getSteerSpeed() {
		return m_steer.getAppliedOutput();
	}

	public void drive(SwerveModuleState state) {
		setDriveSpeed(state.speedMetersPerSecond);
		setModuleAngle(state.angle.getDegrees());
	}
}
