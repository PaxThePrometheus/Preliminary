import java.util.NoSuchElementException;
import java.util.Scanner;

public class Week14Act1 {
    static Scanner obj = new Scanner(System.in);

    public static void main(String[] args) {
        try {
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
        } catch (NoSuchElementException e) {
            System.out.println("\nInput ended. pped safely.");
        } finally {
            obj.close();
        }
    }

    static int readInt(String prompt, int min, int max) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = Integer.parseInt(obj.nextLine().trim());

                if (value < min || value > max) {
                    throw new IllegalArgumentException("Value must be between " + min + " and " + max + ".");
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a whole number.");
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input. " + e.getMessage());
            }
        }
    }

    static void prog1() {
        System.out.println("Exam Score Statistics");
        int numStudents = readInt("Enter the number of students (1-50): ", 1, 50);
        int[] scores = new int[numStudents];

        for (int x = 0; x < numStudents; x++) {
            scores[x] = readInt("Enter score for Student " + (x + 1) + " (0-100): ", 0, 100);
        }

        int total = 0;
        int highest = scores[0];
        int lowest = scores[0];
        int passingCount = 0;
        int failingCount = 0;

        for (int x = 0; x < numStudents; x++) {
            int currentScore = scores[x];
            total += currentScore;

            if (currentScore > highest) highest = currentScore;
            if (currentScore < lowest) lowest = currentScore;
            if (currentScore >= 75) passingCount++;
            else failingCount++;
        }

        double average = (double) total / numStudents;
        System.out.println("Exam Score Statistics");
        System.out.printf("Average Score: %.2f%n", average);
        System.out.println("Highest Score: " + highest);
        System.out.println("Lowest Score: " + lowest);
        System.out.println("Passing Scores (>=75): " + passingCount);
        System.out.println("Failing Scores (<75): " + failingCount);
        System.out.print("Student numbers tied for highest score: ");

        for (int x = 0; x < numStudents; x++) {
            if (scores[x] == highest) System.out.print((x + 1) + " ");
        }
        System.out.println();
    }

    static void prog2() {
        System.out.println("Stock Reorder Report");
        String[] names = { "Notebook", "Pen", "Folder", "USB" };
        int[] reorder = { 5, 10, 5, 2 };
        int[] target = { 20, 30, 20, 10 };
        int[] stock = new int[4];

        for (int x = 0; x < names.length; x++) {
            stock[x] = readInt("Enter stock quantity for " + names[x] + " (0-10000): ", 0, 10000);
        }

        int totalStock = 0;
        int totalSuggestedOrder = 0;
        System.out.println("Stock Reorder Report");

        for (int x = 0; x < names.length; x++) {
            totalStock += stock[x];
            if (stock[x] <= reorder[x]) {
                int suggested = target[x] - stock[x];
                totalSuggestedOrder += suggested;
                System.out.println("[FLAGGED] " + names[x] + " - Stock: " + stock[x] + ", Suggested Order: " + suggested);
            } else {
                System.out.println(names[x] + " - Stock: " + stock[x]);
            }
        }

        System.out.println("Total units in stock: " + totalStock);
        System.out.println("Total suggested order: " + totalSuggestedOrder);
    }

    static void prog3() {
        System.out.println("Branch Sales Matrix");
        int[][] sales = new int[3][5];
        int[] branchTotals = new int[3];
        int[] dayTotals = new int[5];
        int grandTotal = 0;

        for (int b = 0; b < 3; b++) {
            for (int d = 0; d < 5; d++) {
                sales[b][d] = readInt("Enter sales for Branch " + (b + 1) + ", Day " + (d + 1) + " (0-1000000 PHP): ", 0, 1000000);
            }
        }

        for (int b = 0; b < 3; b++) {
            for (int d = 0; d < 5; d++) {
                branchTotals[b] += sales[b][d];
                dayTotals[d] += sales[b][d];
                grandTotal += sales[b][d];
            }
        }

        System.out.println("Branch Sales Matrix Summary");
        for (int b = 0; b < 3; b++) {
            System.out.println("Branch " + (b + 1) + " Total Sales: PHP " + branchTotals[b]);
        }
        for (int d = 0; d < 5; d++) {
            System.out.println("Day " + (d + 1) + " Total Sales: PHP " + dayTotals[d]);
        }
        System.out.println("Grand Total Sales: PHP " + grandTotal);

        int highestTotal = branchTotals[0];
        for (int b = 1; b < 3; b++) {
            if (branchTotals[b] > highestTotal) highestTotal = branchTotals[b];
        }
        System.out.print("Highest branch total achieved by Branch(es): ");
        for (int b = 0; b < 3; b++) {
            if (branchTotals[b] == highestTotal) System.out.print((b + 1) + " ");
        }
        System.out.println();
    }

    static void prog4() {
        System.out.println("Seat Booking");
        int[][] seats = new int[4][5];

        while (true) {
            int availableSeats = 0;
            System.out.println("Current Seat Layout (0=Available, 1=Booked)");
            for (int r = 0; r < 4; r++) {
                for (int c = 0; c < 5; c++) {
                    System.out.print(seats[r][c] + " ");
                    if (seats[r][c] == 0) availableSeats++;
                }
                System.out.println();
            }
            System.out.println("Available seats count: " + availableSeats);
            System.out.println("\nMenu:\n1. Book a Seat\n2. Cancel a Booking\n3. Display Layout\n4. Exit");
            int option = readInt("Select option: ", 1, 4);

            if (option == 4) break;
            if (option == 3) continue;

            int row = readInt("Enter row (1-4): ", 1, 4) - 1;
            int col = readInt("Enter column (1-5): ", 1, 5) - 1;

            try {
                if (option == 1) {
                    if (seats[row][col] == 1) throw new IllegalStateException("Seat is already booked.");
                    seats[row][col] = 1;
                    System.out.println("Seat booked successfully.");
                } else if (option == 2) {
                    if (seats[row][col] == 0) throw new IllegalStateException("Seat is already empty.");
                    seats[row][col] = 0;
                    System.out.println("Booking cancelled successfully.");
                }
            } catch (IllegalStateException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    static void prog5() {
        System.out.println("Temperature Sensors");
        int[][] temperatures = new int[3][4];

        for (int s = 0; s < 3; s++) {
            for (int p = 0; p < 4; p++) {
                temperatures[s][p] = readInt("Enter temp for Sensor " + (s + 1) + ", Period " + (p + 1) + " (-20 to 60 C): ", -20, 60);
            }
        }

        int maxTemp = temperatures[0][0];
        System.out.println("Sensor Averages");
        for (int s = 0; s < 3; s++) {
            int sum = 0;
            for (int p = 0; p < 4; p++) {
                sum += temperatures[s][p];
                if (temperatures[s][p] > maxTemp) maxTemp = temperatures[s][p];
            }
            System.out.printf("Sensor %d Average: %.2f C%n", s + 1, sum / 4.0);
        }

        System.out.println("High Temperature Alerts (>35 C)");
        for (int s = 0; s < 3; s++) {
            for (int p = 0; p < 4; p++) {
                if (temperatures[s][p] > 35) {
                    System.out.println("Alert: Sensor " + (s + 1) + ", Period " + (p + 1) + " read " + temperatures[s][p] + " C");
                }
            }
        }

        System.out.println("\nMaximum Temperature: " + maxTemp + " C recorded at locations:");
        for (int s = 0; s < 3; s++) {
            for (int p = 0; p < 4; p++) {
                if (temperatures[s][p] == maxTemp) {
                    System.out.println("-> Sensor " + (s + 1) + ", Period " + (p + 1));
                }
            }
        }
    }

    static void prog6() {
        System.out.println("Shopping Cart");
        String[] names = { "USB", "Notebook", "Pen", "Folder" };
        int[] prices = { 350, 200, 20, 15 };
        int[] stock = { 10, 10, 20, 20 };
        int[] cart = new int[4];

        while (true) {
            System.out.println("Shopping Menu");
            System.out.println("1. Add Item to Cart\n2. Remove Item Quantity\n3. View Cart\n4. Checkout & Pay\n5. Cancel Sale & Exit");
            int option = readInt("Select action: ", 1, 5);

            if (option == 5) {
                System.out.println("Sale cancelled. Items left in stock unchanged.");
                break;
            }

            try {
                if (option == 1) {
                    System.out.println("Available items:");
                    for (int x = 0; x < names.length; x++) {
                        System.out.println((x + 1) + ". " + names[x] + " (PHP " + prices[x] + ") [In-Stock: " + stock[x] + "]");
                    }
                    int pNum = readInt("Select product number (1-4): ", 1, 4) - 1;
                    int qty = readInt("Enter quantity to add: ", 1, Integer.MAX_VALUE);

                    if (qty > stock[pNum] - cart[pNum]) {
                        throw new IllegalArgumentException("Quantity exceeds available stock.");
                    }
                    cart[pNum] += qty;
                    System.out.println("Added to cart.");

                } else if (option == 2) {
                    System.out.println("Cart contents:");
                    for (int x = 0; x < names.length; x++) {
                        if (cart[x] > 0) {
                            System.out.println((x + 1) + ". " + names[x] + " [Qty in Cart: " + cart[x] + "]");
                        }
                    }
                    int pNum = readInt("Select product number to reduce (1-4): ", 1, 4) - 1;
                    if (cart[pNum] == 0) throw new IllegalStateException("That product is not in the cart.");

                    int qty = readInt("Enter quantity to remove: ", 1, Integer.MAX_VALUE);
                    if (qty > cart[pNum]) throw new IllegalArgumentException("Cannot remove more than the cart contains.");
                    cart[pNum] -= qty;
                    System.out.println("Removed from cart.");

                } else if (option == 3) {
                    System.out.println("Current Cart");
                    int subtotal = 0;
                    for (int x = 0; x < names.length; x++) {
                        if (cart[x] > 0) {
                            int itemTotal = cart[x] * prices[x];
                            subtotal += itemTotal;
                            System.out.println(names[x] + " x" + cart[x] + " = PHP " + itemTotal);
                        }
                    }
                    System.out.println("Subtotal: PHP " + subtotal);

                } else if (option == 4) {
                    int subtotal = 0;
                    for (int x = 0; x < names.length; x++) {
                        subtotal += cart[x] * prices[x];
                    }
                    if (subtotal == 0) throw new IllegalStateException("Cart is empty. Cannot checkout.");

                    // Whole-peso prices and a 10% discount; calculation is exact in centavos.
                    long discountCentavos = subtotal >= 1000 ? subtotal * 10L : 0L;
                    long dueCentavos = subtotal * 100L - discountCentavos;
                    double finalAmount = dueCentavos / 100.0;

                    if (discountCentavos > 0) {
                        System.out.printf("10%% Discount Applied! Saved PHP %.2f%n", discountCentavos / 100.0);
                    }
                    System.out.printf("Total Amount Due: PHP %.2f%n", finalAmount);
                    int cash = readInt("Enter cash payment (whole pesos): ", 0, Integer.MAX_VALUE);
                    if (cash * 100L < dueCentavos) throw new IllegalArgumentException("Insufficient payment. Checkout aborted.");

                    System.out.println("RECEIPT");
                    for (int x = 0; x < names.length; x++) {
                        if (cart[x] > 0) {
                            System.out.println(names[x] + " x" + cart[x] + " : PHP " + (cart[x] * prices[x]));
                            stock[x] -= cart[x];
                        }
                    }
                    System.out.printf("Total Paid: PHP %d.00%n", cash);
                    System.out.printf("Final Due: PHP %.2f%n", finalAmount);
                    System.out.printf("Change: PHP %.2f%n", (cash * 100L - dueCentavos) / 100.0);
                    System.out.println("Transaction complete. Goodbye!");
                    break;
                }
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    static void prog7() {
        System.out.println("Warehouse Transfers");
        int[][] stock = {
            { 20, 30, 40, 50 },
            { 15, 25, 35, 45 },
            { 10, 20, 30, 40 }
        };
        int[][] history = new int[50][4];
        int historyCount = 0;

        while (true) {
            System.out.println("Warehouse Current Stock");
            for (int p = 0; p < 4; p++) {
                int pTotal = stock[0][p] + stock[1][p] + stock[2][p];
                System.out.println("Product " + (p + 1) + " combined stock across warehouses: " + pTotal);
            }
            System.out.println("\nMenu:\n1. Transfer Stock\n2. Show Operations History\n3. Exit");
            int option = readInt("Option: ", 1, 3);
            if (option == 3) break;

            if (option == 1) {
                try {
                    if (historyCount >= history.length) {
                        throw new IllegalStateException("History logs full. No further transfers allowed.");
                    }

                    int src = readInt("Enter source warehouse (1-3): ", 1, 3);
                    int dest = readInt("Enter destination warehouse (1-3): ", 1, 3);
                    int prod = readInt("Enter product index (1-4): ", 1, 4);
                    int qty = readInt("Enter quantity to transfer: ", 1, Integer.MAX_VALUE);

                    if (src == dest) throw new IllegalArgumentException("Source and destination cannot be identical.");

                    int sIdx = src - 1;
                    int dIdx = dest - 1;
                    int pIdx = prod - 1;
                    if (qty > stock[sIdx][pIdx]) throw new IllegalStateException("Insufficient stock at source warehouse.");
                    if (qty > 1000 - stock[dIdx][pIdx]) throw new IllegalStateException("Destination warehouse capacity exceeded (max 1000).");

                    stock[sIdx][pIdx] -= qty;
                    stock[dIdx][pIdx] += qty;
                    history[historyCount][0] = src;
                    history[historyCount][1] = dest;
                    history[historyCount][2] = prod;
                    history[historyCount][3] = qty;
                    historyCount++;
                    System.out.println("Transfer successful and recorded in history log.");
                } catch (IllegalArgumentException | IllegalStateException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } else if (option == 2) {
                System.out.println("Audit Trail History");
                if (historyCount == 0) System.out.println("No records found.");
                for (int x = 0; x < historyCount; x++) {
                    System.out.printf("Log #%d: Transferred %d units of Product %d from WH %d to WH %d%n",
                            x + 1, history[x][3], history[x][2], history[x][0], history[x][1]);
                }
            }
        }
    }

    static void prog8() {
        System.out.println("Subject Analysis and Ranking");
        int n = readInt("Enter number of students (2-10): ", 2, 10);
        int[][] marks = new int[n][4];
        double[] averages = new double[n];
        int[] order = new int[n];

        for (int x = 0; x < n; x++) {
            order[x] = x;
            int studentSum = 0;
            System.out.println("Entering scores for Student " + (x + 1) + ":");
            for (int s = 0; s < 4; s++) {
                marks[x][s] = readInt(" Subject " + (s + 1) + " (0-100): ", 0, 100);
                studentSum += marks[x][s];
            }
            averages[x] = studentSum / 4.0;
        }

        int[] subjectSum = new int[4];
        for (int s = 0; s < 4; s++) {
            for (int x = 0; x < n; x++) subjectSum[s] += marks[x][s];
        }
        System.out.println("Subject Analysis");
        double lowestSubjectAvg = subjectSum[0] / (double) n;
        for (int s = 1; s < 4; s++) {
            double currentAvg = subjectSum[s] / (double) n;
            if (currentAvg < lowestSubjectAvg) lowestSubjectAvg = currentAvg;
        }
        System.out.print("Subject(s) tied for lowest performance average: ");
        for (int s = 0; s < 4; s++) {
            if (subjectSum[s] / (double) n == lowestSubjectAvg) System.out.print((s + 1) + " ");
        }
        System.out.println();

        for (int x = 0; x < n - 1; x++) {
            for (int y = x + 1; y < n; y++) {
                if (averages[order[x]] < averages[order[y]]) {
                    int temp = order[x];
                    order[x] = order[y];
                    order[y] = temp;
                }
            }
        }

        System.out.println("Rank Leaderboard");
        int currentRank = 1;
        for (int x = 0; x < n; x++) {
            if (x > 0 && averages[order[x]] < averages[order[x - 1]]) currentRank = x + 1;
            int sIdx = order[x];
            boolean qualified = averages[sIdx] >= 75;
            for (int s = 0; s < 4; s++) {
                if (marks[sIdx][s] < 60) qualified = false;
            }
            System.out.printf("Rank %d | Student %d | Average: %.2f | Status: %s%n",
                    currentRank, sIdx + 1, averages[sIdx], qualified ? "Qualified" : "Not Qualified");
        }
    }

    static void prog9() {
        System.out.println("Theater Group Booking");
        int[][] seats = new int[5][8];
        int bookingIdCounter = 1;

        while (true) {
            int availableCount = 0;
            System.out.println("Theater Row Layout");
            for (int r = 0; r < 5; r++) {
                System.out.print("Row " + (r + 1) + ": ");
                for (int c = 0; c < 8; c++) {
                    System.out.printf("[%2d] ", seats[r][c]);
                    if (seats[r][c] == 0) availableCount++;
                }
                System.out.println();
            }
            System.out.println("Total seats vacant: " + availableCount);
            System.out.println("\n1. Group Booking\n2. Cancel Booking ID\n3. Exit");
            int choice = readInt("Option choice: ", 1, 3);
            if (choice == 3) break;

            try {
                if (choice == 1) {
                    int size = readInt("Enter size of group (1-8): ", 1, 8);
                    boolean assigned = false;
                    for (int r = 0; r < 5; r++) {
                        int contiguousCount = 0;
                        int startCol = -1;
                        for (int c = 0; c < 8; c++) {
                            if (seats[r][c] == 0) {
                                if (contiguousCount == 0) startCol = c;
                                contiguousCount++;
                                if (contiguousCount == size) {
                                    for (int k = startCol; k <= c; k++) seats[r][k] = bookingIdCounter;
                                    System.out.println("Successfully reserved with Booking ID: " + bookingIdCounter);
                                    bookingIdCounter++;
                                    assigned = true;
                                    break;
                                }
                            } else {
                                contiguousCount = 0;
                            }
                        }
                        if (assigned) break;
                    }
                    if (!assigned) throw new IllegalStateException("No single row contains enough contiguous free seats for this group.");

                } else if (choice == 2) {
                    int targetId = readInt("Enter Booking ID to remove: ", 1, Integer.MAX_VALUE);
                    boolean removed = false;
                    for (int r = 0; r < 5; r++) {
                        for (int c = 0; c < 8; c++) {
                            if (seats[r][c] == targetId) {
                                seats[r][c] = 0;
                                removed = true;
                            }
                        }
                    }
                    if (!removed) throw new IllegalArgumentException("Specified Booking ID could not be matched.");
                    System.out.println("Booking ID " + targetId + " successfully removed.");
                }
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    static void prog10() {
        System.out.println("Seven-Day Stock Simulation");
        String[] pNames = { "Product A", "Product B", "Product C" };
        int[] openStock = { 10, 15, 20 };
        int[] reorderLevel = { 5, 5, 5 };
        int[] unitPrice = { 100, 50, 25 };
        int[][] received = new int[3][7];
        int[][] demand = new int[3][7];
        int[][] sold = new int[3][7];
        int[][] closing = new int[3][7];
        int[] currentStock = { 10, 15, 20 };
        int[] totalUnitsSold = new int[3];
        int[] totalLostUnits = new int[3];
        int[] totalRevenue = new int[3];
        int[] dailyRevenue = new int[7];

        for (int day = 0; day < 7; day++) {
            System.out.println("DAY " + (day + 1) + " SIMULATION INPUTS");
            for (int p = 0; p < 3; p++) {
                System.out.println(pNames[p] + " (Current Stock before delivery: " + currentStock[p] + ")");
                int del = readInt(" Enter incoming delivery units (0-1000): ", 0, 1000);
                received[p][day] = del;
                currentStock[p] += del;

                int dem = readInt(" Enter consumer market demand units (0-1000): ", 0, 1000);
                demand[p][day] = dem;
                int actualSales = Math.min(dem, currentStock[p]);
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

        System.out.println("SIMULATION RESULTS & AUDIT PERFORMANCE");
        for (int p = 0; p < 3; p++) {
            System.out.println("\n" + pNames[p] + " Analytics Summary:");
            System.out.println(" Total Units Sold: " + totalUnitsSold[p]);
            System.out.println(" Total Lost Demand Units: " + totalLostUnits[p]);
            System.out.println(" Total Product Generated Revenue: PHP " + totalRevenue[p]);
            System.out.println(" Final Ending Stock: " + currentStock[p]);
            if (currentStock[p] <= reorderLevel[p]) {
                System.out.println(" [ALERT] Low Stock Condition Detected!");
            }

            int sumDel = 0;
            int sumSales = 0;
            for (int d = 0; d < 7; d++) {
                sumDel += received[p][d];
                sumSales += sold[p][d];
            }
            boolean auditPassed = openStock[p] + sumDel - sumSales == closing[p][6];
            System.out.println(" Audit Baseline Verification: " + (auditPassed ? "PASSED" : "FAILED"));
        }

        System.out.println("Daily Revenue Metrics");
        int maxDailyRev = dailyRevenue[0];
        for (int d = 0; d < 7; d++) {
            System.out.println(" Day " + (d + 1) + ": PHP " + dailyRevenue[d]);
            if (dailyRevenue[d] > maxDailyRev) maxDailyRev = dailyRevenue[d];
        }
        System.out.print("Day(s) tied for capturing the highest peak revenue: ");
        for (int d = 0; d < 7; d++) {
            if (dailyRevenue[d] == maxDailyRev) System.out.print("Day " + (d + 1) + " ");
        }
        System.out.println(" (PHP " + maxDailyRev + ")");
    }
}
