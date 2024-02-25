package API.utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
	
	public static FileInputStream inputStream;
	public static XSSFWorkbook workBook;
	public static XSSFSheet excelSheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	//Read the excel file
	public static String getCellValue(String fileName, String sheetName, int rowNo, int cellNO) {
		
		try {
			inputStream = new FileInputStream(fileName);
			workBook = new XSSFWorkbook(inputStream);
			excelSheet =  workBook.getSheet(sheetName);
			cell = workBook.getSheet(sheetName).getRow(rowNo).getCell(cellNO);
			
			workBook.close();
			
			return cell.getStringCellValue();
		}
		catch(Exception e) {
			return "";
		}
	}
	
	
	//Get total not of Row in the excell shet
	public static int getRowCount(String fileName, String sheetName) {
		
		try {
			inputStream = new FileInputStream(fileName);
			
			//create XSSFWorkBook class object  for excel file manipulation
			workBook = new XSSFWorkbook(inputStream);
			excelSheet = workBook.getSheet(sheetName);
			
			//get total no of row in the sheet
			int ttlRows = excelSheet.getLastRowNum()+1;
			
			workBook.close();
			return ttlRows;
			
		}
		catch(Exception e) {
			return 0;
		}
	}
	
	
	//Get total not of cell int the Sheet
	
	public static int getColCount(String fileName, String sheetName) {
		try {
			FileInputStream inputStream = new FileInputStream(fileName);
			//Creat XSSFWrokBooked  class object  for excel file manipulation
			XSSFWorkbook workBook = new XSSFWorkbook(inputStream);
			XSSFSheet excelSheet = workBook.getSheet(sheetName);
			
			//get total not of columns
			int ttlCells = excelSheet.getRow(0).getLastCellNum();
			
			workBook.close();
			
			return ttlCells;
		}
		catch(Exception e) {
			return 0;
		}
	}

}
