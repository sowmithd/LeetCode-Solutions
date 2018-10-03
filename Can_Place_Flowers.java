class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n <=0){
            return true;
        }

        Boolean valid = false;
            int i = 0;
            while ( i < flowerbed.length ){
                if(i==0 && flowerbed[i] == 0 && i< flowerbed.length-1 &&  flowerbed[i+1] !=1){
                   valid = true;
                }
                else if(i==0 && flowerbed[i] == 0 && flowerbed.length ==1){
                    valid = true;
                }
                else if(i == flowerbed.length-1 && flowerbed[i] == 0 && i> 0 && flowerbed[i-1] !=1 ){
                   valid = true; 
                }
                else if(i> 0 && i< flowerbed.length-1 && flowerbed[i] == 0 && flowerbed[i-1] !=1 && flowerbed[i+1] !=1){
                    valid = true;
                }
                if(valid){
                   n--;                    
                   flowerbed[i] = 1; 
                   valid = false;
                }
                if(n==0){
                    return true;
                }
                i++;
            }
       
        return n<=0;
    }
}