import java.util.*;
import java.util.Scanner;

public class Main
{
    public static String add(String a,String b)
    {
        int n=Math.max(a.length(),b.length());
        
        while(a.length()<n)
        a='0'+a;
        
        while(b.length()<n)
        b='0'+b;
        
        int carry=0;
        int sum=0;
        String ans="";
        
        for(int i=n-1;i>=0;i--)
        {
            int x=a.charAt(i)-'0';
            int y=b.charAt(i)-'0';
            
            sum=x+y+carry;
            carry=sum/10;
            
            ans=Integer.toString(sum%10)+ans;
        }
        if(carry>0)
        ans=Integer.toString(carry)+ans;
        
        return ans;
    }
    public static String mul(String s1,String s2)
    {
        String ans="";
        int n=Math.max(s1.length(),s2.length());
        
        while(s1.length()<n)
        s1='0'+s1;
        
        while(s2.length()<n)
        s2='0'+s2;
        
        if(n<=1)
        {
            int sum=(s1.charAt(0)-'0')*(s2.charAt(0)-'0');
            return Integer.toString(sum);
        }
        int mid=n/2;
        String a1=s1.substring(0,mid);
        String a2=s1.substring(mid);
        String b1=s2.substring(0,mid);
        String b2=s2.substring(mid);
        
        String A=mul(a1,b1);
        String B=mul(a2,b1);
        String C=mul(a1,b2);
        String D=mul(a2,b2);
        
        String ft=A+"0".repeat(2*(n-mid));
        String st=add(B,C)+"0".repeat(n-mid);
        
        ans=add(add(ft,st),D);
        return ans;
        
    }
    public static String squ(String n)
    {
        return mul(n,n);
    }
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    
		System.out.println("Enter n ");
		String  n=sc.nextLine();
		
		System.out.println(squ(n));
	}
}

