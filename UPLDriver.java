public class UPLDriver
{
	int driverID;
	String driverName;
	String constructor;
	int points=0;
	
	public String toString()
	{
		String driverData = driverID+","+driverName+","+constructor+","+points;
		return driverData;
	}
}