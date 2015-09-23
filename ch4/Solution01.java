package chapter4;

import java.util.HashSet;
import java.util.LinkedList;

public class Solution01 {
	//Use BFS method, to traverse all the nodes in the graph
	//Starting from the start node, add all its neighbors into a queue
	//Skip the nodes which have been visited and check all the nodes until the queue is empty
	
	public static boolean isConnected(Graph g, Node start, Node end) {
		HashSet<Node> visited = new HashSet<Node>();
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.add(start);
		while (!queue.isEmpty()) {
			Node current = queue.poll();
			for (Node node : current.children) {
				if (node == end) return true;
				if (visited.contains(node)) continue;
				else queue.add(node);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Node node1 = new Node("node1");
		Node node2 = new Node("node2");
		Node node3 = new Node("node3");
		Node node4 = new Node("node4");
		
		Node[] nodes = new Node[4];
		nodes[0] = node1;
		nodes[1] = node2;
		nodes[2] = node3;
		nodes[3] = node4;
		Graph g = new Graph(nodes);
		
		node1.children = new Node[2];
		node1.children[0] = node2;
		node1.children[1] = node3;
		node2.children = new Node[0];
		node3.children = new Node[0];
		node4.children = new Node[1];
		node4.children[0] = node1;
		
		System.out.println(isConnected(g, node1, node4));
		System.out.println(isConnected(g, node4, node2));

	}

}
