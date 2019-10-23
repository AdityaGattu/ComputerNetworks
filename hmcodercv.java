import java.util.*;
import java.io.*;
import java.net.*;
class hmcoderec
{
	public static void main(String[] args)throws Exception
	{
		Socket s=new Socket("localhost",3135);
		InputStream in=s.getInputStream();
		int n;
		System.out.println("enter num of bits in data ");
		Scanner inp=new Scanner(System.in); 
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
		byte[] res=new byte[n+k];
		in.read(res);
		byte sum=0;
		int check=0;
		for(int i=0;i<k;i++)
		{
			sum=0;
			for(int j=1;j<=(n+k);j++)
			{
				if(((j>>i)&1)==1)
					sum=(byte)(sum^res[j-1]);
					
			}
			if(sum==1)
			check=check+(int)Math.pow(2,i);
		}
		System.out.println("error is at "+(check-1));
			if(res[check-1]==1)
				res[check-1]=0;
			else
				res[check-1]=1;
			System.out.println("after correction ");
		for(byte x:res)
			System.out.print(x);
		System.out.println();

s.close();
	}
}
