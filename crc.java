import java.io.*;
import java.util.*;
class crc4
{

public static int xor(int a,int b)

{if(a==b)

return 0;

else

return 1;}



public static void main(String arg[])

{

Scanner s=new Scanner(System.in);

int n;

System.out.println("enter the size of data and divisor....");

n=s.nextInt();

int m=s.nextInt();

int d[]=new int[m];

int a[]=new int[n+m-1];

int r[]=new int[n+m-1];

System.out.println("enter the data of size "+n);

for(int i=0;i<n;i++)

{a[i]=s.nextInt();

r[i]=a[i];}

System.out.println("enter the divisor value...");

for(int i=0;i<m;i++)

d[i]=s.nextInt();

for(int i=n;i<n+m-1;i++)

a[i]=r[i]=0;

for(int i=0;i<n;i++)

{if(r[i]==0)

	{}

else

{for(int j=0;j<m;j++)

{r[i+j]=xor(r[i+j],d[j]);}}}

for(int i=n;i<n+m-1;i++)

{a[i]=a[i]+r[i];}

System.out.println("CRC frame is....");

for(int i=0;i<n+m-1;i++)

System.out.print(a[i]+" ");

System.out.println();

for(int i=0;i<n;i++)

{if(a[i]==0)

	{}

else

{for(int j=0;j<m;j++)

{a[i+j]=xor(a[i+j],d[j]);}}}

boolean flag=false;

int i=0;

for(i=n;i<n+m-1;i++)

{if(a[i]==0)

	flag=true;

else

{flag=false;

break;}}

if(flag)

	System.out.println("There is no error..");

else

{int k=i-n;

	System.out.println("There is error in bit no:.."+k);

}

}}
