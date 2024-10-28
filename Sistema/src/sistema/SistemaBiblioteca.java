public class SistemaBiblioteca {
    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca("Biblioteca Central", "Rua Principal, 73");


        Livro livro1 = new Livro("O Espelho", "Machado de Assis", "2571531", 2011, 5);
        Livro livro2 = new Livro("Algoritmos", "Cormen", "39836741", 2019, 3);

        biblioteca.cadastrarLivro(livro1);
        biblioteca.cadastrarLivro(livro2);


        Usuario usuario = new Usuario("gustavo", "0001", "gustavo@email.com");


        biblioteca.emprestar(usuario, "Java: Como Programar");


        usuario.exibirInfo();


        biblioteca.devolver(usuario, "Java: Como Programar");


        biblioteca.exibirInfo();
    }
}
