package com.accenture.pessoa.service;

import com.accenture.pessoa.model.Pessoa;
import com.accenture.pessoa.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;


    public List<Pessoa> getAll() {
        return pessoaRepository.findAll();
    }

    public ResponseEntity<Object> getById(long id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        if (pessoa.isPresent())
            return new ResponseEntity<>(pessoa.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public Pessoa savePessoa(Pessoa pessoa) {
        if (pessoa == null) {
            throw new NullPointerException("Não é possivel salvar, pessoa está nulo!");
        }
        return pessoaRepository.save(pessoa);
    }

    public ResponseEntity<Object> update(Pessoa newPessoa, Long id) {
        Optional<Pessoa> oldPessoa = pessoaRepository.findById(id);
        if (oldPessoa.isPresent()) {
            Pessoa pessoa = oldPessoa.get();
            pessoa.setNome(newPessoa.getNome());
            pessoaRepository.save(pessoa);
            return new ResponseEntity<>(pessoa, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }


    public ResponseEntity<Object> delete(long id) {
        Optional<Pessoa> pessoaSaved = pessoaRepository.findById(id);
        if (pessoaSaved.isPresent()) {
            pessoaRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
