package model.gerenciadores;
import model.PessoaFisica;

import java.io.*;
import java.util.ArrayList;

public class PessoaFisicaRepo {
    private ArrayList<PessoaFisica> listaPessoas;

    public PessoaFisicaRepo() {
        listaPessoas = new ArrayList<>();
    }

    public void inserir(PessoaFisica pessoaFisica) {
        listaPessoas.add(pessoaFisica);
    }

    public void alterar(int id, PessoaFisica pessoaFisica) {
        for (int i = 0; i < listaPessoas.size(); i++) {
            PessoaFisica p = listaPessoas.get(i);
            if (p.getId() == id) {
                listaPessoas.set(i, pessoaFisica);
                break;
            }
        }
    }

    public void excluir(int id) {
        listaPessoas.removeIf(p -> p.getId() == id);
    }

    public PessoaFisica obter(int id) {
        for (PessoaFisica pessoaFisica : listaPessoas) {
            if (pessoaFisica.getId() == id) {
                return pessoaFisica;
            }
        }
        return null;
    }

    public ArrayList<PessoaFisica> obterTodos() {
        return new ArrayList<>(listaPessoas);
    }

    public void persistir(String nomeArquivo) throws IOException {
        try (FileWriter fileWriter = new FileWriter(nomeArquivo);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            for (PessoaFisica pessoa : listaPessoas) {
                bufferedWriter.write(pessoa.getId() + "," + pessoa.getNome() + "," + pessoa.getCpf() + "," + pessoa.getIdade());
                bufferedWriter.newLine();
            }
        }
    }

    public void recuperar(String nomeArquivo) throws IOException {
        try (FileReader fileReader = new FileReader(nomeArquivo);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            listaPessoas.clear();
            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                String[] campos = linha.split(",");
                int id = Integer.parseInt(campos[0]);
                String nome = campos[1];
                String cpf = campos[2];
                int idade = Integer.parseInt(campos[3]);
                PessoaFisica pessoa = new PessoaFisica(id, nome, cpf, idade);
                listaPessoas.add(pessoa);
            }
        }
    }
    public PessoaFisica procurarPorId(int idProcurado) {
        for (PessoaFisica pessoa : listaPessoas) {
            if (pessoa.getId() == idProcurado) {
                return pessoa;
            }
        }
        return null;
    }
}
