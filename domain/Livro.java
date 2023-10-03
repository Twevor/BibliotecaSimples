package SistemaDeBibliotecaSimples.domain;

public class Livro {
    private String titulo;
    private Autor autor;
    private String dataPublicacao;
    private boolean disponivel = true;
    private int codigoLivro;

    public Livro(String titulo, Autor autor, String dataPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.dataPublicacao = dataPublicacao;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public Autor getAutor() {
        return this.autor;
    }

    public String getDataPublicacao() {
        return this.dataPublicacao;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void setDataPublicacao(String dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public boolean isDisponivel() {
        return this.disponivel;
    }

    public void setDisponivel() {
        this.disponivel = !this.disponivel;
    }

    public int getCodigoLivro() {
        return this.codigoLivro;
    }

    public void setCodigoLivro(int codigoLivro) {
        this.codigoLivro = codigoLivro;
    }

    @Override
    public String toString() {
        return "Título: " + this.titulo + "\nAutor(a): " + autor.getNome() + "\nData de Publicação: "
                + this.dataPublicacao
                + "\nDisponibiliade: " + (this.disponivel ? "Sim" : "Não");
    }
}
