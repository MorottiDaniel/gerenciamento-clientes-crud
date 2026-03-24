package com.morotti.clientes.controller;

import com.morotti.clientes.entity.ClientesEntity;
import com.morotti.clientes.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientesController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClientesEntity> criarCliente(@RequestBody ClientesEntity entity){
        ClientesEntity cliente = clienteService.criarCliente(entity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(cliente);
    }

    @GetMapping
    public ResponseEntity<List<ClientesEntity>> findAll(){
        List<ClientesEntity> entities = clienteService.findAll();
        return ResponseEntity.ok().body(entities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientesEntity> buscarPorId(@PathVariable Long id){
        try {
            ClientesEntity entity = clienteService.buscarPorId(id);
            return ResponseEntity.ok().body(entity);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        clienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
