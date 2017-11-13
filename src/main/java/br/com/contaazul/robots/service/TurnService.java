package br.com.contaazul.robots.service;

import br.com.contaazul.robots.exception.InvalidCommandException;
import org.springframework.stereotype.Service;

@Service
public class TurnService {

    public String turn(String actualDirection, char turnSide) {
        int angle = getAngle(actualDirection);

        if ('R' == turnSide) {
            angle += 90;
        } else if ('L' == turnSide) {
            angle -= 90;
        } else {
            throw new InvalidCommandException("Turn side can only be [L] or [R]");
        }

        return getDirection(angle);

    }

    private int getAngle(String actualDirection) {
        if ("N".equals(actualDirection)) {
            return 0;
        } else if ("E".equals(actualDirection)) {
            return 90;
        } else if ("S".equals(actualDirection)) {
            return 180;
        } else {
            return 270;
        }
    }

    private String getDirection(int angle) {
        int adjustedAngle = getAdjustedAngle(angle);

        if (adjustedAngle == 0) {
            return "N";
        } else if (adjustedAngle == 90) {
            return "E";
        } else if (adjustedAngle == 180) {
            return "S";
        } else {
            return "W";
        }

    }

    private int getAdjustedAngle(int angle) {
        if (angle < 0) {
            return (360 - Math.abs(angle)) % 360;
        }

        return angle % 360;
    }

}
