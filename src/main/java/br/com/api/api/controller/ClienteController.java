package br.com.api.api.controller;

import br.com.api.api.model.Cliente;
import br.com.api.api.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping(value = "/create")
    public Cliente create(@RequestBody @Valid Cliente clienteRequest) { //interpretar como JSON
        Cliente cliente = clienteService.create(clienteRequest.getCpf(), clienteRequest.getNome());
        return cliente;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClientes() {
        return clienteService.getAll();
    }
        // quando não haver conteúdo, retornar 404? atualmente está retornando vazio []

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable("id") String id) {
        return clienteService.getById(id);
        // quando não haver conteúdo, retornar 404 -> está ok
    }

    @PutMapping(value = "/update")
    public ResponseEntity <Cliente> clienteUpdate(@RequestBody Cliente cliente) {
        Cliente clienteUpdate = clienteService.updateById(cliente);
        return new ResponseEntity("Client updated successfully", HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteClienteById(@PathVariable String id){
        return clienteService.deleteById(id); // erro 404 funcionando
        //return new ResponseEntity("Client deleted successfully", HttpStatus.OK); // mensagem está aparecendo para qualquer id, precisa devolver 404 para id inexistente
    }
}
