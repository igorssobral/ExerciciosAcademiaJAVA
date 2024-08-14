package acc.br.estudantes.service;

import acc.br.estudantes.model.Student;
import acc.br.estudantes.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAllStudent() {
        List<Student> students = new ArrayList<Student>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }

    public ModelAndView createStudentPage() {

        ModelAndView modelAndView = new ModelAndView("criarEstudante");

        return modelAndView;
    }


    public ModelAndView listAllStudents() {
        List<Student> lista = (List<Student>) studentRepository.findAll();

        ModelAndView modelAndView = new ModelAndView("estudantes");
        modelAndView.addObject("estudantes", lista);

        return modelAndView;
    }

    public Student getStudentById(int id) {
        return studentRepository.findById(id).get();
    }

    public void saveOrUpdate(Student student) {
        studentRepository.save(student);
    }

    public void delete(int id) {
        studentRepository.deleteById(id);
    }
}