import com.rover.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static com.rover.RoverCommand.*;

/**
 *
 */

public class TestRover {
    RoverSurface roverSurface=null;

    @BeforeMethod
    public void setUp(){
        roverSurface= new RoverSurface(5,5);
    }

    @Test
    public void testRightTurn()throws  RoverException{
        Rover r1=new Rover(new RoverState(1,2, RoverDirection.NORTH));

        roverSurface.addRover(r1);
        RoverCommand[] commandArray1 ={RIGHT};
        RoverState expRover1State=new RoverState(1,2, RoverDirection.EAST);
        Assert.assertEquals( r1.handleCommand(commandArray1),expRover1State);
    }
    @Test(expectedExceptions = RoverException.class)
    public void testCommandToGoOutOfSurface()throws RoverException{
        Rover r1=new Rover(new RoverState(1,2, RoverDirection.NORTH));

        roverSurface.addRover(r1);
        RoverCommand[] commandArray1 ={MOVE,MOVE,MOVE,MOVE,MOVE,MOVE};
        //RoverState expRover1State=new RoverState(1,2, RoverDirection.WEST);
        r1.handleCommand(commandArray1);

    }

    @Test(expectedExceptions = RoverException.class)
    public void testCommand2RoverAtSameLoc()throws RoverException{
        Rover r1=new Rover(new RoverState(1,2, RoverDirection.NORTH));
        Rover r2=new Rover(new RoverState(1,2, RoverDirection.NORTH));
        roverSurface.addRover(r1);
        roverSurface.addRover(r2);


    }
    @Test
    public void testMoveNorth() throws RoverException{
        Rover r1=new Rover(new RoverState(1,2, RoverDirection.NORTH));

        roverSurface.addRover(r1);
        RoverCommand[] commandArray1 ={MOVE,MOVE};
        RoverState expRover1State=new RoverState(1,4, RoverDirection.NORTH);
        Assert.assertEquals( r1.handleCommand(commandArray1),expRover1State);
    }
    @Test
    public void testMoveSouth() throws RoverException{
        Rover r1=new Rover(new RoverState(1,2, RoverDirection.NORTH));

        roverSurface.addRover(r1);
        RoverCommand[] commandArray1 ={RIGHT,RIGHT,MOVE};
        RoverState expRover1State=new RoverState(1,1, RoverDirection.SOUTH);
        Assert.assertEquals( r1.handleCommand(commandArray1),expRover1State);
    }
    @Test
    public void testMoveEast() throws RoverException{
        Rover r1=new Rover(new RoverState(1,2, RoverDirection.NORTH));

        roverSurface.addRover(r1);
        RoverCommand[] commandArray1 ={RIGHT,MOVE};
        RoverState expRover1State=new RoverState(2,2, RoverDirection.EAST);
        Assert.assertEquals( r1.handleCommand(commandArray1),expRover1State);
    }

    @Test
    public void testMoveWest() throws RoverException{
        Rover r1=new Rover(new RoverState(1,2, RoverDirection.NORTH));

        roverSurface.addRover(r1);
        RoverCommand[] commandArray1 ={LEFT,MOVE};
        RoverState expRover1State=new RoverState(0,2, RoverDirection.WEST);
        Assert.assertEquals( r1.handleCommand(commandArray1),expRover1State);
    }
    @Test
    public void test1Rover() throws RoverException{
        Rover r1=new Rover(new RoverState(1,2, RoverDirection.NORTH));
        roverSurface.addRover(r1);
        RoverState expectedState=new RoverState(1,3, RoverDirection.NORTH);
        RoverCommand[] commandArray ={LEFT,MOVE,LEFT,MOVE,LEFT,MOVE,LEFT,MOVE,MOVE};
        Assert.assertEquals( r1.handleCommand(commandArray),expectedState);

    }

    @Test
    public void test2Rovers() throws RoverException{
        Rover r1=new Rover(new RoverState(1,2, RoverDirection.NORTH));
        Rover r2=new Rover(new RoverState(3,3, RoverDirection.EAST));
        roverSurface.addRover(r1);
        roverSurface.addRover(r2);
        RoverState expRover1State=new RoverState(1,3, RoverDirection.NORTH);
        RoverState expRover2State=new RoverState(5,1, RoverDirection.EAST);
        RoverCommand[] commandArray1 ={LEFT,MOVE,LEFT,MOVE,LEFT,MOVE,LEFT,MOVE,MOVE};
        RoverCommand[] commandArray2 ={MOVE,MOVE,RIGHT,MOVE,MOVE,RIGHT, MOVE,RIGHT,RIGHT,MOVE};
        Assert.assertEquals( r1.handleCommand(commandArray1),expRover1State);
        Assert.assertEquals( r2.handleCommand(commandArray2),expRover2State);

    }

}
