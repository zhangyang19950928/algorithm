import org.jetbrains.annotations.NotNull;

import java.nio.channels.OverlappingFileLockException;
import java.util.*;

/**
 * @author: zhangyang
 * @create: 2023-01-06 12:14
 * @desc: 逆波兰计算器 后缀表达式
 */
public class PolandNotation {
    public static void main(String[] args) {
        //毫秒ms：
        long startTime = System.currentTimeMillis(); //获取开始时间

        //要测的程序或方法


        String expression = "1+((2+3)×4)-5";

        List<String> list = PolandNotation.toInfixExpressionList(expression);
        System.out.println(list);

        List<String> list2 = PolandNotation.parseSuffixExpresionList(list);

        System.out.println(list2);


        // String suffixExpression = "3 4 + 5 × 6 - ";
//        String suffixExpression = "4 5 * 8 - 60 + 8 2 / + ";
//
//
//        List<String> rpnList = PolandNotation.getListString(suffixExpression);

        int calculate = PolandNotation.calculate(list2);
        System.out.println(calculate);

        long endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");


    }

    // 将中缀表达式转换成list中封装
    public static List<String> toInfixExpressionList(String s) {
        ArrayList<String> list = new ArrayList<>();
        String[] split = s.split("");


        StringBuilder fullNum = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            String value = split[i];
            // 下方条件可以变更为 (c = s.charAt(i)) < 48 ||  (c = s.charAt(i)) > 57 也可使用正则
            // 判断是否为符号
            if (isOper(value)) {


                // 若非符号且标志不为空
                if (!fullNum.toString().equals("")) {
                    list.add(fullNum.toString());
                    // 清空标志
                    fullNum.delete(0, fullNum.length());
                }

                // 若是符号直接加入List
                list.add(value);


            } else {
                // 若遍历到数字则更新标志
                fullNum.append(value);

                // 循环到最后为数字结束，则添加入List
                if (i == split.length - 1) {

                    list.add(fullNum.toString());
                }
            }


        }

        return list;

    }

    // 将中缀表达式转换为后缀表达式

    public static List<String> parseSuffixExpresionList(List<String> ls) {
        // 定义两个栈
        // 符号栈
        Stack<String> s1 = new Stack<>();
        // 数栈
        Stack<String> s2 = new Stack<>();
        // 遍历后缀表达式
        for (String value : ls) {
            // 正则匹配数的部分直接进入数栈
            if (value.matches("\\d+")) {

                s2.push(value);
                // 如果是非（）的符号
            } else if (!value.equals("(") && !value.equals(")")) {
                // 4.1 若为空，或s1栈顶为（，则直接入栈s1
                if (s1.isEmpty() || s1.peek().equals("(")) {

                    s1.push(value);
                    // 若符号运算优先级高于栈顶，则直接入栈s1
                } else if (priority(value) > priority(s1.peek())) {

                    s1.push(value);
                    // 否则 将s1栈顶的运算符弹出压入s2，并再判断 4.1若为空，或s1栈顶为（，则直接入栈s1
                } else {

                    s2.push(s1.pop());
                    if (s1.isEmpty() || s1.peek().equals("(")) {

                        s1.push(value);

                    }

                }
                // 若为（）
            } else {
                // 若为左括号 则直接压入s1
                if (value.equals("(")) {
                    s1.push(value);
                    // 若为右括号
                } else {
                    // 依次弹出s1栈顶运算符号并压入s2，直到遇到左括号为止 并丢弃这对括号
                    // ********右括号从未入栈只做判断，不需特意处理
                    // 老师写法
//                    while (!s1.peek().equals("(")){
//
//                        s2.push(s1.pop());
//                    }
////                     丢弃左括号
//                    s1.pop();
                    // 我的写法
                    while (!s1.isEmpty()) {
                        // 遍历终止标识为栈顶为左括号
                        if (s1.peek().equals("(")) {
                            // 丢弃左括号
                            s1.pop();
                            break;
                        } else {
                            s2.push(s1.pop());
                        }
                    }
                }

            }


        }
        // 理论上最后s1一定还会剩至少一个符号,无需判空 压入s2
//        if (!s1.isEmpty()) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
//        }
        // 将s2栈的结果逆序由栈底到栈顶遍历 可直接用栈的for循环
        ArrayList<String> list = new ArrayList<>();
        for (String s : s2) {
            list.add(s);
        }

        return list;
    }

    // 判断符号的优先级
    public static int priority(String oper) {
        if (oper.equals("*") || oper.equals("/") || oper.equals("÷") || oper.equals("×")) {
            return 1;

        } else if (oper.equals("+") || oper.equals("-")) {
            return 0;
        } else {
            return -1;
        }


    }

    public static List<String> getListString(@NotNull String suffixExpression) {

        String[] split = suffixExpression.split(" ");

        ArrayList<String> list = new ArrayList<>();

        // ArrayList<String> list = new ArrayList<>(Arrays.asList(split));
        for (String ele : split) {
            list.add(ele);
        }

        return list;


    }

    public static int calculate(List<String> ls) {

        Stack<String> notation = new Stack<>();
        String num1 = null;
        String num2 = null;
        String res = null;

        for (String ele : ls) {

            // if (!isOper(ele)) {
            if (ele.matches("\\d+")) {

                notation.push(ele);

            } else {

                num1 = notation.pop();
                num2 = notation.pop();

                res = cal(num1, num2, ele);

                notation.push(res);

            }


        }
        return Integer.parseInt(notation.pop());

    }

    // 判断是不是一个运算符
    public static boolean isOper(String val) {
        return val.equals("+") || val.equals("-") || val.equals("*") || val.equals("/") || val.equals("÷") || val.equals("×") || val.equals("(") || val.equals(")");

    }

    public static String cal(String firstNum, String soundNum, String oper) {
        int res = 0;

        int num1 = Integer.parseInt(firstNum);
        int num2 = Integer.parseInt(soundNum);

        switch (oper) {
            case "+":
                res = num1 + num2;
                break;
            case "-":
                res = num2 - num1;
                break;
            case "*":
            case "×":
                res = num1 * num2;
                break;
            case "/":
            case "÷":
                res = num2 / num1;
                break;
            default:
                throw new RuntimeException("运算符号不存在");

        }

        return String.valueOf(res);
    }


}
