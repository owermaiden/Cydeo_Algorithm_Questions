package B_Medium_Data_Structures.Final_Balance;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FinalBalance {

    public int solution(int[] A, String[] D) {

        return 0;
    }


        /*
You are given a list of all the transactions on a bank account during the year 2020. The account was empty at the beginning of the year (the balance was 0).
Each transaction specifies the amount and the date it was executed. If the amount is negative (less than 0) then it was a card payment, otherwise it was an incoming transfer (amount at least 0). The date of each transaction is in YYYY-MM-DD format: for example, 2020-05-20 represents 20th May 2020.
Additionally, there is a fee for having a card (omitted in the given transaction list), which is 5 per month. This fee is deducted from the account balance at the end of each month unless there were at least three payments made by card for a total cost of at least 100 within that month.
Your task is to compute the final balance of the account at the end of the year 2020.
Write a function:
class Solution { public int solution (int[] A, String[] D); }
that, given an array A of N integers representing transaction amounts and an array D of N strings representing transaction dates, returns the final balance of the account at the end of the year 2020. Transaction number K (for K within the range [0..N-1]) was executed on the date represented by D[K] for amount A[K].
Examples:
1. Given A = [100, 100, 100, -10] and D = ["2020-12-31", "2020-12-22", "2020-12-03", "2020-12-29"], the function should return 230. Total income was equal to 100+ 100+ 100-10290 and the fee was paid every month, so 290 - (5*12) = 230.
2. Given A = [180, -50, -25, -25] and D = ["2020-01-01", "2020-01-01", "2020-01-01", "2020-01-31], the function should return 25. The income was equal to 180, the expenditure was equal to 100 and the fee was applied in every month except January: 180 - 100-(5*11) =25.
3. Given A = [1, -1, 0, -105, 1] and D = ["2020-12-31", "2020-04-04", "2020-04-04", "2020-04-14", "2020-07-12"], the function should return -164. The fee is paid every month. 1-1+0-105 +1-(5*12) = -164. Note that in April, even though the total cost of card payments was 106 (more than 100), there were only two payments made by card, so the fee was still applied. A transaction of value 0 is considered a positive, incoming transfer.
4. Given A = [100, 100, -10, -20, -30] and D = ["2020-01-01", "2020-02-01", "2020-02-11", "2020-02-05", "2020-02-08"], the function should return 80.
5. Given A = [-60, 60, -40, -20] and D = ["2020-10-01", "2020-02-02", "2020-10-10", "2020-10-30"], the function should return -115. Assume that:
• N is an integer within the range [1..100];
• each element of array A is an integer within the range [-1,000..1,000];
• D contains strings in YYYY-MM-DD format, representing dates in the range 2020-01-01 to 2020-12-31.
In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.

     */

    public static void main(String[] args) {
        String[] D = {"2020-12-31", "2020-12-22", "2020-12-03", "2020-12-29"};
        int[] A = {100, 100, 100, -10};
//        String[] D = {"2020-01-01", "2020-01-01", "2020-01-01", "2020-01-31"};
//        int[] A = {180, -50, -25, -25};

//        String[] D = {"2020-12-31", "2020-04-04", "2020-04-04", "2020-04-14", "2020-07-12"};
//        int[] A = {1, -1, 0, -105, 1};

        System.out.println(solution1(A, D));
    }

    static int solution1(int[] A, String[] D) {
        int balance = 0;
        List<Transaction> list = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (int i = 0; i < D.length; i++) {
            LocalDate date = LocalDate.parse(D[i], formatter);
            list.add(new Transaction(date, A[i]));
        }
        Map<String, int[]> map = new HashMap<>();
        for (Transaction value : list) {
            String month = value.date.getMonth().toString();
            int amount = value.amount;
            int count = 0;
            if (amount < 0) {
                if (!map.containsKey(month)) {
                    map.put(month, new int[]{amount, 1});
                } else {
                    int[] a = map.get(month);
                    a[0] = a[0] + amount;
                    a[1] = a[1] + 1;
                    map.put(month, a);
                }
            }
        }
        int count = 0;
        for (int[] arr : map.values()) {
            if (arr[1] >= 3 && arr[0] <= -100) {
                count++;
            }
        }
        for (Transaction transaction : list) {
            balance += transaction.amount;
        }
        balance = balance - 60 + (int) count * 5;

        return balance;
    }

    static class Transaction {
        LocalDate date;
        int amount;

        public Transaction(LocalDate date, int amount) {
            this.date = date;
            this.amount = amount;
        }

        @Override
        public String toString() {
            return "Transaction{" +
                    "date=" + date +
                    ", amount=" + amount +
                    '}';
        }
    }

    static int solution2(int[] A, String[] D) {
        int result = 0;
        Map<String, List<Integer>> mapList = new HashMap<>();

        for (int i = 0; i < D.length; i++) {
            String month = D[i].split("-")[1];
            List<Integer> temp = mapList.getOrDefault(month, new ArrayList<>());
            temp.add(A[i]);
            mapList.put(month, temp);
        }

        for (Map.Entry<String, List<Integer>> each : mapList.entrySet()) {
            int cardPaymentTotal = 0;
            int cardPaymentCount = 0;
            for (Integer transaction : each.getValue()) {
                result += transaction;
                if (transaction < 0) {
                    cardPaymentTotal += transaction;
                    cardPaymentCount++;
                }
            }
            if (cardPaymentCount > 2 && cardPaymentTotal <= -100) {
                result += 5;
            }
        }
        return result - 60;
    }

}
