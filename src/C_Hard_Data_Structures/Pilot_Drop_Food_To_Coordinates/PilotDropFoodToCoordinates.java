package C_Hard_Data_Structures.Pilot_Drop_Food_To_Coordinates;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PilotDropFoodToCoordinates {

    /*
 * xCoordinate, represents the N coordinates on x-axis.
yCoordinate, represents the M coordinates on y-axis.
 */
    static void funcDrop2(int[] xCoordinate, int[] yCoordinate){
        Map<Integer, Integer> x = new HashMap<>();
        Map<Integer, Integer> y = new HashMap<>();

        for (int i : xCoordinate) {
            x.put(i, x.getOrDefault(x.get(i), 0)+1);
        }
        for (int i : yCoordinate) {
            y.put(i, y.getOrDefault(y.get(i), 0)+1);
        }
        int xMaxValue = 0;
        for (Map.Entry<Integer, Integer> each : x.entrySet()) {
            if (xMaxValue<each.getValue()){
                xMaxValue = each.getValue();
            }
        }

        int yMaxValue = 0;
        for (Map.Entry<Integer, Integer> each : y.entrySet()) {
            if (yMaxValue<each.getValue()){
                yMaxValue = each.getValue();
            }
        }
        int max = Math.max(xMaxValue, yMaxValue);
        if (max >1) {
            System.out.println(max);
        } else {
            System.out.println(0);
        }
    }

    public static void funcDrop(int[] xCoordinate, int[] yCoordinate) {
        // Write your code here
        Map<Integer, Integer> mapX = new HashMap<>();
        Map<Integer, Integer> mapY = new HashMap<>();

        for (int eachX : xCoordinate) {

            if (!mapX.containsKey(eachX)) {
                mapX.put(eachX, 1);
            } else {
                mapX.put(eachX, mapX.get(eachX) + 1);
            }

        }
        for (int eachY : yCoordinate) {
            if (!mapY.containsKey(eachY)) {
                mapY.put(eachY, 1);
            } else {
                mapY.put(eachY, mapY.get(eachY) + 1);
            }
        }

        int maxPointsX = 0;
        for (Integer xValue : mapX.values()) {
            if (xValue > maxPointsX) {
                maxPointsX = xValue;
            }
        }

        int maxPointsY = 0;
        for (Integer yValue : mapY.values()) {
            if (yValue > maxPointsY) {
                maxPointsY = yValue;
            }
        }
        if (maxPointsX > 1 || maxPointsY > 1) {
            System.out.println(Math.max(maxPointsX, maxPointsY));
        } else {
            System.out.println(0);
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //input for xCoordinate
        int xCoordinate_size = in.nextInt();
        int xCoordinate[] = new int[xCoordinate_size];
        for (int idx = 0; idx < xCoordinate_size; idx++) {
            xCoordinate[idx] = in.nextInt();
        }
        //input for yCoordinate
        int yCoordinate_size = in.nextInt();
        int yCoordinate[] = new int[yCoordinate_size];
        for (int idx = 0; idx < yCoordinate_size; idx++) {
            yCoordinate[idx] = in.nextInt();
        }


        funcDrop(xCoordinate, yCoordinate);
    }
}
