package com.algaworks.osworks.api.dto;

import com.algaworks.osworks.api.model.ClienteModel;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ClienteDto {

    private String nome;
    private String email;
    private String telefone;


    public static List<ClienteDto> converterListToDTO(List<ClienteModel> databaseRetorno) {

        List<ClienteDto> clienteDtos = new ArrayList<>();

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
        return clienteDtos;
    }
}
