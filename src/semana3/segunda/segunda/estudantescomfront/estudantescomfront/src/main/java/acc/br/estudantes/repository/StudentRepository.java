package acc.br.estudantes.repository;


import acc.br.estudantes.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {
}
