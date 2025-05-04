import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Create a scanner for input
        Scanner scanner = new Scanner(System.in);

        Map<String, Set<String>> bookingSchedule = new HashMap<>();

        // Ask for user's name
        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();

        // Ask for email
        System.out.print("Enter your email: ");
        String userEmail = scanner.nextLine();
        System.out.println();
        System.out.println("=============================================================");
        System.out.println();
        // Welcome message
        System.out.println("Hello Mr/Ms " + userName);
        System.out.println("Your email: " + userEmail);
        System.out.println();
        
        // Create a list to store golf courses
        List<GolfCourse> golfCourses = new ArrayList<>();

        // Add sample golf courses with hole details and driving range bay count
        GolfCourse course1 = new GolfCourse("Bintan Lagoon Golf Club", "Bintan, Kepulauan Riau", 18, 1500000, 160000, 20);
        course1.addHole(1, 400, 4);
        course1.addHole(2, 370, 3);
        course1.addHole(3, 450, 5);
        course1.addHole(4, 350, 4);
        course1.addHole(5, 420, 4);
        course1.addHole(6, 380, 3);
        course1.addHole(7, 490, 5);
        course1.addHole(8, 430, 4);
        course1.addHole(9, 370, 3);
        course1.addHole(10, 460, 4);
        course1.addHole(11, 420, 4);
        course1.addHole(12, 380, 4);
        course1.addHole(13, 400, 4);
        course1.addHole(14, 450, 5);
        course1.addHole(15, 370, 3);
        course1.addHole(16, 440, 4);
        course1.addHole(17, 420, 4);
        course1.addHole(18, 490, 5);
        course1.addFacility("Driving Range");
        course1.addFacility("Pro Shop");
        course1.addFacility("Shower");
        course1.addFacility("Changing Room");
        course1.addFacility("Golf Cart");

        golfCourses.add(course1);
        
        GolfCourse course2 = new GolfCourse("Riverside Golf Club", "Bogor, Jawa Barat", 18, 1800000,175000, 15);
        course2.addHole(1, 450, 5);
        course2.addHole(2, 380, 4);
        course2.addHole(3, 400, 4);
        course2.addHole(4, 390, 4);
        course2.addHole(5, 420, 4);
        course2.addHole(6, 370, 3);
        course2.addHole(7, 450, 5);
        course2.addHole(8, 410, 4);
        course2.addHole(9, 380, 4);
        course2.addHole(10, 460, 4);
        course2.addHole(11, 420, 4);
        course2.addHole(12, 400, 4);
        course2.addHole(13, 390, 4);
        course2.addHole(14, 470, 5);
        course2.addHole(15, 380, 3);
        course2.addHole(16, 440, 4);
        course2.addHole(17, 430, 4);
        course2.addHole(18, 490, 5);
        course2.addFacility("Caddy Service");
        course2.addFacility("Restaurant");
        course2.addFacility("Shower");
        course2.addFacility("Golf Cart");
        golfCourses.add(course2);

        GolfCourse course3 = new GolfCourse("Sunset Ridge Golf Resort", "Bandung, Jawa Barat", 18, 1700000,150000, 12);
        course3.addHole(1, 420, 4);
        course3.addHole(2, 360, 3);
        course3.addHole(3, 480, 5);
        course3.addHole(4, 430, 4);
        course3.addHole(5, 400, 4);
        course3.addHole(6, 380, 3);
        course3.addHole(7, 500, 5);
        course3.addHole(8, 450, 4);
        course3.addHole(9, 370, 3);
        course3.addHole(10, 470, 4);
        course3.addHole(11, 440, 4);
        course3.addHole(12, 400, 4);
        course3.addHole(13, 420, 4);
        course3.addHole(14, 460, 5);
        course3.addHole(15, 380, 3);
        course3.addHole(16, 430, 4);
        course3.addHole(17, 410, 4);
        course3.addHole(18, 490, 5);
        course3.addFacility("Caddy Service");
        course3.addFacility("Restaurant");
        course3.addFacility("Changing Room");
        course3.addFacility("Shower");
        course3.addFacility("Cart");
        course3.addFacility("Driving Range");
        golfCourses.add(course3);

        // Display all available golf courses
        System.out.println("List available Golf Courses:");
        for (int i = 0; i < golfCourses.size(); i++) {
            System.out.println((i + 1) + ". " + golfCourses.get(i).getName() + " - " + golfCourses.get(i).getLocation());
        }

        // Ask the user to select a golf course for booking
        System.out.print("\nSelect a golf course to book (1 to " + golfCourses.size() + "): ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice < 1 || choice > golfCourses.size()) {
            System.out.println("Invalid choice.");
            return;
        }

        GolfCourse selectedCourse = golfCourses.get(choice - 1);
        double bookingFee = selectedCourse.getCoursePrice();

        // Display information about the selected course and holes
        System.out.println("\nYou selected: " + selectedCourse.getName());
        System.out.println("Location: " + selectedCourse.getLocation());
        System.out.println("Booking Fee: Rp" + bookingFee);
        System.out.println("Facilities available: " + selectedCourse.getFacilities());
        System.out.println("\nHole details:");

        // Display holes information (Par, Distance)
        selectedCourse.displayHoles();

        // Choose between playing golf or driving range
        System.out.print("\nDo you want to play golf or use the driving range? (Enter 'golf' or 'range'): ");
        String activityChoice = scanner.nextLine();
        boolean isDrivingRange = activityChoice.equalsIgnoreCase("range");

        bookingFee = isDrivingRange ? selectedCourse.getDrivingRangePrice() : selectedCourse.getCoursePrice();

        // Ambil waktu booking yang sudah ada (kalau belum ada, buat set baru)
        Set<String> bookedTimes = bookingSchedule.getOrDefault(selectedCourse.getName(), new HashSet<>());

        System.out.println("\nAvailable Time Slots:");
        String[] timeSlots = {"07:00", "08:30", "10:00", "11:30", "13:00", "14:30"};
        for (String slot : timeSlots) {
            if (!bookedTimes.contains(slot)) {
                System.out.println("- " + slot);
            }
        }

        // Input & validasi waktu booking
        String bookingTime;
        while (true) {
            System.out.print("Enter desired booking time: ");
            bookingTime = scanner.nextLine();
            if (!bookedTimes.contains(bookingTime)) {
                break;
            } else {
                System.out.println("Sorry, that time is already booked. Please choose another.");
            }
        }

        // Simpan booking
        bookedTimes.add(bookingTime);
        bookingSchedule.put(selectedCourse.getName(), bookedTimes);

        // FOOD ORDERING SECTION
        double foodTotal = 0.0; 

        List<MenuItem> menu = new ArrayList<>();
        menu.add(new MenuItem("Nasi Goreng", 55000));
        menu.add(new MenuItem("Mie Goreng", 65000));
        menu.add(new MenuItem("Nasi Hainan", 75000));
        menu.add(new MenuItem("Burger", 60000));
        menu.add(new MenuItem("Es Teh", 40000));
        menu.add(new MenuItem("Es Jeruk", 60000));
        menu.add(new MenuItem("Air Mineral", 45000));

        List<MenuItem> orderedItems = new ArrayList<>();
        System.out.print("\nWould you like to order food or drink? (yes/no): ");
        String foodChoice = scanner.nextLine();

        if (foodChoice.equalsIgnoreCase("yes")) {
            boolean ordering = true;
            while (ordering) {
                System.out.println("\nMenu:");
                for (int i = 0; i < menu.size(); i++) {
                    System.out.println((i + 1) + ". " + menu.get(i));
                }
                System.out.print("Select item number to add to order (0 to finish): ");
                int itemChoice = scanner.nextInt();
                scanner.nextLine();

                if (itemChoice == 0) {
                    ordering = false;
                } else if (itemChoice > 0 && itemChoice <= menu.size()) {
                    orderedItems.add(menu.get(itemChoice - 1));
                    System.out.println(menu.get(itemChoice - 1).getName() + " added to your order.");
                } else {
                    System.out.println("Invalid choice.");
                }
            }
        }

        // Calculate food total
        for (MenuItem item : orderedItems) {
            foodTotal += item.getPrice();
        }

        // Total keseluruhan
        double totalPayment = bookingFee + foodTotal;

        // Displaying the total payment
        System.out.printf("\nBooking Fee: Rp%,.0f\n", bookingFee);
        System.out.printf("Food Total: Rp%,.0f\n", foodTotal);
        System.out.printf("\nTotal Payment: Rp%,.0f\n", totalPayment);

        // Tampilkan ringkasan pembayaran
        System.out.println("\n===== PAYMENT SUMMARY =====");
        System.out.println("Booking Fee     : Rp" + bookingFee);
        System.out.println("Food Total      : Rp" + foodTotal);
        System.out.println("Total Payment   : Rp" + totalPayment);

        // Payment method
        System.out.println("\nSelect Payment Method:");
        System.out.println("1. Bank Transfer");
        System.out.println("2. Credit Card");
        System.out.print("Enter your choice (1 or 2): ");
        int paymentMethod = scanner.nextInt();
        scanner.nextLine();  // consume newline

        switch (paymentMethod) {
            case 1:
                System.out.println("\nPlease transfer the amount to the following bank account:");
                System.out.println("Bank: Bank Central Asia (BCA)");
                System.out.println("Account Number: 7380870481");
                System.out.println("Account Name: PT GolfKacaw");
                System.out.println("Pembayaran akan otomatis terkonfirmasi setelah Anda melakukan pembayaran!");
                break;
            case 2:
                System.out.print("\nEnter your Credit Card Number: ");
                String cardNumber = scanner.nextLine();
                System.out.print("Enter Expiry Date (MM/YY): ");
                String expiry = scanner.nextLine();
                System.out.print("Enter CVV: ");
                String cvv = scanner.nextLine();
                System.out.println("Processing payment...");
                System.out.println("Payment successful!");
                break;
            default:
                System.out.println("Invalid payment method selected.");
        }

        // Close the scanner
        scanner.close();
    }
}
