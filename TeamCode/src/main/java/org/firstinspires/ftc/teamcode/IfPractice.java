package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
@Disabled
@TeleOp
public class IfPractice extends OpMode {
    @Override

    public void init() {

    }

    @Override
    public void loop() {
        /*
        Boolean aButton = gamepad1.a;

        if(aButton) {
            telemetry.addData("A Button", "Pressed");
        }
        else {
            telemetry.addData("A Button", "Not Pressed");
        }            telemetry.addData("A Button State", aButton);
         */
        double leftY = gamepad1.left_stick_y;

        if (leftY < 0) {
            telemetry.addData("Left Stick", "Is Negative");
        }
        else if (leftY > 0) { telemetry.addData("Left Stick", "is greater than 0");
        }
            else {
            telemetry.addData("Left Stick", "Is Positive");
        }
        telemetry.addData("left stick value", leftY);
    }


}

/*
And - && if (leftY < 0.5 && LeftY > 0)
or || if (LeftY < 0 || rightY < 0) {
Not! if (!clawclosed)
 */