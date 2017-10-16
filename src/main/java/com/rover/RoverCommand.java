package com.rover;

/**
 * Rover Class
 */
public enum RoverCommand {

    LEFT,RIGHT,MOVE;

    public static RoverCommand getValueOf(char str) {

        switch (str) {
            case 'L':
                return LEFT;
            case 'R':
                return RIGHT;
            case 'M':
                return MOVE;


        }
        return null;

    }
}
