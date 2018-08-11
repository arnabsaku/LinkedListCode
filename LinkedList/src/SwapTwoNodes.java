public class SwapTwoNodes {
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
	
	Node head;
	
	public void swapNodes(int x, int y) {
		Node currX = head;
		Node currY = head;
		Node preX = null;
		Node preY = null;
		
		if(x==y) return;
		
		while(currX != null && currX.getValue()!=x) {
			preX = currX;
			currX = currX.getNext();
		}
		
		while(currY != null && currY.getValue()!=y) {
			preY = currY;
			currY = currY.getNext();
		}
		
		if(currX == null || currY == null)
			return;
		
		if(preX!= null)
			preX.setNext(currY);
		else
			head = currY;
		
		if(preY!= null)
			preY.setNext(currX);
		else
			head = currX;
		
		Node temp = currX.getNext();
		currX.setNext(currY.getNext());
		currY.setNext(temp);
		
	}
}
