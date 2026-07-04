class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
      Deque<Integer> q=new ArrayDeque<>();
      int [] max=new int[nums.length-k+1];

      

        for(int i=0;i<nums.length;i++){

            if(!q.isEmpty() && q.peekFirst() < i - k + 1){
                q.pollFirst();
            }
            while(!q.isEmpty() && nums[i]>nums[q.peekLast()]){
                q.pollLast();
                
            }
                   q.offerLast(i);

                   if(i>=k-1){
                    max[i-k+1]=nums[q.peekFirst()];
                   }
        }

        return max;
    }
}