
public class NthNodeFromEnd {

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
	
	public void nthNodeFromEnd(int n) {
		Node mainNode = head;
		Node refNode =head;
		int count = 0;
		if(head!= null) {
			while(count<n) {
				refNode = refNode.next;
				count++;
			}
			while(refNode!=null) {
				refNode= refNode.next;
				mainNode= mainNode.next;
			}
			System.out.println("Nth node: "+mainNode.value);
		}
	}
}
