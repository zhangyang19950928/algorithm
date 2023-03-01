/**
 * @author: zhangyang
 * @create: 2023-01-07 14:09
 * @desc: 迷宫寻路
 */
public class MIGong {
    public static void main(String[] args) {
        // 先创建一个二维数组模拟迷宫
        // 地图
        int[][] map = new int[8][7];
        // 使用1表示墙
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;


        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

        // 使用递归回溯给小球找路
        setWay(map, 1, 1);

        System.out.println("小球的路线");

        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }


    }
    // 传入地图和起始位置 找到通路就返回true，否则返回false
    // 约定终点 小球能到 map[6][5] 位置，则说明通路找到
    // 地图上 1表示墙，0表示未走过路，2表示走的路，3表示该点走过，但走不通
    // 走迷宫每一步的方向策略 下-右-上-左，如果该点走不通再回溯
    public static boolean setWay(int[][] map, int i, int j) {
        // 若终点为2，则寻路完成，终止条件
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) { // 如果当前这个点还没走过

                // 按照策略 下-右-上-左
                map[i][j] = 2; // 假定该点是可以走通的
                if (setWay(map, i + 1, j)) { // 向下走
                    return true;

                } else if (setWay(map, i, j + 1)) { // 向右走
                    return true;

                } else if (setWay(map, i - 1, j)) { // 向上走
                    return true;

                } else if (setWay(map, i, j - 1)) { // 向左走
                    return true;

                } else {

                    map[i][j] = 3;
                    return false;

                }

            } else { // 1 2 3 均不可再走，所以直接return false

                return false;

            }


        }


    }
}




