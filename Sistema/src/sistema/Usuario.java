import java.util.ArrayList;

public class Usuario {
    private String nome;
    private String id;
    private String email;
    private ArrayList<Livro> livrosEmPosse;


    public Usuario(String nome, String id, String email) {
        this.nome = nome;
        this.id = id;
        this.email = email;
        this.livrosEmPosse = new ArrayList<>();
    }


    public void exibirInfo() {
        System.out.println("Nome: " + nome);
        System.out.println("ID: " + id);
        System.out.println("E-mail: " + email);
        System.out.println("Livros em Posse: ");
        for (Livro livro : livrosEmPosse) {
            System.out.println("  - " + livro.getTitulo());
        }
    }

    public boolean adicionarLivro(Livro livro) {
        if (livrosEmPosse.size() < 5) {
            livrosEmPosse.add(livro);
            return true;
        } else {
            System.out.println("Limite de 5 livros atingido.");
            return false;
        }
    }

    public boolean removerLivro(Livro livro) {
        return livrosEmPosse.remove(livro);
    }
}
