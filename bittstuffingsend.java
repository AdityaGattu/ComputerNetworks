import java.io.*;
import java.net.*;
import java.util.*;
public class bittstuffingtcpsender{
  public static void main(String args[]) throws Exception{
	ServerSocket ss=new ServerSocket(1234);
	System.out.println("Listening to 1234...");
	Socket s=ss.accept();
	System.out.println("Conn created");
	//FileInputStream fis=new FileInputStream("sample.txt");
	byte[] b=new byte[1024];
	//fis.read(b);
                OutputStream os=s.getOutputStream();
                String data = new String();
               Scanner s1=new Scanner(System.in);
			   System.out.println("enter string..........");
                 data=s1.nextLine();				 
                data=data.trim();
		System.out.println("data: "+data); 
		int cnt = 0; 
		String st = ""; 
		for (int i = 0; i < data.length(); i++) { 
			char ch = data.charAt(i); 
			st+=ch;
			if(ch=='1')
			{
				cnt++;
				if(cnt==5){st+='0';cnt=0;}
			}
			else{cnt=0;}
		} 
		 st = "01111110" + st + "01111110"; 
		System.out.println("Data stuffed in client: " + data); 
		System.out.println("Sending to server for unstuffing"); 
		        os.write(st.getBytes());
	System.out.println("Data sent to receiver is "+st);
	s.close();}
}
