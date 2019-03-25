/**
  Represent a list, implemented in a chain of nodes
 */

public class List_inChainOfNodes{
    private Node headReference;

    /**
      Construct an empty list
     */
    public List_inChainOfNodes() {
    }

    public List_inChainOfNodes(Node ref) {
        headReference = ref;
    }
     

    /**
      @return the number of elements in this list
     */
    public int size() {
        Node element = headReference;
	int length = 0;
	while (element != null) {
	    length++;
	    element = element.getReferenceToNextNode();
	}
	return length;
    }

    
     /**
       @return a string representation of this list,
       format:
           # elements [element0,element1,element2,] 
      */
    public String toString() {
       String stringRep = "# elements [";
       for(Node element = headReference;
	   element != null;
	   element = element.getReferenceToNextNode()) {
            stringRep += element.getCargoReference() + ",";
       }
       return stringRep + "]";

    }
    
    
    /**
      Append @value to the head of this list.

      @return true, in keeping with conventions yet to be discussed
     */
     public boolean addAsHead( Object val) {
	headReference = new Node(val, headReference); 
        return true;
     }
}
