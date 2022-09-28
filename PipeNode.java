
   public class PipeNode
   {
      private FlapPipe p;
      private PipeNode next;
      
      public PipeNode(FlapPipe p)
      {
         this.p = p;
      } 
      public FlapPipe getPipe()
      {
         return p;
      }

      public void setPipe(FlapPipe p_in)
      {
         p = p_in;
      }
      
      public PipeNode getNext()
      {
         return next;
      }
      public void setNext(PipeNode newNext)
      {
         next = newNext;
      }
   }