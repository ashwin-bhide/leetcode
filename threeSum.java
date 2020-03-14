class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<Integer> hs = new HashSet<>(); //to avoid duplicates in outer loop ie the first number we fix
        List<List<Integer>> res = new LinkedList<>();
        int n = nums.length;
        Arrays.sort(nums); //sort so that window cann be shrinked, start-end pointers can be moved based on conditions
        for(int i=0;i<n-2;i++){ //triplet, so check until n-3rd element
            if(!hs.contains(nums[i])){
                hs.add(nums[i]);
                int start = i+1;
                int end = n-1;
                int target = -1*nums[i];
                while(start<end){
                    if(nums[start]+nums[end] == target){
                        res.add(Arrays.asList(nums[i],nums[start],nums[end]));
                        //below steps to ensure that [0,0,0,0,0] input is handled
                        while(start<end && nums[start]==nums[start+1]) start++;
                        while(start<end && nums[end]==nums[end-1]) end--;
                        start++;
                        end--;
                    } else if(nums[start]+nums[end]<target)
                        start++;
                    else
                        end--;
                }
            }
        }
        return res;
    }
}
