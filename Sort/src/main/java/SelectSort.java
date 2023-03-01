import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.jar.JarEntry;

/**
 * @author: zhangyang
 * @create: 2023-01-08 19:41
 * @desc: 选择排序 时间复杂度O(n^2)
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] array = {10, 5, 15, 12, 1, 5, -1};

        selectSort(array);
        System.out.println(Arrays.toString(array));

        int[] ints = new int[80000];
        for (int i = 0; i < 80000; i++) {
            ints[i] = (int) (Math.random() * 800000);
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Format = simpleDateFormat.format(date1);
        System.out.println("排序前时间=" + date1Format);

        selectSort(ints);
//        System.out.println(Arrays.toString(bubbleSort(array)));

        Date date2 = new Date();
        String date2Format = simpleDateFormat.format(date2);
        System.out.println("排序后时间=" + date2Format);


    }

    // 选择排序 选择排序 时间复杂度O(n^2)
    public static void selectSort(int[] array) {
        // 遍历数组，取出一个数后，和后续元素进行对比，取出最小，由左向右放置，最后一个元素不用考虑排序
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            int min = array[i];
            // 与后续的每一个元素进行比较
            for (int j = 1 + i; j < array.length; j++) {
                if (min > array[j]) {
                    // 取得在本次循环中最小的元素索引与元素本身
                    minIndex = j;
                    min = array[j];
                }
            }
            // 判断，与初始设定的比较值 i 是否一致，若一致则无需下面元素替换
            if (minIndex != i) {
                array[minIndex] = array[i];
                array[i] = min;
            }


        }

    }
}
