package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.TestBenchServo;

@Disabled
@TeleOp
public class ServoExamples extends OpMode {
    TestBenchServo bench = new TestBenchServo();

    @Override
    public void init() {
        bench.init(hardwareMap);
    }

    @Override
    public void loop() {
        if(gamepad1.a) {
            bench.setServo1Position(0);
        } else {
            bench.setServo1Position(1.0);
        }

        if (gamepad1.b) {
            bench.setServo2Position(0);
        } else {
            bench.setServo2Position(1.0);
        }

        if (gamepad1.x) {
            bench.setServoRot(1);
        } else if (gamepad1.y) {
            bench.setServoRot(-1);
        } else {
            bench.setServoRot(0);
        }
    }
}
