package com.teste.pratico.projedata.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.teste.pratico.projedata.domain.Funcionario;
import com.teste.pratico.projedata.usecase.AumentarSalarioFuncionarioService;
import com.teste.pratico.projedata.usecase.ImprimirFuncionarioService;
import com.teste.pratico.projedata.usecase.InserirFuncionarioService;
import com.teste.pratico.projedata.usecase.RemoverPessoaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class Principal {
    private final AumentarSalarioFuncionarioService aumentarSalarioFuncionarioService;
    private final ImprimirFuncionarioService imprimirFuncionarioService;
    private final InserirFuncionarioService inserirFuncionarioService;
    private final RemoverPessoaService removerPessoaService;

    private static final String NOME_FUNCIONARIO_REMOVIDO = "João";
    private static final Integer PRIMEIRO_ANIVERSARIO = 10;
    private static final Integer SEGUNDO_ANIVERSARIO = 12;

    public void execute() {
        var listaFuncionarios = new ArrayList<Funcionario>(inserirFuncionarioService.inserirTodos());
        removerPessoaService.remover(listaFuncionarios, NOME_FUNCIONARIO_REMOVIDO);
        imprimirFuncionarioService.imprimir(listaFuncionarios);
        aumentarSalarioFuncionarioService.aumentarTodos(listaFuncionarios);
        imprimirFuncionarioService.imprimirPorFuncao(listaFuncionarios);
        imprimirFuncionarioService.imprimirPorAniversario(listaFuncionarios, PRIMEIRO_ANIVERSARIO);
        imprimirFuncionarioService.imprimirPorAniversario(listaFuncionarios, SEGUNDO_ANIVERSARIO);
        imprimirFuncionarioService.imprimirMaiorIdade(listaFuncionarios);
        imprimirFuncionarioService.imprimirPorOrdemAlfabetica(listaFuncionarios);
        imprimirFuncionarioService.imprimirSalarioTotal(listaFuncionarios);
        imprimirFuncionarioService.imprimirSalariosMinimosDeCadaFuncionario(listaFuncionarios);
    }
}
