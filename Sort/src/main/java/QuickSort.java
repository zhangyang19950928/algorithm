import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author: zhangyang
 * @create: 2023-01-11 16:35
 * @desc: 快速排序 快速排序,说白了就是给基准数据找其正确索引位置的过程.
 */
public class QuickSort {
    public static void main(String[] args) {

 //    int[] arr = {-9, 78, 0, 23, -567, 70};
//     int[] arr = {1,1,1,1,1};
     int[] arr = {5, 1, 2, 0, -1, 4, 7, 12, 17};
//        quickSort(arr, 0, arr.length - 1);
//        System.out.println(Arrays.toString(arr));
        System.out.println("排序后:");

        int[] ints = new int[80000];
        for (int i = 0; i < 80000; i++) {
            ints[i] = (int) (Math.random() * 800000);
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Format = simpleDateFormat.format(date1);
        long longTime1 = System.currentTimeMillis();
        System.out.println("排序前时间=" + date1Format);

        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

        Date date2 = new Date();
        String date2Format = simpleDateFormat.format(date2);
        long longTime2 = System.currentTimeMillis();
        System.out.println("排序后时间=" + date2Format);
        System.out.println("所花费毫秒数="+(longTime2-longTime1));


    }

    public static void quickSort(int[] arr, int left, int right) {
        int l = left; // 左索引下标
        int r = right;// 右索引下标
        // pivot 中轴值
        int pivot = arr[(left + right) / 2]; // -1
        int temp = 0;

        // while循环的
        // 主判断循环 退出循环条件l>=r
        while (l < r) {

            while (arr[l] < pivot) {
                l += 1;
            }
            while (arr[r] > pivot) {
                r -= 1;
            }

            // 循环终止条件
            if (l >= r) {
                break;
            }

            // 大小互换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            // 防止相同数导致死循环
            // 主判断条件中的判断条件为 arr[]>或<pivot 没有涉及相等的情况，若相等则无法跳出循环，需要手动移动指针
            // 如果交换完后，发现这个arr[l] == pivot  r则向左将r前移
            if (arr[l] == pivot) {
                r-=1;
            }
            // 如果交换完后，发现这个arr[r] == pivot  l则向右将l后移
            if (arr[r] == pivot) {
                l+=1;
            }
        }
        // 若左右标识重叠，需要错开位
        if (l == r) {
            l += 1;
            r -= 1;
        }
        // 向左递归
        if (left < r) {
            quickSort(arr, left, r);
        }
        if (right >l ) {
            quickSort(arr, l, right);
        }
    }





}
