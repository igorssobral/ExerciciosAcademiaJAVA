package acc.br.contatos.repository;

import acc.br.contatos.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;


public interface Contatos extends JpaRepository<Contato, Long> {

}
