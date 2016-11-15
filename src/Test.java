import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by huan.gao on 2016/9/8.
 */
public class Test {
    public static  void main(String args[]){
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "application.xml");
        SimpleDateFormat format = (SimpleDateFormat) context
                .getBean("defaultDateFormat");
        System.out.println(format.format(new Date()));
    }
}
