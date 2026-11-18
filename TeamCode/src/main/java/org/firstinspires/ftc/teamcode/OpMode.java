package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.mechanisms.MecanumDrive;

@TeleOp
public class OpMode extends com.qualcomm.robotcore.eventloop.opmode.OpMode {
    MecanumDrive drive = new MecanumDrive();
    ElapsedTime time = new ElapsedTime();
    double forward, rotate;

    @Override
    public void init() {
        drive.init(hardwareMap);
    }

    @Override
    public void loop() {
        forward = gamepad1.left_stick_y;
        rotate = gamepad1.right_stick_x;

        drive.drive(forward, rotate);

/*
        if (gamepad1.right_bumper){
            drive.launch();
        } else if (gamepad1.left_bumper) {
            drive.resetCatapult();
        } else {
            drive.stopCatapult();
        }
 */



        if (gamepad1.right_bumper) {
            boolean loop = true;
            time.reset();
            while (loop) {
                if (time.seconds() > 0 && time.seconds() < .2) {
                    drive.resetCatapult();
                } else if (time.seconds() >= .2 && time.seconds() < .4) {
                    drive.launch();
                } else {
                    drive.stopCatapult();
                    loop = false;

                }

            }
        }
    }
}