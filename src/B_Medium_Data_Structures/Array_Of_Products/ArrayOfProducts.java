package week_24;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ArrayOfProducts {

    public static void main(String[] args) {
        int[] givenArray = {1,1};
        System.out.println(Arrays.toString(productExceptSelf(givenArray)));

        System.out.println(Arrays.toString(productArrayBruteForce(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(productArray1(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(productArray2(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(productArray3(new int[]{1, 2, 3, 4})));
    }

//    public static int[] productsOfOthers(int[] nums) {
//        var resultArray = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            int finalI = i;
//            AtomicInteger temp = new AtomicInteger(1);
//         var list=   Arrays.stream(nums).boxed()
//                .filter(num -> num != nums[finalI])
//                .map(n -> temp.getAndUpdate(v -> v * n)).toList();
//            resultArray[i] = temp.get();
//        }
//        return resultArray;
//    }
    public static int[] productExceptSelf(int[] nums) {

        // The length of the input array
        int length = nums.length;

        // The left and right arrays as described in the algorithm
        int[] L = new int[length];
        int[] R = new int[length];

        // Final answer array to be returned
        int[] answer = new int[length];

        // L[i] contains the product of all the elements to the left
        // Note: for the element at index '0', there are no elements to the left,
        // so L[0] would be 1
        L[0] = 1;
        for (int i = 1; i < length; i++) {

            // L[i - 1] already contains the product of elements to the left of 'i - 1'
            // Simply multiplying it with nums[i - 1] would give the product of all
            // elements to the left of index 'i'
            L[i] = nums[i - 1] * L[i - 1];
        }

        // R[i] contains the product of all the elements to the right
        // Note: for the element at index 'length - 1', there are no elements to the right,
        // so the R[length - 1] would be 1
        R[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {

            // R[i + 1] already contains the product of elements to the right of 'i + 1'
            // Simply multiplying it with nums[i + 1] would give the product of all
            // elements to the right of index 'i'
            R[i] = nums[i + 1] * R[i + 1];
        }

        // Constructing the answer array
        for (int i = 0; i < length; i++) {
            // For the first element, R[i] would be product except self
            // For the last element of the array, product except self would be L[i]
            // Else, multiple product of all elements to the left and to the right
            answer[i] = L[i] * R[i];
        }

        return answer;
    }

    public static int[] productArrayBruteForce(int[] nums) {//   1, 2, 3, 4
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int sub = 1;
            for (int j = 0; j < nums.length; j++) {

                if (i != j) {
                    sub *= nums[j];
                }
            }
            result[i] = sub;
        }
        return result;
    }

    public static int[] productArray1(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] res = new int[nums.length];

        left[0]=right[right.length-1]=1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i-1]*nums[i-1];
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i+1]*nums[i+1];
        }

        for (int i = 0; i < nums.length; i++) {
            res[i]=right[i]*left[i];
        }

        return res;
    }

    public static int[] productArray2(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] res = new int[nums.length];

        int leftRunning = 1;
        for (int i = 0; i < nums.length; i++) {
            left[i] = leftRunning;
            leftRunning *= nums[i];
        }

        int rightRunning = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            right[i] = rightRunning;
            rightRunning*= nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            res[i]=right[i]*left[i];
        }

        return res;
    }

    public static int[] productArray3(int[] nums) {
        int[] product = new int[nums.length];

        int leftRunningProduct = 1;
        for (int i = 0; i < nums.length; i++) {
            product[i]=leftRunningProduct;
            leftRunningProduct*=nums[i];
        }

        int rightRunningProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            product[i]*= rightRunningProduct;
            rightRunningProduct*=nums[i];
        }


        return product;
    }
}
