import jdk.nashorn.internal.ir.Flags;
import jdk.nashorn.internal.ir.VarNode;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

/**
 * @author: zhangyang
 * @create: 2023-01-29 11:13
 * @desc:
 */

//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
//
//        你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
//
//        你可以按任意顺序返回答案。
//
//
//
//        示例 1：
//
//        输入：nums = [2,7,11,15], target = 9
//        输出：[0,1]
//        解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
//        示例 2：
//
//        输入：nums = [3,2,4], target = 6
//        输出：[1,2]
//        示例 3：
//
//        输入：nums = [3,3], target = 6
//        输出：[0,1]
public class L1_twoSum {

    public static void main(String[] args) {
        int[] ints = {2, 7, 11, 15};

        int[] ints1 = twoSum(ints, 9);
        System.out.println(Arrays.toString(ints1));

    }


    public static int[] twoSum(int[] nums, int target) {

        int[] ints = new int[2];
        boolean flag = true;
        while (flag = true) {
            for (int i = 0; i < nums.length; i++) {


                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        ints[0] = i;
                        ints[1] = j;
                        flag = false;
                        return ints;
                    }

                }


            }
        }


        return ints;

    }


}
