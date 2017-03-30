//$Id$

public class FuelCircleProblem 
{
	public static void main(String...strings)throws Exception
	{
		int fuel[]={6,6,1,1,6};
		int distance[]={1,1,7,7,4};
		System.out.println(getStartLocation(fuel,distance));
	}
	public static int getStartLocation(int[] fuel,int distance[])
	{
		int len = fuel.length;
		int sum =0;
		for(int i=0;i<len;i++)
		{
			sum+=fuel[i]-distance[i];
		}
		if(sum<0)
		{
			return -1;
		}
		
		if(sum<0)
		{
			return -1;
		}
		int visited=0,i=0,start=0;
		sum=0;
		while(visited!=len)
		{
			sum+=fuel[i]-distance[i];
			if(sum<0)
			{
				start=i+1;
				visited=0;
				sum=0;
			}
			else
			{
				visited++;
			}
			i++;
			i=i%(len);
		}
		return start+1;
	}
}
