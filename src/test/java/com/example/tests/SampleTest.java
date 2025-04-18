package com.example.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SampleTest {

    @Test
    public void firstTest() {
        System.out.println("Running first TestNG test!");
    }
    
    
    @DataProvider(name = "testData1")
    public static Object[][] getData(){
    	
    	//Object[][] data = readExcel("fileName", "sheetName");
		//return data
    	
    
       Object[][] str = new Object[2][2];
       str[0][0] = "Name";
       str[0][1] = "id";
       str[1][0] = "Ritsh";
        str[1][1] ="123";
        
        
        return str;
        
    }
    
    
    @Test(dataProvider = "testData1")
    public static void Test1(String name, String id){
        
      System.out.println("Name"+name+ ", ID"+id );
        
        
    }
}
