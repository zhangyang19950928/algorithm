
/**
 * @author: zhangyang
 * @create: 2023-01-05 17:33
 * @desc: 栈实现综合计算器
 */
public class Calculator {
    public static void main(String[] args) {
        // 根据思虑完成表达式
        String expression = "7-6-1-8";
        // 创建两个栈 一个是数字栈 一个是符号栈
        ArrayStark numStatic = new ArrayStark(20);
        ArrayStark operStatic = new ArrayStark(20);
        // 定义扫描指针
        int index = 0;
        // 取数1和2
        int num1 = 0;
        int num2 = 0;
        // 取出计算符号
        int oper = 0;
        int res = 0;
        char ch = ' '; // 将每次扫描得到char保存到此处
        String keepNum = "";// 用于拼接多位数
        // 开始使用while循环扫描expression
        while (true) {
            ch = expression.substring(index, index + 1).charAt(0);
            // 判断ch的类型，并放到对应的栈中进行对应的处理
            if (operStatic.isOper(ch)) {
                // 若为符号
                // 判断当前的符号栈是否为空，如果为空则直接放入符号
                if (operStatic.isEmpty())
                    operStatic.push(ch);
                else {
                    // 若符号栈不为空需要判断符号级别，符号级别大于已有符号则继续放入，
                    if (operStatic.priority(ch) > operStatic.priority(operStatic.peek()))
                        operStatic.push(ch);
                    else {
                        // 符号级别小于或等于，则取出数与符号进行计算，并将结果放入数字栈，将判断完后的符号放入符号栈
                        num1 = numStatic.pop();
                        num2 = numStatic.pop();
                        oper = operStatic.pop();
                        res = operStatic.cal(num1, num2, oper);
                        numStatic.push(res);
                        // **********将判断完后的符号放入符号栈
                        operStatic.push(ch);

                    }
                }


            } else {
                // 若判断为数则加入数栈
                // 处理多位数

                keepNum += ch;

                // 如果是最后一个数，则直接入栈
                if (index == expression.length() - 1) {
                    numStatic.push(Integer.parseInt(keepNum));

                } else {
                    // 判断下一个字符是不是数字，如果是数字，就继续扫描，如果是运算符号，则将数字入栈
                    if (operStatic.isOper(expression.substring(index + 1, index + 2).charAt(0))) {

                        numStatic.push(Integer.parseInt(keepNum));

                        keepNum = "";
                    }

                }


                // char 的编码问题
                // numStatic.push(ch - 48);

            }
            // 让指针加一，并判断是否扫描到最后，扫描到则结束程序
            index++;
            if (index >= expression.length()) {
                break;
            }

        }

        // 扫描结束后处理剩余的数字和符号
        while (true) {
            // 最后符号栈中应该没有数据，数栈中应该有一个结果
            if (operStatic.isEmpty()) {
                System.out.println(numStatic.pop());
                break;
            } else {
                num1 = numStatic.pop();
                num2 = numStatic.pop();
                oper = operStatic.pop();
                res = operStatic.cal(num1, num2, oper);
                numStatic.push(res);
            }


        }


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

    // 判断栈满 栈顶指导最大值时
    public boolean isFull() {
        return top == maxSize - 1;

    }

    // 判断栈空
    public boolean isEmpty() {
        return top == -1;


    }

    // 入栈操作 -push
    public void push(int value) {
        // 先判断栈是否满
        if (isFull()) {
            System.out.println("栈已满，不能再放入数据");
            return;
        }
        top++;
        stack[top] = value;

    }

    // 出栈操作 -pop
    public int pop() {
        // 先判断栈是够为空
        if (isEmpty()) {
            // 抛出异常  throw本身就会终止程序，所以不需要return
            throw new RuntimeException("栈空，没有数据~");

        }
        int value = stack[top];
        top--;

        return value;


    }

    public void list() {
        if (isEmpty()) {
            System.out.println("栈为空");
            return;
        }

        for (int i = top; i > -1; i--) {
            System.out.println(stack[i]);
        }


    }

    // 展示此时栈顶的数据 peek,但是不出栈
    public int peek() {
        // 先判断栈是够为空
        if (isEmpty()) {
            // 抛出异常  throw本身就会终止程序，所以不需要return
            throw new RuntimeException("栈空，没有数据~");

        }

        return stack[top];


    }


    // 返回运算符的优先级 返回的数字越大，则优先级越高
    // 在java中int和char在底层是可以混用的
    public int priority(int oper) {
        if (oper == '*' || oper == '/' || oper == '÷') {
            return 1;

        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }


    }

    // 判断是不是一个运算符
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/' || val == '÷';

    }

    // 计算方法
    public int cal(int num1, int num2, int oper) {
        int res = 0;

        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
            case '÷':
                res = num2 / num1;
                break;

        }

        return res;
    }

}