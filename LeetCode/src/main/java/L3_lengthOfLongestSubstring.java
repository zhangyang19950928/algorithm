import java.util.Arrays;

/**
 * @author: zhangyang
 * @create: 2023-01-29 11:55
 * @desc:
 */
public class L3_lengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "46456";
        System.out.println(lengthOfLongestSubstring(s));

    }

    public static int lengthOfLongestSubstring(String s) {
        String[] words = s.split("");
        System.out.println(Arrays.toString(words));


        int flag = 0;
        if (words[0].equals("")){
            return 0;

        }

        if (words.length==1){
            return words.length;

        }



        for (int i = 0; i < words.length; i++) {

            for (int j = i+1; j <words.length ; j++) {
                if (words[i].equals(words[j])){
                    if (j-i>flag){
                        flag = j-i;

                    }

                    }else {
                    flag = j-i+1;

                }


            }

        }

        return flag;

    }
}
