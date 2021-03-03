package assignment6;

import java.util.ArrayList;

public class MyTreeList {
	public MyTreeNode headNode;
	public MyTreeList() {
		this.headNode = null;
		
		
	}
	
	public void add(int k) {
		this.headNode = add_recursive_call(this.headNode,k);
	}
	
	public MyTreeNode add_recursive_call(MyTreeNode root, int k) {
		if(root==null) {
			return new MyTreeNode(k);
		}
		else {
			
			if(k<root.data) {
				root.leftNext = add_recursive_call(root.leftNext, k);
			}
			else { 
				root.rightNext = add_recursive_call(root.rightNext, k);
			}
		}
		return root;
	}
	
	public void printTreeList(MyTreeNode root) {
		ArrayList<ArrayList<MyTreeNode>>nodeThing = new ArrayList<ArrayList<MyTreeNode>>();
		int count = 0;
		while(nodeThing.get(nodeThing.size()-1).size()>0) {
			if(nodeThing.size()==0) {
				nodeThing.add(new ArrayList<MyTreeNode>());
				nodeThing.get(0).add(root);
				System.out.println(root.data);
			}
			nodeThing.add(new ArrayList<MyTreeNode>());
			for(int i=0; i<nodeThing.get(count).size(); i++) {
				nodeThing.get(count+1).add(nodeThing.get(count).get(i).leftNext);
				nodeThing.get(count+1).add(nodeThing.get(count).get(i).rightNext);
			}
			for(int i =0;i<nodeThing.get(count+1).size(); i++) {
				System.out.print(nodeThing.get(count+1).get(i).data+", ");
			}
			System.out.println();
			
		}
		
	}

}
