class Solution {
    public int myAtoi(String str) {
        char[] chars = str.toCharArray();
        boolean sign = false; //positive num
        boolean changed = false;
        String res = "";
        int out = 0;
        for(int j=0;j<chars.length;j++){
            char i = chars[j];
           
            if(i == '-'&& res =="" && !changed){
                sign = true;
                changed = true;
                continue;
            }
            else if(i == '+' && res =="" && !changed){
                sign = false;
                changed = true;
                continue;
            }
            else if(i != ' ' && !tryParseInt(i)){
                break;
            }

            if(tryParseInt(i)){
                res = res+i;
            }
            else if((res !="")|| (changed)){
                break;
            }            
        }
        if(res == ""){
            return 0;
        }else{
            try{
                return sign ? -1*(Integer.parseInt(res)) : Integer.parseInt(res);
            }
            catch(Exception e){
                return sign ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }        
    }
    
    public boolean tryParseInt(char c){
        try{
            Integer.parseInt(String.valueOf(c));
            return true;        
        }
        catch(Exception e){
            return false;
        }
    }
}
