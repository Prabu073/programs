public class MatrixPlusSign 
{
	public static void main(String... args)throws Exception
	{
		int[][] a = {
				{0,0,1,0,0},
				{0,1,1,1,0},
				{1,1,1,1,1},
				{0,1,1,1,0},
				{0,1,1,1,1}
				};
		int m = a.length;
		int n = a[0].length;
		System.out.println(findPlus(a,m,n));
	}
	static int findPlus(int[][] a,int m,int n)
	{
		int max = 0;
		for(int i = 1;i<n-1;i++)
		{
			for(int j=1;j<m-1;j++)
			{
				if(a[i][j]==1)
				{
					max = findMaxPlus(a,i,j,m,n,max);
				}
			}
		}
		return max;
	}
	private static int findMaxPlus(int[][] a,int ii,int jj,int m, int n, int max)
	{
		int currMax =0,size = 0;
		for(int j=jj-1,i=ii;j>=0&&a[i][j]==1;j--,size++);
		currMax = size;
		if(max>=currMax)
			return max;
		for(int i=ii+1,j=jj;i<n&&a[i][j]==1&&size>0;i++,size--);
		currMax-=size;
		size = currMax;
		if(max>=currMax)
			return max;
		for(int i=ii,j=jj+1;j<m&&a[i][j]==1&&size>0;j++,size--);
		currMax-=size;
		size = currMax;
		if(max>=currMax)
			return max;
		for(int i=ii-1,j=jj;i>=0&&a[i][j]==1&&size>0;i--,size--);
		currMax-=size;
		if(max>=currMax)
			return max;
		return currMax;
	}
}
