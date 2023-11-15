package org.example;
public class App 
{
    public static void main( String[] args ){
        StudentRepository studentRepository = new StudentRepository();
        Student student = new Student();
        student.setName("Asyl");
        student.setAge(17);
        studentRepository.save(student);
        System.out.println(studentRepository.findById(1L));
        System.out.println(studentRepository.findById(2L));
        System.out.println(studentRepository.findAll());
        studentRepository.update(3L,new Student("Beka",18));
         studentRepository.deleteById(2L);
         studentRepository.deleteAll();
    }
}
