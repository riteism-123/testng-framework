package com.example.tests;

import com.example.utils.ExcelReader;
import org.testng.annotations.Test;

public class ExcelTest {

    @Test
    public void testReadExcel() throws Exception {
        ExcelReader.readExcel("sample.xlsx");
    }
}
