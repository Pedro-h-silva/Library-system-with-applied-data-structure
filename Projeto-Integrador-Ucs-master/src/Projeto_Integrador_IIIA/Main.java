package Projeto_Integrador_IIIA;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // Instanciando um objeto Scanner para input de dados
        Scanner input = new Scanner(System.in);
        // Instanciando um objeto de Lista de Livros
        BookList bookList = new BookList();
        int option;
        // Menu Inicial do programa chamando as funções conforme a escolha
        do {

            System.out.println(
                    "Bem-vindo à biblioteca virtual!!!\n\nEscolha a funcionalidade desejada:\n\n1-Cadastrar Livro"
                            + "\n2-Consultar de títulos de Livros\n3-Consultar por autor(a)\n4-Remover Livro\n5-Sair ");
            option = input.nextInt();
            // Caso a opção seja 5, o programa será encerrado
            if (option == 5)
                break;
            // Opção 1 abre um mini menu para registro de novos livros
            else if (option == 1) {
                int option2;
                do {
                    System.out.println("\nDeseja cadastrar um Livro em qual posição da lista?"
                            + "\n1.Início\n2.Final\n3.Voltar ao Menu Principal");
                    option2 = input.nextInt();
                    // 3 retorna para menu anterior
                    if (option2 == 3)
                        break;
                    // 1 registra um livro adicionando no inicio da lista
                    else if (option2 == 1)
                        bookList.addBookAtTop(RegisterBook());
                    // 2 registra um livro adicionando no final da lista
                    else if (option2 == 2) {
                        bookList.addBookAtEnd(RegisterBook());
                    } else
                        System.out.println("\nOpção inválida! Tente novamente...");
                } while (option2 != 3);
            }
            // 2 fará a consulta dos Livros de acordo com a escolha
            else if (option == 2) {
                int option3;
                do {
                    System.out.println("\nEscolha uma opção de consulta:\n\n1.Consultar Livro por posição na Lista"
                            + "\n2.Consultar títulos em ordem alfabética\n3.Consultar título por palavras\n4.Retornar ao Menu Principal\n");
                    option3 = input.nextInt();

                    if (option3 == 4)
                        break;

                    else if (option3 == 1) {
                        if (bookList.checkList() == false) {
                            System.out.println("Nenhum Livro cadastrado até o momento!");

                        } else {
                            int position;
                            System.out.println("Digite a posição do livro que deseja consultar:\n");
                            position = input.nextInt();
                            System.out.println(bookList.getBook(position) + "\nDigite 's' para continuar...");
                            input.next();
                        }
                    } else if (option3 == 2)
                        bookList.sortByTitle();
                    // consultar titulos por autor
                    // else if (option3 == 3)
                    else
                        System.out.println("\nOpção inválida! Tente novamente...");
                } while (option3 != 4);
            }

            else if (option == 3)
                ConsultAuthor();
            // 4 Fará remoção do último livro da lista
            else if (option == 4) {
                System.out.println(
                        "\nLivro removido do final da Lista:\n" + bookList.removeBookAtEnd()
                                + "\nDigite 's' para prosseguir...");
                input.next();
            }
            // Caso seja selecionado qualquer outra tecla, irá solicitar para repetir
            else
                System.out.println("\nOpção inválida! Tente novamente...");

        } while (option != 5);

    }

    public static Book RegisterBook() {
        // Alimentando os dados para registro do Livro
        String title, isbn, editora;
        int yearPublication;

        Scanner input = new Scanner(System.in);

        System.out.println("\nInsira o Título do livro:");
        title = input.nextLine();

        System.out.println("\nInsira o isbn do livro:");
        isbn = input.nextLine();

        System.out.println("\nInsira a editora do livro:");
        editora = input.nextLine();

        System.out.println("\nInsira o ano de publicação do livro:");
        yearPublication = input.nextInt();
        // Instanciando um novo Livro enviando os atributos através do construtor
        Book book = new Book(title, isbn, editora, yearPublication);
        // Chamando o método para registrar o Autor e addicionar ao Livro
        book.addAuthor(RegisterAuthor());
        // Laço para caso o Livro possua mais de 1 autor
        // adicionando no seu atributo de Array de Autores
        int chose;
        do {
            System.out.println(
                    "\nDeseja registrar mais um Autor para este Livro?\nDigite 1 para SIM\nDigite 2 para NÃO: ");
            chose = input.nextInt();
            if (chose == 2)
                break;
            else if (chose == 1)
                book.addAuthor(RegisterAuthor());
            else {
                System.out.println("\nOpção inválida, tente novamente...");
            }

        } while (chose != 2);

        System.out.println("\nLivro registrado com sucesso!\nDigite 's' para prosseguir...");
        input.next();
        return book;
    }

    private static Author RegisterAuthor() {
        Scanner input = new Scanner(System.in);

        String nameAuthor, contryAuthor;

        System.out.println("\nInsira o nome do Autor do livro:");
        nameAuthor = input.nextLine();

        System.out.println("\nInsira o país de origem do Autor:");
        contryAuthor = input.nextLine();
        // Instanciando o Objeto Autor passando os seus atributos atravéso do Construtor
        Author author = new Author(nameAuthor, contryAuthor);
        System.out.println("\nAutor registrado!");
        return author;
    }

    private static void ConsultAuthor() {
    }
}