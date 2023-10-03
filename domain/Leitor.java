package SistemaDeBibliotecaSimples.domain;

import java.util.ArrayList;
import java.util.List;

public class Leitor extends Biblioteca {
    private String nome;
    private List<Livro> livrosAlugados = new ArrayList<>();
    private int codigoLeitor;
    private Biblioteca localBiblioteca;

    public Leitor(String nome, String local, int codigoLeitor) {
        super(local);
        this.nome = nome;
        this.codigoLeitor = codigoLeitor;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Livro> getLivrosAlugados() {
        return this.livrosAlugados;
    }

    public int getCodigoLeitor() {
        return this.codigoLeitor;
    }
    public void setCodigoLeitor(int codigoLeitor){
        this.codigoLeitor = codigoLeitor;
    }

    public Biblioteca getLocalBiblioteca() {
        return this.localBiblioteca;
    }

    public void alugarLivro(Livro livro) {
        if (!livrosAlugados.contains(livro)) {
            livrosAlugados.add(livro);
            livro.setDisponivel();
            System.out.println("Alugado com sucesso!");
            return;
        }

        System.out.println("Cliente já possui o livro.");
    }

    public void devolverLivro(Livro livro) {
        if (livrosAlugados.contains(livro)) {
            livrosAlugados.remove(livro);
            livro.setDisponivel();
            System.out.println("Devolvido com sucesso!");
            return;
        }
        System.out.println("Cliente não possui o livro.");
    }

    public void imprimeListaAlugados() {
        if (livrosAlugados.isEmpty()) {
            System.out.println("Cliente não tem livros alugados.");
            return;
        }
        System.out.println("Títulos alugados");
        for (Livro livro : livrosAlugados) {
            System.out.println(livro.getTitulo());
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\nCódigo cliente: " + this.codigoLeitor + " Nome: " + this.nome
                + "\nLocal que aluga: " + this.localBiblioteca;
    }
}
