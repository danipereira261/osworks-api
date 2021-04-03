package com.algaworks.osworks.api.model;

import com.algaworks.osworks.api.dto.ClienteDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Data
@Entity
@Table(name = "TB_CLIENTE_PROJETO")
@AllArgsConstructor
@NoArgsConstructor
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private String email;

    @Column
    private String telefone;

    public static ClienteModel converterToModel(ClienteDto clienteDto) {

        return ClienteModel
                .builder()
                .nome(clienteDto.getNome())
                .email(clienteDto.getEmail())
                .telefone(clienteDto.getTelefone())
                .build();
    }
}
