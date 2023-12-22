package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;

public class LBoardConstants extends DriveBaseConstants {
	public LBoardConstants() {
		kFLDriveID = 1;
		kFRDriveID = 3;
		kBLDriveID = 7;
		kBRDriveID = 5;

		kFLSteerID = 2;
		kFRSteerID = 4;
		kBLSteerID = 8;
		kBRSteerID = 6;

		kFLEncoderID = 9;
		kFREncoderID = 10;
		kBLEncoderID = 12;
		kBREncoderID = 11;

		kFLModuleOffsetRotations = -0.139648;
		kFRModuleOffsetRotations = -0.336182;
		kBLModuleOffsetRotations = 0.262451;
		kBRModuleOffsetRotations = -0.376709;
		// Centimeters
		kFLModulePosition = new Translation2d(-29.25, 29.25);
		kFRModulePosition = new Translation2d(29.25, 29.25);
		kBLModulePosition = new Translation2d(-29.25, -29.25);
		kBRModulePosition = new Translation2d(29.25, -29.25);
	}
}
