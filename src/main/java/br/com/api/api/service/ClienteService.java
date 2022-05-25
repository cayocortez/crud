package br.com.api.api.service;

import br.com.api.api.model.Cliente;
import br.com.api.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<Cliente> getAll() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes;
    }

    public Cliente getById(String id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        // TODO adicionar validação -> não esquecer
        return cliente.get();
    }

    public void deleteById (String id) {
        clienteRepository.deleteById(id);
    }

    public Cliente updateById(Cliente cliente) {
        Cliente updatedCliente = clienteRepository.save(cliente);
        return updatedCliente;
    }
}
