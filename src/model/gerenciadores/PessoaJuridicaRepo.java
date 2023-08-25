package model.gerenciadores;

import model.PessoaFisica;
import model.PessoaJuridica;

import java.io.*;
import java.util.ArrayList;

public class PessoaJuridicaRepo {
    private ArrayList<PessoaJuridica> listaPessoasJuridicas;

    public PessoaJuridicaRepo() {
        listaPessoasJuridicas = new ArrayList<>();
    }

    public void inserir(PessoaJuridica pessoaJuridica) {
        listaPessoasJuridicas.add(pessoaJuridica);
    }

    public void alterar(int id, PessoaJuridica pessoaJuridica) {
        for (int i = 0; i < listaPessoasJuridicas.size(); i++) {
            PessoaJuridica p = listaPessoasJuridicas.get(i);
            if (p.getId() == id) {
                listaPessoasJuridicas.set(i, pessoaJuridica);
                break;
            }
        }
    }

    public void excluir(int id) {
        listaPessoasJuridicas.removeIf(p -> p.getId() == id);
    }

    public PessoaJuridica obter(int id) {
        for (PessoaJuridica pessoaJuridica : listaPessoasJuridicas) {
            if (pessoaJuridica.getId() == id) {
                return pessoaJuridica;
            }
        }
        return null;
    }

    public ArrayList<PessoaJuridica> obterTodos() {
        return new ArrayList<>(listaPessoasJuridicas);
    }

    public void persistir(String nomeArquivo) throws IOException {
        try (FileWriter fileWriter = new FileWriter(nomeArquivo);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            for (PessoaJuridica pessoaJuridica : listaPessoasJuridicas) {
                bufferedWriter.write(
                        pessoaJuridica.getId() + "," +
                                pessoaJuridica.getNome() + "," +
                                pessoaJuridica.getCnpj() + ",");
                bufferedWriter.newLine();
            }
        }
    }

    public void recuperar(String nomeArquivo) throws IOException {
        try (FileReader fileReader = new FileReader(nomeArquivo);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            listaPessoasJuridicas.clear();
            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                String[] campos = linha.split(",");
                int id = Integer.parseInt(campos[0]);
                String nome = campos[1];
                String cnpj = campos[2];
                PessoaJuridica pessoaJuridica = new PessoaJuridica(id, nome, cnpj);
                listaPessoasJuridicas.add(pessoaJuridica);
            }
        }
        System.out.println("Dados das pessoas jurídicas foram recuperados do arquivo " + nomeArquivo);
    }
    public PessoaJuridica procurarPorId(int idProcurado) {
        for (PessoaJuridica pessoa : listaPessoasJuridicas) {
            if (pessoa.getId() == idProcurado) {
                return pessoa;
            }
        }
        return null;
    }
}
