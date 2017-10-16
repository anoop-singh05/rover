package com.rover;

/**
 * Class
 */
public class RoverState {
    private int x;
    private int y;
    private RoverDirection direction;

    public RoverState(int x, int y, RoverDirection direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public RoverDirection getDirection() {
        return direction;
    }

    public void setDirection(RoverDirection direction) {
        this.direction = direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoverState that = (RoverState) o;

        if (x != that.x) return false;
        if (y != that.y) return false;
        return direction == that.direction;
    }
    public void move(final RoverDirection roverDirection) {
        switch (roverDirection) {
            case NORTH:
                ++y;
                break;
            case EAST:
                ++x;
                break;
            case SOUTH:
                --y;
                break;
            case WEST:
                --x;
                break;
        }
    }

    @Override
    public String toString() {
        return "RoverState{" +
                "x=" + x +
                ", y=" + y +
                ", direction=" + direction +
                '}';
    }
}
