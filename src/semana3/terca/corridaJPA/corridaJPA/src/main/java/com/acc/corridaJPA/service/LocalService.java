package com.acc.corridaJPA.service;

import java.util.ArrayList;
import java.util.List;

import com.acc.corridaJPA.model.Local;
import com.acc.corridaJPA.repository.LocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



//Define a lógica de negócio
@Service
public class LocalService
{
    @Autowired
    LocalRepository localRepository;

    //Pega todos os registros da tabela students
    public List<Local> getAllLocal()
    {
        List<Local> locais = new ArrayList<Local>();
        localRepository.findAll().forEach(local -> locais.add(local));
        return locais;
    }
    //Recupera um registro especifico
    public Local getLocalById(long id)
    {
        return localRepository.findById(id).get();
    }
    public void saveOrUpdate(Local local)
    {
        localRepository.save(local);
    }
    //Deleta um registro especifico
    public void delete(long id)
    {
        localRepository.deleteById(id);
    }
}
