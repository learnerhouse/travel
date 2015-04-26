/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tool.data2excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.hslf.model.Sheet;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.examples.CreateCell;

import java.sql.Time;

/**
 *
 * @author lv
 */
public class WriteSheet {

    private static HSSFWorkbook book;
    private static HSSFSheet sheet;
    private static HSSFRow row;
    private static HSSFCell cell;
    private static POIFSFileSystem fs;
    private static FileInputStream in;
    private static OutputStream out;

    public static void write(String filePath,Date date, String name, String content) {
        File file = new File(filePath);
        try {
            in = new FileInputStream(file);
	            fs = new POIFSFileSystem(in);
	            book = new HSSFWorkbook(fs);
            in.close();
            out = new FileOutputStream(file, true);
            sheet = book.getSheetAt(0);
            if (sheet.getLastRowNum()<50000) 
            {
            	 row = sheet.createRow(sheet.getLastRowNum() + 1);
                 System.out.println(row);
                 HSSFCell cell_1 = row.createCell(0);
                 HSSFCell cell_2 = row.createCell(1);
                 HSSFCell cell_3 = row.createCell(2);
                 java.text.DateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                 String s=format.format(date);
                 cell_1.setCellValue(s);
                 cell_2.setCellValue(name);
                 cell_3.setCellValue(content);
                 out.flush();
                 	book.write(out);
                 out.close();
			} 
        } catch (IOException ex) {
            Logger.getLogger(WriteSheet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void write(String filePath ,int sheetNum,ArrayList list) {
    	
        File file = new File(filePath);
        try {
            in = new FileInputStream(file);
	            fs = new POIFSFileSystem(in);
	            book = new HSSFWorkbook(fs);
            in.close();
            out = new FileOutputStream(file);
            sheet = book.getSheetAt(sheetNum); 
            if (sheet.getLastRowNum()<50000) 
            {
            	 row = sheet.createRow(sheet.getLastRowNum() + 1);
                 HSSFCell [] cells  = new HSSFCell [list.size()];
                 for (int i = 0; i < cells.length; i++) 
                 {
                	 cells [i] = row.createCell(i);
                 }
                 java.text.DateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                 for (int i = 0; i < cells.length; i++) 
                 {
                	 cells[i].setCellValue(list.get(i).toString());
				 }
                 out.flush();
                 	book.write(out);
                 out.close();
			}    
        } catch (IOException ex) {
            Logger.getLogger(WriteSheet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void resetLineNum(int lineNum)
    {
    	row.setRowNum(lineNum);	
    }
    
    public static int getLineNum()
    {	
    	return sheet.getLastRowNum();
    }
    
//    public static void main(String[] args) {
//		ArrayList  aa  = new  ArrayList();
//		aa.add("123");
//		aa.add("345");
//		aa.add("567");
//		WriteSheet testSheet = new WriteSheet();
//		testSheet.write("data//command - ¸±±¾.xls", aa);	
//	} 
}