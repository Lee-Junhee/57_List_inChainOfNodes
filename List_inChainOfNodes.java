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

    public Object set(int index, Object val) {
    	return getNode(index).setCargoReference(val);
    }
	    
    public Object get(int index) {
	return getNode(index).getCargoReference();
    }

    private Node getNode(int index) {
	Node target;
	for(target = headReference;
	    0 <= index;
	    index--, target = target.getReferenceToNextNode())
	{}
	return target;
    }

    public boolean add(int index, Object val) {
        if(index == 0) {
	    return addAsHead(val);
	}
	getNode(index - 1).setReferenceToNextNode(
	    new Node(val, getNode(index - 1).getReferenceToNextNode()));
	return true;
    }

    public boolean remove(int index) {
	if(index == 0) {
	    headReference = headReference.getReferenceToNextNode();
	    return true;
	}
	getNode(index - 1).setReferenceToNextNode(
	    getNode(index).getReferenceToNextNode());
	return true;
    }
}
