import com.sun.org.apache.bcel.internal.generic.IfInstruction;
import sun.security.util.Length;
import sun.util.resources.cldr.en.TimeZoneNames_en_PK;

import javax.lang.model.element.VariableElement;
import java.time.chrono.MinguoChronology;
import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

/**
 * @author: zhangyang
 * @create: 2023-01-08 19:34
 * @desc:
 */
public class text {
    public static void main(String[] args) {

        int[] ints = {1,1,1,1,1};
        sort(ints, 0, ints.length - 1);

        System.out.println(Arrays.toString(ints));


    }

    public static void sort(int[] array, int left, int right) {
        int l = left;
        int r = right;
        int mid =array[(left+right)/2];
        int temp = 0;
        while (l<r){
            while (array[l]<mid){

                l++;

            }
            while (array[r]>mid){
                r--;
            }

            if (l>=r){
                break;
            }

            temp = array[l];
            array[l] = array[r];
            array[r] = temp;

          if (array[l] == mid){
              r--;

          }
          if (array[r] == mid){

              l++;
          }


        }

        if (l == r){
            l++;
            r--;

        }

        if (left<r){
            sort(array,left,r);

        }
        if (right>l){
            sort(array,l,right);

        }



    }

}



