import java.io.*;
import java.util.*;
public class UPLDriverList
{
	File driverFileName= new File("driverList.txt");
	UPLDriver[] arrayDriver = new UPLDriver[20];
	int nextDriverLocation = 0;
	UPLDriver resultOfDriverSearch = new UPLDriver();
	int finalDriverID=0;
	int driverPoints=0;
	int currentDriver;
	boolean driverFound;
	
	public void DriverList()
	{
		System.out.println("[LIST] running constructor -new DriverList");
	}
	
	public void showDriverList()
	{
		System.out.println("[LIST] printing driver list");
		for(int i=0; i<nextDriverLocation; i++)
		{
			String currentPosDriverData = arrayDriver[i].toString();
			System.out.println(i+" is "+currentPosDriverData);
		}
	}
	
	public void addDriverToList(UPLDriver tempDriver)
	{
		System.out.println("[LIST] adding driver to list");
		
		arrayDriver[nextDriverLocation]= tempDriver;
		nextDriverLocation++;
		
		
		
	}
	
	public void writeDriverListToFile()
	{
			System.out.println("[LIST] Running write to file");
			try
			{
				FileWriter fw = new FileWriter(driverFileName);
				
				for(int i=0; i<nextDriverLocation; i++)
				{
					String currentPosDriverData = arrayDriver[i].toString();
					fw.write(currentPosDriverData);
					fw.write("\r\n");
					System.out.println("[LIST] written "+i);
				}
				fw.close();
			}
			
			catch(Exception exc)
			{
				System.out.println("[LIST] [ERROR] there was an error writting the drivers to file"+exc);
			}
	}
	
	public void readDriverListFromFile()
	{
		System.out.println("[LIST] Running reading algorithm");
		nextDriverLocation=0;
		try
		{
			FileReader fr = new FileReader(driverFileName);
			BufferedReader br = new BufferedReader(fr);
			
			String sReadLine = br.readLine();
			
			while(sReadLine != null)
			{
				String[] splitData = sReadLine.split(",");
                UPLDriver tempRead = new UPLDriver();
                tempRead.driverID = Integer.parseInt(splitData[0]);
				if (tempRead.driverID > finalDriverID)
				{
					finalDriverID = tempRead.driverID;
				}
                tempRead.driverName = splitData[1];
                tempRead.constructor = splitData[2];
                tempRead.points = Integer.parseInt(splitData[3]);
                System.out.println("[LIST] Driver Found:\n"+tempRead.toString());
                addDriverToList(tempRead);

                sReadLine = br.readLine();
			}
			fr.close();
			System.out.println("[LIST] [READ] Showing contents of file");
			showDriverList();
		}
		
		catch(Exception exc)
		{
			System.out.println("[LIST] [ERROR] there was an error reading the students from the file at: " + exc);
		}
	}
	
	public void sortDriverList()//bubble sort
	{
		boolean swapped = true;
		while(swapped==true)
		{
			swapped = false;
			for(int k=0;k<(nextDriverLocation-1);k++)
			{
				System.out.println("[LIST] [SORT] Checking "+k+" with "+(k+1));
				if(arrayDriver[k].points<arrayDriver[k+1].points)
				{
					UPLDriver tempDriver = arrayDriver[k];
					arrayDriver[k] = arrayDriver[k+1];
					arrayDriver[k+1]=tempDriver;
					System.out.println("[LIST] [SORT] Position swapped correctly");
					swapped=true;
				}
				
				else
				{
					System.out.println("[LIST] [SORT] Position not swapped");
				}
			}
		}
		showDriverList();
	}
	
	public void searchForDriver(String searchValue)
	{
		System.out.println("[LIST] [SEARCH] starting search for " + searchValue);
		readDriverListFromFile();
		driverFound=false;
		
		for(int i=0;i<nextDriverLocation;i++)
		{
			System.out.println("[LIST] [SEARCH] searching at "+i);
			if (arrayDriver[i].driverName.equals(searchValue))
			{
				System.out.println("Search value "+searchValue+" found at "+i);
				resultOfDriverSearch=arrayDriver[i];
				driverFound = true;
				currentDriver = i;
			}
		}
	}
}