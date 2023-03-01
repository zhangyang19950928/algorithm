/**
 * @author: zhangyang
 * @create: 2022-12-25 18:28
 * @desc:
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {


    }
}

class ArrayQueue {
    // 表示数组的最大容量
    private int maxSize;
    // 对列头
    private int front;
    // 对列尾
    private int rear;
    // 该数据用于存放数据，模拟队列
    private int[] arr;

    // 创建对列的构造器


    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;

        arr = new int[maxSize];

        // 指向对列头部，指向对列头的前一个位置
        front = -1;
        // 指向对列尾部，指向对列尾部具体数据
        rear = -1;

    }

    // 判断对列是否满
    public boolean isFull() {
        return rear == maxSize - 1;

    }

    // 判断对列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    // 添加数据到对列
    public void addQueue(int n) {
        // 判断对列是否满
        if (isFull()) {
            System.out.println("队列已满，不能加入数据");
            return;
        }
        rear++;
        arr[rear]=n;

    }


}



