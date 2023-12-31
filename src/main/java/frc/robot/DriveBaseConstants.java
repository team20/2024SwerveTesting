package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;

public abstract class DriveBaseConstants {
	public int kFLDriveID;
	public int kFRDriveID;
	public int kBLDriveID;
	public int kBRDriveID;

	public int kFLSteerID;
	public int kFRSteerID;
	public int kBLSteerID;
	public int kBRSteerID;

	public int kFLEncoderID;
	public int kFREncoderID;
	public int kBLEncoderID;
	public int kBREncoderID;

	public double kFLModuleOffsetRotations;
	public double kFRModuleOffsetRotations;
	public double kBLModuleOffsetRotations;
	public double kBRModuleOffsetRotations;

	public Translation2d kFLModulePosition;
	public Translation2d kFRModulePosition;
	public Translation2d kBLModulePosition;
	public Translation2d kBRModulePosition;

	public boolean kFLSteerInvert = false;
	public boolean kFRSteerInvert = false;
	public boolean kBLSteerInvert = false;
	public boolean kBRSteerInvert = false;

	public boolean kFLDriveInvert = false;
	public boolean kFRDriveInvert = false;
	public boolean kBLDriveInvert = false;
	public boolean kBRDriveInvert = false;
}
