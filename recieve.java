
import java.util.*;
import java.net.*;
import java.io.*;

class recieve
{
public static void main(String args[]) throws Exception
 {
	Socket s=new Socket("localhost",6556);
	System.out.println("connection initated");
	
	InputStream in=s.getInputStream();
	byte[] b=new byte[100];
	in.read(b);
	String st=new String(b);
	
	//for(int i=0;i<6;i++)
	//{System.out.println(b[i]);}
	System.out.println("Recieved string is......."+st);
	
 }

}
