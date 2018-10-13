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
        ListNode output = null;
        ListNode root = null;
        int borrow = 0;
        int sum = 0;
        while(l1 != null || l2 != null){
            sum = 0;
            sum = (l1!=null ? l1.val : 0) + (l2!=null ? l2.val : 0) + borrow;
            borrow = sum>=10 ? 1 : 0;
            sum = sum>=10 ? (sum%10) : sum;            
            if(output != null){
                output.next = new ListNode(sum); 
                output = output.next;
            }
            else{
                output = new ListNode(sum);
                root = output;
            }
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }            
        }
        if(borrow !=0){
            output.next = new ListNode(borrow);
        }
        return root;
    }
}