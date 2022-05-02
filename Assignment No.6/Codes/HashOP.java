import java.util.*;

class Hash{
	public int[] arr;
	public int k;
	
	Hash(int size)
	{
		arr = new int[size];
		k = 0;
		for(int i = 0; i < arr.length; i++)
		{
			arr[i] = -1;
		}
	}
	
	public void InsertElement(int iEle)
	{
		int key = (iEle % 10);
		int temp;
		int i = 0;
		if(k != arr.length)
		{
			if(arr[key] == -1)
			{
				arr[key] = iEle;
				k++;
			}
			else
			{

					if(arr[key] == -1)
					{
						arr[key] = iEle;
						k++;
					}
					else
					{
						for(i = key; i < arr.length; i++)
						{
							if(arr[i] == -1)
							{
								arr[i] = iEle;
								k++;
								break;
							}
						}
						
						if(i == arr.length)
						{
							for(i = 0; i < key; i++)
							{
								if(arr[i] == -1)
								{
									arr[i] = iEle;
									k++;
									break;
								}
							}
						}
						else
						{
							System.out.println("Unable To Insert Elements In The Heap !");
						}
					}	
			}
		}
		else
		{
			System.out.println("Unable to insert element in the heap please free up heap !");
		}
	}
	
	public void DeleteElement(int iEle)
	{
		int key = (iEle % 10);
		int temp;
		int i = 0;
		if(k != arr.length)
		{
			if(arr[key] == iEle)
			{
				arr[key] = -1;
				k--;
			}
			else
			{

					if(arr[key] == iEle)
					{
						arr[key] = -1;
						k--;
					}
					else
					{
						for(i = key; i < arr.length; i++)
						{
							if(arr[i] == iEle)
							{
								arr[i] = -1;
								k--;
								break;
							}
						}
						
						if(i == arr.length)
						{
							for(i = 0; i < key; i++)
							{
								if(arr[i] == iEle)
								{
									arr[i] = -1;
									k++;
									break;
								}
							}
						}
						else
						{
							System.out.println("Record Not Found !");
						}
					}	
			}
		}
		else
		{
			System.out.println("Unable to insert element in the heap please free up heap !");
		}
	}
	
	public void Display()
	{
		if(arr.length == 0)
		{
			return;
		}
		else
		{
			System.out.println("Elements From Hash Table are = ");
			for(int i = 0; i < arr.length; i++)
			{
				System.out.println(arr[i]);
			}
		}
	}
}
public class HashOP{
	public static void main(String args[])
	{
		int iSize = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the hash table: -");
		iSize = sc.nextInt();
		
		Hash hobj = new Hash(iSize);
		hobj.InsertElement(43);	
		hobj.InsertElement(135);
		hobj.InsertElement(72);
		hobj.InsertElement(23);
		hobj.InsertElement(99);
		hobj.InsertElement(19);
		hobj.InsertElement(82);
		hobj.Display();
		hobj.DeleteElement(19);
		hobj.Display();
		hobj.InsertElement(19);
		hobj.Display();
	}
}