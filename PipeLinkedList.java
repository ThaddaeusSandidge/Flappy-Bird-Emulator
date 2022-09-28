//This program was written by Thad Sandidge on 4/7/2022 for CSC1054
public class PipeLinkedList
{
   private PipeNode head;
   
   //Insert at front method, takes in the value
   public void addToFront(FlapPipe fp)
   {
      PipeNode theNode = new PipeNode(fp);
      theNode.setNext(head);
      head = theNode;
   }
   //Insert at end method, takes in value
   public void addToEnd(FlapPipe fp)
   {
      //Current to traverse, temp to save previous location of current
      PipeNode current = head;
      PipeNode temp = current;
      //Traverse list until the end
      while(current != null)
      {
         temp = current;
         current = current.getNext();
      }
      //Set the last node to point to the a new node with the value
      PipeNode theNode = new PipeNode(fp);
      temp.setNext(theNode);

   }
   public boolean deleteHead()
   {
      if(head == null)
         return false;
      else
      {
         head = head.getNext();
         return true;
      }
   }
   public FlapPipe getPipeAt(int index)
   {
      PipeNode current = head;
      //Traverse list, add one to list if there is something in current
      for(int i=0;i<index;i++)
      {
         current = current.getNext();
      }
      return current.getPipe();
   }
   
   //Get Front method
   public FlapPipe getHead(){
      return head.getPipe();
   }

   //Delete at method
   public boolean deleteAt(int i)
   {
      if(head == null)
         return false;
         
      if(i == 0)
      {
         head = head.getNext();
         return true;
      }
      
      int counter = 1;
      PipeNode current = head.getNext();
      PipeNode prev = head;
      while(counter != i && current !=  null)
      {
         prev = current;
         current = current.getNext();
         counter++;
      }
      if(current == null)
         return false;
         
      prev.setNext(current.getNext());
      return true;
   }
   //Length method
   public int length()
   {
      int length = 0;
      PipeNode current = head;
      //Traverse list, add one to list if there is something in current
      while(current != null)
      {
         length++;
         current = current.getNext();
      }
      return length;
   } 
}