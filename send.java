import java.util.*;
import java.net.*;
import java.io.*;

class send
{
public static void main(String args[]) throws Exception
 {
	ServerSocket ss=new ServerSocket(6556);
	System.out.println("listening....to...6556...");
	Socket s=ss.accept();	
	System.out.println("connection created...");
	OutputStream out=s.getOutputStream();
	Scanner inp=new Scanner(System.in);
	
	byte b[]=new byte[100];
	
	//System.out.println("enter length of string...");
	//int n=inp.nextInt();
	//for(int i=0;i<n;i++)
	//{
	//	b[i]=(byte)inp.nextInt();
	//}
	
	
	String str1=new String();
	System.out.println("enter the string...");
	str1=inp.nextLine();
	System.out.println("sending string is......"+str1);
	b=str1.getBytes();
	out.write(b);
	
	s.close();
 }

}
