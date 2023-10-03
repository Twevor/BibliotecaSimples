package SistemaDeBibliotecaSimples;

import java.util.InputMismatchException;
import java.util.Scanner;

import SistemaDeBibliotecaSimples.domain.Autor;
import SistemaDeBibliotecaSimples.domain.Biblioteca;
import SistemaDeBibliotecaSimples.domain.Leitor;
import SistemaDeBibliotecaSimples.domain.Livro;
import SistemaDeBibliotecaSimples.domain.Tools;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca("Rua da cachaça");
        int opcao1 = 0;

        Tools.limparTela();

        do {
            System.out.println("\n1. Listagem de títulos");
            System.out.println("2. Lista de Leitores");
            System.out.println("3. Lista de Autores");
            System.out.println("4. Locação de títulos");
            System.out.println("5. Sair");
            try {
                opcao1 = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor digite um número válido");
                scanner.nextLine();
                continue;
            }
            Tools.limparTela();
            scanner.nextLine();

            switch (opcao1) {
                case 1: // Listagem de títulos
                    System.out.println(
                            "1. Listar todos os livros\n2. Listar apenas disponíveis\n3. Listar apenas os emprestados\n4. Adicionar títulos à biblioteca\n5. Voltar");
                    int opcao1_1 = 0;
                    try {
                        opcao1_1 = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Opção inválida. Retornando ao início...");
                        scanner.nextLine();
                        continue;
                    }
                    scanner.nextLine();
                    Tools.limparTela();
                    switch (opcao1_1) {
                        case 1: // Listar todos os livros
                            biblioteca.imprimeListaTitulos();
                            break;
                        case 2: // Listar apenas disponíveis
                            biblioteca.imprimeListaDisponiveis();
                            break;
                        case 3: // Listar apenas os emprestados
                            biblioteca.imprimeListaAlugados();
                            break;
                        case 4: // Adicionar títulos à biblioteca
                            System.out.print("Informe o título do livro: ");
                            String tituloLivro = scanner.nextLine();

                            System.out.println("\nInforme o ano de publicação: ");
                            String dataPublicacao = scanner.nextLine();

                            Livro livro = new Livro(tituloLivro, null, dataPublicacao);
                            biblioteca.adicionarLivro(livro);

                            System.out.print("\nInforme a autor(a): ");
                            String autorLivro = scanner.nextLine();

                            Autor autorEncontrado = null;
                            for (Autor autor : biblioteca.getListaAutores()) {
                                if (autor.getNome().equalsIgnoreCase(autorLivro)) {
                                    autorEncontrado = autor;
                                    break;
                                }
                            }

                            if (autorEncontrado == null) {
                                System.out.println("Autor(a) não cadastrado.");
                                System.out.println("Adicionando autor(a) na lista de autores...");
                                System.out.print("Informe a idade do(a) autor(a): ");
                                int idadeAutor = 0;
                                try {
                                    idadeAutor = scanner.nextInt();
                                } catch (InputMismatchException e) {
                                    System.out.println(
                                            "Dado incorreto! Operação cancelada!\nRetornando para página inicial");
                                    biblioteca.getListaTitulos().remove(livro);
                                    scanner.nextLine();
                                    break;
                                }
                                Autor newAutor = new Autor(autorLivro, idadeAutor);
                                biblioteca.adicionarAutor(newAutor);
                                newAutor.adicionarLivro(livro);
                                livro.setAutor(newAutor);
                            } else {
                                autorEncontrado.adicionarLivro(livro);
                                livro.setAutor(autorEncontrado);
                            }
                            break;
                        case 5:
                            break;
                        default:
                            System.out.println("Opção inválida.");
                            break;
                    }
                    break;
                case 2: // Lista de Leitores
                    System.out.println(
                            "1. Listar todos os clientes\n2. Verificar cliente\n3. Adicionar cliente\n4. Voltar");
                    int opcao2_1 = 0;
                    try {
                        opcao2_1 = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Opção inválida. Retornando ao início...");
                        scanner.nextLine();
                        continue;
                    }
                    scanner.nextLine();
                    Tools.limparTela();
                    switch (opcao2_1) {
                        case 1: // Listar todos os clientes
                            biblioteca.imprimirTodosLeitores();
                            break;
                        case 2: // Verificar cliente
                            if (biblioteca.getListaLeitores().isEmpty()) {
                                System.out.println("Não há clientes cadastrados.");
                                break;
                            }
                            System.out.print("Digite o código do cliente: ");
                            int opcao2_2 = 0;
                            try {
                                opcao2_2 = scanner.nextInt();
                            } catch (InputMismatchException e) {
                                System.out.println("Opção inválida. Retornando ao início...");
                                scanner.nextLine();
                                break;
                            }
                            scanner.nextLine();
                            boolean clienteEncontrado = false;
                            for (Leitor cliente : biblioteca.getListaLeitores()) {
                                if (cliente.getCodigoLeitor() == opcao2_2) {
                                    clienteEncontrado = true;
                                    cliente.toString();
                                    cliente.imprimeListaAlugados();
                                    break;
                                }
                            }

                            if (!clienteEncontrado) {
                                System.out.println("Cliente não cadastrado.");
                            }
                            break;

                        case 3: // Adicionar cliente
                            System.out.print("Informe o nome completo do cliente: ");
                            String nomeCliente = scanner.nextLine();
                            Leitor leitor = new Leitor(nomeCliente, biblioteca.getLocal(), 0);
                            biblioteca.adicionarLeitor(leitor);
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("Opção inválida.");
                            break;
                    }
                    break;
                case 3: // Lista de Autores
                    System.out.println("1. Listar todos os autores\n2. Verificar autor\n3. Adicionar autor\n4. Voltar");
                    int opcao3_1 = 0;
                    try {
                        opcao3_1 = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Opção inválida. Retornando ao início...");
                        scanner.nextLine();
                        break;
                    }
                    scanner.nextLine();
                    Tools.limparTela();
                    switch (opcao3_1) {
                        case 1: // Listar todos os autores
                            biblioteca.imprimeListaAutores();
                            break;
                        case 2: // Verificar autor
                            if (biblioteca.getListaAutores().isEmpty()) {
                                System.out.println("Não há autores cadastrados.");
                                break;
                            }
                            System.out.print("Digite o nome do autor que gostaria de verificar: ");
                            String opcao3_2 = scanner.nextLine();

                            boolean autorEncontrado = false;
                            for (Autor autor : biblioteca.getListaAutores()) {
                                if (autor.getNome().equalsIgnoreCase(opcao3_2)) {
                                    autorEncontrado = true;
                                    autor.toString();
                                    autor.imprimeListaLivros();
                                    break;
                                }
                            }

                            if (!autorEncontrado) {
                                System.out.println("Autor não encontrado.");
                            }
                            break;

                        case 3: // Adicionar autor
                            System.out.print("Informe o nome do(a) autor(a): ");
                            String nomeAutor = scanner.nextLine();
                            System.out.print("Informe a idade do(a) autor(a): ");
                            int idadeAutor = 0;
                            try {
                                idadeAutor = scanner.nextInt();
                            } catch (InputMismatchException e) {
                                System.out.println("Opção inválida. Retornando ao início...");
                                scanner.nextLine();
                                break;
                            }
                            Autor autor = new Autor(nomeAutor, idadeAutor);
                            biblioteca.adicionarAutor(autor);
                            break;

                        case 4:
                            break;

                        default:
                            System.out.println("Opção inválida.");
                            break;
                    }
                    break;

                case 4: // Locação de títulos
                    if (biblioteca.getListaLeitores().isEmpty()) {
                        System.out.println("Não há clientes registrados para locação");
                        break;
                    }
                    System.out.print("Informe o código do cliente: ");
                    int opcao4_1 = 0;
                    try {
                        opcao4_1 = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Opção inválida. Retornando ao início...");
                        scanner.nextLine();
                        break;
                    }
                    scanner.nextLine();
                    for (Leitor cliente : biblioteca.getListaLeitores()) {
                        if (cliente.getCodigoLeitor() == opcao4_1) {
                            System.out.println("1. Alugar\n2. Devolver\n3. Voltar");
                            int opcao4_2 = 0;
                            try {
                                opcao4_2 = scanner.nextInt();
                            } catch (InputMismatchException e) {
                                System.out.println("Opção inválida. Retornando ao início...");
                                scanner.nextLine();
                                break;
                            }
                            scanner.nextLine();
                            if (opcao4_2 == 3) {
                                break;
                            }
                            if (biblioteca.getListaTitulos().isEmpty()) {
                                System.out.println("Não há títulos disponíveis para locação.");
                                break;
                            }
                            System.out.print("\nAgora informe o título do livro: ");
                            String opcao4_3 = scanner.nextLine();
                            switch (opcao4_2) {
                                case 1: // Alugar
                                    for (Livro livro : biblioteca.getListaTitulos()) {
                                        if (livro.getTitulo().equalsIgnoreCase(opcao4_3)
                                                && livro.isDisponivel() == true) {
                                            cliente.alugarLivro(livro);
                                            break;
                                        } else if (livro.getTitulo().equalsIgnoreCase(opcao4_3)
                                                && livro.isDisponivel() == false) {
                                            System.out.println("Título não disponível");
                                            break;
                                        }
                                    }

                                    break;

                                case 2: // Devolver
                                    for (Livro livro : biblioteca.getListaTitulos()) {
                                        if (livro.getTitulo().equalsIgnoreCase(opcao4_3)) {
                                            cliente.devolverLivro(livro);
                                            break;
                                        }
                                    }
                                    break;

                                default:
                                    System.out.println("Opção inválida.");
                                    break;
                            }
                        }
                    }
                    System.out.println("Cliente não encontrado.");
                    break;
                case 5:
                    System.out.println("Tem certeza que gostaria de sair?\n1. Sim\n2. Não");
                    int verificacaoSaida = 0;
                    try {
                        verificacaoSaida = scanner.nextInt();
                        scanner.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("Opção inválida. Retornando ao início...");
                        scanner.nextLine();
                        opcao1 = 0;
                        break;
                    }
                    switch (verificacaoSaida) {
                        case 1:
                            System.out.println("Obrigado por utilizar nossos serviços!");
                            break;
                        case 2:
                            opcao1 = 0;
                            Tools.limparTela();
                            break;

                        default:
                            Tools.limparTela();
                            System.out.println("Opção inválida. Retornando ao início...");
                            opcao1 = 0;
                            break;
                    }

                    break;

                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (opcao1 != 5);

        scanner.close();
    }
}