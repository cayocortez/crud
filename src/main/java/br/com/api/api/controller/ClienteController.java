package br.com.api.api.controller;

import br.com.api.api.model.Cliente;
import br.com.api.api.service.ClienteService;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<Cliente> getClientList() {
        List<Cliente> clienteList = clienteService.getAll();
        return clienteList;
    }

    @GetMapping(value = "/{id}")
    public Cliente getById(@PathVariable("id") String id) {
        return clienteService.getById(id);
    }


}
