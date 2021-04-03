package com.algaworks.osworks.api.dto;

import com.algaworks.osworks.api.model.ClienteModel;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Builder
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
                //adiciono na lista criada na linha 24
                clienteDtos.add(converterToDto(db));
            }
        }
        return clienteDtos;
    }

    public static ClienteDto converterToDto(ClienteModel clienteModel) {

        return ClienteDto
                .builder()
                .nome(clienteModel.getNome())
                .email(clienteModel.getEmail())
                .telefone(clienteModel.getTelefone())
                .build();
    }
}
