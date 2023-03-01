/**
 * @author: zhangyang
 * @create: 2023-01-04 21:02
 * @desc: 环形链表解决约瑟夫问题
 */
public class Josepfu {
    public static void main(String[] args) {

        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(2789);
//        circleSingleLinkedList.list();
        // 测试小孩出圈
        circleSingleLinkedList.countBoy(1,50,2789);


    }
}
// 创建一个环形的单向链表

class CircleSingleLinkedList {
    // 创建一个first节点，当前没有编号
    private Boy first = null;

    // 添加小孩节点，构建成一个环形的链表 给定参数是添加的小孩的数量
    public void addBoy(int nums) {
        if (nums < 1) {
            System.out.println("输入参数不合理");
            return;
        }

        Boy curBoy = null; // 辅助指针，帮助构建环形链表
        for (int i = 1; i <= nums; i++) {
            // 根据编号，创建小孩节点
            Boy boy = new Boy(i);
            // 如果是第一个小孩
            if (i == 1) {
                first = boy;
                first.setNext(first);
                curBoy = first; // 让curBoy指向first

            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy; // 让curBoy指针后移指向boy


            }

        }

    }

    // 遍历环形列表
    public void list() {
        if (first == null) {
            System.out.println("环形链表为空");
            return;
        }

        Boy cur = first;

        while (true) {

            System.out.println(cur.getNo());
            if (cur.getNext() == first) {
                break;
            }

            cur = cur.getNext();


        }


    }

    // 根据用户的输入，计算出小孩出圈的顺序 参数：开始位置，数的次数，最初有多少小孩在圈中
    public void countBoy(int startNo, int countNum, int nums) {
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误");
        }
        // 创建辅助指针帮助完成小孩出圈
        Boy helper = first;

        // helper 最开始指向队伍的最末尾

        while (true) {
            if (helper.getNext() == first) {
                break;
            }

            helper = helper.getNext();

        }

        // 将两个指针移动到指定的开始位置
        for (int i = 0; i < startNo-1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        // 开始出队列
        while (true){
            // 当helper与first指针指向同一个节点时，说明只剩下一个节点
            if (helper == first){
                break;
            }
            // 让两个指针同时移动 countNum -1 次，然后出圈
            for (int j = 0; j <countNum-1 ; j++) {
                first = first.getNext();
                helper = helper.getNext();

            }
            System.out.println("出圈小孩的编号"+first.getNo());
            // *****此处first要向后移动一位
            first = first.getNext();
            helper.setNext(first);


        }

        System.out.println("最后留在圈中的小孩编号是" + first.getNo());



    }


}


// 先创建一个bean类
class Boy {
    private int no; // 编号
    private Boy next; // 指向下一个对象，默认是null

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }
}