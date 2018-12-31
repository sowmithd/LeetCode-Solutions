/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack();
        Stack<Integer> s2 = new Stack();
        Stack<Integer> resTemp = new Stack();
        ListNode res;
        s1 = fillStack(l1);
        s2 = fillStack(l2);
        int carry = 0;
        while(!s1.isEmpty() && !s2.isEmpty()){
            int temp = s1.pop() + s2.pop()+ carry;
            if(temp >9){
                int val = temp%10;
                resTemp.push(val);
                carry = 1;
            }else{
                resTemp.push(temp);
                carry = 0;
            }
         }
        while(!s1.isEmpty()){
           int temp = s1.pop() + carry;
            if(temp >9){
                int val = temp%10;
                resTemp.push(val);
                carry = 1;
            }else{
                resTemp.push(temp);
                carry = 0;
            }
        }
        while(!s2.isEmpty()){
            int temp =  s2.pop()+ carry;
            if(temp >9){
                int val = temp%10;
                resTemp.push(val);
                carry = 1;
            }else{
                resTemp.push(temp);
                carry = 0;
            }
        }
        if(carry == 1){
            resTemp.push(1);
        }
        return fillList(resTemp);
    }
    public Stack<Integer> fillStack(ListNode l){
        Stack<Integer> st = new Stack();
        while(l != null){
            st.push(l.val);
            l = l.next;
        }
        return st;
    }
    public ListNode fillList(Stack<Integer> st){
        ListNode ln;
        if(st == null){
            return null;
        }
        else{
            ln = new ListNode(st.pop());
        }
        ListNode curr = ln;
        while(!st.isEmpty()){
            curr.next = new ListNode(st.pop());
            curr = curr.next;
        }
        return ln;
    }
}
