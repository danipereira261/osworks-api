package com.algaworks.osworks.api.controller;

import com.algaworks.osworks.api.dto.ClienteDto;
import com.algaworks.osworks.api.model.ClienteModel;
import com.algaworks.osworks.api.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    public List<ClienteDto> listar() {
        return clienteService.buscarTodos();
    }
}
