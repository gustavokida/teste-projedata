package com.teste.pratico.projedata.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioDto {
    @JsonProperty("nome")
    private String nome;
    @JsonProperty("dataNascimento")
    private String dataNascimento;
    @JsonProperty("salario")
    private BigDecimal salario;
    @JsonProperty("funcao")
    private String funcao;
}
