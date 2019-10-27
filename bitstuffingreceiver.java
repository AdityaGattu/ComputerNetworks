import java.net.*;
import java.io.*;
import java.util.*;
public class bitstuffingreceiver{
public static void main(String args[]) throws Exception{
Socket s=new Socket("localhost",1234);
System.out.println("Connection Initiated...");
byte[] b=new byte[100];
InputStream in=s.getInputStream();
FileOutputStream fos=new FileOutputStream("Test1.txt");
in.read(b);
		String st = new String(b); 
		st=st.trim();
		String data="";
		System.out.println("Stuffed data from client: " + st +"length..."+st.length()); 
		System.out.println("Unstuffed data: "); 
		int cnt = 0; 
		for (int i = 8; i < st.length() - 8; i++) 
		{ 
			char ch = st.charAt(i);
           		
			if (ch == '1') { 
				cnt++; 
				if(cnt==5){i++;cnt=0;}
			} 
			else{cnt=0;}
			  data+=ch;	
        }
			
		System.out.println(""+data); 
			fos.write(data.getBytes());
		s.close();
}
		} 
		


