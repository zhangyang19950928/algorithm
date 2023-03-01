import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author: zhangyang
 * @create: 2022-12-25 13:36
 * @desc: 稀疏数组与对列 sparseArray
 */
public class SparseArray {
    public static void main(String[] args) throws IOException {

        // 创建一个原始的二维数组 11*11
        // 0表示没有棋子 1表示白子 2表示蓝子

        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        // 输出原始的二维数组
        System.out.println("原始的二维数组");
        for (int[] ints : chessArr1) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }
        // 将二维数组转换为稀疏数组
        // 1 先遍历二位数组，得到非0的数据的个数
        int sum = 0;

        for (int[] ints : chessArr1) {
            for (int anInt : ints) {
                if (anInt != 0)
                    sum++;

            }
        }
        System.out.println("sum =" + sum);

        // 2.创建对应的稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        // 给稀疏数组赋值
        int row = chessArr1.length;
        int col = chessArr1[0].length;
        sparseArr[0][0] = row;
        sparseArr[0][1] = col;
        sparseArr[0][2] = sum;

        int count = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }

            }
        }

        FileWriter fw = new FileWriter("map.data",true);
        FileReader fr = new FileReader("map.data");


        for (int[] ints : sparseArr) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
                fw.write(anInt);
                fw.flush();
            }
            System.out.println();
        }


        fw.close();

        int read = fr.read();

        System.out.println("read"+read);

        fr.close();


        // 将稀疏数组还原为原始数组
        // 行
        int row1 = sparseArr[0][0];
        // 列
        int col1 = sparseArr[0][1];
        // 有效数据数
        int sum1 = sparseArr[0][2];

        int[][] ints = new int[row1][col1];

        for (int i = 1; i < sparseArr.length; i++) {
            ints[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }


        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.print(i);
            }
            System.out.println();
        }


    }

}
