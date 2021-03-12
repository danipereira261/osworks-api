package com.algaworks.osworks.api.controller;

import com.algaworks.osworks.api.dto.ClienteDto;
import com.algaworks.osworks.api.model.ClienteModel;
import com.algaworks.osworks.api.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/buscar/jpa")
    public List<ClienteDto> listarJPA() {
        return clienteService.buscarTodosComJPA();
    }

    @GetMapping("/buscar/jpql")
    public List<ClienteDto> listarJPQL() {
        return clienteService.buscarTodosComJPQL();
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<ClienteDto> buscar(@PathVariable long id){
        return clienteService.buscarUm(id);
    }

    @PostMapping("/salvar")
    public void salvar(@RequestBody ClienteDto clienteDto){
        clienteService.salvar(clienteDto);
    }
}
