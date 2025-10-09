package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class GamePadPractice extends OpMode {

    @Override
    public void init() {

    }

    @Override
    public void loop() {
        double speedForwardLeft = -gamepad1.left_stick_y / 2.0;
        double speedForwardRight = -gamepad1.right_stick_y / 2.0;

        telemetry.addData("x", gamepad1.left_stick_x);
        telemetry.addData("y", speedForwardLeft);
        telemetry.addData("a button", gamepad1.a);
        telemetry.addData("x", gamepad1.right_stick_x);
        telemetry.addData("y", speedForwardRight);

    }
}
