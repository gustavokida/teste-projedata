package com.teste.pratico.projedata.usecase;

import com.teste.pratico.projedata.domain.Funcionario;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ImprimirFuncionarioService {
    private static final NumberFormat formatter = new DecimalFormat("#,###.##");
    public void imprimir(List<Funcionario> listaFuncionario){
        System.out.println("Lista de funcionários: ");
        for (Funcionario funcionario : listaFuncionario) {
            imprimirFuncionario(funcionario);
        }
        System.out.println();
    }
    public void imprimirPorFuncao(List<Funcionario> listaFuncionario){
        var mapPorFuncao = filtrarPorFuncao(listaFuncionario);
        System.out.println("Funcionários por função: ");
        mapPorFuncao.forEach((chave, listaFuncionarios) -> {
            System.out.println(chave + ": ");
            imprimir(listaFuncionarios);
        });
        System.out.println();
    }
    public void imprimirPorAniversario(List<Funcionario> listaFuncionario, Integer mes){
        System.out.println("Funcionários que fazem aniversario no mês: " + mes.toString());
        listaFuncionario.forEach(funcionario -> {
            if (funcionario.getDataNascimento().getMonthValue() == mes) {
                imprimirFuncionario(funcionario);
            }});
        System.out.println();
    }
    public void imprimirMaiorIdade(List<Funcionario> listaFuncionario){
        var funcionario = listaFuncionario.stream().min(Comparator.comparing(Funcionario::getDataNascimento)).stream().toList();
        if(funcionario.isEmpty()){
            return;
        }
        var idade = Period.between(funcionario.get(0).getDataNascimento(), LocalDate.now()).getYears();
        System.out.println("Funcionário de maior idade:");
        System.out.println(funcionario.get(0).getNome() + " | " + idade);
        System.out.println();

    }
    public void imprimirPorOrdemAlfabetica(List<Funcionario> listaFuncionario){
        listaFuncionario.sort(Comparator.comparing(Funcionario::getNome));
        System.out.println("Funcionários por ordem alfabética:");
        imprimir(listaFuncionario);
        System.out.println();

    }
    public void imprimirSalarioTotal(List<Funcionario> listaFuncionario){
        var soma = listaFuncionario.stream().mapToDouble(funcionario -> funcionario.getSalario().doubleValue()).sum();
        System.out.println("Total dos salários: " + formatter.format(soma));
        System.out.println();

    }
    public void imprimirSalariosMinimosDeCadaFuncionario(List<Funcionario> listaFuncionario){
        System.out.println("Quantidade de salários mínimos: ");
        listaFuncionario.forEach(funcionario -> {
            System.out.println(funcionario.getNome() + " | " +
                    funcionario.getFuncao() + " | " +
                    formatter.format(funcionario.getSalario().doubleValue()/1212.00));
        });
        System.out.println();
    }
    private void imprimirFuncionario(Funcionario funcionario){
        System.out.println(funcionario.getNome() + " | " +
                funcionario.getDataNascimentoFormatado() + " | " +
                funcionario.getSalarioFormatado() + " | " +
                funcionario.getFuncao());
    }
    private Map<String, List<Funcionario>> filtrarPorFuncao(List<Funcionario> listaFuncionario){
        return listaFuncionario.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));
    }
}
