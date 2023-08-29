//{ Driver Code Starts
import java.util.*;

class Node
{

    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}


public class LinkedList
{
    
 

    /* Function to print linked list */
   public static void print(Node root)
    {
        Node temp = root;
        while(temp!=null)
        {
            System.out.print(temp.data + " ");
            temp=temp.next;
        }
    }


    /* Driver program to test above functions */
    public static void main(String args[])
    {

        /* Constructed Linked List is 1.2.3.4.5.6.
         7.8.8.9.null */
        int value;
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0 && sc.hasNextInt() )
        {
            int n = sc.nextInt();
            
            //int n=Integer.parseInt(br.readLine());
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node tail = head;

            for (int i = 1; i < n && sc.hasNextInt() ; i++)
            {
                int a = sc.nextInt();
                tail.next = new Node(a);
                tail = tail.next;
            }


            Node result = new Solution().compute(head);
            print(result);
            System.out.println();
            t--;
        }
    }
}
// } Driver Code Ends


/*
class Node {
   int data;
   Node next;

  Node(int data) {
      this.data = data;
  }
}
*/
class Solution
{
    Node compute(Node head)
    {
        // your code here
        // Reverse the initial linked list
        Node current = head.next;
        Node previous = head;

        while (current != null) {
            Node nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }
        head.next = null;

        // Find the maximum value in the reversed list
        int maxVal = 0;
        maxVal = Math.max(previous.data, maxVal);
        current = previous;

        // Remove nodes with values less than maxVal from the reversed list
        while (current != null) {
            Node cur = current;
            while (current.next != null && current.next.data < maxVal) {
                current = current.next;
            }
            cur.next = current.next;
            current = cur.next;
            if (current != null) {
                maxVal = Math.max(maxVal, current.data);
            }
        }

        // Create a new result linked list and copy values from the modified reversed list
        Node result = new Node(0);
        current = result;
        while (previous != null) {
            current.next = new Node(previous.data);
            current = current.next;
            previous = previous.next;
        }

        // Reverse the modified result linked list
        current = result.next.next;
        previous = result.next;
        while (current != null) {
            Node nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }
        result.next.next = null;
        return previous;
    }
}
  