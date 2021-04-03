package com.algaworks.osworks.api.controller;

import com.algaworks.osworks.api.dto.ClienteDto;
import com.algaworks.osworks.api.service.ClienteServiceDelete;
import com.algaworks.osworks.api.service.ClienteServiceGet;
import com.algaworks.osworks.api.service.ClienteServicePost;
import com.algaworks.osworks.api.service.ClienteServicePut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/clientes")
public class ClienteController {

    @Autowired
    private ClienteServiceDelete clienteServiceDelete;

    @Autowired
    private ClienteServiceGet clienteServiceGet;

    @Autowired
    private ClienteServicePost clienteServicePost;

    @Autowired
    private ClienteServicePut clienteServicePut;

    @GetMapping("/buscar/jpa")
    public ResponseEntity<List<ClienteDto>> listarJPA() {
        return new ResponseEntity<>(clienteServiceGet.buscarTodosComJPA(), HttpStatus.OK);
    }

    @GetMapping("/buscar/jpql")
    public ResponseEntity<List<ClienteDto>> listarJPQL() {
        return new ResponseEntity<>(clienteServiceGet.buscarTodosComJPQL(), HttpStatus.OK) ;
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<ClienteDto> buscar(@PathVariable long id) {
        return new ResponseEntity<>(clienteServiceGet.buscarUm(id), HttpStatus.OK);
    }

    @PostMapping("/salvar")
    public void salvar(@RequestBody ClienteDto clienteDto) {
        clienteServicePost.salvar(clienteDto);
    }
}
