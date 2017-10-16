package com.rover;

/**
 * Enum class for Rover Direction
 */
public enum RoverDirection {
    NORTH,WEST,EAST,SOUTH;

    public static RoverDirection moveLeft(final RoverDirection direction) {
        switch (direction) {
            case NORTH: return WEST;
            case EAST:  return NORTH;
            case SOUTH: return EAST;
            case WEST:  return SOUTH;
        }
        return null;
    }

    public static RoverDirection moveRight(final RoverDirection direction) {
        switch (direction) {
            case NORTH: return EAST;
            case EAST:  return SOUTH;
            case SOUTH: return WEST;
            case WEST:  return NORTH;
        }
        return null;
    }
    public static RoverDirection getValueOf(String str) {

        switch (str) {
            case "N":
                return NORTH;
            case "S":
                return SOUTH;
            case "W":
                return WEST;
            case "E":
                return EAST;

        }
        return null;

    }
}


