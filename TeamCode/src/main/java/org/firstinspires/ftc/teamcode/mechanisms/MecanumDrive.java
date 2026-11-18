package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class MecanumDrive {

    private DcMotor rightDrive, leftDrive, leftCatapult, rightCatapult;

    private IMU imu;

    ElapsedTime time = new ElapsedTime();

    public void init(HardwareMap hwMap) {

        rightDrive = hwMap.get(DcMotor.class, "right_drive");
        rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        leftDrive = hwMap.get(DcMotor.class, "left_drive");
        leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftDrive.setDirection(DcMotorSimple.Direction.REVERSE);

        rightCatapult = hwMap.get(DcMotor.class, "right_catapult");
        rightCatapult.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightCatapult.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        leftCatapult = hwMap.get(DcMotor.class, "left_catapult");
        leftCatapult.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftCatapult.setDirection(DcMotorSimple.Direction.REVERSE);
        leftCatapult.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        imu = hwMap.get(IMU.class, "imu");

        RevHubOrientationOnRobot RevOrientation = new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.FORWARD,
                RevHubOrientationOnRobot.UsbFacingDirection.DOWN
        );

        imu.initialize(new IMU.Parameters(RevOrientation));
    }

    public void drive(double forward, double rotate) {
        double rightPower = forward - rotate;
        double leftPower = forward + rotate;

        double maxPower = 1.0;
        double maxSpeed = 1.0;

        maxPower = Math.max(maxPower, Math.abs(leftPower));
        maxPower = Math.max(maxPower, Math.abs(rightPower));

        leftDrive.setPower(maxSpeed * (leftPower / maxPower));
        rightDrive.setPower(maxSpeed * (rightPower / maxPower));
    }

    /*
    public void driveFieldRelative(double forward, double rotate) {
        double theta = Math.atan2(forward, strafe);
        double r = Math.hypot(strafe, forward);

        theta = AngleUnit.normalizeRadians(
                theta - imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS)
        );

        double newForward = r * Math.sin(theta);
        double newStrafe = r * Math.cos(theta);

        this.drive(newForward, newStrafe, rotate);
    }
     */

    public void stop(){
        leftDrive.setPower(0);
        rightDrive.setPower(0);
    }

    public void driveForXSeconds(double forward, double rotate, double seconds, double elapsedTime) {
        if (elapsedTime <= seconds + elapsedTime) {
            drive(forward, rotate);
        } else {
            stop();
        }
    }

    public void launch() {
        double launchPower = -1.0;
        rightCatapult.setPower(launchPower);
        leftCatapult.setPower(launchPower);
    }

    public void resetCatapult() {
        rightCatapult.setPower(1);
        leftCatapult.setPower(1);
    }

    public void stopCatapult() {
        rightCatapult.setPower(0);
        leftCatapult.setPower(0);
    }
}