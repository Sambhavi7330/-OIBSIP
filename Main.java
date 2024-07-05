import java.util.ArrayList;
import java.util.Scanner;

class Room {
    private int roomNumber;
    private boolean isAvailable;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        this.isAvailable = true;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}

class Reservation {
    private String guestName;
    private Room room;

    public Reservation(String guestName, Room room) {
        this.guestName = guestName;
        this.room = room;
        room.setAvailable(false);
    }

    public String getGuestName() {
        return guestName;
    }

    public Room getRoom() {
        return room;
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Room> rooms = new ArrayList<>();
        ArrayList<Reservation> reservations = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Initialize rooms
        for (int i = 1; i <= 10; i++) {
            rooms.add(new Room(i));
        }

        while (true) {
            System.out.println("Online Reservation System:");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Make a Reservation");
            System.out.println("3. View Reservations");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Available Rooms:");
                    for (Room room : rooms) {
                        if (room.isAvailable()) {
                            System.out.println("Room " + room.getRoomNumber());
                        }
                    }
                    break;
                case 2:
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter room number to reserve: ");
                    int roomNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    boolean foundRoom = false;
                    for (Room room : rooms) {
                        if (room.getRoomNumber() == roomNumber && room.isAvailable()) {
                            reservations.add(new Reservation(name, room));
                            System.out.println("Reservation successful!");
                            foundRoom = true;
                            break;
                        }
                    }
                    if (!foundRoom) {
                        System.out.println("Room not available or does not exist.");
                    }
                    break;
                case 3:
                    System.out.println("Reservations:");
                    for (Reservation reservation : reservations) {
                        System.out.println("Guest: " + reservation.getGuestName() + ", Room: " + reservation.getRoom().getRoomNumber());
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using the Online Reservation System. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}