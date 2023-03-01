/**
 * @author: zhangyang
 * @create: 2023-01-13 19:07
 * @desc: 线性查找
 */
public class SepSearch {
    public static void main(String[] args) {
        int[] arr ={5,4,7,45,1,2};
        int i = seqSearch(arr, 7);
        System.out.println(i);


    }

    public static int seqSearch(int[] arr, int value) {

        for (int i = 0; i < arr.length; i++) {
            if (value == arr[i]) {

                return i;

            }
        }


        return -1;

    }

}
