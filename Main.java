import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Biblioteca acervo = new Biblioteca();

        acervo.adicionaLivros(new Livros("Harry Potter e a Pedra Filosofal", "J. K. Rowling", 78560, true));
        acervo.adicionaLivros(new Livros("Harry Potter e a Câmara Secreta", "J. K. Rowling", 756321, true));
        acervo.adicionaLivros(new Livros("Harry Potter e o Prisioneiro de Azkaban", "J. K. Rowling", 65342, true));
        acervo.adicionaLivros(new Livros("Harry Potter e o Torneio Tribruxo", "J. K. Rowling", 695148, true));
        acervo.adicionaLivros(new Livros("Harry Potter e o Enigma do Príncipe", "J. K. Rowling", 902136, true));
        acervo.adicionaLivros(new Livros("Harry Potter e as Relíquias da Morte", "J. K. Rowling", 928003, true));
        acervo.adicionaLivros(new Livros("Nárnia: A Viagem do Peregrino da Alvorada", "C. S. Lewis", 865214, true));
        acervo.adicionaLivros(new Livros("Percy Jackson e os Olimpianos: O Último Olimpiano", "Rick Riordan", 130987, true));
        acervo.adicionaLivros(new Livros("O Hobbit", "J. R. R. Tolkien", 965210, true));
        acervo.adicionaLivros(new Livros("Dom Casmurro", "Machado de Assis", 127410, true));

        int opcao = 0;
        do {
            System.out.print("\n--Operações da Biblioteca--\n1- Adicionar um livro.\n2- Remover um livro\n3- Empréstimo de um livro.\n4- Devolução de um livro.\n5- Pesquisar por título.\n6- Pesquisar por autor.\n7- Ordenar acervo por autor.\n8- Imprimir acervo.\n0- Sair.\nEscolha uma das opções: ");
            opcao = leitor.nextInt();
            leitor.nextLine();

            if (opcao == 1) {
                acervo.imprimeAcervo();
                System.out.println();
                acervo.adicionaLivros(cadastrarLivro());
                acervo.ordenaTitulo();
                System.out.println();
                acervo.imprimeAcervo();
            } else if (opcao == 2) {
                System.out.print("Informe o número ISBN do livro: ");
                int num = leitor.nextInt();
                acervo.ordenaTitulo();
                acervo.imprimeAcervo();
                System.out.println();
                acervo.removeLivros(num);
                acervo.imprimeAcervo();
            } else if (opcao == 3) {
                System.out.print("Digite o título do livro: ");
                String nome = leitor.nextLine();
                acervo.emprestimo(nome);
                acervo.imprimeAcervo();
            } else if (opcao == 4) {
                System.out.print("Digite o título do livro: ");
                String nome = leitor.nextLine();
                acervo.devolucao(nome);
                acervo.imprimeAcervo();
            } else if (opcao == 5) {
                System.out.print("Digite o título do livro: ");
                String nome = leitor.nextLine();
                acervo.pesquisaTitulo(nome);
            } else if (opcao == 6) {
                System.out.print("Digite o nome do autor: ");
                String autor = leitor.nextLine();
                acervo.ordenaTitulo();
                acervo.pesquisaAutor(autor);
            } else if (opcao == 7) {
                acervo.ordenaAutor();
                acervo.imprimeAcervo();
            } else if (opcao == 8) {
                acervo.imprimeAcervo();
            }
        } while (opcao != 0);
    }

    public static Livros cadastrarLivro () {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Sistema de Cadastro de Livros");

        System.out.print("Informe o título do livro: ");
        String titulo = entrada.nextLine();

        System.out.print("Informe o nome do autor do livro: ");
        String autor = entrada.nextLine();

        System.out.print("Informe o número ISBN do livro: ");
        int isbn = entrada.nextInt();
        boolean disponibilidade = true;

        Livros novoLivro = new Livros(titulo, autor, isbn, disponibilidade);
        return novoLivro;
    }

}
