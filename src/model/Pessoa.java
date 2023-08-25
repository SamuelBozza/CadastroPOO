package model;

import java.io.Serializable;

public class Pessoa implements Serializable {
    private int id;
    private String nome;

    public Pessoa(int id, String nome){
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setId() {
        this.id = id;
    }

    public void setNome() {
        this.nome = nome;
    }

    public void exibir() {
        System.out.println(
                "Id: " + getId() +
                " Nome: " + getNome()
        );
    }
}
