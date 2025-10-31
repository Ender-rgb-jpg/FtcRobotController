package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.TestBench;
@TeleOp
public class DcMotorPractice extends OpMode {
    TestBench bench = new TestBench();
    public void init() {
        bench.init(hardwareMap);
    }

    public void loop() {
        telemetry.addData("Motor Speed", -gamepad1.left_stick_y);
        if (gamepad1.a) {
            bench.setMotorSpeed(1);
        } else if (gamepad1.b) {
            bench.setMotorSpeed(-1);
        }

        else {
            bench.setMotorSpeed(0);
        }
    }

}
