package com.algaworks.osworks.api.teste;

import com.algaworks.osworks.api.dto.ClienteDto;
import com.algaworks.osworks.api.model.ClienteModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TesteDeListas {
    public static void main(String[] args) {

        //1 - Criar a lista
        //List<ClienteDto> clienteDtoList = new ArrayList<>();
        List<ClienteModel> clienteModelList = new ArrayList<>();

        //2 - Criar os objeto do tipo ClienteDto
        ClienteDto obj1 = ClienteDto
                .builder()
                .nome("Felipe")
                .email("fesacaba@gmail.com")
                .telefone("1192026904")
                .build();

        ClienteDto obj2 = ClienteDto
                .builder()
                .nome("Daniele")
                .email("dpereira261@gmail.com")
                .telefone("11985942916")
                .build();

        //4 Iterar dentro da lista
        for (ClienteDto clienteDto : Arrays.asList(obj1, obj2)) {

        //5 Converter de DTO para Model
            clienteModelList.add(ClienteModel.converterToModel(clienteDto));
        }

        System.out.println(clienteModelList);
    }
}
