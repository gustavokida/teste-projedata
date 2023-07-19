package com.teste.pratico.projedata.usecase;

import com.teste.pratico.projedata.domain.Funcionario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RemoverPessoaService {
    public void remover(List<Funcionario> listaPessoa, String nome){
        for(int i=0; i<listaPessoa.size(); i++){
            if(listaPessoa.get(i).getNome().equals(nome)){
                listaPessoa.remove(i);
                break;
            }
        }
    }
}
