package dataDrivenTesting;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import utility.Utility;

public class ReadCSVFile {
	
	@DataProvider(name="testdatacsv")
	public Object[][] getTestDataCSV() throws CsvValidationException, IOException{
		
		Object[][] obj= null;
		//map to store  each row test data
		Map<String,String> map = null;
		//list of map to store all the rows
		List<Map<String,String>> testDataList = null;
		
		try {
			//now read the csvFile with opencsv library
			CSVReader csvReader = new CSVReader(new FileReader(Utility.csvFile));
			
			String[] line = null;
			//create a list to store map with key and value
			testDataList= new ArrayList<Map<String,String>>();
			int count = 0; 
			
			//read each line from file one by one
			while((line = csvReader.readNext()) != null) {
				// we do not want first row from csv file as it contains key's name
				if(count == 0) {
					count++;
					continue;
				}
				
				map = new TreeMap<String,String>(String.CASE_INSENSITIVE_ORDER);
				map.put("firstname", line[0]);
				map.put("lastname", line[1]);
				map.put("age", line[2]);
				testDataList.add(map);	
			}
			//now put all the array list data into object[][]
			obj = new Object[testDataList.size()][1];
			for(int i = 0 ; i < testDataList.size();i++) {
				obj[i][0] = testDataList.get(i);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
		return obj;
	}
	
	
	
	@Test(dataProvider="testdatacsv")
	public void readCsvFile(TreeMap<String,String> testData) {
		System.out.println(testData.get("firstname")+" "+testData.get("lastname")+" "+testData.get("age"));

	}
	

}
