package samplePackage;

public class Tries 
{
	class Node
	{
		char ch;
		Node[] node = null;
		boolean end = false;
		Node(char ch)
		{
			this.ch=ch;
			this.node = new Node[256];
		}
	}
	private Node root = new Node(' ');
	private int min=-1,max = -1;
	public void buildTrie(String str)
	{
		buildTrie(root,str,0);
	}
	public void printTree()
	{
		StringBuilder str = new StringBuilder();
		printTree(root,str,0);
	}
	private void printTree(Node root,StringBuilder str,int index)
	{
		if(root == null)
			return;
		for(int i=0;i<256;i++)
		{
			Node curr = root.node[i];
			if(curr == null)
				continue;
			str.insert(index,curr.ch);
			if(curr.end)
			{
				str.setLength(index+1);
				System.out.println(str);
			}
			printTree(root.node[i],str,index+1);
		}
	}
	private void buildTrie(Node root,String str,int index)
	{
		if(index < str.length())
		{
			char ch = str.charAt(index);
			Node curr = root.node[(int)ch];
			if(curr == null)
			{
				curr = new Node(ch);
				root.node[(int)ch] = curr;
			}
			else//this else used only for finding the longest repeating substring
			{
				if(min == -1)
				{
					min = index;
				}
				max = index;
			}
			if(index == str.length()-1)
				curr.end = true;
			 buildTrie(curr,str,index+1);
		}
	}
	public String longestRepeatingSubString(String str)
	{
		
		int preMax = -1 , preMin =-1;
		for(int i=0; i<str.length();i++)
		{
			buildTrie(root,str,i);
			if(preMax-preMin < max-min)
			{
				preMin= min;
				preMax = max;
			}
			min = -1;
			max = -1;
		}
		if(preMax-preMin > 1 )
		{
			return str.substring(preMin, preMax+1);
		}
		return null;
	}
}
