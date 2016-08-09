//$Id$

public class Median 
{
	public static void main(String[] args) 
	{ 
		int[] a = {1,2,2,4,6,7};
		int[] b = {6,6};
		System.out.println("Median = "+MedianFun(a,b));
	}
	private static float MedianFun(int[] a, int[] b)
	{
		
		if(a.length ==0 && b.length == 0)
			return -1;
		else 
			if(a.length < b.length)
				return MedianUtil(b,a);
			else
				return MedianUtil(a,b);
	}
	private static float MedianUtil(int[] a,int[] b)
	{
		int aLen = a.length, bLen = b.length;
		int i=0,j=0,median = 0;
		if((aLen+bLen)%2 ==0)
			median = (aLen+bLen)/2;
		else 
			median = (aLen+bLen)/2 +1;
		for(int count=2; count<=median;count++)
		{
			if(j < bLen)
				if(a[i] < b[j])
					i++;
				else 
					j++;
			else
				i++;
		}
		if((aLen+bLen)%2 == 0)
		{
			float two = 2.0f;
			if(bLen == 0)
				return (a[i]+a[i+1])/two;
			else if(i >= aLen)
				return (b[j]+b[j+1])/two;
			else if(j >= bLen)
				return (a[i]+a[i+1])/two;
			else
			{
				if(a[i]<b[j])
				{
					if((i+1)<aLen && a[i+1]<b[j])
					{	
						return (a[i]+a[i+1])/two;
					}	
				}
				else
				{
					if((j+1)<bLen && b[j+1]<a[i])
					{
						return (b[j]+b[j+1])/two;
					}
				}
				return (a[i]+b[j])/two;
			}	
		}
		else 
		{
			if(bLen == 0)
				return a[i];
			else if(i >= aLen)
				return b[j];
			else if(j >= bLen)
				return a[i];
			else 
			{
				if(a[i]<b[j])
					return a[i];
				else
					return b[j];
			}
		}
	}
}