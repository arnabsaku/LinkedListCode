
public class LinkedList {
	
	 Node head;
	
	class Node{
		int value;
		Node next;
		
		Node(int value){
			this.value = value;
			next = null;
		}
	}
	
	public void insertAtBegin(int value) {
		Node newNode = new Node(value);
		if(head== null) {
			head = newNode;
			return;
		}
		newNode.next = head;
		head = newNode;
	}
	
	public void insertAfterSpecific(Node preNode, int value) {
		Node newNode = new Node(value);
		newNode.next = preNode.next;
		preNode.next = newNode;
	}
	
	public void insertAtEnd(int value) {
		Node newNode = new Node(value);
		if(head== null) {
			head = newNode;
			return;
		}
		Node preNode = head;
		while(preNode.next != null)
			preNode= preNode.next;
		preNode.next = newNode;
	}
	
	public void print() {
		Node tempNode = head;
		while(tempNode!= null) {
			System.out.println(tempNode.value);
			tempNode =  tempNode.next;
		}
	}
	
	public void deleteAtBegin() {
		Node temp = head;
		if(temp!= null)
			head = head.next;
		System.out.println(temp.value +" deleted");
	}
	
	public void deleteAfterSpecificValue(int value) {
		Node temp = head;
		while(temp != null && temp.value!= value)
			temp = temp.next;
		
		if(temp !=null) {
			Node deleteNode = temp.next;
			temp.next = temp.next.next;
			System.out.println(deleteNode.value +" deleted.");
		}
	}
	
	public void deleteAfterSpecificNode(Node preNode) {
		Node temp = head;
		if(temp !=null && temp.equals(preNode)) {
			Node deleteNode = temp.next;
			temp.next = temp.next.next;
			System.out.println(deleteNode.value +" deleted.");
			return;
		}
			
		while(temp!= null && temp.next!= preNode)
			temp = temp.next;
		if(temp!=null) {
			Node deleteNode = temp.next.next;
			temp.next.next = temp.next.next.next;
			System.out.println(deleteNode.value +" deleted.");
		}
	}
	
	public void deleteFromEnd() {
		Node temp =head;
		if(temp != null && temp.next != (null)) {
			System.out.println(head.value+" deleted.");
			head =null;
			return;
		}
		while(temp != null && temp.next.next!=null)
			temp = temp.next;
		if(temp != null) {
			System.out.println(temp.next.value+" deleted");
			temp.next.next = null;
		}
	}
	
	public void deleteSpecificValue(int value) {
		Node temp = head;
		while(temp.next.value!= value)
			temp = temp.next;
		if(temp != null) {
			Node deleteNode = temp.next;
			temp.next = temp.next.next;
			System.out.println(deleteNode.value +" deleted.");
		}
	}
	
	public void deleteSpecificposition(int position) {
		Node temp = head;
		if(temp==null)
			return;
		if(temp != null && position==0) {
			head = temp.next;
		}
		for(int i=1;temp!=null && i<position-1;i++) {
			temp = temp.next;
		}
		if(temp != null) {
			Node delete = temp.next;
			temp.next = temp.next.next;
			System.out.println(delete.value+" deleted.");
		}
	}
	
	public int length() {
		int length = 0;
		Node temp = head;
		if(temp == null)
			return 0;
		while(temp != null) {
			length++;
			temp = temp.next;
		}
		return length;
	}
	
	
	public void searchElement(int element) {
		Node temp = head;
		int pos = 1;
		boolean found = false;
		if(temp == null) {
			System.out.println("List is empty.");
			return;
		}
		while(temp != null) {
			if(temp.value== element) {
				found = true;
				break;
			}
			else {
				temp = temp.next;
				pos++;
			}
		}
		if(found)
			System.out.println(element+" found at "+pos);
		else
			System.out.println("Not found.");
	}
	
	public void swapNode(int x, int y) {
		if(x==y)
			return;
		Node prevX = null;
		Node curX = head;
		while(curX != null && curX.value!=x) {
			prevX = curX;
			curX = curX.next;
		}
		
		Node prevY = null;
		Node curY = head;
		while(curY != null && curY.value!=y) {
			prevY = curY;
			curY = curY.next;
		}
		
		if(curX == null || curY == null)
			return;
		if(prevX!=null)
			prevX.next = curY;
		else
			head= curY;
		
		if(prevY!=null)
			prevY.next = curX;
		else
			head= curX;
		
		Node temp = curX.next;
		curX.next =  curY.next;
		curY.next = temp;

	}
	
	public void middleElement() {
		Node point = head;
		Node slowPoint = head;
		if(head!=null) {
			while(point != null && point.next!=null) {
				point = point.next.next;
				slowPoint = slowPoint.next;
			}
			System.out.println("Middle element: "+slowPoint.value);
		}
	}
	
	
	
	public void deleteList() {
		head = null;
	}
	
	public void countOccurance(int key) {
		Node temp = head;
		int count = 0;
		while(temp != null) {
			if(temp.value== key)
				count++;
			temp = temp.next;
		}
		System.out.println("Count: "+count);
	}
	
	public Node reverse(Node node) {
		Node prev = null;
		Node curr = node;
		Node next = null;
		while(curr!=null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		node = prev;
		return node;
	}
	
	
	
}
