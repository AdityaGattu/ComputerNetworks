
import gnu.io.*;
import java.io.*;
import java.util.*;
public class Receiver implements SerialPortEventListener
{
	static InputStream in;
	static SerialPort serialPort;
	Receiver()throws Exception{
        	CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier("COM1");
	        serialPort = (SerialPort) portIdentifier.open("Receiver", 5000);
		serialPort.notifyOnDataAvailable(true);
	        serialPort.setSerialPortParams(38400, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE); 
	        in = serialPort.getInputStream();
			System.out.println("process started");
	      	serialPort.addEventListener(this);
	}
	public void serialEvent(SerialPortEvent event)
	{	
		int c;
		if(event.getEventType()==SerialPortEvent.DATA_AVAILABLE){
		try {
			do{
				c = in.read();
				System.out.print("\nReceived..." + (char) c);
				Thread.sleep(100);
			
			} while(c!=-1);
			System.exit(0);
		}catch (Exception e) { System.out.print("out of data!");}}
   	}
    	public static void main(String[] args)throws Exception
   	{
		Receiver r=new Receiver();
      
    	}
}
