public class Node {
    private Livros livro;
    private Node proximo;

    public Node(Livros livro) {
        this.livro = livro;
        this.proximo = null;
    }

    public Node(Livros livro, Node proximo) {
        this.livro = livro;
        this.proximo = proximo;
    }

    public Livros getLivro() {
        return livro;
    }

    public void setLivro(Livros livro) {
        this.livro = livro;
    }

    public Node getProximo() {
        return proximo;
    }

    public void setProximo(Node proximo) {
        this.proximo = proximo;
    }
}
