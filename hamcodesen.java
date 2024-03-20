import java.util.*;
import java.net.*;
import java.io.*;
class hmcodesen
{
	public static void main(String[] args)throws Exception
	{
		ServerSocket ss=new ServerSocket(3135);
		Socket s=ss.accept();
		OutputStream out=s.getOutputStream();
		int n;
		Scanner inp=new Scanner(System.in);
		System.out.println("enter num of bits in data ");
		n=inp.nextInt();
		int k=0;
		for(int i=0;i<n;i++)
		{
			if(((int)Math.pow(2,i)-1)>=(n+i))
			{
				k=i;
				break;
			}
		}
		byte[] data=new byte[n];
		System.out.println("enter data bits in binary form bit by bit ");
		for(int i=0;i<n;i++)
		{
			data[i]=(byte)inp.nextInt();
		}
		byte[] res=new byte[n+k];
		for(int i=0;i<(n+k);i++)
		{
			res[i]=-1;
		}
		for(int i=0;i<k;i++)
		{
			res[(int)Math.pow(2,i)-1]=0;
		}
		int j=0;
		for(int i=0;i<(n+k);i++)
		{
			if(res[i]==-1)
				{
					res[i]=data[j];
					j++;
				}
		}
		byte sum=0;
		
		for(int i=0;i<k;i++)
		{
			sum=0;
			for(j=1;j<=(n+k);j++)
			{
				if(((j>>i)&1)==1)
					{
					    sum=(byte)(sum^res[j-1]);
					}
					//res[(int)Math.pow(2,i)-1]=sum;
			}
			res[(int)Math.pow(2,i)-1]=sum;
			
		}
		
		System.out.print("data withcheck bits is ");
		//for(byte x:res)
			for(int i=0;i<n+k;i++)
			System.out.print(res[i]);
		System.out.println();
System.out.println("enter position to corrupt ");
int pos=inp.nextInt();
if(res[pos]==0)
	res[pos]=1;
else
	res[pos]=0;
out.write(res);
s.close();
	}
}
