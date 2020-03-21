package CLI;

import Puzzle.ListKR;
import PuzzleElements.Axis;
import PuzzleElements.Bus;
import PuzzleElements.Car;
import PuzzleElements.Vehicle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Application {

    Scanner in = new Scanner(System.in);

    public void printMenu(){
        System.out.println("--- Menu ---");
        System.out.println("1. Play Easy Difficulty Game");
        System.out.println("2. Play Medium Difficulty Game");
        System.out.println("3. Play Hard Difficulty Game");
        System.out.println("4. Quit");

    }

    public void menu(){
        printMenu();
        String menuChoice = in.next();
        switch(menuChoice){
            case "1":
                menuChoice1();
                menu();
                break;

            case "2":
                menuChoice2();
                menu();
                break;

            case "3":
                menuChoice3();
                menu();
                break;

            case "4":
                menuChoice4();
                System.exit(0);
                break;

            default:
                System.out.println("Please enter a correct input");
                menu();
                break;

        }

    }

    public void menuChoice1(){
        ListKR puzzle = new ListKR();
        Car car1 = new Car(new Integer[]{2,3}, Axis.Horizontal, "C1");
        Car car2 = new Car(new Integer[]{2,4},Axis.Horizontal, "C2");
        Car target = new Car(new Integer[]{1,2},Axis.Horizontal, "RR");
        Bus bus1 = new Bus(new Integer[]{3,0},Axis.Vertical, "B1");
        puzzle.addVehicle(car1);
        puzzle.addVehicle(car2);
        puzzle.addVehicle(bus1);
        puzzle.addTargetVehicle(target);

        playGame(puzzle);
    }

    public void menuChoice2(){
        ListKR puzzle = new ListKR();
        Car car1 = new Car(new Integer[]{3,1}, Axis.Vertical, "C1");
        Car car2 = new Car(new Integer[]{3,3},Axis.Vertical, "C2");
        Car car3 = new Car(new Integer[]{2,0},Axis.Horizontal, "C3");
        Car car4 = new Car(new Integer[]{1,0},Axis.Vertical, "C4");
        Car car5 = new Car(new Integer[]{4,0},Axis.Vertical, "C5");

        Car target = new Car(new Integer[]{1,2},Axis.Horizontal, "RR");
        puzzle.addVehicle(car1);
        puzzle.addVehicle(car2);
        puzzle.addVehicle(car3);
        puzzle.addVehicle(car4);
        puzzle.addVehicle(car5);
        puzzle.addTargetVehicle(target);

        this.playGame(puzzle);
    }

    public void menuChoice3(){
        ListKR puzzle = new ListKR(7,new Integer[]{6,2});

        Car car1 = new Car(new Integer[]{1,0},Axis.Vertical, "C1");
        Car car2 = new Car(new Integer[]{3,0},Axis.Horizontal, "C2");
        Car car3 = new Car(new Integer[]{5,2},Axis.Vertical, "C3");
        Car car4 = new Car(new Integer[]{3,3},Axis.Horizontal, "C4");
        Car car5 = new Car(new Integer[]{6,5},Axis.Vertical, "C5");
        Car car6 = new Car(new Integer[]{2,5},Axis.Horizontal, "C6");

        Bus bus1 = new Bus(new Integer[]{2,2},Axis.Vertical, "B1");
        Bus bus2 = new Bus(new Integer[]{3,1},Axis.Horizontal, "B2");
        Bus bus3 = new Bus(new Integer[]{6,2},Axis.Vertical, "B3");
        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>(Arrays.asList(car1,car2,car3,car4,car5,car6,bus1,bus2,bus3));

        puzzle.replaceAllVehicles(vehicles);

        Car target = new Car(new Integer[]{3,2},Axis.Horizontal, "RR");
        puzzle.addTargetVehicle(target);

        playGame(puzzle);
    }

    public void menuChoice4(){
        System.out.println("Quiting game");
    }

    public void playGame(ListKR puzzle){
        while (!puzzle.isPuzzleComplete()){
            System.out.println(puzzle.toString());
            //----------------------------------------------------
            System.out.println("Please Enter Vehicle ID to move");
            String vehicleID = in.next();
            Vehicle theVehicle = puzzle.getVehicle(vehicleID);
            if(theVehicle==null){
                System.out.println("Vehicle Not Found");
                continue;
            }
            //----------------------------------------------------
            //----------------------------------------------------
            System.out.println("Please enter by amount");
            Integer amount = in.nextInt();

            puzzle.moveVehicle(theVehicle,amount);
            //----------------------------------------------------
        }

        System.out.println("Game Won!!!");
    }
    public static void main(String[] args){
        Application app = new Application();
        app.menu();
    }
}
