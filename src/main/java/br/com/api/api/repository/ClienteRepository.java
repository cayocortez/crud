package br.com.api.api.repository;

import br.com.api.api.model.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository //lógica de acesso a dados
public interface ClienteRepository extends MongoRepository<Cliente, String> {

}
