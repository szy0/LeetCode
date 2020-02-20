class Solution {
    public int maxArea(int[] height) {
        int length = height.length;
        int left = 0;
        int right = length - 1;
        int maxArea = 0;

        while (left < right){
            maxArea = Math.max(maxArea, Math.min(height[left], height[right])*(right-left));
            if (height[left] < height[right]){
                left +=1;
            } else {
                right -=1;
            }
        }
       
        return maxArea;

    }
}