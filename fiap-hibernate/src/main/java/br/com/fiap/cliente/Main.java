package br.com.fiap.cliente;

import br.com.fiap.modelo.Pessoa;
import br.com.fiap.modelo.PessoaFisica;
import br.com.fiap.modelo.PessoaJuridica;
import br.com.fiap.repositorio.PessoaRepositorio;
import br.com.fiap.repositorio.PessoaRepositorioImpl;



public class Main {

	public static void main(String[] args) {

		PessoaRepositorio repositorio = new PessoaRepositorioImpl();

		PessoaFisica pessoa = new PessoaFisica();

		pessoa.setNome("Fernando");
		pessoa.setCpf("59876543-56");
		pessoa.setRg("1231313213");

		repositorio.criar(pessoa);


		/*PessoaJuridica pessoaJuridica = new PessoaJuridica();
		pessoaJuridica.setRazaoSocial("Coca-Cola");
		pessoaJuridica.setCnpj("4343546743");

		repositorio.criar(pessoaJuridica);*/

		repositorio.consultar("59876543-56");

	}
	
}
