//5. Client program
import java.rmi.*;
import java.rmi.registry.*;
public class SortClient{
	public static void main(String args[])throws Exception{
		SortInter obj=(SortInter) Naming.lookup("rmi://localhost:1567/InsertionSort");
		int a[]={6,9,7,1,5,7};
		System.out.println("Sorted list is...");
		int b[]=obj.isort(a);
		for(int i=0;i<b.length;i++)
  		{System.out.print(b[i]+" ");}
	}
}
	
