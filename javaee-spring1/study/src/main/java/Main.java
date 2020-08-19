import edu.School;
import edu.Student;
import edu.Student1;
import edu.Student2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        //开启一个Spring容器 ApplicationContext 应用上下文(可以配置和管理Bean对象,还有其他工作等)
        //ClassPathXmlApplicationContext 是根据classpath路径, 指定一个xml配置文件
        //根据配置文件完成配置工作(如Bean的实例化)
        ApplicationContext context = new
                ClassPathXmlApplicationContext("application.xml");
        //通过bean的名字找到bean对象, bean的名字就是xml文件中bean的id
        String str1 = (String) context.getBean("happy");
        //String str2 = (String) context.getBean("java.lang.String#0");
        System.out.println(str1);
       // System.out.println(str2);

        //通过类型找bean对象, 如果该类型在xml有多个bean对象, 就会报错
        String str2 = (String)context.getBean(String.class);
        System.out.println(str2);

        Student student = (Student) context.getBean("student");
        System.out.println(student);

        Student1 student1 = (Student1)context.getBean("student1");
        System.out.println(student1);

        Student2 student2 = (Student2) context.getBean("s1");
        System.out.println(student2);

        School students = (School) context.getBean("school");
        System.out.println(students);
    }
}
