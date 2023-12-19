package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;

public class LBoardConstants extends DriveBaseConstants {
	public LBoardConstants() {
		kFLDriveID = 1;
		kBLDriveID = 7;
		kFRDriveID = 3;
		kBRDriveID = 5;

		kFLSteerID = 2;
		kBLSteerID = 8;
		kFRSteerID = 4;
		kBRSteerID = 6;

		kFLEncoderID = 9;
		kBLEncoderID = 12;
		kFREncoderID = 10;
		kBREncoderID = 11;

		kFLModuleOffsetRotations = -0.139648;
		kFRModuleOffsetRotations = -0.336182;
		kBLModuleOffsetRotations = 0.262451;
		kBRModuleOffsetRotations = -0.376709;

		kFLModulePosition = new Translation2d(0, 0);
		kBLModulePosition = new Translation2d(0, 0);
		kFRModulePosition = new Translation2d(0, 0);
		kBRModulePosition = new Translation2d(0, 0);
	}
}
