package com.teste.pratico.projedata.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;

@Getter
@Setter
public class Funcionario extends Pessoa{
    private BigDecimal salario;
    private String funcao;
    private static final NumberFormat formatter = new DecimalFormat("#,###.##");
    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao){
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public String getSalarioFormatado(){
        return formatter.format(this.salario.doubleValue());
    }
}
