package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@Disabled
@TeleOp
public class VariablePractice extends OpMode {
    @Override
    public void init() {
        int teamNumber = 16903;
        double motorSpeed = 0.75;
        boolean clawClosed = true;
        String mechaRavens = "Tyler and Moussa";
        int motorAngle = 60;

        telemetry.addData("Team Number", teamNumber);
        telemetry.addData("Motor Speed", motorSpeed);
        telemetry.addData("Claw State", clawClosed);
        telemetry.addData("Name", mechaRavens);
        telemetry.addData("Motor Angle", motorAngle);
    }

    @Override
    public void loop() {

    }
}
