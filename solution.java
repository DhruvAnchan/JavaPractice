import java.util.HashMap;

public class solution{
    public int[] twosum(int[] nums, int target){
        HashMap<Integer,Integer> bar = new HashMap<>();
        for(int i = 0; i <  nums.length; i++){
            int tar = target - nums[i];
            if(bar.containsKey(tar))
                return new int[] {bar.get(tar),i}; 
            bar.put(nums[i],i);
        }
        return new int[]{};
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,6,5,7};
        int target = 13;
        solution s = new solution();
        int[] x = s.twosum(nums, target);
        for(int i = 0; i < x.length; i++){
            System.out.println(x[i]);
        }
    }
}