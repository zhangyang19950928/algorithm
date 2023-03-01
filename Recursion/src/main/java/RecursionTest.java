/**
 * @author: zhangyang
 * @create: 2023-01-07 1:14
 * @desc:递归
 */
public class RecursionTest {
    public static void main(String[] args) {

        int a = 4;
        test(a);


    }

    public static void test(int n){
        if (n>2){

            test(n-1);

        }
        System.out.println("n="+n);



    }


}


