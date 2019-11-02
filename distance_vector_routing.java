import java.util.*;
import java.lang.*;
class dsv
{
public static void main(String[] args) throws Exception
{
Scanner inp= new  Scanner(System.in);
System.out.println("enter number of nodes");
int n=inp.nextInt();
int arr[][]= new int[n][n];
int cost[][]=new int[n][n];
for(int i=0;i<n;i++)
{
for(int j=0;j<n;j++)
{
if(i==j)
{arr[i][j]=0;
cost[i][j]=0;
}
else{
System.out.println("enter the cost between "+i+" and "+j);
arr[i][j]=inp.nextInt();
}
}
}
//System.out.println(cost[2][1]);
int m;
for(int z=0;z<n;z++)
{
for (int i=0;i<n;i++)
{
for (int j=0;j<n;j++)
{
m=99;
if(i!=j)
{
for(int k=0;k<n;k++)
{
if(i!=k)
  {
  if(m>(arr[i][k]+cost[k][j]))
   {m=arr[i][k]+cost[k][j];}
  }
}
cost[i][j]=m;
}
}
}
}
System.out.println("enter node no to which to be find");
int l=inp.nextInt();
System.out.println("result is");
for(int i=0;i<n;i++)
{
   System.out.println(cost[i][l]);
}
}
}
