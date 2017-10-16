package com.rover;


import java.util.Scanner;

public class RoverMain {

    public static void main(final String[] args) throws RoverException {
        Scanner scanner = new Scanner(System.in);
        try {

            //Rover rover1= new Rover(new RoverState(1,2,RoverDirection.NORTH));
            //Rover rover2 = new Rover(new RoverState(3, 3, RoverDirection.NORTH));
            System.out.println("Please enter Surface Area");


            String surfaceArea = scanner.nextLine();
            String[] surfaceAreaParams = surfaceArea.split(" ");
            if (surfaceAreaParams.length != 2) {
                throw new RoverException("Surface Area parameters are not correct");
            }
            int surfaceX = Integer.parseInt(surfaceAreaParams[0]);
            int surfaceY = Integer.parseInt(surfaceAreaParams[1]);
            RoverSurface roverSurface = new RoverSurface(surfaceX, surfaceY);

            for (int i = 1; i <= 2; i++) {


                System.out.println("Please enter Rover " + i + " location X Y and Directions sprated with a space");
                String[] rsStateParam = (scanner.nextLine().split(" "));
                Rover rover = new Rover(new RoverState(Integer.parseInt(rsStateParam[0]), Integer.parseInt(rsStateParam[1]), RoverDirection.getValueOf(rsStateParam[2])));
                roverSurface.addRover(rover);
                System.out.println("Please enter Rover " + i + " command");
                char[] roverCommand = (scanner.nextLine().toCharArray());
                RoverCommand[] commands = new RoverCommand[roverCommand.length];
                for (int j = 0; j < roverCommand.length; j++) {

                    commands[j] = RoverCommand.getValueOf(roverCommand[j]);

                }
                System.out.println(rover.handleCommand(commands));

            }

        }catch (RoverException roverException){
           roverException.printStackTrace();

        }finally {
            scanner.close();
        }

    }
}
