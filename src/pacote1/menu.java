package pacote1;

import javax.swing.JOptionPane;

public class menu {
  /**
   * @param args
   */
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

    book newBook = new book();

    newBook.title = JOptionPane.showInputDialog(null, "Digite o título do livro: ");
    newBook.author = JOptionPane.showInputDialog(null, "Nome do autor: ");
    newBook.publisher = JOptionPane.showInputDialog(null, "Editora do livro: ");
    newBook.isbn = JOptionPane.showInputDialog(null, "Número isbn do livro: ");
    newBook.year = JOptionPane.showInputDialog(null, "Ano de publicação: ");

    JOptionPane.showMessageDialog(null,
        "Livro cadastrado com sucesso !" + "\n\n" + "Título: " + newBook.title + "\nAutor: " + newBook.author
            + "\nEditora: " + newBook.publisher + "\nAno de publicação: " + newBook.year + "\nNúmero Isbn: "
            + newBook.isbn);
  }

  public static void RegisterAuthor() {

    author newAuthor = new author();

    newAuthor.name = JOptionPane.showInputDialog(null, "Digite o nome completo do autor: ");
    newAuthor.countryOfOrigin = JOptionPane.showInputDialog(null, "Digite o país de origem do autor: ");
    newAuthor.yearOfBirth = JOptionPane.showInputDialog(null, "Digite o ano de nascimento do autor: ");

    JOptionPane.showMessageDialog(null, "Autor cadastrado com sucesso!\n\n" + "Nome: " + newAuthor.name
        + "\nPaís de origem: " + newAuthor.countryOfOrigin + "\nAno de nascimento: " + newAuthor.yearOfBirth);

  }

  private static void ConsultAuthor() {
  }

  private static void ConsultBook() {
  }

}
