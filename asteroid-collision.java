import java.util.*;
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> ll = new LinkedList<Integer>();
        for(int i: asteroids){
            if(ll.size()!= 0){
                int left = ll.getLast();
                if((left < 0 && i < 0) || (left >0 && i > 0)){
                 ll.add(i);
                }else{
                   doAllCollisions(ll,i);  
                }                
            }else{
                ll.add(i);
            }            
        }
        int[] finalAsters = new int[ll.size()];
        int i=0;
        for(Integer aster: ll){
            finalAsters[i] = aster;
            i++;
        }        
        return finalAsters;
    }
    public LinkedList<Integer> doAllCollisions(LinkedList<Integer> remAster, int i){
        if(remAster.size() !=0){
            int left = remAster.getLast();
            if((left < 0 && i < 0) || (left >0 && i > 0)){                
                  remAster.add(i);                                
            }
            else if(left < 0 && i >0){
                remAster.add(i);
            }
            else{
                remAster.removeLast();
                int strongAster = (Math.abs(left)==Math.abs(i))? 0 :                        (Math.abs(left)>Math.abs(i))?left : i;
                if(remAster.size() !=0){
                    doAllCollisions(remAster, strongAster);
                }
                else{
                    if(strongAster !=0)
                    remAster.add(strongAster);
                }                
            }
        }
        return remAster;
    }
}
