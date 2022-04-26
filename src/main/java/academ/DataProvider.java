package academ;

// import org.testng.annotations.DataProvider;

public class DataProvider {

	@org.testng.annotations.DataProvider(name = "InputData")
	//@DataProvider(name = "InputData")
	public Object[][] getDataforEditField(){
		
		//Row stands for how many different data types test should run
		//column stands for how many values per each test
		//[1]--> no. of rows  [2]--> no. of coloumns
		
		Object[][] obj = new Object[1][2];
		//0th Row
		obj[0][0]="nonrestricteduser";
		obj[0][1]="12345";
		//obj[0][2]="First Text";
		
		//1st Row
		/*obj[1][0]="restricteduser";
		obj[1][1]="12345";
		obj[1][2]="Second Text";
		*/
		return obj;
	}
	
}
