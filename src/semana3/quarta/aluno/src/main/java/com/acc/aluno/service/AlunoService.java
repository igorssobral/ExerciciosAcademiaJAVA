package com.acc.aluno.service;

import java.util.ArrayList;
import java.util.List;

import com.acc.aluno.model.Aluno;
import com.acc.aluno.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//defining the business logic
@Service
public class AlunoService {
    @Autowired
    AlunoRepository alunoRepository;
    //getting all student records
    public List<Aluno> getAllAluno()
    {
        List<Aluno> alunos = new ArrayList<Aluno>();
        alunoRepository.findAll().forEach(aluno -> alunos.add(aluno));
        return alunos;
    }
    //getting a specific record
    public Aluno getAlunoById(int id)
    {
        return alunoRepository.findById(id).get();
    }
    public void saveOrUpdate(Aluno aluno)
    {
        alunoRepository.save(aluno);
    }
    //deleting a specific record
    public void delete(int id)
    {
        alunoRepository.deleteById(id);
    }
}
