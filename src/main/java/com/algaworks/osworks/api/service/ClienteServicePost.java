package com.algaworks.osworks.api.service;

import com.algaworks.osworks.api.dto.ClienteDto;
import com.algaworks.osworks.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServicePost {

    @Autowired
    private ClienteRepository clienteRepository;

    public void salvar(ClienteDto clienteDto) {
        clienteRepository.save(ClienteDto.converterToModel(clienteDto));
    }
}
