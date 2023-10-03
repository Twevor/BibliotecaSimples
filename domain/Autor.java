package SistemaDeBibliotecaSimples.domain;

import java.util.ArrayList;
import java.util.List;

public class Autor {
    private String nome;
    private List<Livro> listaLivros = new ArrayList<>();
    private int idade;

    public Autor(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return this.nome;
    }

    public List<Livro> getListaLivros() {
        return this.listaLivros;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void adicionarLivro(Livro livro) {
        if (listaLivros.contains(livro)) {
            System.out.println("Livro já faz parte do portifólio do(a) autor(a)!");
            return;
        }
        listaLivros.add(livro);
        System.out.println("Autoria corrigida com sucesso!");
    }

    public void removerLivro(Livro livro) {
        if (!listaLivros.contains(livro)) {
            System.out.println("Autor(a) não possui a autoria desse título.");
            return;
        }
        listaLivros.remove(livro);
        System.out.println("Autoria retirada com sucesso!");
    }

    public void imprimeListaLivros() {
        if (listaLivros.isEmpty()) {
            System.out.println("Autor(a) não possui títulos publicados.");
            return;
        }

        for (Livro livro : listaLivros) {
            System.out.println("Título: " + livro.getTitulo() + " (" + livro.getDataPublicacao() + ")");
        }
    }

    // Não possui o retorno da lista de todos os livros
    // para tal utilize imprimeListaLivros()
    @Override
    public String toString() {
        return "Nome: " + this.nome + "\nIdade: " + this.idade;
    }
}