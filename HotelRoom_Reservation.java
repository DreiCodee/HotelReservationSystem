import java.util.Scanner;

public class HotelRoom_Reservation {
    public static void main(String[] args) {
        // Initialize 7x5 hotel array (7 floors, 5 rooms per floor)
        int[][] hotel = new int[7][5];
        
        // Sample data as shown in the example
        hotel[1][1] = 1;  // Floor 1, Room 2
        hotel[1][4] = 1;  // Floor 1, Room 5
        hotel[5][3] = 1;  // Floor 2, Room 4
        
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        // Main menu loop
        while (true) {
            System.out.println("\n=== HOTEL RESERVATION SYSTEM ===");
            System.out.println("1. View Rooms");
            System.out.println("2. Check In");
            System.out.println("3. Check Out");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");
            
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    viewRooms(hotel);
                    break;
                case 2:
                    checkIn(hotel, scanner);
                    break;
                case 3:
                    checkOut(hotel, scanner);
                    break;
                case 4:
                    System.out.println("Thank you for using Hotel Reservation System!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please enter 1-4.");
            }
        }
    }
    
    // Display all rooms in the specified format
    public static void viewRooms(int[][] hotel) {
        System.out.println("\n--- CURRENT ROOM STATUS ---");
        // Display from Floor 7 to Floor 1 (reverse order)
        for (int floor = 6; floor >= 0; floor--) {
            System.out.print("Floor " + (floor + 1) + ": ");
            for (int room = 0; room < 5; room++) {
                System.out.print("[" + hotel[floor][room] + "]");
            }
            System.out.println();
        }
        System.out.println("0 = Available, 1 = Occupied");
    }
    
    // Check-in functionality
    public static void checkIn(int[][] hotel, Scanner scanner) {
        System.out.print("Enter floor number (1-7): ");
        int floor = scanner.nextInt() - 1; // Convert to 0-based index
        
        System.out.print("Enter room number (1-5): ");
        int room = scanner.nextInt() - 1; // Convert to 0-based index
        
        // Validate input
        if (floor < 0 || floor > 6 || room < 0 || room > 4) {
            System.out.println("Invalid floor or room number!");
            return;
        }
        
        if (hotel[floor][room] == 0) {
            hotel[floor][room] = 1;
            System.out.println("Room Floor " + (floor + 1) + ", Room " + (room + 1) + " successfully checked in!");
        } else {
            System.out.println("Room already occupied!");
        }
    }
    
    // Check-out functionality
    public static void checkOut(int[][] hotel, Scanner scanner) {
        System.out.print("Enter floor number (1-7): ");
        int floor = scanner.nextInt() - 1; // Convert to 0-based index
        
        System.out.print("Enter room number (1-5): ");
        int room = scanner.nextInt() - 1; // Convert to 0-based index
        
        // Validate input
        if (floor < 0 || floor > 6 || room < 0 || room > 4) {
            System.out.println("Invalid floor or room number!");
            return;
        }
        
        if (hotel[floor][room] == 1) {
            hotel[floor][room] = 0;
            System.out.println("Room Floor " + (floor + 1) + ", Room " + (room + 1) + " successfully checked out!");
        } else {
            System.out.println("Room already empty!");
        }
    }
}