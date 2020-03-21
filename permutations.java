class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generateAllPermutations(nums, new ArrayList<>(),result);
        return result;
    }
    public void generateAllPermutations(int[] nums,List<Integer> runningPerm, List<List<Integer>> result){
        //our end goal
        if(runningPerm.size() == nums.length){
            result.add(new ArrayList<Integer>(runningPerm));
            return;
        }
        //our choice
        for(int i=0;i<nums.length;i++){
            int choice = nums[i];
            
            //our constraint
            if(runningPerm.contains(nums[i]))
                continue;
            
            runningPerm.add(choice);
            generateAllPermutations(nums,runningPerm,result);
            
            //remove most recent choice to backtrack
            runningPerm.remove(runningPerm.size()-1);
        }
    }
}
