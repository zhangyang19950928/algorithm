import com.sun.deploy.panel.ITreeNode;

import java.util.Stack;

/**
 * @author: zhangyang
 * @create: 2023-01-07 0:01
 * @desc:
 */
public class test {
    public static void main(String[] args) {
        Stack<Integer> ints = new Stack<Integer>();

        ints.push(1);
        ints.push(2);
        ints.push(3);
        ints.push(4);

        for (Integer anInt : ints) {
            System.out.println(anInt);
        }

        while (!ints.isEmpty()) {
            System.out.println(ints.pop());
        }




    }
}
