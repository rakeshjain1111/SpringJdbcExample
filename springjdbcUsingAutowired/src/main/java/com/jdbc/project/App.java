package com.jdbc.project;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.jdbc.dao.StudentDao;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//    	ApplicationContext ctx =new ClassPathXmlApplicationContext("com/jdbc/project/config.xml");
        ApplicationContext ctx =new AnnotationConfigApplicationContext(JdbcConfig.class);
     
        
//        JdbcTemplate template =ctx.getBean("jdbcTemplate",JdbcTemplate.class);
//        String query = "insert into student(id,name,city) value (?,?,?)";
//        template.update(query,143,"rrrr","pune");
//        
        
        
        StudentDao sdao = ctx.getBean("studentDao", StudentDao.class);
        
        
        //Addition
//        Student s =new Student();
//        s.setId(101);
//        s.setName("Rajesh");
//        s.setCity("Bhopal");
//        
//        int result = sdao.insert(s);
//        
//        System.out.println(result+"record inserted");
        
        
        //Updation
//        Student s =new Student();
//        
//        s.setId(101);
//        s.setName("Rajesh");
//        s.setCity("Indore");
//        
//        int result = sdao.change(s);
//        
//        System.out.println("record updated");
        
         //Deletion
//        int result =sdao.delete(101);
//        System.out.println("record deleted");
        
         //Get Single Record
//        Student s = sdao.getStudent(222);
//        System.out.println(s);
        
        
        //GetAllStudents
        List<Student> slist = sdao.getAllStudent();
        
        for(Student s: slist) {
        	System.out.println(s);
        }
          
    }
}
