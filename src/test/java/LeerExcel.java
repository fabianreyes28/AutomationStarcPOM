
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LeerExcel {
    //leer todo el archivo excel fila por fila y cada una de las celdas de la fila
    public void leerExcel(String filepath, String sheetName) throws IOException {

        //creamos un objeto de tipo file
        File file=new File(filepath);
        FileInputStream inputStream=new FileInputStream(file);

        //creamos el objeto donde vamos a guardar el libro de excel
        XSSFWorkbook newWorkbook=new XSSFWorkbook(inputStream);

        //creamos el objeto donde se guarda la hoja con la que estamos trabajando,
        // sheetName es el nombre de la hoja que se lo pasamos como parametro
        XSSFSheet newSheet= newWorkbook.getSheet(sheetName);

        //filas de datos que tiene el excel
        int rowCount = newSheet.getLastRowNum() - newSheet.getFirstRowNum();

        //for para correr las filas, entonces mientra i sea menor que la cantidad de filas
        for (int i=0;i<=rowCount;i++){
            //creamos el objeto fila: va a ir leyendo fila por fila de la hoja
            XSSFRow row= newSheet.getRow(i);

            //el siguiente for itera sobre todas las celdas de esa fila
            //getLastCellNum() devuelve la cantidad de celdas que tiene la fila,
            // suponiendo que todas las filas tengan la misma cantidad de celdas

            for (int j=0; j< row.getLastCellNum(); j++ ){
                System.out.println(row.getCell(j).getStringCellValue()+"||");


            }

        }



    }


    //Este metodo permite leer una celda especifica
    public String getCellValue(String filepath, String sheetName, int rowNumber, int cellNumber ) throws IOException{
        //creamos un objeto de tipo file
        File file=new File(filepath);
        FileInputStream inputStream=new FileInputStream(file);

        //creamos el objeto donde vamos a guardar el libro de excel
        XSSFWorkbook newWorkbook=new XSSFWorkbook(inputStream);

        //creamos el objeto donde se guarda la hoja con la que estamos trabajando,
        // sheetName es el nombre de la hoja que se lo pasamos como parametro
        XSSFSheet newSheet= newWorkbook.getSheet(sheetName);

        XSSFRow row= newSheet.getRow(rowNumber);
        XSSFCell cell= row.getCell(cellNumber);
        return cell.getStringCellValue();

    }

    //------------------------------------//

}

