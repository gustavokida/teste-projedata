package com.teste.pratico.projedata.domain.dto.mapper;

import com.teste.pratico.projedata.domain.Funcionario;
import com.teste.pratico.projedata.domain.dto.FuncionariosDto;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class FuncionariosDtoMapper {
    public List<Funcionario> map(FuncionariosDto funcionariosDto){
        return funcionariosDto.getFuncionario().stream().map(funcionarioDto -> {
            var data =  LocalDate.parse(funcionarioDto.getDataNascimento(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            return new Funcionario(funcionarioDto.getNome(),
                    data,
                    funcionarioDto.getSalario(),
                    funcionarioDto.getFuncao());
        }).toList();
    }
}
