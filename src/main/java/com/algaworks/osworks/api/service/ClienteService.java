package com.algaworks.osworks.api.service;

import com.algaworks.osworks.api.dto.ClienteDto;
import com.algaworks.osworks.api.model.ClienteModel;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    @PersistenceContext
    private EntityManager manager;

    public List<ClienteDto> buscarTodos() {

        //Query para trazer os dados do banco
        List<ClienteModel> databaseRetorno = manager.createQuery("from ClienteModel", ClienteModel.class).getResultList();

        //criei o objeto que vou retornar para o controller, famoso DTO
        List<ClienteDto> clienteDtos = new ArrayList<>();

        //Peguei os dados que voltaram do banco e populei o DTO criado anteriormente
        if (!databaseRetorno.isEmpty()) {
            //Se o que reotornou do banco NAO for vazio, itera nele
            for (ClienteModel db : databaseRetorno) {
                //a cada item que eu encontrar no databaseRetorno eu vou criar um novo ClienteDTO
                ClienteDto clienteDto = new ClienteDto();
                clienteDto.setEmail(db.getEmail());
                clienteDto.setNome(db.getNome());
                clienteDto.setTelefone(db.getTelefone());

                //adiciono na lista criada na linha 24
                clienteDtos.add(clienteDto);
            }
        }

        //Retorne o DTO
        return clienteDtos;
    }
}
