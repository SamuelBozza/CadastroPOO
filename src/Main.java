import model.PessoaFisica;
import model.PessoaJuridica;
import model.gerenciadores.PessoaFisicaRepo;
import model.gerenciadores.PessoaJuridicaRepo;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PessoaFisicaRepo repoPessoaFisica = new PessoaFisicaRepo();
        PessoaJuridicaRepo repoPessoaJuridica = new PessoaJuridicaRepo();

        while (true) {
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Incluir");
            System.out.println("2 - Alterar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Exibir pelo ID");
            System.out.println("5 - Exibir todos");
            System.out.println("6 - Salvar dados");
            System.out.println("7 - Recuperar dados");
            System.out.println("0 - Finalizar");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    int tipo = 0;

                    while (tipo != 1 && tipo != 2) {
                        System.out.println("Escolha o tipo: 1 - Pessoa Física, 2 - Pessoa Jurídica");
                        tipo = scanner.nextInt();

                        if (tipo != 1 && tipo != 2) {
                            System.out.println("Opção inválida. Escolha apenas 1 ou 2.");
                        }
                    }
                    if (tipo == 1) {
                        System.out.print("Id: ");
                        int id = scanner.nextInt();

                        scanner.nextLine();

                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();

                        System.out.print("CPF: ");
                        String cpf = scanner.next();

                        System.out.print("Idade: ");
                        int idade = scanner.nextInt();

                        PessoaFisica novaPessoaFisica = new PessoaFisica(id, nome, cpf, idade);
                        repoPessoaFisica.inserir(novaPessoaFisica);
                    } else if (tipo == 2) {
                        System.out.print("Id: ");
                        int id = scanner.nextInt();

                        scanner.nextLine();

                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();

                        System.out.print("CNPJ: ");
                        String cnpj = scanner.nextLine();

                        PessoaJuridica novaPessoaJuridica = new PessoaJuridica(id , nome, cnpj);
                        repoPessoaJuridica.inserir(novaPessoaJuridica);
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;
                case 2:
                    int tipo2 = 0;

                    while (tipo2 != 1 && tipo2 != 2) {
                        System.out.println("Escolha o tipo: 1 - Pessoa Física, 2 - Pessoa Jurídica");
                        tipo2 = scanner.nextInt();

                        if (tipo2 != 1 && tipo2 != 2) {
                            System.out.println("Opção inválida. Escolha apenas 1 - Pessoa Física ou 2 - Pessoa Jurídica");
                        }
                    }
                    System.out.println("Qual ID do usuário que deseja alterar?");
                    int changeID = scanner.nextInt();

                    boolean usuarioEncontrado = false;
                    while (!usuarioEncontrado) {
                        if (tipo2 == 1) {
                            PessoaFisica pessoaEncontrada = repoPessoaFisica.procurarPorId(changeID);
                            if (pessoaEncontrada != null) {
                                usuarioEncontrado = true;

                                System.out.print("Novo Id: ");
                                int newId = scanner.nextInt();

                                scanner.nextLine();

                                System.out.print("Novo nome: ");
                                String newName = scanner.nextLine();

                                System.out.print("Novo CPF: ");
                                String newCPF = scanner.next();

                                scanner.nextLine();

                                System.out.print("Nova idade: ");
                                int newAge = scanner.nextInt();

                                PessoaFisica alterarPessoaFisica = new PessoaFisica(newId, newName, newCPF, newAge);
                                repoPessoaFisica.alterar(changeID, alterarPessoaFisica);
                            } else {
                                System.out.println("Id não encontrado! Digite um ID válido ou 0 para voltar ao menu.");
                                changeID = scanner.nextInt();
                                if (changeID == 0) {
                                    break;
                                }
                            }
                        } else if (tipo2 == 2) {
                            PessoaJuridica pessoaEncontrada = repoPessoaJuridica.procurarPorId(changeID);
                            if (pessoaEncontrada != null) {
                                usuarioEncontrado = true;

                                System.out.print("Novo Id: ");
                                int newId = scanner.nextInt();

                                System.out.print("Novo nome: ");
                                String newName = scanner.next();

                                scanner.nextLine();

                                System.out.print("Novo CNPJ: ");
                                String newCNPJ = scanner.next();

                                PessoaJuridica alterarPessoaJuridica = new PessoaJuridica(newId, newName, newCNPJ);
                                repoPessoaJuridica.alterar(changeID, alterarPessoaJuridica);
                            } else {
                                System.out.println("Id não encontrado! Digite um ID válido ou 0 para voltar ao menu.");
                                changeID = scanner.nextInt();
                                if (changeID == 0) {
                                    break;
                                }
                            }
                        }
                    }
                    break;
                case 3:
                    int tipo3 = 0;

                    while (tipo3 != 1 && tipo3 != 2) {
                        System.out.println("Escolha o tipo: 1 - Pessoa Física, 2 - Pessoa Jurídica");
                        tipo3 = scanner.nextInt();

                        if (tipo3 != 1 && tipo3 != 2) {
                            System.out.println("Opção inválida. Escolha apenas 1 ou 2.");
                        }
                    }
                    boolean repetion = false;
                    while (!repetion) {
                    System.out.println("Qual ID do usuário que deseja remover?");
                    int removerID = scanner.nextInt();
                        if (tipo3 == 1) {
                            PessoaFisica encontrarPessoa = repoPessoaFisica.procurarPorId(removerID);
                            if (encontrarPessoa != null) {
                                repoPessoaFisica.excluir(removerID);
                                System.out.println("Usuario removido do repositorio.");
                                repetion = true;
                            } else {
                                System.out.println("Usario nao encontrado, tente novamente:");
                            }
                        } else if (tipo3 == 2) {
                            PessoaJuridica encontrarPessoa = repoPessoaJuridica.procurarPorId(removerID);
                            if (encontrarPessoa != null) {
                                repoPessoaJuridica.excluir(removerID);
                                System.out.println("Usuario removido do repositorio.");
                                repetion = true;
                            } else {
                                System.out.println("Usario nao encontrado, tente novamente:");
                            }
                        }
                    }
                    break;
                case 4:
                    int tipo4 = 0;

                    while (tipo4 != 1 && tipo4 != 2) {
                        System.out.println("Escolha o tipo: 1 - Pessoa Física, 2 - Pessoa Jurídica");
                        tipo4 = scanner.nextInt();

                        if (tipo4 != 1 && tipo4 != 2) {
                            System.out.println("Opção inválida. Escolha apenas 1 ou 2.");
                        }
                    }
                    boolean repetion2 = false;
                    while (!repetion2) {
                        System.out.println("Digite o ID do usuário que deseja consultar:");
                        int consultarID = scanner.nextInt();

                        if (tipo4 == 1) {
                            PessoaFisica obterF = repoPessoaFisica.obter(consultarID);
                            if (obterF != null) {
                                System.out.println("Nome: " + obterF.getNome());
                                System.out.println("CPF: " + obterF.getCpf());
                                System.out.println("Idade: " + obterF.getIdade());
                                repetion2 = true;
                            } else {
                                System.out.println("Pessoa não encontrada.");

                            }
                        } else if (tipo4 == 2) {
                            PessoaJuridica obterJ = repoPessoaJuridica.obter(consultarID);
                            if (obterJ != null) {
                                System.out.println("Nome: " + obterJ.getNome());
                                System.out.println("CPF: " + obterJ.getCnpj());
                                repetion2 = true;
                            } else {
                                System.out.println("Pessoa não encontrada.");
                            }
                        }
                    }
                    break;
                case 5:
                    boolean tipo5 = false;

                    while (!tipo5) {
                        System.out.println("Escolha o tipo: 1 - Pessoa Física, 2 - Pessoa Jurídica");
                        int escolhendoTipo = scanner.nextInt();

                        if (escolhendoTipo == 1) {
                            List<PessoaFisica> pessoasFisicas = repoPessoaFisica.obterTodos();
                            if (!pessoasFisicas.isEmpty()) {
                                for (PessoaFisica pessoa : pessoasFisicas) {
                                    System.out.println("ID: " + pessoa.getId());
                                    System.out.println("Nome: " + pessoa.getNome());
                                    System.out.println("CPF: " + pessoa.getCpf());
                                    System.out.println("Idade: " + pessoa.getIdade());
                                    System.out.println("----------------------------");
                                }
                            } else {
                                System.out.println("Não há pessoas físicas cadastradas.");
                            }
                            tipo5 = true;
                        } else if (escolhendoTipo == 2) {
                            List<PessoaJuridica> pessoasJuridicas = repoPessoaJuridica.obterTodos();
                            if (!pessoasJuridicas.isEmpty()) {
                                for (PessoaJuridica pessoa : pessoasJuridicas) {
                                    System.out.println("ID: " + pessoa.getId());
                                    System.out.println("Nome: " + pessoa.getNome());
                                    System.out.println("CNPJ: " + pessoa.getCnpj());
                                    System.out.println("----------------------------");
                                }
                            } else {
                                System.out.println("Não há pessoas jurídicas cadastradas.");
                            }
                            tipo5 = true;
                        } else {
                            System.out.println("Opção inválida. Escolha apenas 1 ou 2.");
                        }
                    }
                    break;
                case 6:
                    System.out.print("Digite o nome do arquivo para salvar os dados das pessoas físicas: ");
                    String nomeArquivoPessoaFisica = scanner.next();
                    try {
                        repoPessoaFisica.persistir(nomeArquivoPessoaFisica);
                        System.out.println("Dados das pessoas físicas foram salvos com sucesso no arquivo " + nomeArquivoPessoaFisica);
                    } catch (IOException e) {
                        System.out.println("Ocorreu um erro ao salvar os dados das pessoas físicas: " + e.getMessage());
                    }

                    System.out.print("Digite o nome do arquivo para salvar os dados das pessoas jurídicas: ");
                    String nomeArquivoPessoaJuridica = scanner.next();
                    try {
                        repoPessoaJuridica.persistir(nomeArquivoPessoaJuridica);
                        System.out.println("Dados das pessoas jurídicas foram salvos com sucesso no arquivo " + nomeArquivoPessoaJuridica);
                    } catch (IOException e) {
                        System.out.println("Ocorreu um erro ao salvar os dados das pessoas jurídicas: " + e.getMessage());
                    }
                    break;
                case 7:
                    System.out.print("Digite o nome do arquivo para recuperar os dados das pessoas físicas: ");
                    String nomeArquivoRecuperarPessoaFisica = scanner.next();
                    try {
                        repoPessoaFisica.recuperar(nomeArquivoRecuperarPessoaFisica);
                        System.out.println("Dados das pessoas físicas foram recuperados com sucesso do arquivo " + nomeArquivoRecuperarPessoaFisica);
                    } catch (IOException e) {
                        System.out.println("Ocorreu um erro ao recuperar os dados das pessoas físicas: " + e.getMessage());
                    }

                    System.out.print("Digite o nome do arquivo para recuperar os dados das pessoas jurídicas: ");
                    String nomeArquivoRecuperarPessoaJuridica = scanner.next();
                    try {
                        repoPessoaJuridica.recuperar(nomeArquivoRecuperarPessoaJuridica);
                        System.out.println("Dados das pessoas jurídicas foram recuperados com sucesso do arquivo " + nomeArquivoRecuperarPessoaJuridica);
                    } catch (IOException e) {
                        System.out.println("Ocorreu um erro ao recuperar os dados das pessoas jurídicas: " + e.getMessage());
                    }
                    break;
                case 0:
                    System.out.println("Finalizando o programa.");
                    return;
                default:
                    System.out.println("Opção inválida. Escolha uma das opções listadas.");
                    break;
            }
        }
    }
}