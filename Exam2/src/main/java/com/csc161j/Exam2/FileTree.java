package com.csc161j.Exam2;

import java.io.File;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.w3c.dom.Node;

public class FileTree implements Iterable<FileNode> {

	private FileNode root;

	public FileTree(String path) {
		root = new FileNode(path);
		buildTree(root);
	}

	/**
	 * Return a depth first post-order traversal iterator
	 */
	@Override
	public Iterator<FileNode> iterator() {

		return new DepthFirstIterator();
	}

	public FileNode getRoot() {
		return root;
	}

	/**
	 * TODO for Exam 2
	 * Use recursion to build the tree from the directory structure.
	 * For each of node starting from the root node use listFiles() from File to get
	 * the list of files in that directory/folder.
	 * Create a node for each of the files and add it to a list of child nodes for
	 * the node
	 * Do this recursively for all the nodes.
	 * 
	 * @param fileNode
	 */
	private void buildTree(FileNode fileNode) {
		File[] f = fileNode.getFile().listFiles(); // gets folders from root

		for (File file : f) {
			if (file.isDirectory()) {
				FileNode fn = new FileNode(file.getAbsolutePath());
				buildTree(fn);
				fileNode.getChildNodes().add(fn);
			} else if (file.isFile()) {
				FileNode fn = new FileNode(file);
				fileNode.getChildNodes().add(fn);
			}
		}
	}

	/**
	 * TODO for Exam 2
	 * Iterator that does a post order traversal of the tree.
	 * For post-order traversal use the 2 stack approach outlined here:
	 * https://www.geeksforgeeks.org/iterative-postorder-traversal/
	 * 
	 * @return
	 */

	private class DepthFirstIterator implements Iterator<FileNode> {
		private ArrayDeque<FileNode> s1, s2;

		public DepthFirstIterator() {
			s1 = new ArrayDeque<FileNode>();
			s2 = new ArrayDeque<FileNode>();
			s1.push(root);

			while (!s1.isEmpty()) {
				FileNode node = s1.pop();
				s2.push(node);

				for (FileNode fn : node.getChildNodes()) {
					if (fn.getFile().isDirectory()) {
						s1.push(fn);
					} else {
						s2.push(fn);
					}
				}
			}
		}

		@Override
		public boolean hasNext() {
			return !s2.isEmpty();
		}

		@Override
		public FileNode next() {
			return s2.pop();
		}
	}

	/**
	 * Returns an iterator that does a breadth first traversal of the tree using a
	 * queue.
	 * 
	 * @return
	 */
	public Iterator<FileNode> breadthFirstIterator() {
		return new BreadthFirstIterator();

	}

	/**
	 * TODO for Exam 2
	 * Iterator that does a breadth first traversal of the tree using a queue.
	 * 
	 */
	private class BreadthFirstIterator implements Iterator<FileNode> {

		ArrayDeque<FileNode> queue;
		ArrayDeque<FileNode> directories;

		public BreadthFirstIterator() {
			queue = new ArrayDeque<FileNode>();
			directories = new ArrayDeque<FileNode>();

			directories.add(root);
			queue.add(root);

			while (directories.size() > 0) {
				FileNode node = directories.pop();
				for (FileNode fn : node.getChildNodes()) {
					queue.add(fn);
					if (fn.getFile().isDirectory()) {
						directories.add(fn);
					}
				}
			}

		}

		@Override
		public boolean hasNext() {
			return !queue.isEmpty();
		}

		@Override
		public FileNode next() {
			return queue.pop();
		}

	}
}
