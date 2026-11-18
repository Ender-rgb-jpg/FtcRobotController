package org.firstinspires.ftc.teamcode.practice;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class TestBench {
    //private DcMotor motor;

    private DcMotor rightFront, leftBack;

    public void init(HardwareMap hwMap) {
        //motor = hwMap.get(DcMotor.class, "motor");
        //motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        rightFront = hwMap.get(DcMotor.class, "right_front_drive");
        rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        leftBack = hwMap.get(DcMotor.class, "left_back_drive");
        leftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftBack.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    /*
    public void setMotorSpeed(double speed) {
        motor.setPower(speed);

     */

    public void setRightFrontSpeed(double speed) {
        rightFront.setPower(speed);
    }

    public void  setLeftBackSpeed(double speed) {
        leftBack.setPower(speed);
    }
}
