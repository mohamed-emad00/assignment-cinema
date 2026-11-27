//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    public static ConcurrentHashMap<Long,Movie> movies = new ConcurrentHashMap<>();
    public static void printMenu(){
        IO.println("1. Display Seats");
        IO.println("2. Book Seat");
        IO.println("3. Cancel Booking");
        IO.println("4. Show All movies");
        IO.println("5. Show number of available and booked seats");
        IO.println("0. Exit");
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        IO.println("Enter the number of the movies: ");
        int noMovies = scan.nextInt();
        scan.nextLine();
        String [] moviesNames = new String[noMovies];
        for(int i=0; i<noMovies; i++){
            IO.print("Enter the movie name no. " + i + ":");
            moviesNames[i] = scan.nextLine();
        }
        IO.println("Enter number of rows that represent the seats: ");
        byte noRows = scan.nextByte();
        IO.println("Enter the number of columns that represent the seats: ");
        byte noColumns = scan.nextByte();

        CinemaArea cinemaArea = CinemaArea.create(noRows,noColumns);

        byte option = -1;
        do{
            printMenu();
            IO.print("Enter the option: ");
            option = scan.nextByte();
            switch (option){
                case 1:
                cinemaArea.printArea();
                break;
                case 2:
                IO.print("Enter the seat to book: ");
                cinemaArea.book(scan.next());
                break;
                case 3:
                IO.print("Enter the seat to unbook: ");
                cinemaArea.unbook(scan.next());
                break;
                case 4:
                IO.println("The movies: ");
                for(int i=0; i < noMovies; i++ ){
                    IO.println(moviesNames[i]);
                }
                break;
                case 5:
                cinemaArea.showSeatsStatus();
                break;
                case 0:
                IO.println("Thank you for dealing with us GoodBye");
                break;
                default:
                IO.println("You have entered invalid option");
            }
        }while (option != 0);
    }
}