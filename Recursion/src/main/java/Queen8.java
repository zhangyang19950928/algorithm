/**
 * @author: zhangyang
 * @create: 2023-01-07 19:15
 * @desc: 八皇后问题
 */
public class Queen8 {

    // 定义一个max表示共有多少个皇后
    int max = 8;
    // 定义数组array，保存皇后放置未知的结果，比如 arr= {0,4,7,5,2,6,1,3}

    int[] array = new int[max];

    static int count = 0;

    public static void main(String[] args) {
        // 测试
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.println(count);

    }

    // 编写一个方法放置第n个皇后
    public void check(int n) {
        // 此处说明8个皇后都已经放好
        if (n == max) {
            print();
            return;
        }

        for (int i = 0; i < max; i++) {
            // 先把这个皇后n，放在该行的第一列
            array[n] = i;

            if (judge(n)){ // 不冲突
                // 接着放n+1个皇后，开始递归
                check(n+1);

            }
            // 如果冲突，就继续执行array[n] = i;将第n个皇后放置在本行后移的一个位置上

        }
        


    }


    // n表示第n个皇后
    private boolean judge(int n) {

        for (int i = 0; i < n; i++) {
            // 不在同一列 行差等于列差 则在同一斜线上
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;

            }
        }
        return true;
    }

//        if (array[n-1] != 0){
//            // 不在同一列
//            if (array[n-1] == array[n])
//
//            return false;
//            // 不在对角线
//            else if (array[n-1] == array[n]-1 || array[n-1] == array[n-2]+1)
//
//                return false;
//
//        }else {
//
//            // 不在同一列
//            if (array[n-1] == array[n])
//
//                return false;
//                // 不在对角线
//            else if (array[n-1] == array[n]-1)
//
//                return false;
//
//        }
//
//        return true;



    public void print() {

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        count++;


    }


}
