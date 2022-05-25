package br.com.api.api.controller;

import br.com.api.api.model.Cliente;
import br.com.api.api.repository.ClienteRepository;
import br.com.api.api.service.ClienteService;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping(value = "/create")
    public Cliente create(@RequestBody Cliente clienteRequest) { //interpretar como JSON
        Cliente cliente = clienteService.create(clienteRequest.getCpf(), clienteRequest.getNome());
        return cliente;
    }

    @GetMapping // falta fazer funcionar a parte da lista
    public List<Cliente> getClientList() {
        List<Cliente> clienteList = clienteService.getAll();
        return clienteList;

        // quando não haver conteúdo, retornar 204
    }

    @GetMapping(value = "/{id}")
    public Cliente getById(@PathVariable("id") String id) {
        return clienteService.getById(id);
        // quando não haver conteúdo, retornar 204
    }

    @PutMapping(value = "/update")
    public ResponseEntity <Cliente> clienteUpdate(@RequestBody Cliente cliente) {
        Cliente clienteUpdate = clienteService.updateById(cliente);
        return new ResponseEntity("Student updated successfully", HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteClienteById(@PathVariable String id){
        clienteService.deleteById(id);
        return new ResponseEntity("Student deleted successfully", HttpStatus.OK);
    }
}
