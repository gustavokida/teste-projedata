package com.teste.pratico.projedata.usecase;

import com.teste.pratico.projedata.domain.Funcionario;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AumentarSalarioFuncionarioService {
    public void aumentarTodos(List<Funcionario> listaFuncionario){
        for (Funcionario funcionario : listaFuncionario) {
            aumentaSalario(funcionario);
        }
    }
    private void aumentaSalario(Funcionario funcionario){
        funcionario.setSalario(funcionario.getSalario().multiply(BigDecimal.valueOf(1.1)));
    }
}
