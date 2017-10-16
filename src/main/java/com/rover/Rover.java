package com.rover;

import java.util.Observable;

/**
 * Class which handles com.rover.Rover Movement and state of com.rover.Rover
 */
public class Rover extends Observable{
    RoverState rovState;

    /**
     *
     * @param initState
     */
    public Rover(RoverState initState){
        this.rovState=initState;
        setChanged();
    }



    /****
     * handle the command for rover based upon the current direction of the Rover.
     * @param commands:- Parameter to take the command
     */
    public RoverState handleCommand(RoverCommand [] commands ) throws RoverException {


        for (RoverCommand roverCommand :commands){


                    switch (roverCommand) {
                        case LEFT:
                            rovState.setDirection(RoverDirection.moveLeft(rovState.getDirection()));
                            break;
                        case RIGHT:
                            rovState.setDirection(RoverDirection.moveRight(rovState.getDirection()));
                            break;
                        case MOVE:

                            rovState.move(rovState.getDirection());
                            setChanged();
                            break;
                    }
                RoverException rovEx= new RoverException();
                notifyObservers(rovEx);
                if(rovEx.getException()!=null){
                    throw rovEx.getException();
                }
            }
            return rovState;
        }

    public RoverState getRovState() {
        return rovState;
    }

    public void setRovState(RoverState rovState) {
        this.rovState = rovState;
    }
}