import java.util.ArrayList;

public class Biblioteca {
    private String nome;
    private String endereco;
    private ArrayList<Livro> livrosDisponiveis;


    public Biblioteca(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.livrosDisponiveis = new ArrayList<>();
    }


    public void cadastrarLivro(Livro livro) {
        if (livrosDisponiveis.size() < 100) {
            livrosDisponiveis.add(livro);
            System.out.println("Livro cadastrado com sucesso.");
        } else {
            System.out.println("Limite de 100 livros atingido.");
        }
    }

    public void verificarDisponibilidade(String titulo) {
        for (Livro livro : livrosDisponiveis) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                if (livro.getQuantidadeEmEstoque() > 0) {
                    System.out.println("O livro '" + titulo + "' está disponível.");
                    return;
                } else {
                    System.out.println("O livro '" + titulo + "' não está disponível.");
                    return;
                }
            }
        }
        System.out.println("Livro não encontrado.");
    }

    public Livro localizarLivroPorTitulo(String titulo) {
        for (Livro livro : livrosDisponiveis) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        System.out.println("Livro não encontrado.");
        return null;
    }

    public ArrayList<Livro> localizarLivroPorAutor(String autor) {
        ArrayList<Livro> encontrados = new ArrayList<>();
        for (Livro livro : livrosDisponiveis) {
            if (livro.getAutor().equalsIgnoreCase(autor)) {
                encontrados.add(livro);
            }
        }
        return encontrados;
    }

    public boolean emprestar(Usuario usuario, String titulo) {
        Livro livro = localizarLivroPorTitulo(titulo);
        if (livro != null && livro.decrementarEstoque()) {
            if (usuario.adicionarLivro(livro)) {
                System.out.println("Empréstimo realizado com sucesso.");
                return true;
            } else {
                livro.incrementarEstoque();
            }
        }
        System.out.println("Empréstimo não realizado.");
        return false;
    }

    public void devolver(Usuario usuario, String titulo) {
        Livro livro = localizarLivroPorTitulo(titulo);
        if (livro != null && usuario.removerLivro(livro)) {
            livro.incrementarEstoque();
            System.out.println("Livro devolvido com sucesso.");
        } else {
            System.out.println("Erro ao devolver o livro.");
        }
    }

    public void exibirInfo() {
        System.out.println("Biblioteca: " + nome);
        System.out.println("Endereço: " + endereco);
        System.out.println("Livros Disponíveis:");
        for (Livro livro : livrosDisponiveis) {
            livro.exibirInfo();
            System.out.println("-------------------------");
        }
    }
}
