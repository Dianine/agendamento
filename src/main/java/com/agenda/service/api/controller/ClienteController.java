package com.agenda.service.api.controller;

import com.agenda.service.domain.entity.Cliente;
import com.agenda.service.domain.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping
    public ResponseEntity<Cliente> salvsr(@Valid @RequestBody Cliente cliente){
        Cliente clienteSalvo = service.salvar(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
    }
    @GetMapping
    public ResponseEntity<List<Cliente>> listarTodos(){
        List<Cliente> clientes = service.listarTodos();
        return ResponseEntity.status(HttpStatus.OK).body(clientes);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
        Optional<Cliente> optCliente = service.buscarPorId(id);
        if(!optCliente.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(optCliente.get());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> alterar(@PathVariable Long id, @RequestBody Cliente cliente) {
        Cliente clienteSalvo = service.alterar(id, cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
