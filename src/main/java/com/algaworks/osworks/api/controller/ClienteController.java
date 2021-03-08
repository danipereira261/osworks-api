package com.algaworks.osworks.api.controller;

import com.algaworks.osworks.api.domain.model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ClienteController {

    @GetMapping("/clientes")
    public List<Cliente> listar(){
        Cliente cliente1 = new Cliente();
        cliente1.setId(1L);
        cliente1.setNome("João");
        cliente1.setTelefone("11 99999-9999");
        cliente1.setEmail("joaodascolves@algaworks.com");

        Cliente cliente2 = new Cliente();
        cliente2.setId(2L);
        cliente2.setNome("Maria");
        cliente2.setTelefone("11 22222-2222");
        cliente2.setEmail("mariadascolves@algaworks.com");

        return Arrays.asList(cliente1,cliente2);
    }
}
