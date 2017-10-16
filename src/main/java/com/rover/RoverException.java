package com.rover;

/**
 * Exception represents invalid commands
 */
public class RoverException extends Exception {
    RoverException ex;
  public RoverException(String msg){
        super(msg);

    }
    public RoverException(){
        super();

    }
    public void setException(RoverException ex){
        this.ex=ex;

    }
    public RoverException getException(){
        return this.ex;

    }


}
