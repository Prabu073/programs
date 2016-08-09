public class Square1Matrix 
{
	public static void main(String[] args)throws Exception
	{
		int a[][]={
				{1,1,1,1,1},
				{1,1,1,1,1},
				{1,1,1,1,1},
				{1,1,1,1,1},
				{1,1,1,1,1}
				};
		System.out.println(sqaure1Matrix(a));
	}
	private static int sqaure1Matrix(int[][] a)
	{
		int max =0, count=0,row = a.length, col=a[0].length;
		for(int i=0;i<row-1;i++)
		{
			for(int j=0;j<col;j++)
			{
				if(a[i][j]==0)
				{
					if(max < count)
						max = count;
					count = 0;
				}
				else 
				{
					count++;
					if(count > 1 && sqaure1MatrixUtil(a,i,j,row,col,count) == false)
					{
						if(max < count-1)
							max = count-1;
						count=0;
					}
				}
			}
			if(max < count)
				max = count;
			count = 0;
		}
		return max;
	}
	private static boolean sqaure1MatrixUtil(int[][]a, int i, int j, int row, int col, int count)
	{
		if(count+i > row)
			return false;
		int tempCount = count-1;
		int iTemp = i+1;
		int jTemp = j-1;
		
		while(tempCount != 0)
		{
			if(a[iTemp][j]==0)
				return false;
			iTemp++;tempCount--;
		}
		
		tempCount = count-1;
		while(tempCount !=0)
		{
			if(a[i][jTemp] == 0)
				return false;
			jTemp--;tempCount--;
		}
		return true;
	}
}
