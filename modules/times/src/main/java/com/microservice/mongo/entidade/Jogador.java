package com.microservice.mongo.entidade;

import com.microservice.mongo.enums.Posicao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class Jogador {

    @Id
    private String id;

    private String nome;

    private Posicao posicao;

}
