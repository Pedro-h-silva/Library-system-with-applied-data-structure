package Pacote1;

import javax.swing.JOptionPane;

public class menu {
  public static void main(String[] args) {

    int option;

    do {
      option = Integer.parseInt(JOptionPane.showInputDialog(
          "Bem-vindo à biblioteca virtual ! \n\nEscolha a funcionalidade desejada:\n\n1-Cadastrar Livro\n2-Cadastrar autor(a)\n3-Consultar Livro\n4-Consultar autor(a)\n5-Sair "));
      if (option == 5)
        break;
      else if (option == 1)
        RegisterBook();
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

  public static void RegisterBook() {

    String title = JOptionPane.showInputDialog("Insira o Título do livro:");
    int isbn = Integer.parseInt(JOptionPane.showInputDialog("Insira o isbn do  livro:"));
    String author = JOptionPane.showInputDialog("Insira o Autor do livro:");
    String publisher = JOptionPane.showInputDialog("Insira a editora do livro:");
    int year = Integer.parseInt(JOptionPane.showInputDialog("Insira o ano de publicação do livro:"));

    JOptionPane.showMessageDialog(null, "Livro salvo com sucesso !");

  }

  private static void RegisterAuthor() {
  }

  private static void ConsultBook() {
  }

  private static void ConsultAuthor() {
  }

}
