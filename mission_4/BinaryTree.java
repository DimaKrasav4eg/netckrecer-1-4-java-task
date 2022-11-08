package mission_4;

import java.util.LinkedList;

public class BinaryTree {

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.add(4);
		bt.add(2);
	    bt.add(3);
	    bt.add(5);
	    bt.add(6);
	    System.out.println(bt.preOrder());
	    System.out.println(bt.inOder());
	    System.out.println(bt.postOder());
	}
	
	Node root;
	
	public void add(int value) {
	    root = addRecursive(this.root, value);
	}
	
	//when current value less than root value 
	//add current value to the left
	private Node addRecursive(Node current, int value) {
		if (current == null) {
	        return new Node(value);
	    }

	    if (value < current.value) {
	        current.left = addRecursive(current.left, value);
	    } else if (value > current.value) {
	        current.right = addRecursive(current.right, value);
	    } else {
	        return current;
	    }

	    return current;
	}
	public LinkedList<Integer> preOrder() {
		if(this.root == null) {
			throw new IllegalArgumentException("root is null");
		}
		return BinaryTree.preOrder(this.root);
	}
	private static LinkedList<Integer> preOrder(Node current){
		LinkedList<Integer> prod = new LinkedList<>();
		prod.add(current.value);
		if (current.left != null) {
			prod.addAll(BinaryTree.preOrder(current.left));
		}
		if (current.right != null) {
			prod.addAll(BinaryTree.preOrder(current.right));
		}
		return prod;
	}
	
	public LinkedList<Integer> inOder() {
		if(this.root == null) {
			throw new IllegalArgumentException("root is null");
		}
		return BinaryTree.inOder(this.root);
	}
	private static LinkedList<Integer> inOder(Node current){
		LinkedList<Integer> prod = new LinkedList<>();
		if (current.left != null) {
			prod.addAll(BinaryTree.inOder(current.left));
		}
		prod.add(current.value);
		if (current.right != null) {
			prod.addAll(BinaryTree.inOder(current.right));
		}
		return prod;
	}
	
	public LinkedList<Integer> postOder() {
		if(this.root == null) {
			throw new IllegalArgumentException("root is null");
		}
		return BinaryTree.postOder(this.root);
	}
	private static LinkedList<Integer> postOder(Node current){
		LinkedList<Integer> prod = new LinkedList<>();
		if (current.left != null) {
			prod.addAll(BinaryTree.postOder(current.left));
		}
		if (current.right != null) {
			prod.addAll(BinaryTree.postOder(current.right));
		}
		prod.add(current.value);
		return prod;
	}
}
