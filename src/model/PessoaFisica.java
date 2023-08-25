package model;

import java.io.Serializable;

public class PessoaFisica extends Pessoa implements Serializable {
    private String cpf;
    private int idade;

    public PessoaFisica(int id, String nome, String cpf, int idade) {
        super(id, nome);
        this.cpf = cpf;
        this.idade = idade;
    }

    public String getCpf(){
        return cpf;
    }

    public int getIdade(){
        return idade;
    }

    public void setCpf(){
        this.cpf = cpf;
    }

    public void setIdade(){
        this.idade = idade;
    }

    @Override
    public void exibir() {
        System.out.println(
                "Id: " + getId() + "\n" +
                " Nome: " + getNome() + "\n" +
                " CPF: " + getCpf() + "\n" +
                " Idade: " + getIdade()
        );
    }
}
