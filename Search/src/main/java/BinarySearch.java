import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: zhangyang
 * @create: 2023-01-13 19:46
 * @desc: 二分查找
 */

public class BinarySearch {
    public static void main(String[] args) {
        // 二分查找要求数组必须是有序的

        int[] arr = {1, 1, 1, 1, 1, 1, 1, 1, 1};
        ArrayList<Integer> list = binarySearch1(arr, 1, 0, arr.length - 1);
        System.out.println(list);


    }

    // 二分查找
    public static int binarySearch(int[] arr, int value, int left, int right) {

        if (right > left) {
            return -1;
        }


        int mid = (left + right) / 2;


        if (value == arr[mid]) {
            return mid;
        } else if (value < arr[mid]) {
            return binarySearch(arr, value, left, mid - 1);


        } else {
            return binarySearch(arr, value, mid + 1, right);

        }
    }

    // 寻找到所有相同的数据并返回 因为数组有序，只需要将返回值mid周围的相同值找到并放入数组即可
    public static ArrayList<Integer> binarySearch1(int[] arr, int value, int left, int right) {
        ArrayList<Integer> list = new ArrayList<>();
        int index = 0;

        int mid = (left + right) / 2;

        if (left > right) {
            list.add(-1);
            return list;
        }
        if (value < arr[mid]) {
            return binarySearch1(arr, value, left, mid - 1);

        } else if (value > arr[mid]) {
            return binarySearch1(arr, value, mid + 1, right);

        } else {
            // 向左遍历
            index = mid - 1;
            while (true) {
                if (index < 0 || arr[index] != arr[mid]) {
                    break;
                }
                list.add(index);
                index--;
            }

            list.add(mid);

            index = mid + 1;

            while (true) {
                if (index > arr.length - 1 || arr[index] != arr[mid]) {
                    break;
                }
                list.add(index);
                index++;
            }


            return list;

        }


    }


}
