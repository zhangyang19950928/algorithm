import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author: zhangyang
 * @create: 2023-01-12 19:00
 * @desc: 归并排序
 */
public class MangeSort {
    public static void main(String[] args) {

        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
//        int[] tmp = new int[arr.length];
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

//        mergeSort(arr, 0, arr.length - 1, tmp);
//
//        System.out.println(Arrays.toString(arr));
//
//        System.out.println("排序后:");
//
//        int[] ints = new int[80000];
//        int[] intsTmp = new int[ints.length];
//        for (int i = 0; i < 80000; i++) {
//            ints[i] = (int) (Math.random() * 800000);
//        }
//
//        Date date1 = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String date1Format = simpleDateFormat.format(date1);
//        long longTime1 = System.currentTimeMillis();
//        System.out.println("排序前时间=" + date1Format);
//
//        mergeSort(ints, 0, ints.length - 1, intsTmp);
////        System.out.println(Arrays.toString(bubbleSort(array)));
//
//        Date date2 = new Date();
//        String date2Format = simpleDateFormat.format(date2);
//        long longTime2 = System.currentTimeMillis();
//        System.out.println("排序后时间=" + date2Format);
//        System.out.println("所花费毫秒数=" + (longTime2 - longTime1));


    }

    // 归并排序
    public static void mergeSort(int[] nums, int start, int end){
        if (start >= end ) return;
        int mid = (start + end) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        merge(nums, start, mid, mid + 1, end);
    }
    private static void merge(int[] nums, int lstart, int lend, int rstart, int rend){
        int[] result = new int[rend - lstart + 1];
        int left = lstart;
        int right = rstart;
        int i = 0;
        while (left <= lend && right <= rend){
            if (nums[left] <= nums[right])
                result[i++] = nums[left++];
            else
                result[i++] = nums[right++];
        }
        while (left <= lend)
            result[i++] = nums[left++];
        while (right <= rend)
            result[i++] = nums[right++];
        System.arraycopy(result, 0, nums, lstart, result.length);
    }









//    // 归并算法
//    // 分+合方法 执行顺序，先左后右，从上到下
//    public static void mergeSort(int[] arr, int left, int right, int[] tmp) {
//        if (left < right) {
//            // 中间索引
//            int mid = (left + right) / 2;
//            // 向左递归进行分解
//            mergeSort(arr, left, mid, tmp);
//            // 向右递归进行分解********mid+1
//            mergeSort(arr, mid + 1, right, tmp);
//            // 合并
//            marge(arr, left, mid, right, tmp);
//
//        }
//
//    }





//    // 合并方法
//    // 参数：传入数组 左有序数列的初始索引，中间索引，右边索引，中转数组
//    public static void marge(int[] arr, int left, int mid, int right, int[] tmp) {
//        int i = left; // 初始i，左边有序序列的初始索引
//        int j = mid + 1;// 初始化j，右边有序序列的初始索引
//        int t = 0; // 指向tmp辅助数组的辅助索引
//
//        // 先将左右两边（有序）的数据按照规则填充到temp数组
//        // 直到左右两边的有序序列，有一边处理完毕为止
//        // ******左右两边轮询对比，谁小谁进入临时数组******
//
//        while (i <= mid && j <= right) {
//            // 左边的小于或等于右边的，则放入暂存数组
//            if (arr[i] <= arr[j]) {
//                tmp[t] = arr[i];
//                t++;
//                i++;
//                // 反之arr[i]>arr[j]，则
//            } else {
//
//                tmp[t] = arr[j];
//                t++;
//                j++;
//
//            }
//
//        }
//
//        // 把有剩余数据的一边依次填充到temp
//        // 左剩余
//        while (i <= mid) {
//            tmp[t] = arr[i];
//            t++;
//            i++;
//        }
//        // 右剩余
//        while (j <= right) {
//            tmp[t] = arr[j];
//            t++;
//            j++;
//        }
//
//        // 将temp数组的元素填充到原数组arr
//        // 注意 不是每次都要拷贝所有的
//        t = 0;
//        int tempLeft = left;
//
//        while (tempLeft <= right) {
//            arr[tempLeft] = tmp[t];
//            t++;
//            tempLeft++;
//
//        }


//    }

}
