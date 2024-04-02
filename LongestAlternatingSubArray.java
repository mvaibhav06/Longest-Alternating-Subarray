import java.util.ArrayList;
import java.util.List;

public class LongestAlternatingSubArray {
    public static int alternatingSubarray(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        for(int i=1; i<nums.length; i++){
            temp.add(nums[i]-nums[i-1]);
        }
        // 1 1 -1 1
        int i = 1;
        int out = 0;
        int start = -1;
        int end = -1;
        if(!temp.contains(1)){
            return -1;
        }
        if (!temp.contains(-1) && temp.contains(1)){
            return 2;
        }

        while(i<temp.size()){
            if(temp.get(i)+temp.get(i-1) == 0 && (temp.get(i)==1 || temp.get(i)==-1) && (temp.get(i-1)==1 || temp.get(i-1)==-1)){
                if(start==-1 && temp.get(i)<temp.get(i-1)){
                    start = i;
                }
            }else{
                if(end == -1 && start!=-1){
                    end = i;
                    out = Math.max(out, end-start+2);
                    start = -1;
                    end = -1;
                }
            }
            i++;
        }
        if (end == -1 && start!=-1){
            out = Math.max(out, i-start+2);
        }
        if (out == 0 && temp.contains(1)){
            out = 2;
        }
        return out;
    }

    public static void main(String[] args) {
        int[] nums = {1,5,2,12,2,10,9,7,9,10};
        System.out.println(alternatingSubarray(nums));
    }
}
