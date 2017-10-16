package com.rover;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by zffow on 10/9/17.
 */
public class RoverSurface implements Observer{
    private int maxX;
    private int maxY;
    List<Rover> roverList=new ArrayList<>();

    public RoverSurface(int x, int y){
        this.maxX=x;
        this.maxY=y;

    }
    public void addRover(Rover rover) throws RoverException{
        roverList.add(rover);
        rover.addObserver(this);
        verifyRoverPostion(rover);
    }

    @Override
    public void update(Observable o, Object arg)  {
        if(o instanceof Rover){
            Rover changedRover= (Rover) o;
            try {
                verifyRoverPostion(changedRover);
            }catch (RoverException roEx){
                if (arg instanceof RoverException ) {
                    ((RoverException) arg).setException(roEx);
                }
            }

        }

    }

    private void verifyRoverPostion(Rover movedRover) throws RoverException{
        if(movedRover.rovState.getX()>maxX || movedRover.rovState.getX()<0 ||
                movedRover.rovState.getY()>maxY|| movedRover.rovState.getY()<0){
            throw new RoverException("Rover is outside of plateu surface area");
        }
        for (Rover rover :roverList) {

           if( rover!=movedRover && rover.getRovState().equals(movedRover.getRovState())){

               throw new RoverException("another rover is already on the same position");
               }
           }

        }

    }

