public class PalindromeLinkedList {
	
	public Node head;
	
	class Node{
		private int value;
		private Node next;
		
		Node(int value){
			this.value = value;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
		
		
	}
	public void checkPalidrome() {
		Node midNode = null;
		Node fastNode = head;
		Node slowNode = head;
		Node secondHalf = null;
		Node prevSlowNode = null;
		
		while(fastNode!= null && fastNode.getNext()!=null) {
			fastNode= fastNode.getNext().getNext();
			prevSlowNode = slowNode;
			slowNode = slowNode.getNext();
		}
		
		if(fastNode!=null) {
			midNode = slowNode;
			slowNode= slowNode.getNext();
		}
		
		prevSlowNode.setNext(null);
		secondHalf = slowNode;
		
		secondHalf = reverse(secondHalf);

		boolean matched = compareList(head,secondHalf);
		System.out.println("matched: "+matched);
		
		if(midNode != null) {
			prevSlowNode.setNext(midNode);
			midNode.setNext(secondHalf);
		}else {
			prevSlowNode.setNext(secondHalf);
		}
		
	}
	public Node reverse(Node node) {
		Node prev = null;
		Node curr = node;
		Node next = null;
		while(curr!=null) {
			next = curr.getNext();
			curr.setNext(prev);
			prev = curr;
			curr = next;
		}
		node = prev;
		return node;
	}
	
	public boolean compareList(Node node1, Node node2) {
		if(node1 ==null & node2==null)
			return true;
		while(node1 !=null && node2 !=null) {
			if(node1.getValue()==node2.getValue()) {
				node1 = node1.getNext();
				node2 = node2.getNext();
			}
			else
				return false;
		}
		if(node1== null && node2==null)
			return true;
		else 
			return false;
	}

}
