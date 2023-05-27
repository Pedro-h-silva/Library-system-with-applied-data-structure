package projeto;

import java.util.Scanner;

public class Register {
    private static Scanner input = new Scanner(System.in);

    public static Book RegisterBook(BookList list) {

        input = new Scanner(System.in);
        System.out.println("Insira o Título do livro:");
        String title = input.nextLine();

        System.out.println("\nInsira o isbn do livro:");
        String isbn = input.nextLine();

        System.out.println("\nInsira a editora do livro:");
        String editora = input.nextLine();

        System.out.println("\nInsira o ano de publicação do livro:");
        int yearPublication = input.nextInt();

        // Instanciando um novo Livro enviando os atributos através do construtor
        Book book = new Book(title, isbn, editora, yearPublication);
        if (list.chekEqualsBooks(book)) {
            System.out.println("Este livro já existe no cadastro!");
            input.nextLine();
            return null;

        } else {
            // Chamando o método para registrar o Autor e addicionar ao Livro
            book.addAuthor(RegisterAuthor(book));
            // Laço para caso o Livro possua mais de 1 autor, adicionando no seu atributo de
            // Array de Autores
            int chose;
            do {
                System.out.println(
                        "\nDeseja registrar mais um Autor para este Livro?\nDigite 1 para SIM\nDigite 2 para NÃO: ");
                chose = input.nextInt();
                if (chose == 2)
                    break;
                else if (chose == 1)
                    book.addAuthor(RegisterAuthor(book));
                else {
                    ShowMenu.invalidOptionMessage();
                }

            } while (chose != 2);
            System.out.println("\nLivro registrado com sucesso!\nDigite 's' para prosseguir...");
            input.next();
            return book;
        }
    }

    private static Author RegisterAuthor(Book book) {

        input = new Scanner(System.in);
        System.out.println("\nInsira o nome do Autor do livro:");
        String nameAuthor = input.nextLine();

        System.out.println("\nInsira o país de origem do Autor:");
        String contryAuthor = input.nextLine();
        // Instanciando o Objeto Autor passando os seus atributos atravéso do Construtor
        Author author = new Author(nameAuthor, contryAuthor);
        // Verificando se não está sendo instanciado um autor igual no mesmo livro
        if (book.getAuthor().contains(author)) {
            System.out.println("Este autor já foi cadastrado.");
            book.getAuthor().remove(author);
        }
        System.out.println("\nAutor registrado!");
        return author;
    }
}
