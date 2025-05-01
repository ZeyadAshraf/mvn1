//
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.File;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//
//public class ExcelReader {
//    static FileInputStream fis ;
//    public FileInputStream fileInputStream(){
//        String filePath =System.getProperty("user,dir")+"/src/test/java/testdata.xlsx";
//        File srcfile = new File(filePath);
//        try {
//            fis=new FileInputStream(srcfile);
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        return fis;
//
//    }
//    public Object[][] getData() throws IOException {
//    fis=fileInputStream();
//    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//        XSSFSheet sheet = workbook.getSheetAt(0);
//                int numRows = sheet.getPhysicalNumberOfRows();
//        int numCols = sheet.getRow(0).getPhysicalNumberOfCells();
//        Object[][] data = new Object[numRows][numCols];
//        for (int i = 0; i < numRows; i++) {
//            XSSFRow row = sheet.getRow(i);
//            for (int j = 0; j < numCols; j++) {
//                data[i][j] = row.getCell(j).getStringCellValue();
//            }
//        }
//        workbook.close();
//        return data;
//    }
//}
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {

    static FileInputStream fis;

    public FileInputStream getFileInputStream(){
        String filePath = System.getProperty("user.dir")+"/src/main/java/org/example/testData/testData.xlsx";
        File srcFile = new File(filePath);
        try {
            fis = new FileInputStream(srcFile);
        } catch (FileNotFoundException e) {
            System.out.println("ERROR occurred"+e.getMessage());;
        }
        return fis;
    }

    public Object [][]  getExcelData() throws IOException {
        fis = getFileInputStream();
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);
        int numberOfRows = (sheet.getLastRowNum()+1);
        int numberOfColumns = 4;

        String[][] arrayExcelData = new String[numberOfRows][numberOfColumns];
        for(int i =0;i<numberOfRows;i++){
            for (int j=0; j<numberOfColumns;j++){
                XSSFRow row = sheet.getRow(i);
                arrayExcelData[i][j] = row.getCell(j).toString();
            }
        }
        wb.close();
        return arrayExcelData;
    }

}
