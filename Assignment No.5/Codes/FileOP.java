import java.util.*;
import java.io.*;

public class FileOP {
	public static void main(String args[])throws Exception
	{
		String fname = "";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the File Name To Create And Store The Data: - ");
		fname = sc.next();
		File file = new File(fname);
		try {
			if(file.createNewFile())
			{
				System.out.println("File Created SuccessFully");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String[] myArray = new String[2];
		ArrayList<String> a1 = new ArrayList<String>();
		
		String find ="";		
		String Name = "";
		String Roll_No = "";
		String Gr_No = "";
		String Final = "";
		int iNo;
		boolean temp = false;
		
		System.out.println("How Many Records Do You Want To Insert");
		iNo = sc.nextInt();
		
		for(int j = 0; j < iNo; j++)
		{
			sc.nextLine();
			System.out.println("Enter the Name of Student: -");
			Name = sc.nextLine();
			System.out.println("Enter the Roll No of Student: -");
			Roll_No = sc.next();
			System.out.println("Enter the Gr No of Student: -");
			Gr_No = sc.next();
			Final = Name+" "+Roll_No+" "+Gr_No;
			
			try {
				FileWriter pobj = new FileWriter(file, true);
				pobj.append(Final);
				pobj.append(System.getProperty("line.separator"));
				pobj.close();
				System.out.println("Record Added Successfully !");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("The Records Stored In The File Are: - ");
		char[] buffer = new char[500];
		try {
			FileReader robj = new FileReader(file);
			robj.read(buffer);
			System.out.println(buffer);
			robj.close();
			System.out.println("Data Fetch From File Successfully !");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Enter The Roll_No of the student to check whether student exists in record or not: -");
		find = sc.next();
		
		try {
			Scanner sobj = new Scanner(file);
			int lineNum = 0;
			while(sobj.hasNext())
			{
				String line = sobj.nextLine();
		        lineNum++;
				myArray = line.split(" ");
				for(int i = 0; i < myArray.length; i++)
				{
					if(find.equalsIgnoreCase(myArray[i]))
					{
						temp = true;
						break;
					}
				}
			}
			sobj.close();
			if(temp == true)
			{
				System.out.println("Record Found !");
			}
			else
			{
				System.out.println("Record Not Found !");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Enter The Roll_No of the student to delete an record: -");
		find = sc.next();
		
		try {
			Scanner sobj1 = new Scanner(file);
			String currentLine = "";
			int lineNum = 0;
			boolean stemp = false;
			int k = 0;
			while(sobj1.hasNext())
			{
				currentLine = sobj1.nextLine();		
				stemp = currentLine.contains(find);
				if(stemp == false)
				{
					a1.add(currentLine);
				}
				
			}
			sobj1.close();
			System.out.println(file.delete());
			try {
				File file1 = new File(fname);
				file1.createNewFile();
				FileWriter pobj1 = new FileWriter(file1, true);
				for(int i = 0; i < a1.size(); i++)
				{
					String str = a1.get(i);
					pobj1.append(str);
					pobj1.append(System.getProperty("line.separator"));
					temp = true;
				}
				pobj1.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			if(temp == true)
			{
				System.out.println("Record Deleted Successfully !");
			}
			else
			{
				System.out.println("Unable to Delete Record !");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
