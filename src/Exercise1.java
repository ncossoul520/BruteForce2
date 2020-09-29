import java.util.Arrays;

public class Exercise1 {

    public static void RunA() {

        int[] list_nums = new int[] {3, 9, 5, -1, -3};
        int target = 7;
        boolean possible = canMakeSum( list_nums, target );  // returns true because 3 + 5 + (-1) = 7
        System.out.println( possible + " " + Arrays.toString(list_nums) + " = " + target );

        target = 6;
        possible = canMakeSum( list_nums, target );  // returns false because you can’t make 6 by adding 3 elements from the list
        System.out.println( possible + " " + Arrays.toString(list_nums) + " = " + target );

        target = 27;
        possible = canMakeSum( list_nums, target );  // returns false because 9 + 9 + 9 = 27
        System.out.println( possible + " " + Arrays.toString(list_nums) + " = " + target );
    }

    private static boolean canMakeSum(int[] list_nums, int target) {

        for (int i = 0; i < list_nums.length; i++) {
            for (int j = i + 1; j < list_nums.length; j++) {
                for (int k = j + 1; k < list_nums.length; k++) {
                    if (list_nums[i] + list_nums[j] + list_nums[k] == target) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void RunB() {

        int[] list_nums = new int[] {3, 9, 5, -1, -3};
        int target = 7;
        boolean possible = canMakeSum2( list_nums, target );  // returns true because 3 + 5 + (-1) = 7
        System.out.println( possible + " " + Arrays.toString(list_nums) + " = " + target );

        target = 13;
        possible = canMakeSum2( list_nums, target );  // returns true because 5 + 5 + 3 = 13
        System.out.println( possible + " " + Arrays.toString(list_nums) + " = " + target );

        target = -9;
        possible = canMakeSum2( list_nums, target );  // returns true because -3 + -3 + -3 = -9
        System.out.println( possible + " " + Arrays.toString(list_nums) + " = " + target );

    }
    private static boolean canMakeSum2(int[] list_nums, int target) {

        for (int num1 : list_nums) {
            for (int num2 : list_nums) {
                for (int num3 : list_nums) {
                    if (num1 + num2 + num3 == target) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
