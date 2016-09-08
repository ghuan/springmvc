import java.io.File;
import java.io.FileInputStream;

/**
 * Created by huan.gao on 2016/9/8.
 */
public class Test {
    public static  void main(String args[]){

        String excelFilePath = "D://江干区域卫生项目需求跟踪.xlsx";
        try {
            FileInputStream input = new FileInputStream(new File(excelFilePath));
            System.out.print(0);
        }catch (Exception e){

        }


    }
}
