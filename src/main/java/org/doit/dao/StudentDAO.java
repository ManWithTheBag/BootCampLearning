package org.doit.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.doit.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class StudentDAO {

    private EntityManager entityManager;
    @Autowired
    public StudentDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void saveStudent(Student student){
        entityManager.persist(student);
    }

    public Student getStudentById(int id){
        return entityManager.find(Student.class, id);
    }

    public List<Student> getStudentList(){
        return entityManager.createQuery("from Student", Student.class).getResultList();
    }

    public Student getStudentByFirstName(String firstname){

        TypedQuery<Student> queryStudent = entityManager.createQuery("from Student where firstName =: firstNameData", Student.class);
        queryStudent.setParameter("firstNameData", firstname);

        return queryStudent.getResultList().stream().findAny().orElse(null);
    }

    public void updateStudent(Student student){
        entityManager.merge(student);
    }

    public void removeStudentById(int searchId){
        Student currentStudent = entityManager.find(Student.class, searchId);
        entityManager.remove(currentStudent);
    }
}
