import java.util.*;
import java.util.Scanner;
public class Main{
    static class Job{
        int de;
        int pr;
        int id;
        
        public Job(int i,int j,int k)
        {
            de=i;
            pr=j;
            id=k;
        }
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        
        ArrayList<Job> jobs=new ArrayList<>();
        
        
        System.out.println("Enter no of jobs : ");
        int n=sc.nextInt();
        
        int maxde=Integer.MIN_VALUE;
        for(int k=0;k<n;k++)
        {
            int i=sc.nextInt();
            int j=sc.nextInt();
            
            maxde=Math.max(maxde,i);
            jobs.add(new Job(i,j,k));
        }
        
        boolean []result=new boolean[maxde];
        
         int []seq=new int[maxde];
        
        Collections.sort(jobs,(a,b)->b.pr-a.pr);
        
        
        int maxpr=0;
        
        for(int i=0;i<n;i++)
        {
            int cude=jobs.get(i).de-1;
            
            for(int j=cude;j>=0;j--)
            {
                if(result[j]==false)
                {
                    result[j]=true;
                    seq[j]=jobs.get(i).id;
                    maxpr+=jobs.get(i).pr;
                    break;
                }
            }
        }
        
        System.out.println("Enter no of jobs : "+ maxpr);
        for(int i=0;i<maxde;i++)
        System.out.println(seq[i]);
    }
}

