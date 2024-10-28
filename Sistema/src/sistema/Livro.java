public class Livro {
    private String titulo;
    private String autor;
    private String isbn;
    private int anoPublicacao;
    private int quantidadeEmEstoque;


    public Livro(String titulo, String autor, String isbn, int anoPublicacao, int quantidade) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anoPublicacao = anoPublicacao;
        this.quantidadeEmEstoque = quantidade;
    }


    public void exibirInfo() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("ISBN: " + isbn);
        System.out.println("Ano de Publicação: " + anoPublicacao);
        System.out.println("Quantidade em Estoque: " + quantidadeEmEstoque);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void incrementarEstoque() {
        quantidadeEmEstoque++;
    }

    public boolean decrementarEstoque() {
        if (quantidadeEmEstoque > 0) {
            quantidadeEmEstoque--;
            return true;
        }
        return false;
    }
}
