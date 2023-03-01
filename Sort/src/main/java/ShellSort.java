import java.time.temporal.Temporal;
import java.util.Arrays;

/**
 * @author: zhangyang
 * @create: 2023-01-11 12:40
 * @desc: 希尔排序
 */
public class ShellSort {
    public static void main(String[] args) {

        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};

        shellSort(arr);

        System.out.println(Arrays.toString(arr));


    }
//希尔排序
    public static void shellSort(int[] arr) {
        int temp = 0;

        // 5 -> 2 -> 1
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < arr.length; i++) {

                // 此处步长为gap
                for (int j = i - gap; j >= 0; j -= gap) {

                    if (arr[j] > arr[j + gap]) {

                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;


                    }


                }

            }

        }

    }

    public static void shellSort2(int[] arr) {


        // 5 -> 2 -> 1
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < arr.length; i++) {

                int j = i;
                int temp = arr[j];
                if (arr[j]<arr[j-gap]){
                    while (j-gap >= 0 && temp<arr[j-gap]){

                        arr[j] = arr[j-gap];
                        j-=gap;

                    }

                    arr[j] = temp;

                }





            }

        }


    }


}
