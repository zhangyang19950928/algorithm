/**
 * @author: zhangyang
 * @create: 2023-01-04 18:35
 * @desc:
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();


        HeroNode hN1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hN2 = new HeroNode(3, "张洋", "洋洋");
        HeroNode hN3 = new HeroNode(5, "龙楹", "龙儿");
        HeroNode hN4 = new HeroNode(7, "杨雨欣", "寥寥");

        HeroNode hN5 = new HeroNode(6, "杨雨欣", "寥寥");

        doubleLinkedList.add(hN1);
        doubleLinkedList.add(hN2);
        doubleLinkedList.add(hN3);
        doubleLinkedList.add(hN4);

        doubleLinkedList.list();

        doubleLinkedList.delete(7);

        doubleLinkedList.list();

        doubleLinkedList.addByOrder(hN5);
        System.out.println("按顺序插入");
        doubleLinkedList.list();


    }

}

class DoubleLinkedList {
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    // 遍历双向链表
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
        // 形成双向列表
        temp.next = heroNode;
        heroNode.pre = temp;

    }

    public void addByOrder(HeroNode heroNode) {

        HeroNode temp = head.next;
        // 标识添加的编号是否存在，默认是false
        boolean flag = false;

        while (true) {
            if (temp.next == null) {// 说明找到链表的最后位置
                break;

            }
            if (temp.next.no > heroNode.no && temp.no < heroNode.no) {
                break;
            } else if (temp.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;


        }
        if (flag)
            System.out.println("准备插入的英雄编号已存在" + heroNode.no);
        else {

            if (temp.next == null){
                heroNode.pre =temp;
                temp.next = heroNode;

            }else {
                heroNode.pre= temp;
                heroNode.next= temp.next;
                temp.next.pre = heroNode;
                temp.next = heroNode;
            }

        }

    }

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
    public void delete(int no) {
        if (head.next == null) {
            System.out.println("当前列表为空");
            return;
        }


        HeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }

            if (temp.no == no) {
                flag = true;
                break;
            }

            temp = temp.next;

        }

        if (flag) {
            temp.pre.next = temp.next;
            // 如果删除的是最后一个节点，此处则会有空指针异常
            if (temp.next != null){
                temp.next.pre = temp.pre;
            }

        } else {
            System.out.println("未找到数据");

        }


    }


}

class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;// 指向下一个节点
    public HeroNode pre;// 指向前一个节点

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


