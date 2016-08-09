import java.util.List;

import com.java.graph.Graph;
import com.java.graph.TopologicalSort;

public class AlienDictionary 
{
	public static void main(String[] args)throws Exception
	{
		Graph<Character> graph  = new Graph<Character>(true);
		
        String[] words = {"wwa", "wwb", "wwd"};//{"baa", "abbde", "abca", "cab", "ccd"};
        for(int i = 0; i < words.length-1; i++)
        {
        	boolean wordFlag = false;
        	for(int j=0;j<words[i].length() || j< words[i+1].length();j++)
        	{
        		if(wordFlag == false && j<words[i].length() && j<words[i+1].length() )
        		{
        			if(words[i].charAt(j) != words[i+1].charAt(j))
        			{	
        				graph.addEdge(words[i].charAt(j), words[i+1].charAt(j));
        				wordFlag = true;
        			}
        			else
        			{
        				graph.addVertex(words[i].charAt(j));
        			}
        			continue;
        		}
        		if(j<words[i].length())
        		{
        			graph.addVertex(words[i].charAt(j));
        		}
        		if(j<words[i+1].length())
        		{
        			graph.addVertex(words[i+1].charAt(j));
        		}
        	}
        }
        TopologicalSort topological =  new TopologicalSort();
        List<Character> list = topological.sort(graph);
        for(int index=0; index < list.size();index++)
        {
        	System.out.println(list.get(index));
        }
	}
}
