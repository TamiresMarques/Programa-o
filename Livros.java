public class Livros {
    private String titulo;
    private String autor;
    private int isbn;
    private boolean disponibilidade;

    public Livros(String titulo, String autor, int isbn, boolean disponibilidade) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.disponibilidade = disponibilidade;
    }

    public String getTitulo () {
        return titulo;
    }

    public void setTitulo (String titulo) {
        this.titulo = titulo;
    }

    public String getAutor () {
        return autor;
    }

    public void setAutor (String autor) {
        this.autor = autor;
    }

    public int getIsbn () {
        return isbn;
    }

    public void setIsbn (int isbn) {
        this.isbn = isbn;
    }

    public boolean getDisponibilidade () {
        return disponibilidade;
    }

    public void setDisponibilidade (boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public void ToString () {
        System.out.println("Título: "+getTitulo()+", autor: "+ getAutor()+", ISBN: "+getIsbn()+", disponibilidade: "+getDisponibilidade());
    }

}
