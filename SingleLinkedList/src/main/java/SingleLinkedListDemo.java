import jdk.nashorn.internal.objects.annotations.Where;

import javax.sound.midi.Soundbank;
import java.util.Properties;
import java.util.Stack;

/**
 * @author: zhangyang
 * @create: 2023-01-03 18:04
 * @desc:
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        SingleLinkedList singleLinkedList1 = new SingleLinkedList();

        HeroNode hN1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hN2 = new HeroNode(3, "张洋", "洋洋");
        HeroNode hN3 = new HeroNode(5, "龙楹", "龙儿");
        HeroNode hN4 = new HeroNode(7, "杨雨欣", "寥寥");

        HeroNode hN5 = new HeroNode(2, "杜娟", "丫头");
        HeroNode hN6 = new HeroNode(4, "杜娟", "丫头");
        HeroNode hN7 = new HeroNode(6, "杜娟", "丫头");
        HeroNode hN8 = new HeroNode(8, "杜娟", "丫头");

//        singleLinkedList.add(hN3);
//        singleLinkedList.add(hN2);
//        singleLinkedList.add(hN1);
//        singleLinkedList.add(hN4);
//        singleLinkedList.list();

        singleLinkedList.addByOrder(hN1);
        singleLinkedList.addByOrder(hN2);
        singleLinkedList.addByOrder(hN3);
        singleLinkedList.addByOrder(hN4);

        singleLinkedList1.addByOrder(hN5);
        singleLinkedList1.addByOrder(hN6);
        singleLinkedList1.addByOrder(hN7);
        singleLinkedList1.addByOrder(hN8);

        singleLinkedList.list();

        singleLinkedList1.list();

        SingleLinkedList.unionList(singleLinkedList.getHead(),singleLinkedList1.getHead());



        int length = SingleLinkedList.getLength(singleLinkedList.getHead());
        System.out.println(length);

        HeroNode recNode = SingleLinkedList.getRecNode(singleLinkedList.getHead(), 2);
        System.out.println("倒数" + recNode);

        SingleLinkedList.fanzhuanList(singleLinkedList.getHead());
        singleLinkedList.list();

        System.out.println("逆序打印");

        SingleLinkedList.reversePrint(singleLinkedList.getHead());



//        singleLinkedList.delete(hN4);
//
//
//        singleLinkedList.list();


    }

}

class SingleLinkedList {
    // 先初始化一個頭結點，頭結點不要動，作為標識
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    // 添加節點到單向列表
    // 思路:當不考慮標號的順序時
    // 找到當前列表的最後一個節點
    // 將最後節點的next域指向新的節點即可
    public void add(HeroNode heroNode) {
        // 因為head頭結點不能變動，因此我們需要一個輔助指針來協助遍歷 temp

        HeroNode temp = head;

        // 遍历链表，找到最后
        while (true) {
            // 找到链表的最后
            if (temp.next == null) {
                break;
            }
            // 如果没有找到最后，则继续寻找下一个
            temp = temp.next;
        }
        // 当退出while循环时，则temp指向链表最后
        // 將最後節點的next域指向新的節點
        temp.next = heroNode;

    }

    public void addByOrder(HeroNode heroNode) {

        HeroNode temp = head;
        // 标识添加的编号是否存在，默认是false
        boolean flag = false;

        while (true) {
            if (temp.next == null) {// 说明找到链表的最后位置
                break;

            }
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;


        }
        if (flag)
            System.out.println("准备插入的英雄编号已存在" + heroNode.no);
        else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }

    }

    // 修改节点信息，根据no信息更改姓名和昵称
    public void update(HeroNode newHeroNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;

        }

        HeroNode temp = head.next;
        boolean flag = false;

        while (true) {
            // 此段的作用是识别链表中的最后一个数据，并作为结束循环的标识
            if (temp == null) {
                break;

            }
            if (temp.no == newHeroNode.no) {
                flag = true;
                break;
            }

            temp = temp.next;


        }
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else
            System.out.println("未找到输入数据" + newHeroNode);


    }

    // 删除节点
    public void delete(HeroNode newHeroNode) {
        if (head.next == null) {
            System.out.println("当前列表为空");
            return;
        }


        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null)
                break;
            if (temp.next.no == newHeroNode.no) {
                flag = true;
                break;
            }

            temp = temp.next;

        }

        if (flag) {
            temp.next = temp.next.next;

        } else {
            System.out.println("未找到数据");

        }


    }


    // 单链表中节点的个数

    public static int getLength(HeroNode head) {
        if (head.next == null) {

            return 0;
        }

        HeroNode temp = head.next;
        int sum = 0;
        while (temp != null) {
            sum++;
            temp = temp.next;
        }
//        while (true){
//
//            if (temp.next == null ){
//                break;
//            }else {
//                sum++;
//            }
//            temp = temp.next;
//
//
//        }
        return sum;

    }
    // 查找单链表倒数第k个节点【新浪面试题】

    public static HeroNode getRecNode(HeroNode head, int k) {
        if (head.next == null) {

            return null;

        }


        HeroNode temp = head;

        int length = getLength(head);
        if (k > 0 && k <= length) {
            int i = length - k + 1;

            for (int j = 1; j <= i; j++) {
                HeroNode next = temp.next;
                temp = next;
                if (j == i) {
                    return next;
                }

            }

        } else {
            return null;
        }


        return null;


    }

    // 单链表的反转
    public static void fanzhuanList(HeroNode head) {
        // 如果当前链表为空，或者只有一个节点，无需反转，直接返回
        if (head.next == null || head.next.next == null) {
            return;

        }

        HeroNode temp = head.next;
        // 指向当前节点【temp】的下一个节点
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0, "", "");

        while (temp != null) {// 1
            next = temp.next;// 当前节点的下一个节点暂时保存 2

            temp.next = reverseHead.next;

            reverseHead.next = temp;

            temp = next;

        }
        head.next = reverseHead.next;


    }
    // 合并两个有序单链表
    public static void unionList(HeroNode firstHead,HeroNode secondHead){
        if (firstHead.next == null && secondHead.next==null){
            return;
        }
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        HeroNode temp =  firstHead.next;

        while (temp != null){


            singleLinkedList.add(temp);
            temp = temp.next;


        }
        singleLinkedList.list();


//        HeroNode fTemp = firstHead.next;
//
//        newHead.next = fTemp;
//
//        HeroNode sTemp = secondHead.next;
//


//        while (sTemp != null){
//            while (newHead != null){
//                if (sTemp.next.no > newHead.no){
//                    newHead.next =sTemp.next;
//                    sTemp.next = newHead;
//                    newHead = newHead.next;
//                }
//
//                sTemp = sTemp.next;
//            }






        }






    // 倒序打印
    public static void reversePrint(HeroNode head) {
        if (head.next == null) {
            return;
        }

        Stack<HeroNode> nodeStack = new Stack<>();

        HeroNode temp = head.next;
        while (temp != null) {


            nodeStack.push(temp);

            temp = temp.next;

        }
        // 加强for循环的出栈顺序和入栈顺序一致
//        for (HeroNode heroNode : nodeStack) {
//            System.out.println("for"+heroNode);
//        }

        while (nodeStack.size() > 0) {
            System.out.println("出栈"+nodeStack.pop());

        }


    }


    // 显示链表 遍历

    public void list() {

        if (head.next == null) {
            System.out.println("当前链表为空");
            return;
        }

        HeroNode temp = head.next;

        while (true) {
            if (temp == null) {
                break;
            }
            // 输出节点的信息
            System.out.println(temp);
            // 将temp后移
            temp = temp.next;


        }


    }


}


class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;// 指向下一个节点

    // 构造器


    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    public int getNo() {
        return no;
    }

    // 重寫toString方法
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
