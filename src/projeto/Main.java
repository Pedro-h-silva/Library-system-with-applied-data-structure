package projeto;

import java.util.InputMismatchException;
import java.util.Scanner;

class Main {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        input = new Scanner(System.in);
        // Instanciando um objeto de Lista de Livros
        BookList bookList = new BookList();
        // Menu Inicial do programa chamando as funções conforme a escolha
        int option;
        do {
            ShowMenu.showInitialMenu();
            option = input.nextInt();
            switch (option) {
                // Opção 1 abre um mini menu para registro de novos livros
                case 1: {
                    int option2;
                    do {
                        ShowMenu.registerBookMenu();

                        switch (option2 = input.nextInt()) {
                            case 1:
                                try {
                                    bookList.addBookAtTop(RegisterBook(bookList));
                                    break;

                                } catch (NullPointerException exc) {
                                    System.out.println("Não foi possível cadastrar o Livro, tente novamente...\n");
                                    break;
                                }
                            case 2:
                                try {
                                    bookList.addBookAtEnd(RegisterBook(bookList));
                                    break;

                                } catch (NullPointerException exc) {
                                    System.out.println("Não foi possível cadastrar o Livro, tente novamente...\n");
                                    break;
                                }

                            case 3:
                                ShowMenu.backMainMenuMessage();
                                break;
                            default:
                                ShowMenu.invalidOptionMessage();
                                break;
                        }
                    } while (option2 != 3);
                    break;
                }
                // Opção 2 fará a consulta dos Livros de acordo com a escolha
                case 2: {
                    int option3;
                    do {
                        ShowMenu.consultBookMenu();
                        switch (option3 = input.nextInt()) {
                            case 1: {
                                try {
                                    System.out.println("Digite a posição do livro que deseja consultar:\n");
                                    System.out.println(bookList.getBook(input.nextInt())
                                            + "\nDigite 's' para continuar...");
                                    input.next();
                                    break;

                                } catch (NullPointerException exc) {
                                    System.out.println("Livro não encontrado tente novamente.");
                                    break;

                                } catch (InputMismatchException exc) {
                                    System.out
                                            .print("Você deve inserir um número inteiro para a posição do livro, tente novamente...");
                                    input.nextLine();
                                    break;
                                }

                            }
                            // consultar titulos por ordem alfabetica
                            case 2:
                                bookList.sortByTitle();
                                break;
                            // consulta por palavra
                            case 3: {
                                input = new Scanner(System.in);
                                System.out.println("Digite uma frase ou palavra:");
                                String word = input.nextLine();
                                bookList.getWordTitle(word);
                                break;
                            }
                            // consulta por intervalo de ano de publicação
                            case 4: {
                                try {
                                    System.out.println("Digite um ano inicial para pesquisa:");
                                    int year1 = input.nextInt();
                                    System.out.println("Digite o ano final:");
                                    int year2 = input.nextInt();

                                    bookList.getYearTittle(year1, year2);
                                    break;

                                } catch (InputMismatchException exc) {
                                    System.out
                                            .print("Você deve inserir um número inteiro para o ano do livro, tente novamente...");
                                    input.nextLine();
                                    break;
                                }
                            }
                            case 5:
                                ShowMenu.backMainMenuMessage();
                                break;

                            default:
                                ShowMenu.invalidOptionMessage();
                                break;
                        }
                    } while (option3 != 5);
                    break;
                }
                // Opção 3 consulta livros publicados pelo Autor escolhido
                case 3: {
                    input = new Scanner(System.in);
                    System.out.println("Digite o nome de um Autor:");
                    String author = input.nextLine();
                    bookList.getAuthorBook(author);
                    break;
                }
                // Opção 4 Fará remoção do último livro da lista
                case 4: {
                    try {
                        System.out.println(
                                "\nLivro removido do final da Lista:\n" + bookList.removeBookAtEnd()
                                        + "\nDigite 's' para prosseguir...");
                        input.next();
                        break;
                    } catch (NullPointerException exc) {
                        System.out.println("Nenhum livro consta no cadastro." +
                                "\nVoltando ao menu principal...\n");
                        break;
                    }
                }
                // Caso a opção seja 5, o programa será encerrado
                case 5:
                    System.out.println("Encerrando o programa...");
                    break;
                // Caso seja selecionado qualquer outra tecla, informará para tentar novamente
                default:
                    ShowMenu.invalidOptionMessage();
                    break;
            }

        } while (option != 5);

    }

    public static Book RegisterBook(BookList list) {
        try {
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

        } catch (Exception exc) {
            System.out.println("Dado inserido inválido...");
            input.nextLine();
            return null;
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
            return null;
        }
        System.out.println("\nAutor registrado!");
        return author;
    }
}
