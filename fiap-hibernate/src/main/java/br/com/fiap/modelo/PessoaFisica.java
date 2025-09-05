package br.com.fiap.modelo;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

@Entity
@DiscriminatorValue(value = "pessoaFisica")

@NamedQueries({
        @NamedQuery(name = "xpto", query = "FROM PessoaFisica WHERE cpf = :cpf")
})
public class PessoaFisica extends Pessoa{

    private String rg;
    private String cpf;

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "PessoaFisica{" +
                "rg='" + rg + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
