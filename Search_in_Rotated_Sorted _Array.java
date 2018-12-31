class Solution {
    public int search(int[] nums, int target) {
        int res = -1;
        if(nums.length<1){
            return res;
        }
        if(nums.length<2){
            return nums[0] == target ? 0 : -1;
        }
        int index = findP(nums,0,nums.length-1);
       // System.out.println(index);
        if(target >= nums[index] && target <= nums[nums.length-1]){
            int[] arr = Arrays.copyOfRange(nums,index,nums.length);
            res = bs(arr, 0, arr.length-1,target);
            return  res == -1 ? -1 : res+index ;
        }else{
            int[] arr = Arrays.copyOfRange(nums,0,index+1);
            return bs(arr, 0, arr.length-1,target);
        }
        
    }
    int findP(int[] arr, int left, int right){
        if(left > right) return -1; //pivot not found
        int mid = (left+right)/2;
        if(mid != 0 && arr[mid] < arr[mid-1]){
                return mid;
        }
        if(arr[left] <=arr[right]){
            return left;
        }
        else{
           if(arr[mid] < arr[left]){
               right = mid-1;
           }
            else{  
                left = mid+1;
            } 
        }        
        return findP(arr,left,right);
    }
    int bs(int[] arr,int  left, int right,int target){
        if(left > right) return -1;
        int mid = (left+right)/2;
        if(target == arr[mid]){
            return mid;
        }
        if(target > arr[mid]){
            left = mid+1;
        }else{
            right = mid-1;
        }
        return bs(arr,left,right, target);
    }
}
