package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class TestBenchServo {
    private Servo servoPos1;
    private Servo servoPos2;

    public void init(HardwareMap hwMap) {
        servoPos1 = hwMap.get(Servo.class, "servo_pos1");
        servoPos2 = hwMap.get(Servo.class, "servo_pos2");
    }

    public void setServo1Position(double angle) {
        servoPos1.setPosition(angle);
    }
    public void setServo2Position(double angle) {
        servoPos2.setPosition(angle);
    }
}
