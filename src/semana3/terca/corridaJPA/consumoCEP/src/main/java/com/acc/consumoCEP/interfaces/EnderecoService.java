package com.acc.consumoCEP.interfaces;

import com.acc.consumoCEP.model.Endereco;
import com.acc.consumoCEP.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository enderecoRepository;

    public ModelAndView listAllEnderecos() {
        List<Endereco> lista = enderecoRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("enderecos");
        modelAndView.addObject("enderecos", lista);

        return modelAndView;
    }


    public Endereco save(Endereco endereco){
        if(endereco != null){
            if(endereco.getComplemento().equals("") ){
                endereco.setComplemento("S/C");
            }
          return  enderecoRepository.save(endereco);

        }else throw new NullPointerException("Objeto Nulo, Não é possivel salvar!");
    }
}
