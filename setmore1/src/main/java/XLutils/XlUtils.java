package XLutils;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlUtils {
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static Row r;
	public static Cell c;
	public String Xlfile, Xlsheet;
	public static CellStyle style;

	public static int row_count(String Xlfile, String Xlsheet) throws Exception {
		fis = new FileInputStream(Xlfile);
		wb = new XSSFWorkbook(fis);
		sh = wb.getSheet(Xlsheet);
		int no_of_rows = sh.getLastRowNum();
		wb.close();
		fis.close();
		return no_of_rows;
	}

	public static int cell_count(String Xlfile, String Xlsheet, int no_of_rows) throws Exception {
		fis = new FileInputStream(Xlfile);
		wb = new XSSFWorkbook(fis);
		sh = wb.getSheet(Xlsheet);
		r = sh.getRow(no_of_rows);
		int no_of_columns = r.getLastCellNum();
		wb.close();
		fis.close();
		return no_of_columns;
	}

	public static String getdata(String Xlfile, String Xlsheet, int no_of_rows, int no_of_columns) throws Exception {
		fis = new FileInputStream(Xlfile);
		wb = new XSSFWorkbook(fis);
		sh = wb.getSheet(Xlsheet);
		r = sh.getRow(no_of_rows);
		String data;
		try {
			c = r.getCell(no_of_columns);
			data = c.getStringCellValue();
		} catch (Exception e) {
			data = "";
		}

		wb.close();
		fis.close();
		return data;
	}

	public static void writedata(String Xlfile, String Xlsheet, int no_of_rows, int no_of_columns, String data)
			throws Exception {

		fis = new FileInputStream(Xlfile);
		wb = new XSSFWorkbook(fis);
		sh = wb.getSheet(Xlsheet);
		sh.getRow(no_of_rows).createCell(no_of_columns).setCellValue(data);
		fos = new FileOutputStream(Xlfile);
		wb.write(fos);
		wb.close();
		fis.close();
		fos.close();
	}

	public static void fillGreenColor(String Xlfile, String Xlsheet, int no_of_rows, int no_of_columns)
			throws Exception {
		fis = new FileInputStream(Xlfile);
		wb = new XSSFWorkbook(fis);
		sh = wb.getSheet(Xlsheet);
		r = sh.getRow(no_of_rows);
		c = r.getCell(no_of_columns);
		style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		c.setCellStyle(style);
		fos = new FileOutputStream(Xlfile);
		wb.write(fos);
		wb.close();
		fis.close();
		fos.close();
	}

	public static void fillRedColor(String Xlfile, String Xlsheet, int no_of_rows, int no_of_columns) throws Exception {
		fis = new FileInputStream(Xlfile);
		wb = new XSSFWorkbook(fis);
		sh = wb.getSheet(Xlsheet);
		r = sh.getRow(no_of_rows);
		c = r.getCell(no_of_columns);
		style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		c.setCellStyle(style);
		fos = new FileOutputStream(Xlfile);
		wb.write(fos);
		wb.close();
		fis.close();
		fos.close();
	}

}
