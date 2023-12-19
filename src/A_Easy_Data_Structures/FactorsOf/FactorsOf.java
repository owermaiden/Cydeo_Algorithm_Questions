package A_Easy_Data_Structures.FactorsOf;

public class FactorsOf {

    public static void main(String[] args) {
        // Example usage:
        long low = 400000;
        long high = 500000;
        System.out.println(getIdealNums(low, high));
    }

    public static int getIdealNums(long low, long high) {
        int count = 0;
        for (int i = 0; Math.pow(3, i) <= high; i++) {
            for (int j = 0; Math.pow(5, j) <= high; j++) {
                double number = Math.pow(3, i) * Math.pow(5, j);
                if (number >= low && number <= high) {
                    count++;
                }
                if (number > high) {
                    break;
                }
            }
        }
        return count;
    }
}
