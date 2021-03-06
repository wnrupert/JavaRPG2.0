public class MultiPurposeStack {

	/* 
	 * Variables for the Master of the Stack
	 * Head is the first node in the stack
	 * Foot is the last node in the stack
	 * Head and foot allow the program to use this class as either a stack or a que 
	 * 
	 */
	private Node head, foot;
	private int length;
	
	public MultiPurposeStack(){
		//initializes the variables for the stack or queue
		length = 0;
		head = null;
		foot = null;
	}
	public boolean isEmpty(){
		//checks to see if the array is empty or not;
		if(length == 0){
			return true;
		}else{
			return false;
		}
	}
	public void addBeginning(int value){
		//creates a new node and assigns the integer value to the input value
		//then assigns the parent pointer of the old head to the new node
		//and changes the head pointer to point to the new node
		//increases the length of the master class
		Node newNode = new Node();
		newNode.setIntValue(value);
		newNode.setParent(null);
		if(isEmpty()){
			newNode.setChild(null);
			head = newNode;
			foot = newNode;
		}else{
			newNode.setChild(head);
			head.setParent(newNode);
			head = newNode;
		}
		length++;
	}
	public void addBeginning(String value){
		//creates a new node and assigns the string value to the input value
				//then assigns the parent pointer of the old head to the new node
				//and changes the head pointer to point to the new node
				//increases the length of the master class
		Node newNode = new Node();
		newNode.setStringValue(value);
		newNode.setParent(null);
		
		if(isEmpty()){
			newNode.setChild(null);
			head = newNode;
			foot = newNode;
		}else{
			newNode.setChild(head);
			head.setParent(newNode);
			head = newNode;
		}
		length++;
	}
	public void addEnd(int value){
		//creates a new node and assigns the integer value to the input value
		//then assigns the child pointer of the old foot to the new node
		//and changes the foot pointer to point to the new node
		//increases the length of the master class
		Node newNode = new Node();
		newNode.setIntValue(value);
		newNode.setChild(null);
		
		if(isEmpty()){
			newNode.setParent(null);
			head = newNode;
			foot = newNode;
		}else{
			newNode.setParent(foot);
			foot.setChild(newNode);
			foot = newNode;
		}
		length++;
	}
	public void addEnd(String value){
		//creates a new node and assigns the string value to the input value
		//then assigns the child pointer of the old foot to the new node
		//and changes the foot pointer to point to the new node
		//increases the length of the master class
		Node newNode = new Node();
		newNode.setStringValue(value);
		newNode.setChild(null);
		
		if(isEmpty()){
			newNode.setParent(null);
			head = newNode;
			foot = newNode;
		}else{
			newNode.setParent(foot);
			foot.setChild(newNode);
			foot = newNode;
		}
		length++;
	}
	public int getLength(){
		//returns the length of the stack or queue
		return length;
	}
	public void deleteEnd(){
		//reassigns the pointers on the node above and reassigns the present node's pointers to null
		//has conditions for if there is only one node in the system and if there is no nodes
		//adjusts the length of the system as well
		if(!isEmpty()){
			if(foot.equals(head)){
				foot.Destory();
			}else{
				foot = foot.getParent();
				foot.getChild().Destory();
			}
			length--;
		}
	}
	public void deleteBeginning(){
		//reassigns the pointers on the node below and reassigns the current node's pointers to null
		//has conditions for if there is only one node in the system and if there is no nodes
		//adjusts the length of the system as well
		if(!isEmpty()){
			if(head.equals(foot)){
				head.Destory();
			}else{
				head = head.getChild();
				head.getParent().Destory();
			}
			length--;
		}
	}
	public void deleteAt(int index){
		if(!isEmpty()){
			if(index == 1){
				deleteBeginning();
				return;
			}
			if(index == length){
				deleteEnd();
				return;
			}
		
			Node inQuestion = head;
			for(int i = 1; i < index; i++){
				inQuestion = inQuestion.getChild();
			}
			inQuestion.Destory();
			length--;
		}
	}
	public Node getNodeAt(int a){
		Node que = head;
		for(int i = 1; i < a; i++){
			if(que!=foot){
				que = que.getChild();
			}
		}
		return que;
	}
	//this can probably be written in a better fashion. like with a for loop
	public void deleteValue(int value){
		Node inQuestion = head;
		if(length == 1){
			purge();
			return;
		}
		while(!inQuestion.equals(foot)){
			if(inQuestion.getIntValue() == value){
				if(inQuestion.equals(head)){
					head = inQuestion.getChild();
				}
				inQuestion.Destory();
				length--;
				return;
			}
			inQuestion = inQuestion.getChild();
		}
		if(inQuestion.getIntValue() == value && inQuestion.equals(foot)){
			foot = inQuestion.getParent();
			inQuestion.Destory();
			length--;
		}
		
	}
	public void purge(){
		Node inQuestion = head, yeh;
		while(!inQuestion.equals(foot)){
			yeh = inQuestion.getChild();
			inQuestion.Destory();
			inQuestion = yeh;
		}
		inQuestion.Destory();
		head = null;
		foot = null;
		length = 0;
	}
	public void deleteValue(String value){
		Node inQuestion = head;
		while(!inQuestion.equals(foot)){
			if(inQuestion.getStringValue() == value){
				if(inQuestion.equals(head)){
					head = inQuestion.getChild();
				}
				inQuestion.Destory();
				return;
			}
			inQuestion = inQuestion.getChild();
		}
		if(inQuestion.getStringValue() == value){
			foot = inQuestion.getParent();
			inQuestion.Destory();
		}
		length--;
	}
	public Node getHead(){
		return head;
	}
	public void displayValues(){
		Node inque = head;
		while(!inque.equals(foot)){
			System.out.print(head.getIntValue() + ",");
			inque = head.getChild();
		}
		System.out.println(head.getIntValue() + ",");
		inque = head.getChild();
	}
	
}

class Node{
	int intValue;
	String stringValue;
	Node child, parent;
	
	public void Destory(){
		if(child != null && parent != null){
			child.setParent(parent);
			parent.setChild(child);
		}else if(child != null){
			child.setParent(null);
		}else if(parent != null){
			parent.setChild(null);
		}
		child = null;
		parent = null;
	}
	//Setters and Getters*****
	public String getStringValue() {
		return stringValue;
	}
	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}
	public int getIntValue() {
		return intValue;
	}
	public void setIntValue(int intValue) {
		this.intValue = intValue;
	}
	public Node getChild() {
		return child;
	}
	public void setChild(Node child) {
		this.child = child;
	}
	public Node getParent() {
		return parent;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
	//*****//
}