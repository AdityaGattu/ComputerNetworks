import gnu.io.*;
import java.io.*;
import java.util.*;
public class Sender1
{
    public static void main(String[] args)throws Exception
    {
       		CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier("COM1");
	        SerialPort serialPort = (SerialPort) portIdentifier.open("Sender", 5000);
		serialPort.setSerialPortParams(38400, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
                OutputStream out = serialPort.getOutputStream();
	        DataInputStream in=new DataInputStream(System.in);
		String s=in.readLine();
		out.write(s.getBytes());
		out.flush();
     }

}
