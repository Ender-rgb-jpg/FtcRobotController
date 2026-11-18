package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.mechanisms.MecanumDrive;

@Autonomous
public class BlueGoalAuto extends OpMode {
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
             drive.drive(0, 0.2);
         } else if (time.seconds() >= 6 && time.seconds() <7.5) {
             drive.drive(-.2, 0);
         } else {
             drive.stop();
         }
    }
}
