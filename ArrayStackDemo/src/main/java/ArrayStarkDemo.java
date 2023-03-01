/**
 * @author: zhangyang
 * @create: 2023-01-05 14:21
 * @desc: 使用数组模拟栈的操作过程
 */
public class ArrayStarkDemo {
    public static void main(String[] args) {
        ArrayStark arrayStark = new ArrayStark(4);
        arrayStark.push(10);
        arrayStark.push(20);
        arrayStark.push(30);
        arrayStark.push(40);
        arrayStark.push(50);
        arrayStark.list();
        int pop = arrayStark.pop();
        System.out.println(pop);
        arrayStark.list();

        String a = "7*2*2-5+1=";



    }
}

class ArrayStark {
    private int maxSize;// 栈的最大值
    private int[] stack;// 数组
    private int top = -1; // 表示栈顶，无数据的时候栈顶为-1

    public ArrayStark(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    // 判断栈满
    public boolean isFull(){
        return top == maxSize-1;

    }

    // 判断栈空
    public boolean isEmpty(){
        return top == -1;


    }

    // 入栈操作 -push
    public void push(int value){
        // 先判断栈是否满
        if (isFull()) {
            System.out.println("栈已满，不能再放入数据");
            return;
        }
        top++;
        stack[top] = value;

    }

    // 出栈操作 -pop
    public int  pop(){
        // 先判断栈是够为空
        if (isEmpty()) {
            // 抛出异常  throw本身就会终止程序，所以不需要return
           throw new RuntimeException("栈空，没有数据~");

        }
        int value = stack[top];
        top--;

        return value;


    }

    public void list(){
        if (isEmpty()) {
            System.out.println("栈为空");
            return;
        }

        for (int i = top; i > -1; i--) {
            System.out.println(stack[i]);
        }


    }







}
