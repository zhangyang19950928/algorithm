import java.sql.Time;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collector;

/**
 * @author: zhangyang
 * @create: 2023-02-18 21:54
 * @desc:
 */
public class test {
    public static void main(String[] args) {

        int[] ints = {5, 6, 11, 7, 6, 78, -7};


        int[] arr = BubbleSortTest(ints);

        System.out.println(Arrays.toString(arr));


    }

    // 冒泡
    private static int[] BubbleSortTest(int[] arr) {
        int flag;
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    flag = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = flag;
                }
            }
        }
        return arr;
    }

    /**
     * @param a 要查找的有序 int 数组 最坏O（log n）
     * @param key 要查找的数值元素
     * @return 返回找到的元素下标；如果没有找到，返回-1
     */
    public int binarySearch(int[] a, int key){
        int low = 0;
        int high = a.length - 1;
        if ( key < a[low] || key > a[high] )
            return -1;
        while ( low <= high){
            int mid = ( low + high ) / 2;
            if( a[mid] < key)
                low = mid + 1;
            else if( a[mid] > key )
                high = mid - 1;
            else
                return mid;
        }
        return -1;
    }






}


