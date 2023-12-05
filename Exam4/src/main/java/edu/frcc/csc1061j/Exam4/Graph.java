package edu.frcc.csc1061j.Exam4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;

//import com.csc161j.Exam2.FileNode;

public class Graph<E> {
	public List<Vertex> vertices = new ArrayList<>();

	private class Vertex {
		private E elem;
		private List<Edge> neighbors = new ArrayList<>();

		public Vertex(E elem) {
			this.elem = elem;
		}

		public E getKey() {
			return elem;
		}

		@Override
		public boolean equals(Object other) {
			if (!(other instanceof Graph.Vertex))
				return false;

			if (elem.equals(((Vertex) other).elem)) {
				return true;
			}
			return false;
		}

		@Override
		public String toString() {
			return elem.toString();
		}
	}

	private class Edge implements Comparable<Edge> {
		private Vertex s;
		private Vertex d;
		private int weight;

		public Edge(Vertex s, Vertex d, int weight) {
			this.s = s;
			this.d = d;
			this.weight = weight;
		}

		public boolean equals(Object edge) {
			return s.equals(((Edge) edge).s) && d.equals(((Edge) edge).d);
		}

		@Override
		public int compareTo(Graph<E>.Edge o) {
			return (int) (weight - o.weight);
		}
	}

	public Graph(List<Vertex> vertices) {
		for (Vertex vertex : vertices) {
			addVertex(new Vertex(vertex.getKey()));
		}
	}

	public Graph(List<E> vertices, E[][] edges) {
		for (E ver : vertices) {
			addVertex(new Vertex(ver));
		}
		createAdjacencyLists(edges);
	}

	public boolean addVertex(Vertex vertex) {
		if (!vertices.contains(vertex)) {
			vertices.add(vertex);
			return true;
		} else {
			return false;
		}

	}

	public boolean addEdge(Edge edge) {

		List<Edge> neighbors = edge.s.neighbors;
		if (!neighbors.contains(edge)) {
			neighbors.add(edge);
			return true;
		} else {
			return false;
		}
	}

	private Vertex findVertex(E key) {
		for (Vertex v : vertices) {
			if (v.elem.equals(key)) {
				return v;
			}
		}
		return null;
	}

	private void createAdjacencyLists(E[][] edges) {
		for (int i = 0; i < edges.length; i++) {
			addEdge(new Edge(findVertex(edges[i][0]), findVertex(edges[i][1]), (int) edges[i][2]));
		}
	}

	public void printEdges() {
		for (int i = 0; i < vertices.size(); i++) {
			System.out.print("Vertex: " + vertices.get(i).toString() + ":");
			List<Edge> neighbors = vertices.get(i).neighbors;
			for (Edge edge : neighbors) {
				System.out.print("(" + edge.s + ", " + edge.d + ", " + edge.weight + ")");
			}
			System.out.println();
		}
	}

	public List<Vertex> getChildNodes(Vertex vertex) {
		List<Vertex> childNodes = new ArrayList<>();
		List<Edge> neighbors = vertex.neighbors;
		for (Edge edge : neighbors) {
			childNodes.add(edge.d);
		}
		return childNodes;
	}

	/*
	 * TODO: Implement the DFS algorithm for a graph either recursively
	 ** or iteratively using a stack. It should return a list of all the
	 ** vertices in the pre-order depth-first traversal.
	 */

	public List<Vertex> dfs(Vertex root) {
		List<Vertex> visited = new ArrayList<Vertex>();

		Deque<Vertex> queue = new ArrayDeque<>();
		queue.push(root); // Push given root.

		while (!queue.isEmpty()) {
			Vertex v = queue.pop(); // Pop for dfs.
			List<Edge> neighbors = v.neighbors;

			if (!visited.contains(v)) {
				visited.add(v);

				for (Edge e : neighbors) {
					queue.push(e.d); // Push.
				}
			}
		}
		return visited;
	}

	/*
	 * TODO: Implement the BFS algorithm for a graph. It should return a list
	 ** of all the vertices in the breadth-first traversal.
	 */
	public List<E> bfs() {
		Vertex root = findVertex((E) (Integer) 0); // Set root.
		List<Vertex> visited = new ArrayList<Vertex>();

		Deque<Vertex> queue = new ArrayDeque<>();
		queue.offer(root); // Offer.

		while (!queue.isEmpty()) {
			Vertex v = queue.poll(); // Poll for bfs.
			List<Edge> neighbors = v.neighbors;

			if (!visited.contains(v)) {
				visited.add(v);

				for (Edge e : neighbors) {
					queue.offer(e.d); // Offer.
				}
			}
		}
		return (List<E>) visited; // Casted.
	}

	/*
	 * TODO: Create a spanning tree using Kruskal's Algorithm and return it.
	 ** The spanning tree will be a new graph
	 */
	public Graph<E> findMinimumSpanningTree() {
		// Empty edge list to order edges. 
		List<Edge> orderEdges = new ArrayList<Edge>();

		// Add edges.
		for (Vertex v : vertices) {
			for (Edge e : v.neighbors) {
				orderEdges.add(e);
			}
		}

		// Sort edges.
		Collections.sort(orderEdges, new Comparator<Edge>() {
			public int compare(Edge e1, Edge e2) {
				return e1.compareTo(e2);
			}
		});

		// Create empty vertices.
		List<Vertex> vertices = new ArrayList<>();
		for (Integer i = 0; i < 6; i++) {
			vertices.add(i, new Vertex((E) i));
		}

		// Create empty MST graph to connect and return. 
		Graph<E> mst = new Graph<>(vertices);

		// Loop over ordered edges.
		for (Edge e : orderEdges) {
			// Does connection exist?
			// If dfs contains dest then a connection already exists. Would be cyclical.
			if (!mst.dfs(mst.findVertex(e.s.elem)).contains(e.d)) {
				// Destination not found, let's add the edge. 
				mst.addEdge(new Edge(mst.findVertex(e.s.elem), mst.findVertex(e.d.elem), e.weight));
			}
		}

		return (Graph<E>) mst;
	}
}