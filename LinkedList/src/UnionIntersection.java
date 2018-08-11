public class UnionIntersection {

	Node head;
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
	
	void push(int new_data)
    {
        
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }
	
	public boolean checkIfExist(Node head, int data) {
		Node t = head;
		while(t!=null) {
			if(t.getValue()==data)
				return true;
			t = t.getNext();
		}
		return false;
	}
 
	
	public void getUnion(Node node1, Node node2) {
		Node head1 = node1;
		Node head2 = node2;
		while(head1!=null) {
			push(head1.getValue());
			head1 = head1.getNext();
		}
		
		while(head2 != null) {
			if(!checkIfExist(head, head2.getValue()))
				push(head2.getValue());
			head2 = head2.getNext();
		}
	}
	
	public void getInsercetion(Node node1, Node node2) {
		Node head1 = node1;
		Node head2 = node2;
		
		while(head1!=null) {
			if(checkIfExist(head2, head1.getValue()))
				push(head1.getValue());
			head1 = head1.getNext();
		}
	}
	
}
