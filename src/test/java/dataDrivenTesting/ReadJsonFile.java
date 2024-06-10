package dataDrivenTesting;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;

import org.apache.commons.io.FileUtils;
import net.minidev.json.JSONArray;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import utility.Utility;


public class ReadJsonFile {
	
	@DataProvider(name="testdatajson")
	public Object[] getTestDataJson() {
		Object[] obj = null;
		
		//read json file
		try {
			String jsonTestData = FileUtils.readFileToString(new File(Utility.jsonFile), "UTF-8");
			System.out.println(jsonTestData);
			
			//convert to jsonArray
			JSONArray jsonArray = JsonPath.read(jsonTestData,"$");
			System.out.println(jsonArray);
			
			//now put the value from json array to object array
			
			obj = new Object[jsonArray.size()];
			
			for(int i = 0 ; i < jsonArray.size();i++) {
				obj[i] = jsonArray.get(i);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return obj;
		
		
	}
	
	
	
	@Test(dataProvider="testdatajson")
	public void readjsonFile(LinkedHashMap<String,String> testData) {
		System.out.println(testData.get("firstname"));
		System.out.println(testData.get("lastname"));
	}
}
