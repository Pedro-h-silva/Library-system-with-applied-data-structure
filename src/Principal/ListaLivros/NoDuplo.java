package Principal.ListaLivros;

public class NoDuplo<T> {
	private T livro;
	private NoDuplo<T> proximo;
	private NoDuplo<T> anterior;
	
	public NoDuplo(T livro){
		this.livro = livro;
	}
	
	public T getLivro(){
		return livro;
	}
	
	public void setLivro(T livro){
		this.livro = livro;
	}
	
	public NoDuplo<T> getProximo(){
		return proximo;
	}
	
	public NoDuplo<T> getAnterior(){
		return anterior;
	}
	
	public void setAnterior(NoDuplo<T> anterior){
		this.anterior = anterior;
	}
	
}
