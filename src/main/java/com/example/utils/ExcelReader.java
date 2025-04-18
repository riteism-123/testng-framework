package com.example.utils;

import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.*;

public class ExcelReader {

	    public static void readExcel(String resourceName) throws IOException {
	        InputStream fis = ExcelReader.class.getClassLoader().getResourceAsStream(resourceName);
	        if (fis == null) {
	            throw new FileNotFoundException("Resource not found: " + resourceName);
	        }

	        Workbook workbook = WorkbookFactory.create(fis);
	        Sheet sheet = workbook.getSheetAt(0);

	        for (Row row : sheet) {
	            for (Cell cell : row) {
	                switch (cell.getCellType()) {
	                    case STRING:
	                        System.out.print(cell.getStringCellValue() + "\t");
	                        break;
	                    case NUMERIC:
	                        System.out.print(cell.getNumericCellValue() + "\t");
	                        break;
	                    default:
	                        System.out.print("Unknown\t");
	                }
	            }
	            System.out.println();
	        }

	        workbook.close();
	        fis.close();
	    }
	    
	   
	    public static Object[][] readExcelData(String resourceName) throws Exception {
	            InputStream fis = ExcelReader.class.getClassLoader().getResourceAsStream(resourceName);
	            if (fis == null) {
	                throw new IllegalArgumentException("File not found: " + resourceName);
	            }

	            Workbook workbook = WorkbookFactory.create(fis);
	            Sheet sheet = workbook.getSheet("LoginData");

	            Iterator<Row> rowIterator = sheet.iterator();
	            rowIterator.next(); // skip header row

	            List<Object[]> data = new ArrayList<>();

	            while (rowIterator.hasNext()) {
	                Row row = rowIterator.next();
	                Object[] rowData = new Object[row.getLastCellNum()];
	                for (int i = 0; i < row.getLastCellNum(); i++) {
	                    Cell cell = row.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
	                    rowData[i] = getCellValue(cell);
	                }
	                data.add(rowData);
	            }

	            workbook.close();
	            fis.close();

	            return data.toArray(new Object[0][]);
	        }
	    
	    private static Object getCellValue(Cell cell) {
	        switch (cell.getCellType()) {
	            case STRING:
	                return cell.getStringCellValue();
	            case NUMERIC:
	                return cell.getNumericCellValue();
	            case BOOLEAN:
	                return cell.getBooleanCellValue();
	            case FORMULA:
	                return cell.getCellFormula();
	            case BLANK:
	                return "";
	            default:
	                return "";
	        }
	    }

	    
	    
	    

		/*
		 * private static Object getCellValue(Cell cell) { return switch
		 * (cell.getCellType()) { case STRING -> cell.getStringCellValue(); case NUMERIC
		 * -> cell.getNumericCellValue(); case BOOLEAN -> cell.getBooleanCellValue();
		 * case FORMULA -> cell.getCellFormula(); default -> ""; }; }
		 */
	    }

	   
