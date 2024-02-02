

public class Biblioteca {

    private Node primeiro;
    private Node ultimo;
    private int quantidade = 0;

    public int quantidade () {
        return this.quantidade;
    }

    public void adicionaLivros (Livros livro) {
        Node aux = new Node(livro);
        if (this.quantidade == 0) {
            this.primeiro = aux;
            this.ultimo = this.primeiro;
            this.quantidade++;
        } else if (livro.getTitulo().compareTo(this.primeiro.getLivro().getTitulo()) <= 0) {
            aux.setProximo(this.primeiro);
            this.primeiro = aux;
            this.quantidade++;
        } else if (livro.getTitulo().compareTo(this.ultimo.getLivro().getTitulo()) >= 0) {
            this.ultimo.setProximo(aux);
            this.ultimo = aux;
            this.quantidade++;
        } else {
            Node x = this.primeiro;
            while (x.getProximo() != null && livro.getTitulo().compareTo(x.getProximo().getLivro().getTitulo()) > 0) {
                x = x.getProximo();
            }
            aux.setProximo(x.getProximo());
            x.setProximo(aux);
            this.quantidade++;
        }
    }

    public void removeLivros (int isbn) {
        if (this.quantidade == 0) {
            System.out.println("Erro! Acervo vazio.");
            return;
        } else {
            Node aux = this.primeiro;
            while(aux.getProximo() != null && aux.getProximo().getLivro().getIsbn() != isbn) {
                aux = aux.getProximo();
            }
            if (aux.getProximo() == null && aux.getLivro().getIsbn() != isbn) {
                System.out.println("Erro! Livro não encontrado.");
                return;
            } else {
                aux.setProximo(aux.getProximo().getProximo());
                if (aux.getProximo() == null) {
                    this.ultimo = aux;
                }
                this.quantidade--;
            }
        }
    }

    public void emprestimo(String titulo) {
        if (this.quantidade == 0) {
            System.out.println("Erro! Acervo vazio.");
            return;
        } else {
            Node aux = this.primeiro;
            while(aux.getProximo() != null && !aux.getProximo().getLivro().getTitulo().equals(titulo)) {
                aux =  aux.getProximo();
            }
            if (aux.getProximo() == null && !aux.getLivro().getTitulo().equals(titulo)) {
                System.out.println("Erro! Livro não encontrado.");
                return;
            } else {
                if (aux.getProximo().getLivro().getDisponibilidade() == true) {
                    aux.getProximo().getLivro().setDisponibilidade(false);
                    System.out.println(" Empréstimo efetuado com sucesso.");
                } else {
                    System.out.println("O livro solicitado está indisponível, tente novamente outro dia.");
                }
            }
        }
    }

    public void devolucao(String titulo) {
        if (this.quantidade == 0) {
            System.out.println("Erro! Acervo vazio.");
            return;
        } else {
            Node aux = this.primeiro;
            while(aux.getProximo() != null && !aux.getProximo().getLivro().getTitulo().equals(titulo)) {
                aux =  aux.getProximo();
            }
            if (aux.getProximo() == null && !aux.getLivro().getTitulo().equals(titulo)) {
                System.out.println("Erro! Livro não encontrado.");
                return;
            } else {
                if (aux.getProximo().getLivro().getDisponibilidade() == false) {
                    aux.getProximo().getLivro().setDisponibilidade(true);
                    System.out.println(" Devolução efetuada com sucesso.");
                }
            }
        }
    }

    public void imprimeAcervo() {
        if (this.quantidade == 0) {
            System.out.println("Lista vazia.");
            return;
        } else {
            Node aux =  this.primeiro;
            while (aux != null) {
                aux.getLivro().ToString();
                aux = aux.getProximo();
            }
        }
    }

    public void pesquisaTitulo(String titulo) {
        Node aux =  this.primeiro;
        while(aux.getProximo() != null && !aux.getProximo().getLivro().getTitulo().equals(titulo)) {
            aux = aux.getProximo();
        }
        if (aux.getProximo() == null && !aux.getLivro().getTitulo().equals(titulo)) {
            System.out.println("Erro! Livro não encontrado.");
            return;
        } else {
            aux = aux.getProximo();
            aux.getLivro().ToString();
        }
    }

    public void pesquisaAutor(String autor) {
        int encontrado = 0;
        Node aux =  this.primeiro;
        while(aux.getProximo() != null) {
            if (aux.getLivro().getAutor().equals(autor)) {
                aux.getLivro().ToString();
                encontrado = 1;
            }
            aux = aux.getProximo();
        }
        if (encontrado == 0) {
            System.out.println("Nenhum livro deste autor foi encontrado.");
            return;
        }
    }

    public void ordenaTitulo() {

        Node inicio = null;
        Node fim = null;
        Node aux = this.primeiro;
        while (aux != null) {
            Node x = aux.getProximo();
            if (inicio == null || aux.getLivro().getTitulo().compareTo(inicio.getLivro().getTitulo()) <= 0) {
                aux.setProximo(inicio);
                inicio = aux;
            } else {
                Node y = inicio;
                Node z = inicio.getProximo();

                while (z != null && aux.getLivro().getTitulo().compareTo(z.getLivro().getTitulo()) > 0) {
                    y = z;
                    z = z.getProximo();
                }

                y.setProximo(aux);
                aux.setProximo(z);

                if (z == null) {
                    fim = aux;
                }
            }

            aux = x;
        }

        this.primeiro = inicio;
        this.ultimo = fim;
    }

    public void ordenaAutor() {
        Node inicio = null;
        Node fim = null;
        Node aux = this.primeiro;
        while (aux != null) {
            Node x = aux.getProximo();
            if (inicio == null || aux.getLivro().getAutor().compareTo(inicio.getLivro().getAutor()) <= 0) {
                aux.setProximo(inicio);
                inicio = aux;
            } else {
                Node y = inicio;
                Node z = inicio.getProximo();

                while (z != null && aux.getLivro().getAutor().compareTo(z.getLivro().getAutor()) > 0) {
                    y = z;
                    z = z.getProximo();
                }

                y.setProximo(aux);
                aux.setProximo(z);

                if (z == null) {
                    fim = aux;
                }
            }

            aux = x;
        }

        this.primeiro = inicio;
        this.ultimo = fim;
    }
}