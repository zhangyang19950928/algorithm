import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author: zhangyang
 * @create: 2023-01-11 22:34
 * @desc:
 */
public class QuickSort1 {
    public static void main(String[] args) {
//        int[] arr = { 49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22 };
        int[] arr = { 1,1,1,1,1,-1};

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

        quickSort(ints, 0, ints.length - 1);
//        System.out.println(Arrays.toString(bubbleSort(array)));

        Date date2 = new Date();
        String date2Format = simpleDateFormat.format(date2);
        long longTime2 = System.currentTimeMillis();
        System.out.println("排序后时间=" + date2Format);
        System.out.println("所花费毫秒数="+(longTime2-longTime1));

    }

    private static void quickSort(int[] arr, int low, int high) {

        if (low < high) {
            // 找寻基准数据的正确索引
            int index = getIndex(arr, low, high);

            // 进行迭代对index之前和之后的数组进行相同的操作使整个数组变成有序
            //quickSort(arr, 0, index - 1); 之前的版本，这种姿势有很大的性能问题，谢谢大家的建议
            quickSort(arr, low, index - 1);
            quickSort(arr, index + 1, high);
        }

    }

    private static int getIndex(int[] arr, int low, int high) {
        // 基准数据
        int tmp = arr[low];
        while (low < high) {
            // 当队尾的元素大于等于基准数据时,向前挪动high指针
            while (low < high && arr[high] >= tmp) {
                high--;
            }
            // 如果队尾元素小于tmp了,需要将其赋值给low
            arr[low] = arr[high];
            // 当队首元素小于等于tmp时,向前挪动low指针
            while (low < high && arr[low] <= tmp) {
                low++;
            }
            // 当队首元素大于tmp时,需要将其赋值给high
            arr[high] = arr[low];
        }
        // 跳出循环时low和high相等,此时的low或high就是tmp的正确索引位置
        // 由原理部分可以很清楚的知道low位置的值并不是tmp,所以需要将tmp赋值给arr[low]
        arr[low] = tmp;
        return low; // 返回tmp的正确位置
    }

    // 快速排序 O（nlogn）
    public void qSort(int[] nums, int start, int end){
        if (start >= end) return;
        int mid = partition(nums, start, end);
        qSort(nums, start, mid - 1);
        qSort(nums, mid + 1, end);
    }
    // 定义分区方法，把数组按一个基准划分两部分，左侧元素一定小于基准，右侧大于基准
    private static int partition( int[] nums, int start, int end ){
    // 以当前数组起始元素为 pivot
        int pivot = nums[start];
        int left = start;
        int right = end;
        while ( left < right ){
            while ( left < right && nums[right] >= pivot )
                right --;
            nums[left] = nums[right];
            while ( left < right && nums[left] <= pivot )
                left ++;
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }


}
