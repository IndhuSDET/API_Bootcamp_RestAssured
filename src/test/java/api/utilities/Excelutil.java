package api.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;
import api.endpoints.Routes;

public class Excelutil {

    public static JSONObject excelreader(int rowIndex) 
    {
        JSONObject userBody = new JSONObject(); 
        JSONObject userAddress = new JSONObject(); 
        DataFormatter formatter = new DataFormatter();

        try {
        	FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + Routes.exceldatapath);
     
             XSSFWorkbook workbook = new XSSFWorkbook(fis);

            XSSFSheet sheet = workbook.getSheet("user_contract");
            if (sheet == null) {
                System.err.println("Sheet 'user_contract' not found.");
                return userBody;
            }

            XSSFRow row = sheet.getRow(rowIndex);
            if (row == null) {
                System.out.println("Row " + rowIndex + " is empty.");
                return userBody;
            }

            for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
                String cellValue = formatter.formatCellValue(row.getCell(j));

                switch (j) {
                    case 0: userBody.put("user_first_name", cellValue); break;
                    case 1: userBody.put("user_last_name", cellValue); break;
                    case 2: userBody.put("user_contact_number", cellValue); break;
                    case 3: userBody.put("user_email_id", cellValue); break;
                    case 4: userAddress.put("plotNumber", cellValue); break;
                    case 5: userAddress.put("street", cellValue); break;
                    case 6: userAddress.put("state", cellValue); break;
                    case 7: userAddress.put("country", cellValue); break;
                    case 8: userAddress.put("zipCode", cellValue); break;
                    default: System.out.println("Unexpected column index: " + j);
                }
            }

            userBody.put("userAddress", userAddress); 
        } catch (IOException e) {
            System.err.println("Error reading the Excel file: " + e.getMessage());
            e.printStackTrace();
        }
        return userBody;
    }
}