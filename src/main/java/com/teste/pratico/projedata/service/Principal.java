package com.teste.pratico.projedata.service;

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
        var listaFuncionarios = new ArrayList<Funcionario>(inserirFuncionarioService.inserirTodos()); //3.1
        removerPessoaService.remover(listaFuncionarios, NOME_FUNCIONARIO_REMOVIDO); //3.2
        imprimirFuncionarioService.imprimir(listaFuncionarios); //3.3
        aumentarSalarioFuncionarioService.aumentarTodos(listaFuncionarios); //3.4
        imprimirFuncionarioService.imprimirPorFuncao(listaFuncionarios); //3.5, 3.6
        imprimirFuncionarioService.imprimirPorAniversario(listaFuncionarios, PRIMEIRO_ANIVERSARIO); //3.8 não há 3.7 no teste
        imprimirFuncionarioService.imprimirPorAniversario(listaFuncionarios, SEGUNDO_ANIVERSARIO); //3.8
        imprimirFuncionarioService.imprimirMaiorIdade(listaFuncionarios); //3.9
        imprimirFuncionarioService.imprimirPorOrdemAlfabetica(listaFuncionarios); //3.10
        imprimirFuncionarioService.imprimirSalarioTotal(listaFuncionarios); //3.11
        imprimirFuncionarioService.imprimirSalariosMinimosDeCadaFuncionario(listaFuncionarios); //3.12
    }
}
