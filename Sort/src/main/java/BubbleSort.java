import sun.security.util.Length;

import java.awt.geom.FlatteningPathIterator;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.ForkJoinPool;

/**
 * @author: zhangyang
 * @create: 2023-01-08 16:32
 * @desc: 冒泡排序 一共进行n-1次排序
 */
public class BubbleSort {
    public static void main(String[] args) {

//        int[] array = {3,9,-1,10,20};
//

        int[] ints = new int[800000];
        for (int i = 0; i < 800000; i++) {
            ints[i] = (int) (Math.random() * 800000);
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Format = simpleDateFormat.format(date1);
        System.out.println("排序前时间=" + date1Format);

        bubbleSort(ints);
//        System.out.println(Arrays.toString(bubbleSort(array)));

        Date date2 = new Date();
        String date2Format = simpleDateFormat.format(date2);
        System.out.println("排序后时间=" + date2Format);


    }


    // 冒泡排序时间复杂度O(n^2)
    public static int[] bubbleSort(int[] array) {
        int temp = 0;
        boolean flag = false;
        // 次数i是排序次数，不是取出元素
        for (int i = 0; i < array.length - 1; i++) {
            // 注意:此处遍历的元素数量为总数量减一,每当遍历排列好一个数到最后以后下一轮可以不用再对比该数
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    flag = true;
                    temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;

                }
            }
            // 如果count的数值为0，则直接跳出排序
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
        return array;
    }


}