//{ Driver Code Starts
/* package whatever; // don't place package name! */
import java.util.*;
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
class Remove_Duplicate_From_LL
{
    Node head;  
    Node tail;
	public void addToTheLast(Node node) 
	{
	  if (head == null) 
	  {
	   head = node;
	   tail = node;
	  } 
	  else 
	  {
	   tail.next = node;
	   tail = node;
	  }
	}
      void printList()
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
	/* Drier program to test above functions */
	public static void main(String args[])
    {
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 while(t>0)
         {
			int n = sc.nextInt();
			Remove_Duplicate_From_LL llist = new Remove_Duplicate_From_LL(); 
			int a1=sc.nextInt();
			Node head= new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) 
			{
				int a = sc.nextInt(); 
				llist.addToTheLast(new Node(a));
			}
			
        GfG g = new GfG();
		llist.head = g.removeDuplicates(llist.head);
		llist.printList();
		
        t--;		
        }
    }}
// } Driver Code Ends


/*
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/

class GfG
{
    //Function to remove duplicates from sorted linked list.
    Node removeDuplicates(Node head)
    {
	// Your code here
	
	// Start with the head of the linked list.
	Node current = head;
	
	// Traverse through the linked list.
        while (current != null) {
            
            // Initialize a runner node to check for duplicates.
            Node runner = current.next;
            
            // Check for duplicates by comparing data values.
            // Move the runner until a different value is found.
            while (runner != null && runner.data == current.data)
                runner = runner.next;
                
                // Update the current node's next pointer to point to the next non-duplicate node.
            current.next = runner;
            
            // Move to the next node in the original linked list.
            current = current.next;
        }
        
         // Return the modified linked list with duplicates removed.
        return head;
    }
}
