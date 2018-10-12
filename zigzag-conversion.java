class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        StringBuilder[] sb = new StringBuilder[numRows];
        for(int i=0;i<numRows;i++){
            sb[i]= new StringBuilder();
        }
        int direction = 1;
        int sbIndex = 0;
        for(int i=0; i< s.length() && sbIndex <numRows;i++){
            sb[sbIndex].append(s.charAt(i));
            if(sbIndex == numRows-1){
                direction = -1;
            }
            else if(sbIndex == 0){
                direction = 1;
            }
            sbIndex+=direction;
        }
        StringBuilder sbOutput = new StringBuilder();
       for(StringBuilder i: sb){
           sbOutput.append(i);
       }
       return new String(sbOutput);
               
    }
}