package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.mechanisms.MecanumDrive;

@Autonomous
public class BlueGoalAutoShoot extends OpMode {
    MecanumDrive drive = new MecanumDrive();
    ElapsedTime time = new ElapsedTime();
    boolean startCounting = true;

    @Override
    public void init() {
        drive.init(hardwareMap);

    }

    @Override
    public void loop() {
        while (startCounting) {
            time.reset();
            startCounting = false;
        }

        if (time.seconds() >= 3 && time.seconds() < 4.5) {
             drive.drive(-.3, 0);
        } else if (time.seconds() >= 4.5 && time.seconds() < 6) {
             drive.drive(0, 0.52);
        } else if (time.seconds() >= 6 && time.seconds() <7.5) {
             drive.drive(-.2, 0);
        } else if (time.seconds() >= 7.5 && time.seconds() < 7.7) {
            drive.resetCatapult();
        } else if (time.seconds() >= 7.7 && time.seconds() < 7.9) {
            drive.launch();
        } else if (time.seconds() >= 8 && time.seconds() < 8.5) {
            drive.stop();
            drive.stopCatapult();
        } else if (time.seconds() >= 8.5 && time.seconds() < 10) {
             drive.drive(0, 0.40);
        } else if (time.seconds() >= 10 && time.seconds() < 11.5) {
             drive.drive(-.3, 0);
        } else {
             drive.stop();
             drive.stopCatapult();
        }
    }
}
