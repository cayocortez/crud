package br.com.api.api.service;

import br.com.api.api.model.Cliente;
import br.com.api.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente create(String cpf, String nome) {

        Cliente cliente = new Cliente();
        cliente.setCpf(cpf);
        cliente.setNome(nome);
        Cliente save = clienteRepository.save(cliente);
        return save;
    }

    public ResponseEntity<List<Cliente>> getAll() {
        Optional<List<Cliente>> clientes = Optional.of(clienteRepository.findAll());
        if (clientes.isPresent()) {
            return ResponseEntity.ok(clientes.get());
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Cliente> getById(String id) {
        Optional<Cliente> cliente = clienteRepository.findById(id); // findById retorna um objeto <Optional>, podendo ou não conter um objeto
        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        }
        return ResponseEntity.notFound().build(); // retornando 404 not found quando o id é inválido
    }

    public ResponseEntity<?> deleteById (String id) { //retornando 404 not found quando o id é inválido
        Optional<Cliente> optional = clienteRepository.findById(id);
        if (optional.isPresent()) {
            clienteRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    public Cliente updateById(Cliente cliente) {
        Cliente updatedCliente = clienteRepository.save(cliente);
        return updatedCliente;
    }
}
