//$Id$
package com.java.graph;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Graph<T>
{
	private boolean isDirected = false;
	private HashMap<T,Vertex> allVertex = new HashMap<T,Vertex>();
	
	public Graph(boolean directed)
	{
		this.isDirected = directed;
	}
	public void addEdge(T id1, T id2)
	{
		Vertex v1 = null,v2 = null;
		if(allVertex.containsKey(id1))
			v1 = allVertex.get(id1);
		else
		{
			v1 = new Vertex(id1); allVertex.put(id1, v1);
		}
		
		if(allVertex.containsKey(id2))
			v2 = allVertex.get(id2);
		else
		{
			v2 = new Vertex(id2);allVertex.put(id2, v2);
		}
		
		Edge e = new Edge(v1,v2,0,isDirected);
		v1.addVertexDetails(e, v2);
		if(isDirected == false)
			v2.addVertexDetails(e, v1);
	}
	
	public void addVertex(T id)
	{
		if(!allVertex.containsKey(id))
			allVertex.put(id,new Vertex(id));
	}
	public Collection<Graph<T>.Vertex> getAllVertex()
	{
		return allVertex.values();
	}
	public class Vertex
	{
		private T id;
		private ArrayList<Vertex> adjVertex = new ArrayList<Vertex>();
		private ArrayList<Edge> edges = new ArrayList<Edge>();
		
		public Vertex(T id)
		{
			this.id=id;
		}
		public T getId()
		{
			return id;
		}
		public void addVertexDetails(Edge e, Vertex v)
		{
			adjVertex.add(v);
			edges.add(e);
		}
		public ArrayList<Vertex> getAdjVertex()
		{
			return adjVertex;
		}
	}
	public class Edge
	{
		private boolean isDirected = false;
		private Vertex v1 = null , v2 = null;
		private int weight = 0;
		
		public Edge(Vertex v1,Vertex v2,int weight, boolean isDirected)
		{
			this.isDirected=isDirected;
			this.v1=v1;
			this.v2=v2;
			this.weight=weight;
		}
		public boolean isDirected() 
		{
			return isDirected;
		}
		public Vertex getV1() 
		{
			return v1;
		}
		public Vertex getV2() 
		{
			return v2;
		}
		public int getWeight() 
		{
			return weight;
		}
	}
}
