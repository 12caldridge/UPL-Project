
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

//*************************
//Code Generated by JGuiD
//*************************

public class UPLGUI extends JFrame implements ActionListener 
{
	
	UPLDriverList driversList = new UPLDriverList();
	
//[StartVariables]
	JPanel MYPANEL = new JPanel(null); //layout
	JPanel ADD = new JPanel(null);
	JPanel UPDATE = new JPanel(null);
	JPanel EDIT = new JPanel(null);
	
	//TABLE PANE
	JTextField txtSearch = new JTextField();
	JButton btnSearch = new JButton();
	JScrollPane scrDriverTable;
	JLabel lblSearchValue = new JLabel();
	
	//ADD PANE
	JButton btnAdd = new JButton();
	JLabel lblUsername = new JLabel();
	String[] consData = {"Mercedes", "Ferrari", "Red Bull", "Force India", "Williams", "Haas", "Renault", "Mclaren", "Sauber", "Toro Rosso"};
	JComboBox comCons = new JComboBox(consData);
	JTextField txtUsername = new JTextField();
 	
	//UPDATE PANE
	JLabel lblDriver = new JLabel();
	JComboBox comDriver = new JComboBox();
	JLabel lblPosition = new JLabel();
	String[] positions = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
	JComboBox comPosition = new JComboBox(positions);
	JButton btnUpdate = new JButton();
	
	//EDIT/DELETE PANE
	JLabel lblNewCons = new JLabel();
	JComboBox comEditDriver = new JComboBox();
	JTextField txtNewName = new JTextField();
	JButton btnDelete = new JButton();
	JButton btnEdit = new JButton();
	JComboBox comEditCons = new JComboBox(consData);
	JLabel lblNewName = new JLabel();
	
	//Links
	
	
	JTabbedPane jtp = new JTabbedPane();
	

//[EndVariables]

//[StartFrameSettings]
public void startGUI()
{

	this.setLayout(new GridLayout(1,1));
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	driversList.readDriverListFromFile();
	CREATEMYPANEL();
	CREATEPANEL2();
	CREATEPANEL3();
	CREATEPANEL4();
	jtp.addTab("Table", MYPANEL);
	jtp.addTab("Add", ADD);
	jtp.addTab("Update", UPDATE);
	jtp.addTab("Edit", EDIT);
	this.setTitle("UPL F1");
	this.setSize(1000,800);
	this.setForeground( new Color(-255255255) );
	this.setBackground( new Color(-255255255) );
	this.setVisible(true);
	this.setResizable(true);
	this.add(jtp);
}
//[EndFrameSettings]

public void CREATEPANEL4()
{
	createEditDriverCombo();
	
	comEditCons.setLocation(200, 100);
	comEditCons.setSize(200, 100);
	comEditCons.setForeground( new Color(0, 0, 0));
	comEditCons.setBackground( new Color(255, 255, 255));
	EDIT.add(comEditCons);
	
	lblNewName.setLocation(0, 200);
	lblNewName.setSize(200, 100);
	lblNewName.setForeground( new Color(0, 0, 0) );
	lblNewName.setBackground( new Color(255, 255, 255) );
	lblNewName.setText("New Driver Name:");
	EDIT.add(lblNewName);
	
	txtNewName.setLocation(200,200);
	txtNewName.setSize(200,100);
	txtNewName.setForeground( new Color(0, 0, 0) );
	txtNewName.setBackground( new Color(255, 255, 255) );
	txtNewName.setToolTipText("Your new username");
	EDIT.add(txtNewName);
	
	lblNewCons.setLocation(0, 100);
	lblNewCons.setSize(200, 100);
	lblNewCons.setForeground( new Color(0, 0, 0) );
	lblNewCons.setBackground( new Color(255, 255, 255) );
	lblNewCons.setText("New Constructor:");
	EDIT.add(lblNewCons);
	
	btnEdit.setLocation(0, 300);
	btnEdit.setSize(400, 100);
	btnEdit.setForeground( new Color(0, 0, 0) );
	btnEdit.addActionListener(this);
	btnEdit.setOpaque(true);
	btnEdit.setBackground( new Color(255, 255, 255) );
	btnEdit.setText("Update account");
	EDIT.add(btnEdit);
	
	btnDelete.setLocation(0, 400);
	btnDelete.setSize(400, 100);
	btnDelete.setForeground( new Color(0, 0, 0) );
	btnDelete.addActionListener(this);
	btnDelete.setOpaque(true);
	btnDelete.setBackground( new Color(255, 255, 255) );
	btnDelete.setText("Delete Account");
	EDIT.add(btnDelete);
}

public void createEditDriverCombo()
{
	comEditDriver.removeAllItems();
	comEditDriver.setForeground( new Color(0, 0, 0));
	comEditDriver.setBackground( new Color(255, 255, 255));
	comEditDriver.setLocation(0, 0);
	comEditDriver.setSize(400, 100);
	for(int i=0;i<driversList.nextDriverLocation;i++)
	{
		comEditDriver.addItem(driversList.arrayDriver[i].driverName);
	}
	EDIT.add(comEditDriver);
}

public void createDriverCombo()
{
	comDriver.removeAllItems();
	comDriver.setLocation(200, 0);
	comDriver.setSize(200, 100);
	for(int i=0;i<driversList.nextDriverLocation;i++)
	{
		comDriver.addItem(driversList.arrayDriver[i].driverName);
	}
	comDriver.setForeground( new Color(0, 0, 0));
	comDriver.setBackground( new Color(255, 255, 255));
	UPDATE.add(comDriver);
}

public void CREATEPANEL3()
{
	btnUpdate.setLocation(0, 200);
	btnUpdate.setSize(400, 100);
	btnUpdate.setForeground( new Color(0, 0, 0) );
	btnUpdate.addActionListener(this);
	btnUpdate.setOpaque(true);
	btnUpdate.setBackground( new Color(255, 255, 255) );
	btnUpdate.setText("Update");
	UPDATE.add(btnUpdate);
	
	lblDriver.setLocation(0, 0);
	lblDriver.setSize(200, 100);
	lblDriver.setForeground( new Color(0, 0, 0) );
	lblDriver.setBackground( new Color(255, 255, 255) );
	lblDriver.setText("Driver Name:");
	UPDATE.add(lblDriver);
	
	createDriverCombo();
	
	lblPosition.setLocation(0, 100);
	lblPosition.setSize(200, 100);
	lblPosition.setForeground( new Color(0, 0, 0) );
	lblPosition.setBackground( new Color(255, 255, 255) );
	lblPosition.setText("Position:");
	UPDATE.add(lblPosition);
	
	comPosition.setLocation(200, 100);
	comPosition.setSize(200, 100);
	comPosition.setForeground( new Color(0, 0, 0));
	comPosition.setBackground( new Color(255, 255, 255));
	UPDATE.add(comPosition);
}

public void CREATETABLE()
{
	
	
	String[] columnNames ={"Position", "Username", "Constructor", "Points"};
	
	Object[][] data = new Object[20][4];
	driversList.sortDriverList();
	for(int i=0;i<driversList.nextDriverLocation;i++)
	{
		Object[] tempRow = new Object[4];
		String tempName = driversList.arrayDriver[i].driverName;
		String tempConstructor = driversList.arrayDriver[i].constructor;
		int tempPoints = driversList.arrayDriver[i].points;
		tempRow[0]=(i+1);
		tempRow[1]= tempName;
		tempRow[2]= tempConstructor;
		tempRow[3]= tempPoints;
		data[i]=tempRow;
			
	}
	
	JTable tblDriver = new JTable(data, columnNames);
	tblDriver.setSize(600,500);
	tblDriver.setForeground(Color.white);
	tblDriver.setEnabled(false);
	tblDriver.setBackground(new Color(0, 102, 204));
	scrDriverTable = new JScrollPane(tblDriver);
	scrDriverTable.setLocation(0,0);
	scrDriverTable.setSize(1200,300);
	scrDriverTable.setForeground( new Color(-200200200) );
	scrDriverTable.setOpaque(true);
	scrDriverTable.setBackground( new Color(-000) );
	MYPANEL.add(scrDriverTable);
	
	 
				
}

public void CREATEPANEL2()
{
	btnAdd.setLocation(0, 200);
	btnAdd.setSize(400, 100);
	btnAdd.setForeground( new Color(0, 0, 0) );
	btnAdd.addActionListener(this);
	btnAdd.setOpaque(true);
	btnAdd.setBackground( new Color(255, 255, 255) );
	btnAdd.setText("Add");
	ADD.add(btnAdd);
	
	txtUsername.setLocation(200,0);
	txtUsername.setSize(200,100);
	txtUsername.setForeground( new Color(0, 0, 0) );
	txtUsername.setBackground( new Color(255, 255, 255) );
	txtUsername.setToolTipText("Your PSN username");
	ADD.add(txtUsername);
	
	lblUsername.setLocation(0, 0);
	lblUsername.setSize(200, 100);
	lblUsername.setForeground( new Color(0, 0, 0) );
	lblUsername.setBackground( new Color(255, 255, 255) );
	lblUsername.setText("Username:");
	ADD.add(lblUsername);
	
	comCons.setLocation(0, 100);
	comCons.setSize(400, 100);
	comCons.setForeground( new Color(0, 0, 0));
	comCons.setBackground( new Color(255, 255, 255));
	ADD.add(comCons);
}

//[StartIntialization]
public void CREATEMYPANEL()
{
	txtSearch.setLocation(1210,0);
	txtSearch.setSize(100,50);
	txtSearch.setForeground( new Color(0, 0, 0) );
	txtSearch.setBackground( new Color(255, 255, 255) );
	txtSearch.setToolTipText("Search for a value");
	MYPANEL.add(txtSearch);

	btnSearch.setLocation(1210,55);
	btnSearch.setSize(100,50);
	btnSearch.setForeground( new Color(0, 0, 0) );
	btnSearch.addActionListener(this);
	btnSearch.setBackground( new Color(255, 255, 255) );
	btnSearch.setText("Search");
	MYPANEL.add(btnSearch);
	
	lblSearchValue.setLocation(1210, 110);
	lblSearchValue.setSize(300, 100);
	lblSearchValue.setForeground( new Color(0, 0, 0) );
	lblSearchValue.setBackground( new Color(255, 255, 255) );
	lblSearchValue.setText("");
	MYPANEL.add(lblSearchValue);

	CREATETABLE();
	
}
//[EndIntialization]

public void addDriver()
{
	String driverName = txtUsername.getText();
	String constructor = comCons.getSelectedItem().toString();
	driversList.readDriverListFromFile();
	int DriverID = driversList.finalDriverID+1;
	UPLDriver tempDriver = new UPLDriver();
	tempDriver.driverName=driverName;
	tempDriver.constructor=constructor;
	tempDriver.driverID=DriverID;
	driversList.addDriverToList(tempDriver);
	driversList.writeDriverListToFile();
	MYPANEL.remove(scrDriverTable);
	CREATETABLE();
	UPDATE.remove(comDriver);
	createDriverCombo();
	EDIT.remove(comEditDriver);
	createEditDriverCombo();
	txtUsername.setText("");
}

public void updatePoints(String tempPosition)
{
	if(tempPosition.equals("1"))
	{
		int tempDriver = driversList.currentDriver;
		int tempPoints = driversList.arrayDriver[tempDriver].points;
		tempPoints= tempPoints+25;
		driversList.arrayDriver[tempDriver].points= tempPoints;
		driversList.writeDriverListToFile();
		MYPANEL.remove(scrDriverTable);
		CREATETABLE();
	}
	if(tempPosition.equals("2"))
	{
		int tempDriver = driversList.currentDriver;
		int tempPoints = driversList.arrayDriver[tempDriver].points;
		tempPoints= tempPoints+18;
		driversList.arrayDriver[tempDriver].points= tempPoints;
		driversList.writeDriverListToFile();
		MYPANEL.remove(scrDriverTable);
		CREATETABLE();
	}
	if(tempPosition.equals("3"))
	{
		int tempDriver = driversList.currentDriver;
		int tempPoints = driversList.arrayDriver[tempDriver].points;
		tempPoints= tempPoints+15;
		driversList.arrayDriver[tempDriver].points= tempPoints;
		driversList.writeDriverListToFile();
		MYPANEL.remove(scrDriverTable);
		CREATETABLE();
	}
	if(tempPosition.equals("4"))
	{
		int tempDriver = driversList.currentDriver;
		int tempPoints = driversList.arrayDriver[tempDriver].points;
		tempPoints= tempPoints+12;
		driversList.arrayDriver[tempDriver].points= tempPoints;
		driversList.writeDriverListToFile();
		MYPANEL.remove(scrDriverTable);
		CREATETABLE();
	}
	if(tempPosition.equals("5"))
	{
		int tempDriver = driversList.currentDriver;
		int tempPoints = driversList.arrayDriver[tempDriver].points;
		tempPoints= tempPoints+10;
		driversList.arrayDriver[tempDriver].points= tempPoints;
		driversList.writeDriverListToFile();
		MYPANEL.remove(scrDriverTable);
		CREATETABLE();
	}
	if(tempPosition.equals("6"))
	{
		int tempDriver = driversList.currentDriver;
		int tempPoints = driversList.arrayDriver[tempDriver].points;
		tempPoints= tempPoints+8;
		driversList.arrayDriver[tempDriver].points= tempPoints;
		driversList.writeDriverListToFile();
		MYPANEL.remove(scrDriverTable);
		CREATETABLE();
	}
	if(tempPosition.equals("7"))
	{
		int tempDriver = driversList.currentDriver;
		int tempPoints = driversList.arrayDriver[tempDriver].points;
		tempPoints= tempPoints+6;
		driversList.arrayDriver[tempDriver].points= tempPoints;
		driversList.writeDriverListToFile();
		MYPANEL.remove(scrDriverTable);
		CREATETABLE();
	}
	if(tempPosition.equals("8"))
	{
		int tempDriver = driversList.currentDriver;
		int tempPoints = driversList.arrayDriver[tempDriver].points;
		tempPoints= tempPoints+4;
		driversList.arrayDriver[tempDriver].points= tempPoints;
		driversList.writeDriverListToFile();
		MYPANEL.remove(scrDriverTable);
		CREATETABLE();
	}
	if(tempPosition.equals("9"))
	{
		int tempDriver = driversList.currentDriver;
		int tempPoints = driversList.arrayDriver[tempDriver].points;
		tempPoints= tempPoints+2;
		driversList.arrayDriver[tempDriver].points= tempPoints;
		driversList.writeDriverListToFile();
		MYPANEL.remove(scrDriverTable);
		CREATETABLE();
	}
	if(tempPosition.equals("10"))
	{
		int tempDriver = driversList.currentDriver;
		int tempPoints = driversList.arrayDriver[tempDriver].points;
		tempPoints= tempPoints+1;
		driversList.arrayDriver[tempDriver].points= tempPoints;
		driversList.writeDriverListToFile();
		MYPANEL.remove(scrDriverTable);
		CREATETABLE();
	}
}

public void Edit()
{
	
	String tempNewName = txtNewName.getText();
	String searchValue = comEditDriver.getSelectedItem().toString();
	String newConstructor = comEditCons.getSelectedItem().toString();
	driversList.searchForDriver(searchValue);
	int tempDriver = driversList.currentDriver;
	if (tempNewName.equals(""))
	{
		driversList.arrayDriver[tempDriver].constructor=newConstructor;
		MYPANEL.remove(scrDriverTable);
		CREATETABLE();
		UPDATE.remove(comDriver);
		createDriverCombo();
		EDIT.remove(comEditDriver);
		createEditDriverCombo();
		driversList.writeDriverListToFile();
		txtNewName.setText("");
	}
	else
	{
		driversList.arrayDriver[tempDriver].driverName=tempNewName;
		driversList.arrayDriver[tempDriver].constructor=newConstructor;
		MYPANEL.remove(scrDriverTable);
		CREATETABLE();
		UPDATE.remove(comDriver);
		createDriverCombo();
		EDIT.remove(comEditDriver);
		createEditDriverCombo();
		driversList.writeDriverListToFile();
		txtNewName.setText("");
	}
}

public void Delete()
{
		String searchValue = comEditDriver.getSelectedItem().toString();
		driversList.searchForDriver(searchValue);
		int tempRemove = driversList.currentDriver;
		UPLDriverList tempList = new UPLDriverList();
		int deleteCount=0;
		for(int i=0;i<driversList.nextDriverLocation;i++)
		{
			if(i==tempRemove)
			{
				System.out.println("Removed driver "+driversList.arrayDriver[i].driverName);
			}
			
			else
			{
				tempList.addDriverToList(driversList.arrayDriver[i]);
				System.out.println("Keeping driver: " + driversList.arrayDriver[i].driverName);
				System.out.println("Driver now in tempList: " + tempList.arrayDriver[deleteCount].driverName);
				deleteCount=deleteCount+1;
			}
		}
		tempList.showDriverList();
		driversList=tempList;
		driversList.writeDriverListToFile();
		MYPANEL.remove(scrDriverTable);
		CREATETABLE();
		UPDATE.remove(comDriver);
		createDriverCombo();
		EDIT.remove(comEditDriver);
		createEditDriverCombo();
		
		
}

public void actionPerformed(ActionEvent e)
{
//[StartActions]
	
	if(e.getSource()==btnAdd)
	{
		System.out.println("Add button pressed");
		addDriver();
		driversList.sortDriverList();
	}
	
	if(e.getSource()==btnSearch)
	{
		System.out.println("Search button pressed");
		lblSearchValue.setText("");
		String searchValue=txtSearch.getText();
		txtSearch.setText("");
		System.out.println(searchValue);
		driversList.searchForDriver(searchValue);
		boolean DriverFound=driversList.driverFound;
		if (DriverFound==true)
		{
			int tempDriver = driversList.currentDriver;
			lblSearchValue.setText(driversList.arrayDriver[tempDriver].toString());
		}
		else
		{
				lblSearchValue.setText("ERROR, DRIVER NOT FOUND");
		}
	}
	
	if(e.getSource()==btnEdit)
	{
		System.out.println("Edit button pressed");
		Edit();
	}
	
	if(e.getSource()==btnDelete)
	{
		System.out.println("Delete button pressed");
		Delete();
	}
	
	if(e.getSource()==btnUpdate)
	{
		System.out.println("Update button pressed");
		String searchValue = comDriver.getSelectedItem().toString();
		driversList.searchForDriver(searchValue);
		String tempPosition = comPosition.getSelectedItem().toString();
		updatePoints(tempPosition);
	}
	
//[EndActions]
}

 
public static void main(String[] args )
{
	UPLGUI gd = new UPLGUI();
	gd.startGUI();
}
 
}  
