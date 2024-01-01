import java.util.*;
import java.util.Scanner;

public class Main{
    public boolean solve(int x,int y,int [][]dis,int n,int count)
    {
        if(count==n*n)
        {
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    System.out.print(dis[i][j]+" ");
                }
                System.out.println();
            }
            return true;
        }
        
        int []dx={1,1,-1,-1,2,2,-2,-2};
        int []dy={2,-2,2,-2,1,-1,1,-1};
        
        for(int i=0;i<8;i++)
        {
            int nex=x+dx[i];
            int ney=y+dy[i];
            
            if(nex>=0 && nex<n && ney>=0 && ney<n && dis[nex][ney]==-1)
            {
                dis[nex][ney]=count+1;
               if(solve(nex,ney,dis,n,count+1))
               return true;
               dis[nex][ney]=-1;
            }
        }
        return false;
    }
    public static void main(String []args)
    {
        Scanner sc=new Scanner(System.in);
       System.out.println("Enter value of n : ");
       int n=sc.nextInt();
       
        System.out.println("Enter value of x and y : ");
        int x=sc.nextInt();
        int y=sc.nextInt();
        
        Main m=new Main();
        
        int [][]dis=new int [n][n];
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                dis[i][j]=-1;
            }
        }
        dis[x][y]=1;
        if(m.solve(x,y,dis,n,1))
        System.out.println("Solution exist");
        else
        System.out.println("solution not exist");
    }
}


