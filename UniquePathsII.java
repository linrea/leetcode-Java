package leetcode;

/*
 * Follow up for "Unique Paths":
Now consider if some obstacles are added to the grids. How many unique paths would there be?
An obstacle and empty space is marked as 1 and 0 respectively in the grid.
For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100.
 */
public class UniquePathsII
{
	public static int uniquePathsWithObstacles(int[][] obstacleGrid)
	{
		
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		if(m>0&&n>0&&obstacleGrid[m-1][n-1]==1) return 0;
		int[][] dp = new int[m][n];
		boolean flag = false;
		for (int i = 0; i < m; i++)
		{
			if (obstacleGrid[i][0] == 1)
			{
				flag = true;				
			}
			if (flag == false)
				dp[i][0] = 1;	
			else 
				dp[i][0] = 0;
		}
		flag=false;
		for (int i = 0; i < n; i++)
		{
			if (obstacleGrid[0][i] == 1)
			{
				flag = true;
				
			}
			if (flag == false)
				dp[0][i] = 1;
			else
				dp[0][i] = 0;
			
		}
		for (int i = 1; i < m; i++)
			for (int j = 1; j < n; j++)
			{
				if(obstacleGrid[i - 1][j] == 1&&obstacleGrid[i][j - 1] == 1)
					dp[i][j]=0;					
				else if (obstacleGrid[i - 1][j] == 1&&obstacleGrid[i][j - 1] != 1)
					dp[i][j] = dp[i][j - 1];
				else if (obstacleGrid[i - 1][j] != 1&&obstacleGrid[i][j - 1] == 1)
					dp[i][j] = dp[i - 1][j];
				else
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		return dp[m - 1][n - 1];

	}

	public static void main(String[] args)
	{
		int[][] obstacleGrid = { {1,0 } };
		int a = uniquePathsWithObstacles(obstacleGrid);
		System.out.println(a);

	}

}
