package Projeto_Integrador_IIIA;

import java.util.ArrayList;

public class Book {
    private String title;
    private String isbn;
    private ArrayList<Author> author = new ArrayList<Author>();
    private String editora;
    private int yearPublication;
    private int position;

    public Book(String title, String isbn, String editora, int yearPublication) {
        this.title = title;
        this.isbn = isbn;
        this.editora = editora;
        this.yearPublication = yearPublication;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void addAuthor(Author author) {
        this.author.add(author);
    }

    public String getEditora() {
        return editora;
    }

    public int getAnoPublication() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Livro:" + "\nTitulo: " + title + "\nIsbn = " + isbn + "\nAutor = " + author + "\nEditora = " + editora
                + "\nAno de publicacao: " + yearPublication + "\nPosicao: " + position + "\n\n";
    }
}
