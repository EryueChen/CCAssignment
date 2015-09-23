package chapter4;

import java.util.ArrayList;

public class Solution07 {

	public static Project[] findBuildOrder(String[] projects, String[][] dependencies) {
		ProjectGraph graph = buildProjectGraph(projects, dependencies);
		return orderProjects(graph.getNodes());
	}
	
	//Build the graph, adding all the nodes and their dependencies
	public static ProjectGraph buildProjectGraph(String[] projects, String[][] dependencies) {
		ProjectGraph graph = new ProjectGraph();
		for (String project : projects) {
			graph.getOrCreateNode(project);
		}
		for (String[] dependency : dependencies) {
			String first = dependency[0];
			String second = dependency[1];
			graph.addEdge(first, second);
		}
		return graph;
	}

	//Iteratively find the nodes with no dependencies, and add to the order
	//Then decrement the number of dependencies of their children nodes
	public static Project[] orderProjects(ArrayList<Project> projects) {
		Project[] order = new Project[projects.size()];
		int endOfList = addNonDependent(order, projects, 0);
		int toBeProcessed = 0;
		while (toBeProcessed < order.length) {
			Project current = order[toBeProcessed];
			ArrayList<Project> children = current.getChildren();
			for (Project child : children) {
				child.decrementDependencies();
			}
			endOfList = addNonDependent(order, children, endOfList);
			toBeProcessed++;
		}
		return order;
	}
	
	//Find all the nodes with no denpendcies and return their offsets of array
	public static int addNonDependent(Project[] order, ArrayList<Project> projects, int offset) {
		for (Project project : projects) {
			if (project.getNumberDependencies() == 0) {
				order[offset] = project;
				offset++;
			}
		}
		return offset;
	}
	
	public static void main(String[] args) {
		String[] projects = {"a", "b", "c", "d", "e", "f"};
		String[][] dependencies = {{"d", "a"}, {"b", "f"}, {"d", "b"}, {"a", "f"}, {"c", "d"}};
		Project[] results = findBuildOrder(projects, dependencies);
		for (Project result : results) {
			System.out.println(result.getName());
		}
	}

}
