import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

/**
 * @author: zhangyang
 * @create: 2023-01-13 13:05
 * @desc: 基数排序
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr ={53,3,542,748,14,214};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));


    }

    // 基数排序方法
    public static void radixSort(int[] arr) {
        // 第一轮排序（针对每个元素的个位进行排序）
        // 空间换时间
        int[][] bucket = new int[10][arr.length];

        // 为了记录每个桶中，实际存放了多少个数据，我们定义一个一维数组来记录各个桶的每次放入的数据个数

        int[] bucketElementCounts = new int[10];

        // 得到数组中最大的数是几位数
        // 找到数组中最大的数

        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];

            }
        }

        // 得到最大数是几位数
        int maxLength = (max + "").length();


        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                // 取出每个元素的个位数
                int digitOfElement = arr[j] / n % 10;
                // 放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;

            }

            // 按照这个桶的顺序（一维数组的下标依次取出数据，放入原数组中）
            int index = 0;
            // 遍历每一桶，并将桶中的数据放入原数组
            for (int k = 0; k < bucketElementCounts.length; k++) {
                // 如果桶中有数据我们才放入原数组
                if (bucketElementCounts[k] != 0) {
                    // 循环该桶即第k个桶（即第k个一维数组，将数据放入）
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        // 取出元素放入到arr中
                        arr[index] = bucket[k][l];
                        index++;

                    }

                }

                bucketElementCounts[k] = 0;
            }

        }


    }

}
