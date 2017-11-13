package br.com.contaazul.robots.service;

import br.com.contaazul.robots.exception.InvalidPositionException;
import org.springframework.stereotype.Service;

@Service
public class MoveService {

    public String move(String directionToMove, String actualPosition) {
        int posX = Integer.valueOf(actualPosition.split(",")[0].trim());
        int posY = Integer.valueOf(actualPosition.split(",")[1].trim());

        if ("N".equals(directionToMove)) {
            posY++;
        } else if ("S".equals(directionToMove)) {
            posY--;
        } else if ("E".equals(directionToMove)) {
            posX++;
        } else {
            posX--;
        }

        if (posX < 0 || posX > 4 || posY < 0 || posY > 4) {
            throw new InvalidPositionException("Position out of bounds. The range limit for X and Y is 0..4");
        }

        return String.format("%d,%d", posX, posY);
    }

}
