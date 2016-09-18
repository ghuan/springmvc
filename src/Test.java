import com.fanfan.system.xsd.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by huan.gao on 2016/9/8.
 */
public class Test {
    public static  void main(String args[]){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");
        Person p = (Person)ctx.getBean("3");
        System.out.println(p.getId());
        System.out.println(p.getName());
        System.out.println(p.getAge());
    }
}
