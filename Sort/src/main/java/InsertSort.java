import javax.lang.model.element.VariableElement;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author: zhangyang
 * @create: 2023-01-08 22:05
 * @desc:
 */
public class InsertSort {
    public static void main(String[] args) {

        int[] array = {5,1,3,4,2};

        insertSort(array);

        System.out.println(Arrays.toString(array));

        int[] ints = new int[80000];
        for (int i = 0; i < 80000; i++) {
            ints[i] = (int) (Math.random() * 800000);
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Format = simpleDateFormat.format(date1);
        System.out.println("排序前时间=" + date1Format);

        insertSort(ints);
//        System.out.println(Arrays.toString(bubbleSort(array)));

        Date date2 = new Date();
        String date2Format = simpleDateFormat.format(date2);
        System.out.println("排序后时间=" + date2Format);


    }

    // 插入排序
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int insertVal = array[i];
            int insertPrevIndex = i - 1;

            while (insertPrevIndex >= 0 && insertVal < array[insertPrevIndex]) {
                array[insertPrevIndex + 1] = array[insertPrevIndex];
                insertPrevIndex--;
            }
            array[insertPrevIndex+1] = insertVal;
        }
    }

}
//   for (int i = 1; i < array.length; i++) {
//        // 定义待插入的数
//        int insertVal = array[i];
//        // 待插入数前一个数的下标索引
//        int insertPrevIndex = i - 1;
//        // 前半判断条件防止越界   若比前一个小，则前一个后移，自身前移
//        // 不停向前循环，直到判断数据本身大于已插入数值为止
//        while (insertPrevIndex >= 0 && insertVal < array[insertPrevIndex]) {
//
//        array[insertPrevIndex + 1] = array[insertPrevIndex];
//        insertPrevIndex--;
//
//        }
//
//        array[insertPrevIndex + 1] = insertVal;
//
//        }
