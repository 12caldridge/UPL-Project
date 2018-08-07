import java.io.*;
import java.util.*;
public class UPLDriverList
{
	String driverFileName="driverList.txt";
	UPLDriver[] arrayDriver = new UPLDriver[20];
	int nextDriverLocation = 0;
	int resultOfDriverSearch = -1;
	
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
		//remove these!
		showDriverList();
		writeDriverListToFile();
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
		int tempCount = 0;
		try
		{
			FileReader fr = new FileReader(driverFileName);
			BufferedReader br = new BufferedReader(fr);
			
			String sReadLine = br.readLine();
			
			while(sReadLine != null)
			{
				String[] splitData = sReadLine.split(",");
                 UPLDriver tempRead = new UPLDriver();
                 tempRead.driverId = Integer.parseInt(splitData[0]);
                 tempRead.driverName = splitData[1];
                 tempRead.constructor = splitData[2];
                 tempRead.points = Integer.parseInt(splitData[3]);
                 System.out.println("[LIST] Finished reading index: " + tempCount);
                 System.out.println("[LIST] Driver Found:\n"+tempRead.toString());
                 addDriverToListToList(tempRead);

                 sReadLine = br.readLine();
			}
			fr.close();
		}
		
		catch(Exception exc)
		{
			System.out.println("[LIST] [ERROR] there was an error reading the students from the file at: " + tempCount + "   "  + exc);
		}
	}
}