package com.teste.pratico.projedata.usecase.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FuncionariosDto {
    @JsonProperty("funcionario")
    private List<FuncionarioDto> funcionario;
}
