//$Id$
package com.java.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class TopologicalSort 
{
	public <T> List<T> sort(Graph<T> graph)
	{
		Collection<Graph<T>.Vertex> allVertex = graph.getAllVertex();
		Stack<Graph<T>.Vertex> stack = new Stack<Graph<T>.Vertex>();
		Set<Graph<T>.Vertex> visited = new HashSet<Graph<T>.Vertex>();
		for(Graph<T>.Vertex v : allVertex)
		{
			if(!visited.contains(v))
				TopologicalUtil(v,stack,visited);
		}
		List<T> list = new ArrayList<T>();
		while(stack.isEmpty() == false)
        	{
        		list.add(stack.pop().getId());
        	}
		return list;
	}
	private <T> void TopologicalUtil(Graph<T>.Vertex v, Stack<Graph<T>.Vertex> stack,Set<Graph<T>.Vertex> visited)
	{
		visited.add(v);
		for(Graph<T>.Vertex adj : v.getAdjVertex())
		{
			if(!visited.contains(adj))
				TopologicalUtil(adj,stack,visited);
		}
		stack.push(v);
	}
}
