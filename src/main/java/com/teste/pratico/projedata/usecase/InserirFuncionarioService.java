package com.teste.pratico.projedata.usecase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teste.pratico.projedata.domain.Funcionario;
import com.teste.pratico.projedata.dto.FuncionariosDto;
import com.teste.pratico.projedata.dto.mapper.FuncionariosDtoMapper;
import com.teste.pratico.projedata.dto.json.FuncionarioJson;
import com.teste.pratico.projedata.shared.exception.MapFuncionarioJsonException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InserirFuncionarioService {
    private final FuncionariosDtoMapper funcionariosDtoMapper;
    public List<Funcionario> inserirTodos() {
        try{
            ObjectMapper mapper = new ObjectMapper();
            FuncionarioJson funcionarioJson = new FuncionarioJson();
            var funcionariosDto = mapper.readValue(funcionarioJson.getJson(), FuncionariosDto.class);
            return funcionariosDtoMapper.map(funcionariosDto);
        } catch (Exception e){
            throw new MapFuncionarioJsonException("Erro ao mapear a lista json de funcionários.");
        }
    }
}
