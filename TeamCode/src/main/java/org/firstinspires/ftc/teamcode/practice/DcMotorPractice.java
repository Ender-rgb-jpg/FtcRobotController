package org.firstinspires.ftc.teamcode.practice;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
@Disabled
public class DcMotorPractice extends OpMode {
    TestBench bench = new TestBench();
    public void init() {
        bench.init(hardwareMap);
    }

    public void loop() {
        /*
        telemetry.addData("Motor Speed", -gamepad1.left_stick_y);
        if (gamepad1.a) {
            bench.setMotorSpeed(1);
        } else if (gamepad1.b) {
            bench.setMotorSpeed(-1);
        }

        else {
            bench.setMotorSpeed(0);
        }
         */

        if (gamepad1.a) {
            bench.setRightFrontSpeed(1);
        } else if(gamepad1.b) {
            bench.setLeftBackSpeed(1);
        } else {
            bench.setLeftBackSpeed(0);
            bench.setRightFrontSpeed(0);
        }
    }

}
