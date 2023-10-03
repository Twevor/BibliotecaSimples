package SistemaDeBibliotecaSimples.domain;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private final String NOME = "Minha Biblioteca";
    private String local;
    private List<Livro> listaTitulos = new ArrayList<>();
    private List<Leitor> listaLeitores = new ArrayList<>();
    private List<Autor> listaAutores = new ArrayList<>();

    public Biblioteca(String local) {
        this.local = local;
    }

    public String getNOME() {
        return this.NOME;
    }

    public String getLocal() {
        return this.local;
    }

    public List<Livro> getListaTitulos() {
        return this.listaTitulos;
    }

    public List<Leitor> getListaLeitores() {
        return this.listaLeitores;
    }

    public List<Autor> getListaAutores() {
        return this.listaAutores;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public void imprimeListaTitulos() {
        if (listaTitulos.isEmpty()) {
            System.out.println("Não há livros cadastrados!");
            return;
        }
        for (Livro livro : listaTitulos) {
            System.out
                    .println("Código: " + livro.getCodigoLivro() + " ("
                            + (livro.isDisponivel() ? "Disponível" : "Não disponível") + ") Título: " + livro.getTitulo());
        }
    }

    public void imprimeListaDisponiveis() {
        List<Livro> disponiveis = new ArrayList<>();
        for (Livro livro : listaTitulos) {
            if (livro.isDisponivel()) {
                disponiveis.add(livro);
            }
        }
        if (disponiveis.isEmpty()) {
            System.out.println("Não há livros disponíveis.");
            return;
        }

        for (Livro livro : disponiveis) {
            System.out.println(livro.getTitulo());
        }
    }

    public void imprimeListaAlugados() {
        List<Livro> alugados = new ArrayList<>();
        for (Livro livro : listaTitulos) {
            if (!livro.isDisponivel()) {
                alugados.add(livro);
            }
        }
        if (alugados.isEmpty()) {
            System.out.println("Não há livros alugados");
            return;
        }

        for (Livro livro : alugados) {
            System.out.println(livro.getTitulo());
        }
    }

    public void adicionarLivro(Livro livro) {
        if (!listaTitulos.contains(livro)) {
            listaTitulos.add(livro);
            livro.setCodigoLivro(somaCodigoLivro());
            System.out.println("Adicionado com sucesso!");
            return;
        }
        System.out.println("Já possuimos esse livro");
    }

    public int somaCodigoLivro() {
        int somaCodigoLivro = listaTitulos.size();
        return somaCodigoLivro;
    }

    public void imprimirTodosLeitores() {
        if (listaLeitores.isEmpty()) {
            System.out.println("Não há clientes cadastrados.");
            return;
        }
        for (Leitor leitor : listaLeitores) {
            System.out.println("(" + leitor.getCodigoLeitor() + ")" + " " + leitor.getNome());
        }
    }

    public void adicionarLeitor(Leitor leitor) {
        if (!listaLeitores.contains(leitor)) {
            listaLeitores.add(leitor);
            leitor.setCodigoLeitor(adicionarCodigoLeitor());
            System.out.println("Cliente adicionado com sucesso!");
            return;
        }
        System.out.println("Cliente já cadastrado!");
    }

    private int adicionarCodigoLeitor() {
        int somaCodigoLeitor = (listaLeitores.size());
        return somaCodigoLeitor;
    }

    public void adicionarAutor(Autor autor) {
        if (!listaAutores.contains(autor)) {
            listaAutores.add(autor);
            System.out.println("Autor(a) adicionado(a) com sucesso!");
            return;
        }

        System.out.println("Autor já cadastrado.");

    }

    public void imprimeListaAutores() {
        if (listaAutores.isEmpty()) {
            System.out.println("Não há autores cadastrados.");
            return;
        }

        for (Autor autor : listaAutores) {
            System.out.println(autor.getNome());
        }
    }

    // Não possui o retorno da lista de todos os livros
    // para tal utilize imprimeListaLivros()
    @Override
    public String toString() {
        if (listaLeitores.isEmpty()) {
            return "Não há clientes cadastrados";
        }
        return this.NOME + "\nLocal: " + this.local;
    }

}
