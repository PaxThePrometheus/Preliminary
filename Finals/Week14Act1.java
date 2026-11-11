import java.util.Scanner;

public class Week14Act1 {

    public static void main(String[] args) {


        prog1();
        prog2();
        prog3();
        prog4();
        prog5();
        prog6();
        prog7();
        prog8();
        prog9();
        prog10();

        }

    static void prog1() {
        Scanner obj = new Scanner(System.in);
        int numStudents = 0;

        while (true) {
            System.out.print("Enter the number of students (1-50): ");
            if (obj.hasNextInt()) {
                numStudents = obj.nextInt();
                if (numStudents >= 1 && numStudents <= 50) {
                    break;
                }
            } else {
                obj.next();
            }
            System.out.println("Invalid number of students. Must be between 1 and 50.");
        }

        int[] scores = new int[numStudents];

        for (int x = 0; x < numStudents; x++) {
            while (true) {
                System.out.print("Enter score for Student " + (x + 1) + " (0-100): ");
                if (obj.hasNextInt()) {
                    int prompt = obj.nextInt();
                    if (prompt >= 0 && prompt <= 100) {
                        scores[x] = prompt;
                        break;
                    }
                } else {
                    obj.next();
                }
                System.out.println("Please enter a valid score between 0 and 100.");
            }
        }

        int total = 0;
        int highest = scores[0];
        int lowest = scores[0];
        int passingCount = 0;
        int failingCount = 0;

        for (int x = 0; x < numStudents; x++) {
            int currentScore = scores[x];
            total += currentScore;

            if (currentScore > highest) {
                highest = currentScore;
            }
            if (currentScore < lowest) {
                lowest = currentScore;
            }
            if (currentScore >= 75) {
                passingCount++;
            } else {
                failingCount++;
            }
        }

        double average = (double) total / numStudents;

        System.out.println("\n--- Exam Score Statistics ---");
        System.out.printf("Average Score: %.2f\n", average);
        System.out.println("Highest Score: " + highest);
        System.out.println("Lowest Score: " + lowest);
        System.out.println("Passing Scores (>=75): " + passingCount);
        System.out.println("Failing Scores (<75): " + failingCount);

        System.out.print("Student numbers tied for highest score: ");
        for (int x = 0; x < numStudents; x++) {
            if (scores[x] == highest) {
                System.out.print((x + 1) + " ");
            }
        }
        System.out.println();
    }

    static void prog2() {
        Scanner obj = new Scanner(System.in);
        String[] names = { "Notebook", "Pen", "Folder", "USB" };
        int[] reorder = { 5, 10, 5, 2 };
        int[] target = { 20, 30, 20, 10 };
        int[] stock = new int[4];

        for (int i = 0; i < names.length; i++) {
            while (true) {
                System.out.print("Enter stock quantity for " + names[i] + " (0-10000): ");
                if (obj.hasNextInt()) {
                    int qty = obj.nextInt();
                    if (qty >= 0 && qty <= 10000) {
                        stock[i] = qty;
                        break;
                    }
                } else {
                    obj.next();
                }
                System.out.println("Invalid input. Stock must be between 0 and 10000.");
            }
        }

        int totalStock = 0;
        int totalSuggestedOrder = 0;

        System.out.println("\n--- Stock Reorder Report ---");
        for (int i = 0; i < names.length; i++) {
            totalStock += stock[i];
            if (stock[i] <= reorder[i]) {
                int suggested = target[i] - stock[i];
                totalSuggestedOrder += suggested;
                System.out
                        .println("[FLAGGED] " + names[i] + " - Stock: " + stock[i] + ", Suggested Order: " + suggested);
            } else {
                System.out.println("          " + names[i] + " - Stock: " + stock[i]);
            }
        }
        System.out.println("Total units in stock: " + totalStock);
        System.out.println("Total suggested order: " + totalSuggestedOrder);
    }

    static void prog3() {
        Scanner obj = new Scanner(System.in);
        int[][] sales = new int[3][5];
        int[] branchTotals = new int[3];
        int[] dayTotals = new int[5];
        int grandTotal = 0;

        for (int b = 0; b < 3; b++) {
            for (int d = 0; d < 5; d++) {
                while (true) {
                    System.out.print("Enter sales for Branch " + (b + 1) + ", Day " + (d + 1) + " (0-1000000 PHP): ");
                    if (obj.hasNextInt()) {
                        int amount = obj.nextInt();
                        if (amount >= 0 && amount <= 1000000) {
                            sales[b][d] = amount;
                            break;
                        }
                    } else {
                        obj.next();
                    }
                    System.out.println("Invalid input. Amount must be between 0 and 1000000.");
                }
            }
        }

        for (int b = 0; b < 3; b++) {
            for (int d = 0; d < 5; d++) {
                branchTotals[b] += sales[b][d];
                dayTotals[d] += sales[b][d];
                grandTotal += sales[b][d];
            }
        }

        System.out.println("\n--- Branch Sales Matrix Summary ---");
        for (int b = 0; b < 3; b++) {
            System.out.println("Branch " + (b + 1) + " Total Sales: PHP " + branchTotals[b]);
        }
        for (int d = 0; d < 5; d++) {
            System.out.println("Day " + (d + 1) + " Total Sales: PHP " + dayTotals[d]);
        }
        System.out.println("Grand Total Sales: PHP " + grandTotal);

        int highestTotal = branchTotals[0];
        for (int b = 1; b < 3; b++) {
            if (branchTotals[b] > highestTotal) {
                highestTotal = branchTotals[b];
            }
        }

        System.out.print("Highest branch total achieved by Branch(es): ");
        for (int b = 0; b < 3; b++) {
            if (branchTotals[b] == highestTotal) {
                System.out.print((b + 1) + " ");
            }
        }
        System.out.println();
    }

    static void prog4() {
        Scanner obj = new Scanner(System.in);
        int[][] seats = new int[4][5];
        
        while (true) {
            int availableSeats = 0;
            System.out.println("\n--- Current Seat Layout (0=Available, 1=Booked) ---");
            for (int r = 0; r < 4; r++) {
                for (int c = 0; c < 5; c++) {
                    System.out.print(seats[r][c] + " ");
                    if (seats[r][c] == 0) {
                        availableSeats++;
                    }
                }
                System.out.println();
            }
            System.out.println("Available seats count: " + availableSeats);

            System.out.println("\nMenu:\n1. Book a Seat\n2. Cancel a Booking\n3. Display Layout\n4. Exit");
            System.out.print("Select option: ");
            int option = 0;
            if (obj.hasNextInt()) {
                option = obj.nextInt();
            } else {
                obj.next();
                continue;
            }

            if (option == 4) break;
            if (option == 3) continue;

            if (option == 1 || option == 2) {
                int row = 0, col = 0;
                while (true) {
                    System.out.print("Enter row (1-4): ");
                    if (obj.hasNextInt()) {
                        row = obj.nextInt();
                        if (row >= 1 && row <= 4) break;
                    } else {
                        obj.next();
                    }
                    System.out.println("Invalid row.");
                }
                while (true) {
                    System.out.print("Enter column (1-5): ");
                    if (obj.hasNextInt()) {
                        col = obj.nextInt();
                        if (col >= 1 && col <= 5) break;
                    } else {
                    obj.next();
                    }
                    System.out.println("Invalid column.");
                    }
                int rIdx = row - 1;
                int cIdx = col - 1;
                if (option == 1) {
                    if (seats[rIdx][cIdx] == 1) {
                        System.out.println("Error: Seat is already booked!");
                    } else {
                        seats[rIdx][cIdx] = 1;
                        System.out.println("Seat booked successfully.");
                    }
                } else {
                    if (seats[rIdx][cIdx] == 0) {
                    System.out.println("Error: Seat is already empty!");
                    } else {
                        seats[rIdx][cIdx] = 0;
                        System.out.println("Booking cancelled successfully.");
                    }
                }
            } else {
                System.out.println("Invalid option.");
            }
        }
    }

    static void prog5() {
        Scanner obj = new Scanner(System.in);
        int[][] temperatures = new int[3][4];
        for (int s = 0; s < 3; s++) {
            for (int p = 0; p < 4; p++) {
                while (true) {
                    System.out.print("Enter temp for Sensor " + (s + 1) + ", Period " + (p + 1) + " (-20 to 60 °C): ");
                    if (obj.hasNextInt()) {
                        int temp = obj.nextInt();
                        if (temp >= -20 && temp <= 60) {
                            temperatures[s][p] = temp;
                            break;
                        }
                    } else {
                        obj.next();
                    }
                    System.out.println("Invalid reading. Temperature must be between -20 and 60.");
                }
            }
        }
        System.out.println("\n--- Sensor Averages ---");
        int maxTemp = temperatures[0][0];
        for (int s = 0; s < 3; s++) {
            int sum = 0;
            for (int p = 0; p < 4; p++) {
                sum += temperatures[s][p];
                if (temperatures[s][p] > maxTemp) {
                    maxTemp = temperatures[s][p];
                }
            }
            double avg = (double) sum / 4;
            System.out.printf("Sensor %d Average: %.2f °C\n", (s + 1), avg);
        }
        System.out.println("\n--- High Temperature Alerts (>35 °C) ---");
        for (int s = 0; s < 3; s++) {
            for (int p = 0; p < 4; p++) {
                if (temperatures[s][p] > 35) {
                    System.out.println(
                            "Alert: Sensor " + (s + 1) + ", Period " + (p + 1) + " read " + temperatures[s][p] + " °C");
                }
            }
        }
        System.out.println("\nMaximum Temperature: " + maxTemp + " °C recorded at locations:");
        for (int s = 0; s < 3; s++) {
            for (int p = 0; p < 4; p++) {
                if (temperatures[s][p] == maxTemp) {
                    System.out.println("-> Sensor " + (s + 1) + ", Period " + (p + 1));
                }
            }
        }
    }

    static void prog6() {
        Scanner obj = new Scanner(System.in);
        String[] names = { "USB", "Notebook", "Pen", "Folder" };
        int[] prices = { 350, 200, 20, 15 };
        int[] stock = { 10, 10, 20, 20 };
        int[] cart = new int[4];
        while (true) {
            System.out.println("\n--- Shopping Menu ---");
            System.out.println(
                    "1. Add Item to Cart\n2. Remove Item Quantity\n3. View Cart\n4. Checkout & Pay\n5. Cancel Sale & Exit");
            System.out.print("Select action: ");
            int option = 0;
            if (obj.hasNextInt()) {
                option = obj.nextInt();
            } else {
                obj.next();
                continue;
            }
            if (option == 5) {
                System.out.println("Sale cancelled. Items left in stock unchanged.");
                break;
            }
            if (option == 1) {
                System.out.println("Available items:");
                for (int i = 0; i < 4; i++) {
                    System.out.println(
                            (i + 1) + ". " + names[i] + " (PHP " + prices[i] + ") [In-Stock: " + stock[i] + "]");
                }
                System.out.print("Select product number (1-4): ");
                int pNum = obj.nextInt() - 1;
                if (pNum >= 0 && pNum < 4) {
                    System.out.print("Enter quantity to add: ");
                    int qty = obj.nextInt();
                    if (qty > 0 && (cart[pNum] + qty) <= stock[pNum]) {
                        cart[pNum] += qty;
                        System.out.println("Added to cart.");
                    } else {
                        System.out.println("Invalid quantity or exceeds available stock.");
                    }
                } else {
                    System.out.println("Invalid product selection.");
                }
            } else if (option == 2) {
                System.out.println("Cart contents:");
                for (int i = 0; i < 4; i++) {
                    if (cart[i] > 0) {
                        System.out.println((i + 1) + ". " + names[i] + " [Qty in Cart: " + cart[i] + "]");
                    }
                }
                System.out.print("Select product number to reduce: ");
                int pNum = obj.nextInt() - 1;
                if (pNum >= 0 && pNum < 4 && cart[pNum] > 0) {
                    System.out.print("Enter quantity to remove: ");
                    int qty = obj.nextInt();
                    if (qty > 0 && qty <= cart[pNum]) {
                        cart[pNum] -= qty;
                        System.out.println("Removed from cart.");
                    } else {
                        System.out.println("Invalid removal quantity.");
                    }
                } else {
                    System.out.println("Invalid selection.");
                }
            } else if (option == 3) {
                System.out.println("\n--- Current Cart ---");
                int subtotal = 0;
                for (int i = 0; i < 4; i++) {
                    if (cart[i] > 0) {
                        int itemTotal = cart[i] * prices[i];
                        subtotal += itemTotal;
                        System.out.println(names[i] + " x" + cart[i] + " = PHP " + itemTotal);
                    }
                }
                System.out.println("Subtotal: PHP " + subtotal);
            } else if (option == 4) {
                int subtotal = 0;
                boolean empty = true;
                for (int i = 0; i < 4; i++) {
                    if (cart[i] > 0) {
                        subtotal += cart[i] * prices[i];
                        empty = false;
                    }
                }
                if (empty) {
                    System.out.println("Cart is empty! Cannot checkout.");
                    continue;
                }
                double finalAmount = subtotal;
                long finalCentavos = subtotal * 100L;
                if (subtotal >= 1000) {
                    long discountCentavos = Math.round((subtotal * 0.10) * 100.0);
                    finalCentavos = (subtotal * 100L) - discountCentavos;
                    finalAmount = finalCentavos / 100.0;
                    System.out.printf("10%% Discount Applied! Saved PHP %.2f\n", (discountCentavos / 100.0));
                }
                System.out.printf("Total Amount Due: PHP %.2f\n", finalAmount);
                System.out.print("Enter cash payment (whole pesos): ");
                int cash = obj.nextInt();
                if (cash < finalAmount) {
                    System.out.println("Insufficient payment. Checkout aborted.");
                } else {
                    double change = cash - finalAmount;
                    System.out.println("\n--- RECEIPT ---");
                    for (int i = 0; i < 4; i++) {
                        if (cart[i] > 0) {
                            System.out.println(names[i] + " x" + cart[i] + " : PHP " + (cart[i] * prices[i]));
                            stock[i] -= cart[i];
                        }
                    }
                    System.out.printf("Total Paid: PHP %d.00\n", cash);
                    System.out.printf("Final Due:  PHP %.2f\n", finalAmount);
                    System.out.printf("Change:     PHP %.2f\n", change);
                    System.out.println("Transaction complete. Goodbye!");
                    break;
                }
            }
        }
    }

    static void prog7() {
        Scanner obj = new Scanner(System.in);
        int[][] stock = {
                { 20, 30, 40, 50 },
                { 15, 25, 35, 45 },
                { 10, 20, 30, 40 }
        };
        int[][] history = new int[50][4];
        int historyCount = 0;
        while (true) {
            System.out.println("\n--- Warehouse Current Stock ---");
            int totalAcross = 0;
            for (int p = 0; p < 4; p++) {
                int pTotal = stock[0][p] + stock[1][p] + stock[2][p];
                totalAcross += pTotal;
                System.out.println("Product " + (p + 1) + " combined stock across warehouses: " + pTotal);
            }
            System.out.println("\nMenu:\n1. Transfer Stock\n2. Show Operations History\n3. Exit");
            System.out.print("Option: ");
            int opt = 0;
            if (obj.hasNextInt()) {
                opt = obj.nextInt();
            } else {
                obj.next();
                continue;
            }
            if (opt == 3)
                break;
            if (opt == 1) {
                if (historyCount >= 50) {
                    System.out.println("Error: History logs full! No further transfers allowed.");
                    continue;
                }
                System.out.print("Enter source warehouse (1-3): ");
                int src = obj.nextInt();
                System.out.print("Enter destination warehouse (1-3): ");
                int dest = obj.nextInt();
                System.out.print("Enter product index (1-4): ");
                int prod = obj.nextInt();
                System.out.print("Enter quantity to transfer: ");
                int qty = obj.nextInt();
                if (src < 1 || src > 3 || dest < 1 || dest > 3 || prod < 1 || prod > 4 || qty <= 0) {
                    System.out.println("Error: Invalid warehouse or product selections.");
                    continue;
                }
                if (src == dest) {
                    System.out.println("Error: Source and destination cannot be identical.");
                    continue;
                }
                int sIdx = src - 1;
                int dIdx = dest - 1;
                int pIdx = prod - 1;
                if (stock[sIdx][pIdx] < qty) {
                    System.out.println("Error: Insufficient stock at source warehouse.");
                } else if (stock[dIdx][pIdx] + qty > 1000) {
                    System.out.println("Error: Destination warehouse capacity exceeded (max 1000).");
                } else {
                    stock[sIdx][pIdx] -= qty;
                    stock[dIdx][pIdx] += qty;
                    history[historyCount][0] = src;
                    history[historyCount][1] = dest;
                    history[historyCount][2] = prod;
                    history[historyCount][3] = qty;
                    historyCount++;
                    System.out.println("Transfer successful and recorded in history log.");
                }
            } else if (opt == 2) {
                System.out.println("\n--- Audit Trail History ---");
                if (historyCount == 0) {
                    System.out.println("No records found.");
                }
                for (int i = 0; i < historyCount; i++) {
                    System.out.printf("Log #%d: Transferred %d units of Product %d from WH %d to WH %d\n",
                            (i + 1), history[i][3], history[i][2], history[i][0], history[i][1]);
                }
            }
        }
    }

    static void prog8() {
        Scanner obj = new Scanner(System.in);
        int n = 0;
        while (true) {
            System.out.print("Enter number of students (2-10): ");
            if (obj.hasNextInt()) {
                n = obj.nextInt();
                if (n >= 2 && n <= 10)
                    break;
            } else {
                obj.next();
            }
            System.out.println("Invalid input range.");
        }
        int[][] marks = new int[n][4];
        double[] averages = new double[n];
        int[] order = new int[n];
        for (int i = 0; i < n; i++) {
            order[i] = i;
            int studentSum = 0;
            boolean failedSubject = false;
            System.out.println("Entering scores for Student " + (i + 1) + ":");
            for (int s = 0; s < 4; s++) {
                while (true) {
                    System.out.print("  Subject " + (s + 1) + " (0-100): ");
                    if (obj.hasNextInt()) {
                        int score = obj.nextInt();
                        if (score >= 0 && score <= 100) {
                            marks[i][s] = score;
                            studentSum += score;
                            break;
                        }
                    } else {
                        obj.next();
                    }
                    System.out.println("Invalid score range.");
                }
            }
            averages[i] = studentSum / 4.0;
        }
        int[] subjectSum = new int[4];
        for (int s = 0; s < 4; s++) {
            for (int i = 0; i < n; i++) {
                subjectSum[s] += marks[i][s];
            }
        }
        System.out.println("\n--- Subject Analysis ---");
        double lowestSubjectAvg = subjectSum[0] / (double) n;
        for (int s = 1; s < 4; s++) {
            double currentAvg = subjectSum[s] / (double) n;
            if (currentAvg < lowestSubjectAvg) {
                lowestSubjectAvg = currentAvg;
            }
        }
        System.out.print("Subject(s) tied for lowest performance average: ");
        for (int s = 0; s < 4; s++) {
            double currentAvg = subjectSum[s] / (double) n;
            if (Math.abs(currentAvg - lowestSubjectAvg) < 0.0001) {
                System.out.print((s + 1) + " ");
            }
        }
        System.out.println();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (averages[order[i]] < averages[order[j]]) {
                    int temp = order[i];
                    order[i] = order[j];
                    order[j] = temp;
                }
            }
        }
        System.out.println("\n--- Rank Leaderboard ---");
        int currentRank = 1;
        for (int i = 0; i < n; i++) {
            if (i > 0 && averages[order[i]] < averages[order[i - 1]]) {
                currentRank = i + 1;
            }
            int sIdx = order[i];
            boolean qualified = (averages[sIdx] >= 75);
            for (int s = 0; s < 4; s++) {
                if (marks[sIdx][s] < 60) {
                    qualified = false;
                }
            }
            System.out.printf("Rank %d | Student %d | Average: %.2f | Status: %s\n",
                    currentRank, (sIdx + 1), averages[sIdx], (qualified ? "Qualified" : "Not Qualified"));
        }
    }

    static void prog9() {
        Scanner obj = new Scanner(System.in);
        int[][] seats = new int[5][8];
        int bookingIdCounter = 1;
        while (true) {
            System.out.println("\n--- Theater Row Layout ---");
            int availableCount = 0;
            for (int r = 0; r < 5; r++) {
                System.out.print("Row " + (r + 1) + ": ");
                for (int c = 0; c < 8; c++) {
                    System.out.printf("[%2d] ", seats[r][c]);
                    if (seats[r][c] == 0)
                        availableCount++;
                }
                System.out.println();
            }
            System.out.println("Total seats vacant: " + availableCount);
            System.out.println("\n1. Group Booking\n2. Cancel Booking ID\n3. Exit");
            System.out.print("Option choice: ");
            int choice = 0;
            if (obj.hasNextInt()) {
                choice = obj.nextInt();
            } else {
                obj.next();
                continue;
            }
            if (choice == 3)
                break;
            if (choice == 1) {
                System.out.print("Enter size of group (1-8): ");
                int size = obj.nextInt();
                if (size < 1 || size > 8) {
                    System.out.println("Invalid group size configuration requested.");
                    continue;
                }
                boolean assigned = false;
                for (int r = 0; r < 5; r++) {
                    int contiguousCount = 0;
                    int startCol = -1;
                    for (int c = 0; c < 8; c++) {
                        if (seats[r][c] == 0) {
                            if (contiguousCount == 0)
                                startCol = c;
                            contiguousCount++;
                            if (contiguousCount == size) {
                                for (int k = startCol; k <= c; k++) {
                                    seats[r][k] = bookingIdCounter;
                                }
                                System.out.println("Successfully reserved with Booking ID: " + bookingIdCounter);
                                bookingIdCounter++;
                                assigned = true;
                                break;
                            }
                        } else {
                            contiguousCount = 0;
                        }
                    }
                    if (assigned)
                        break;
                }
                if (!assigned) {
                    System.out.println("No single row contains enough contiguous free seats for this group.");
                }
            } else if (choice == 2) {
                System.out.print("Enter Booking ID to remove: ");
                int targetId = obj.nextInt();
                boolean removed = false;
                if (targetId > 0) {
                    for (int r = 0; r < 5; r++) {
                        for (int c = 0; c < 8; c++) {
                            if (seats[r][c] == targetId) {
                                seats[r][c] = 0;
                                removed = true;
                            }
                        }
                    }
                }
                if (removed) {
                    System.out.println("Booking ID " + targetId + " successfully removed.");
                } else {
                    System.out.println("Error: Specified Booking ID could not be matched.");
                }
            }
        }
    }

    static void prog10() {
        Scanner obj = new Scanner(System.in);
        String[] pNames = { "Product A", "Product B", "Product C" };
        int[] openStock = { 10, 15, 20 };
        int[] reorderLevel = { 5, 5, 5 };
        int[] unitPrice = { 100, 50, 25 };
        int[][] received = new int[3][7];
        int[][] demand = new int[3][7];
        int[][] sold = new int[3][7];
        int[][] closing = new int[3][7];
        int[] currentStock = new int[3];
        for (int p = 0; p < 3; p++) {
            currentStock[p] = openStock[p];
        }
        int[] totalUnitsSold = new int[3];
        int[] totalLostUnits = new int[3];
        int[] totalRevenue = new int[3];
        int[] dailyRevenue = new int[7];
        for (int day = 0; day < 7; day++) {
            System.out.println("\n--- DAY " + (day + 1) + " SIMULATION INPUTS ---");
            for (int p = 0; p < 3; p++) {
                System.out.println(pNames[p] + " (Current Stock before delivery: " + currentStock[p] + ")");
                int del = 0;
                while (true) {
                    System.out.print("  Enter incoming delivery units (0-1000): ");
                    if (obj.hasNextInt()) {
                        del = obj.nextInt();
                        if (del >= 0 && del <= 1000)
                            break;
                    } else {
                        obj.next();
                    }
                    System.out.println("Invalid amount.");
                }
                received[p][day] = del;
                currentStock[p] += del;
                int dem = 0;
                while (true) {
                    System.out.print("  Enter consumer market demand units (0-1000): ");
                    if (obj.hasNextInt()) {
                        dem = obj.nextInt();
                        if (dem >= 0 && dem <= 1000)
                            break;
                    } else {
                        obj.next();
                    }
                    System.out.println("Invalid amount.");
                }
                demand[p][day] = dem;
                int actualSales = (dem <= currentStock[p]) ? dem : currentStock[p];
                int lost = dem - actualSales;
                currentStock[p] -= actualSales;
                sold[p][day] = actualSales;
                closing[p][day] = currentStock[p];
                totalUnitsSold[p] += actualSales;
                totalLostUnits[p] += lost;
                int itemRevenue = actualSales * unitPrice[p];
                totalRevenue[p] += itemRevenue;
                dailyRevenue[day] += itemRevenue;
            }
        }
        System.out.println("\n=== SIMULATION RESULTS & AUDIT PERFORMANCE ===");
        for (int p = 0; p < 3; p++) {
            System.out.println("\n" + pNames[p] + " Analytics Summary:");
            System.out.println("  Total Units Sold: " + totalUnitsSold[p]);
            System.out.println("  Total Lost Demand Units: " + totalLostUnits[p]);
            System.out.println("  Total Product Generated Revenue: PHP " + totalRevenue[p]);
            System.out.println("  Final Ending Stock: " + currentStock[p]);
            if (currentStock[p] <= reorderLevel[p]) {
                System.out.println("  [ALERT] Low Stock Condition Detected!");
            }
            int sumDel = 0, sumSales = 0;
            for (int d = 0; d < 7; d++) {
                sumDel += received[p][d];
                sumSales += sold[p][d];
            }
            boolean auditPassed = (openStock[p] + sumDel - sumSales == closing[p][6]);
            System.out.println("  Audit Baseline Verification: " + (auditPassed ? "PASSED" : "FAILED"));
        }
        System.out.println("\n--- Daily Revenue Metrics ---");
        int maxDailyRev = dailyRevenue[0];
        for (int d = 1; d < 7; d++) {
            System.out.println("  Day " + (d + 1) + ": PHP " + dailyRevenue[d]);
            if (dailyRevenue[d] > maxDailyRev) {
                maxDailyRev = dailyRevenue[d];
            }
        }
        System.out.print("Day(s) tied for capturing the highest peak revenue: ");
        for (int d = 0; d < 7; d++) {
            if (dailyRevenue[d] == maxDailyRev) {
                System.out.print("Day " + (d + 1) + " ");
            }
        }
        System.out.println(" (PHP " + maxDailyRev + ")");
    }
}
