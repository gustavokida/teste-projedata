package com.teste.pratico.projedata.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {
    private String nome;
    private LocalDate dataNascimento;
    private static final DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public String getDataNascimentoFormatado(){
        return this.dataNascimento.format(formatters);
    }
}
