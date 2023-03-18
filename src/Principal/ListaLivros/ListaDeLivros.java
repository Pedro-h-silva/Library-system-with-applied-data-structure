package Principal.ListaLivros;

import Principal.Livros.Livro;

import javax.swing.JOptionPane;

public class ListaDeLivros<L> {
	private ListaDeLivros<Livro> livro;
	
	private NoDuplo<L> primeiroNodo;
	private NoDuplo<L> ultimoNodo;
	int tamanho;
	
	//Livro get(int posicão){}

	public static void incluirNoInicio(){
		
		Livro.titulo = JOptionPane.showInputDialog("Insira o Título do livro:");
		Livro.isbn = JOptionPane.showInputDialog("Insira o isbn do  livro:");
		Livro.autor.nome = JOptionPane.showInputDialog("Insira o Autor do livro:");
		Livro.editora = JOptionPane.showInputDialog("Insira a editora do livro:");
		Livro.anoPublicacao = Integer.parseInt(JOptionPane.showInputDialog("Insira o ano de publicação do livro:"));
		
		JOptionPane.showMessageDialog(null, "Livro salvo com sucesso !");
		
	}
	
	public static void incluirNoFim(){
		
	}
	
	public static void ordenar(){
		
	}
	
	void removerDoFim(){
		
	}
	

}
