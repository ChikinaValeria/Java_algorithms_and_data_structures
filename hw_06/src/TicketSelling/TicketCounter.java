package TicketSelling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//TicketCounter writes tracing data to a CSV file and outputs the trace to the console
public class TicketCounter
{
    private final static int PROCESS = 120;
    private final static int NUM_CUSTOMERS = 22;
    private final static int CASHIERS_TO_TRACE = 4;

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the name of the output CSV file:");
        String finalPath = scan.nextLine();
        scan.close();

        Customer customer;
        Queue<Customer> customerQueue = new LinkedList<Customer>();

        try (PrintWriter writer = new PrintWriter(finalPath)) {

            System.out.println("\nSIMULATION TRACE");
            System.out.println("Customer | Arrival Time | Cashier Free Times | Wait Time | Total Time");
            System.out.println("------------------------------------------------------------------");

            writer.println("Customer_Nbr,Arrival_Time,Cashier_Free_Times,Wait_Time,Total_Time");
            writer.flush();

            for (int cashiers = CASHIERS_TO_TRACE - 1; cashiers < CASHIERS_TO_TRACE; cashiers++)
            {
                int[] cashierTime = new int[CASHIERS_TO_TRACE];
                int totalTime = 0;
                int averageTime, departs, start, waitTime;

                for (int count = 0; count < CASHIERS_TO_TRACE; count++)
                    cashierTime[count] = 0;

                customerQueue.clear();
                for (int count = 1; count <= NUM_CUSTOMERS; count++)
                    customerQueue.add(new Customer(count * 15));

                while (!(customerQueue.isEmpty()))
                {
                    // Find the soonest available cashier index (minTimeCashierIndex)
                    int minTime = cashierTime[0];
                    int minTimeCashierIndex = 0;
                    for (int c = 1; c < CASHIERS_TO_TRACE; c++) {
                        if (cashierTime[c] < minTime) {
                            minTime = cashierTime[c];
                            minTimeCashierIndex = c;
                        }
                    }

                    StringBuilder cashierTimesOutput = new StringBuilder();
                    for (int c = 0; c < CASHIERS_TO_TRACE; c++) {
                        cashierTimesOutput.append(cashierTime[c]).append(":");
                    }
                    String allCashierTimes = cashierTimesOutput.toString().substring(0, cashierTimesOutput.length() - 1);

                    customer = customerQueue.remove();

                    if (customer.getArrivalTime() > cashierTime[minTimeCashierIndex]) {
                        start = customer.getArrivalTime();
                    } else {
                        start = cashierTime[minTimeCashierIndex];
                    }

                    waitTime = start - customer.getArrivalTime();
                    departs = start + PROCESS;
                    customer.setDepartureTime(departs);
                    cashierTime[minTimeCashierIndex] = departs;
                    totalTime += customer.totalTime();

                    System.out.printf("%8d | %12d | %s | %9d | %11d\n",
                            NUM_CUSTOMERS - customerQueue.size(),
                            customer.getArrivalTime(),
                            allCashierTimes,
                            waitTime,
                            customer.totalTime());

                    writer.printf("%d,%d,%s,%d,%d\n",
                            NUM_CUSTOMERS - customerQueue.size(),
                            customer.getArrivalTime(),
                            allCashierTimes,
                            waitTime,
                            customer.totalTime());

                    writer.flush();
                }

                averageTime = totalTime / NUM_CUSTOMERS;
                System.out.println("------------------------------------------------------------------");
                System.out.println("Simulation results written to " + finalPath);
                System.out.println("Summary: Average time: " + averageTime + " for " + CASHIERS_TO_TRACE + " cashiers.");
            }

        } catch (FileNotFoundException e) {
            System.err.println("FATAL ERROR: Could not open or write to file at path: " + finalPath);
            System.err.println("Check file path correctness and ensure Java has WRITE permission to that location.");
            System.err.println("Details: " + e.getMessage());
        }
    }
}