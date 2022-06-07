package br.com.api.api.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Document
@Getter
@Setter
public class Cliente {

    @Id
    private String id;

    @NotNull @NotEmpty @Length(min = 11, max = 11) //devolve bad request caso o cpf não tenha 11 números
    private String cpf;

    @NotNull @NotEmpty
    private String nome; //devolve bad request para nulo e vazio ""

}
