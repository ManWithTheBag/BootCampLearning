package org.doit.bootcamplearning;

import org.doit.dao.StudentDAO;
import org.doit.model.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication(scanBasePackages = {"org.doit"})
public class BootCampLearningApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootCampLearningApplication.class, args);
    }

    @Bean
    public CommandLineRunner printStudentById(StudentDAO studentDAO){
        return  runner -> {removeStudentById(studentDAO, 1);};
    }

//     Create data to database
//    @Autowired
//    private void createAllStudents(StudentDAO studentDAO){
//        studentDAO.saveStudent(new Student("Dgime", "Ferst", "gimefirst@gmail.com"));
//        studentDAO.saveStudent(new Student("Kate", "Second", "katesecond@gmail.com"));
//        studentDAO.saveStudent(new Student("Jeff", "Third", "jeffthird@gmail.com"));
//        studentDAO.saveStudent(new Student("Inna", "Fourth", "innafourth@gmail.com"));
//    }

    //     Read student by ID
    public void readStudent(StudentDAO studentDAO){
        System.out.println(studentDAO.getStudentById(2).toString());
    }

    //     Read Student list
    public void readStudentsList(StudentDAO studentDAO){
        List<Student> studentList =  studentDAO.getStudentList();

        for (int i = 0; i < studentList.size(); i++){
            System.out.println(studentList.get(i).toString());
        }
    }

    //     Read Student by first name
    public void readStudentByFirstName(StudentDAO studentDAO){
        System.out.println(studentDAO.getStudentByFirstName("Jeff").toString());
    }

    // Update first name in current student which found by id
    public void updateStudentByName(StudentDAO studentDAO, int searchId, String newFirstName){
        Student currentStudent = studentDAO.getStudentById(searchId);
        currentStudent.setFirstName(newFirstName);
        studentDAO.updateStudent(currentStudent);

        System.out.println(currentStudent.toString());
    }

    public void removeStudentById(StudentDAO studentDAO, int searchId){
        studentDAO.removeStudentById(searchId);
    }
}
