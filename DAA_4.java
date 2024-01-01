import java.util.*;
import java.util.Scanner;

public class Main
{
    public static int mindis(int []ans,boolean vis[],int n)
    {
        int val=Integer.MAX_VALUE, id=-1;
        
        for(int i=0;i<n;i++)
        {
            if(val>=ans[i] && vis[i]==false)
            {
                id=i;
                val=ans[i];
            }
        }
        return id;
    }
    public static void djs(int graph[][],int s,int n)
    {
        int []ans=new int[n];
        
        boolean []vis=new boolean[n];
        
        for(int i=0;i<n;i++)
        {
            ans[i]=Integer.MAX_VALUE;
            vis[i]=false;
        }
        
        ans[s]=0;
        
        
        for(int i=0;i<n-1;i++)
        {
            
            int j=mindis(ans,vis,n);
            
            vis[j]=true;
            
            for(int k=0;k<n;k++)
            {
                if(vis[k]==false && graph[j][k]!=0 && ans[j]!=Integer.MAX_VALUE && ans[j]+graph[j][k]<ans[k])
                {
                    ans[k]=ans[j]+graph[j][k];
                }
            }
            
            
        }
        for(int i=0;i<n;i++)
            System.out.println(ans[i]);
    }
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
		System.out.println("Enter no of vertices");
		int n=sc.nextInt();
		
		//int [][]graph=new int[n][n];
		
// 		for(int i=0;i<n;i++)
// 		{
// 		    for(int j=0;j<n;j++)
// 		    {
// 		        graph[i][j]=sc.nextInt();
// 		    }
// 		}

        int graph[][]
            = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                            { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                            { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                            { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                            { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                            { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                            { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                            { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                            { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
                            
             djs(graph,0,n);               
	}
}

