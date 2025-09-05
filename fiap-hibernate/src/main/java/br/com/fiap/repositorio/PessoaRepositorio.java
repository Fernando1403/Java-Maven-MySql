package br.com.fiap.repositorio;

import br.com.fiap.modelo.Pessoa;
import br.com.fiap.modelo.PessoaFisica;

import java.util.List;

public interface PessoaRepositorio {

    public void criar(Pessoa pessoa); // Create

    public List<PessoaFisica> consultar(String cpf); //Consult
}
