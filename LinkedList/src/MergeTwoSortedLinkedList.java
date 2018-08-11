public class MergeTwoSortedLinkedList {

	public class Node{
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
	
	public Node mergeSortedLinkedList(Node node1, Node node2) {
		Node result = null;
		if(node1==null)
			return node2;
		else if (node2 == null)
			return node1;
		
		if(node1.getValue()<node2.getValue()) {
			result = node1;
			result = mergeSortedLinkedList(node1.getNext(), node2);
		}
		else {
			result = node2;
			result = mergeSortedLinkedList(node1, node2.getNext());
		}
		return result;
	}
}
