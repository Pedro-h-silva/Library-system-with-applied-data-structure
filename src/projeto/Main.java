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
                                    bookList.addBookAtTop(Register.RegisterBook(bookList));
                                    break;

                                } catch (NullPointerException exc) {
                                    System.out.println("Não foi possível cadastrar o Livro, tente novamente...\n");
                                    bookList.removeBookAtTop();
                                    break;
                                }
                            case 2:
                                try {
                                    bookList.addBookAtEnd(Register.RegisterBook(bookList));
                                    break;

                                } catch (NullPointerException exc) {
                                    System.out.println("Não foi possível cadastrar o Livro, tente novamente...\n");
                                    bookList.removeBookAtEnd();
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
                                System.out.println("Digite a posição do livro que deseja consultar:\n");
                                System.out.println(bookList.getBook(input.nextInt())
                                        + "\nDigite 's' para continuar...");
                                input.next();
                                break;
                            }
                            // consultar titulos por ordem alfabetica
                            case 2:
                                bookList.sortByTitle();
                                break;
                            // consulta por palavra
                            case 3: {
                                input = new Scanner(System.in);
                                System.out.print("Digite uma frase ou palavra: ");
                                String word = input.nextLine();
                                bookList.getWordTitle(word);
                                break;
                            }
                            // consulta por intervalo de ano de publicação
                            case 4: {
                                System.out.print("Digite um ano inicial para pesquisa: ");
                                int year1 = input.nextInt();
                                System.out.print("Digite o ano final: ");
                                int year2 = input.nextInt();

                                bookList.getYearTittle(year1, year2);
                                break;
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
                    System.out.print("Digite o nome de um Autor: ");
                    String author = input.nextLine();
                    bookList.getAuthorBook(author);
                    break;
                }
                // Opção 4 Fará remoção do último livro da lista
                case 4: {

                    System.out.println(
                            "\nLivro removido do final da Lista:\n" + bookList.removeBookAtEnd()
                                    + "\nDigite 's' para prosseguir...");
                    input.next();
                    break;

                }
                case 5:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    ShowMenu.invalidOptionMessage();
                    break;
            }

        } while (option != 5);
    }
}
