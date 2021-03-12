package com.algaworks.osworks.api.service;

import com.algaworks.osworks.api.dto.ClienteDto;
import com.algaworks.osworks.api.model.ClienteModel;
import com.algaworks.osworks.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @PersistenceContext
    private EntityManager manager;

    //JPQL
    public List<ClienteDto> buscarTodosComJPQL() {
        List<ClienteModel> databaseRetorno = manager.createQuery("from ClienteModel", ClienteModel.class).getResultList();
        return ClienteDto.converterListToDTO(databaseRetorno);
    }

    //JPA
    public List<ClienteDto> buscarTodosComJPA(){
        List<ClienteModel> dadosDoBanco = clienteRepository.findAll();
        return ClienteDto.converterListToDTO(dadosDoBanco);
    }
}
