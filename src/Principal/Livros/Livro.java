package Principal.Livros;

public class Livro {
	public static String titulo;
	public static String isbn;
	public static Autor autor;
	public static String editora;
	public static int anoPublicacao;
	public static int posicao;

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public void setIsn(String isbn){
        this.isbn = isbn;
    }

    public String getIsbn(){
        return this.isbn;
    }
    public void setEditora(String editora){
        this.editora = editora;
    }

    public String getEditora(){
        return this.editora;
    }

    public void setAnoPublicacao(int anoPublicacao){
        this.anoPublicacao = anoPublicacao;
    }


}
