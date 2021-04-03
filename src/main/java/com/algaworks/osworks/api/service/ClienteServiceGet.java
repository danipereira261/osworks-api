package com.algaworks.osworks.api.service;

import com.algaworks.osworks.api.dto.ClienteDto;
import com.algaworks.osworks.api.exception.ClientNotFoundException;
import com.algaworks.osworks.api.model.ClienteModel;
import com.algaworks.osworks.api.repository.ClienteRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceGet {

    @Autowired
    private ClienteRepository clienteRepository;

    @PersistenceContext
    private EntityManager manager;

    public List<ClienteDto> buscarTodosComJPQL() {
        List<ClienteModel> databaseRetorno = manager.createQuery("from ClienteModel", ClienteModel.class).getResultList();
        return ClienteDto.converterListToDTO(databaseRetorno);
    }

    public List<ClienteDto> buscarTodosComJPA() {
        List<ClienteModel> dadosDoBanco = clienteRepository.findAll();
        return ClienteDto.converterListToDTO(dadosDoBanco);
    }

    @SneakyThrows
    public ClienteDto buscarUm(long id) {
        Optional<ClienteModel> clienteModel = clienteRepository.findById(id);
        if (clienteModel.isPresent()) {
            return ClienteDto.converterToDto(clienteModel.get());
        }
        throw new ClientNotFoundException("Cliente não encontrado");
    }
}