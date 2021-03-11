package assignment4;

public class Main {
	public static void main(String[]args) {
		Node node = new Node(7);
		MyLinkedList ll1 = new MyLinkedList(node);
		ll1.add(5);
		ll1.add(4);
		ll1.printList();
		ll1.reverse();
		ll1.printList();
		ll1.remove(1);
		ll1.printList();
		ll1.swapNodes(0, 1);
		
		
	}
	public MyLinkedList merge(MyLinkedList l1, MyLinkedList l2) {
		MyLinkedList mergedLL = new MyLinkedList(null);
		l1.findNode(l1.length()-1).next = l2.headNode;
		
		int tempNum = 1000;
		while(mergedLL.length()!=l1.length()) {
			for(int i=0;i<l1.length();i++) {
				
				if (l1.headNode.data<tempNum) {
					tempNum = l1.headNode.data;
					mergedLL.add(tempNum);
				}
				l1.headNode = l1.headNode.next;
			}
		}
		return mergedLL;
		
	}
}
