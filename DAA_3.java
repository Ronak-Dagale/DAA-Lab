import java.util.*;
import java.util.Scanner;

public class Main{
    public void solve(int [][]graph,int n)
    { 
               int [][]dis=new int [n][n];
       
       for(int i=0;i<n;i++)
       {
           for(int j=0;j<n;j++)
           {
               dis[i][j]=graph[i][j];
           }
       }
       
       
       for(int k=0;k<n;k++)
       {
           for(int i=0;i<n;i++)
           {
               for(int j=0;j<n;j++)
               {
                   dis[i][j]=Math.min(dis[i][j],dis[i][k]+dis[k][j]);
               }
           }
       }
       
       for(int i=0;i<n;i++)
       {
           for(int j=0;j<n;j++)
           {
               System.out.print(dis[i][j]+" ");
           }
           System.out.println();
       }
    }
    public static void main(String []args)
    {
    //   int [][]graph={
    //       {6,3,99,7},
    //       {1,0,2,99},
    //       {5,99,7,1},
    //       {1,99,99,0}
    //   };
    Scanner sc=new Scanner(System.in);
     System.out.println("Enter no of vertices : ");
     
       int n=sc.nextInt();
       
       int [][]graph=new int[n][n];
       
       for(int i=0;i<n;i++)
       {
           for(int j=0;j<n;j++)
           {
               graph[i][j]=sc.nextInt();
           }
       }
      Main p =new Main();
      p.solve(graph,n);
    }
}
