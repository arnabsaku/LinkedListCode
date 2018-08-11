public class DetectAndRemoveLoop {
	
	public  Node head;
	
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

	public void detectAndRemove(Node node) {
		Node fast = node, slow = node;
		while(fast != null && slow != null && fast.getNext()!=null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			
			if(slow == fast) {
				removeLoop(slow,node);
			}
		}
	}
	
	public void removeLoop(Node slow, Node node) {
		Node fNode = node, tNode = slow;
		while(true) {
			if(fNode.getNext() == tNode.getNext())
				break;
			fNode= fNode.getNext();
			tNode = tNode.getNext();
		}
		tNode.setNext(null);
	}
	
	void printList(Node node) {
        while (node != null) {
            System.out.println(node.getValue() + " ");
            node = node.next;
        }
    }
 
    // Driver program to test above functions
    public static void main(String[] args) {
    	DetectAndRemoveLoop list = new DetectAndRemoveLoop();
        list.head = list.new Node(5);
        list.head.next = list.new Node(20);
        list.head.next.next = list.new Node(15);
        list.head.next.next.next = list.new Node(4);
        list.head.next.next.next.next = list.new Node(10);
 
        // Creating a loop for testing 
        list.head.next.next.next.next.next = list.head.next.next;
        list.detectAndRemove(list.head);
        System.out.println("Linked List after removing loop : ");
        list.printList(list.head);
    }
}
