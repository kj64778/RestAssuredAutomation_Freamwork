package API.utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name ="AllData")
	public String [][] AllDataProvier(){
		
		//patcing the excel file properties
		
		String fname = System.getProperty("user.dir")+"//TestData//TestData.xlsx";
		
		int ttRowcnt = ReadExcelFile.getRowCount(fname, "TestData");
		int ttCellcnt = ReadExcelFile.getColCount(fname, "TestData");
		
		String [][] userData = new String[ttRowcnt-1][ttCellcnt];
		
		for(int rowNo =1; rowNo<ttRowcnt; rowNo++) {
			for(int cellNo =0; cellNo<ttCellcnt; cellNo++) {
				userData [rowNo-1][cellNo] = ReadExcelFile.getCellValue(fname, "TestData", rowNo, cellNo);
			}
			
		}
		return userData;
		
	}
	
	
	@DataProvider(name="UserNameData")
	public String [] UserNameDataProvider(){
		
		//patcing the excel file properties
		
		String fname = System.getProperty("user.dir")+"//TestData//TestData.xlsx";
		
		int ttRowcnt = ReadExcelFile.getRowCount(fname, "TestData");
//		int ttCellcnt = DataProviders.getColCount(fname, "TestData");
		
		String [] userNameData = new String[ttRowcnt-1];
		
		for(int rowNo =1; rowNo<ttRowcnt; rowNo++) {
			userNameData[rowNo-1] = ReadExcelFile.getCellValue(fname, "TestData", rowNo, 1);
			
		}
		return userNameData;
		
	}
	
	

}
