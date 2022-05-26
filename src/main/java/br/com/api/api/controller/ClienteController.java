package br.com.api.api.controller;

import br.com.api.api.model.Cliente;
import br.com.api.api.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping(value = "/create")
    public Cliente create(@RequestBody Cliente clienteRequest) { //interpretar como JSON
        Cliente cliente = clienteService.create(clienteRequest.getCpf(), clienteRequest.getNome());
        return cliente;
    }

    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteService.getAll();
    }
        // quando não haver conteúdo, retornar 204

    @GetMapping(value = "/{id}")
    public Cliente getById(@PathVariable("id") String id) {
        return clienteService.getById(id);
        // quando não haver conteúdo, retornar 204
    }

    @PutMapping(value = "/update")
    public ResponseEntity <Cliente> clienteUpdate(@RequestBody Cliente cliente) {
        Cliente clienteUpdate = clienteService.updateById(cliente);
        return new ResponseEntity("Client updated successfully", HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteClienteById(@PathVariable String id){
        clienteService.deleteById(id);
        return new ResponseEntity("Client deleted successfully", HttpStatus.OK);
    }
}
