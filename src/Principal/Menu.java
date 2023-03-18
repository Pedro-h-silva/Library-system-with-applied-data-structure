package Principal;

import Principal.ListaLivros.ListaDeLivros; 

import javax.swing.JOptionPane;

public class Menu {
	public static void main(String [] args) {
		int option;
		int option2;

	    do {
	      option = Integer.parseInt(JOptionPane.showInputDialog(
	          "Bem-vindo à biblioteca virtual ! \n\nEscolha a funcionalidade desejada:\n\n1-Cadastrar Livro\n2-Cadastrar autor(a)\n3-Consultar Livro\n4-Consultar autor(a)\n5-Sair "));
	      if (option == 5)
	    	break;
	      else if (option == 1)	    	  
	    	  do {
	    		  	option2 = Integer.parseInt(JOptionPane.showInputDialog("Desja cadastrar o Livro em qual posição da lista?\n\n1.Início\n\n2.Final\n\n3Voltar ao menu Anterior"));	  
	    		  	if(option2 == 3)
	    		  		break;
	    		  	else if(option2 == 1)
	    		  		ListaDeLivros.incluirNoInicio();
	    		  	else if(option2 == 2)
	    		  		ListaDeLivros.incluirNoFim();
	    		  	else
	    		  		JOptionPane.showMessageDialog(null, "Opção inválida! Tente novamente...");
	    		  	
	    	  } while(option2 != 3);
	    	  
	      else if (option == 2)
	        RegisterAuthor();
	      else if (option == 3)
	        ConsultBook();
	      else if (option == 4)
	        ConsultAuthor();
	      else
	        JOptionPane.showMessageDialog(null, "Opção inválida! Tente novamente...");
	    } while (option != 5);

	}

	private static void RegisterAuthor() {
	}

	private static void ConsultBook() {
	}

	private static void ConsultAuthor() {
	}	
		
}