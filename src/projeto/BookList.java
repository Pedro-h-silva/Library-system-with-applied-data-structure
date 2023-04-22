package projeto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class BookList {
    // contador do tamanho da Lista
    private int sizeList = 0;
    private Scanner input = new Scanner(System.in);

    // Uma classe de nodo para lista duplamente encadeada com objetos Livros
    class Node {
        private Book book;
        private Node previous;
        private Node next;

        public Node(Object object) {
            this.book = (Book) object;
        }
    }

    // Inicialmente, cabeça(head) e tail(cauda) são definidos como nulos
    Node head, tail = null;

    // adicionar um Objeto Livro no inicio da lista
    public void addBookAtTop(Object book) {
        // Criar um novo nó
        Node newBook = new Node(book);
        // Acrescenta o tamanho da Lista de Livros
        this.sizeList++;
        // se a lista estiver vazia, cabeça e cauda apontam para novo Nodo(newNode)
        if (head == null) {
            head = tail = newBook;
            // o anterior da cabeça será nulo
            head.previous = null;
            // o próximo da cauda será nulo
            tail.next = null;
        } else {
            // adiciona newBook ao inicio da lista. tail->próximo definido para newNode
            head.previous = newBook;
            // newBook->proximo definido como cabeça
            newBook.next = head;
            // newBook->proximo torna-se a nova cabeça
            head = newBook;
            // ponto anterior da cabeça para nulo
            head.previous = null;
        }
        setListPosition();
    }

    // adicionar um Objeto Livro no final da lista
    public void addBookAtEnd(Object book) {
        // Criar um novo nó
        Node newBook = new Node(book);
        // Acrescenta o tamanho da Lista de Livros
        this.sizeList++;
        // se a lista estiver vazia, cabeça e cauda apontam para novo Nodo(newBook)
        if (head == null) {
            head = tail = newBook;
            // o anterior da cabeça será nulo
            head.previous = null;
            // o próximo da cauda será nulo
            tail.next = null;
        } else {
            // adiciona newBook ao final da lista. tail->próximo definido para newNode
            tail.next = newBook;
            // newBook->anterior definido como cauda
            newBook.previous = tail;
            // newBook torna-se uma nova cauda
            tail = newBook;
            // próximo ponto da cauda para nulo
            tail.next = null;
        }
        setListPosition();
    }

    // Remove livro do final da Lista
    public Book removeBookAtEnd() {
        Node current = tail;
        Book removedBook = current.book;

        // Verifica se a lista esá vazia
        if (head == null) {
            System.out.println("\nA lista está vazia.\nDigite 's' para prosseguir...");
            input.next();

        } else {
            // Verifica se o elemento está no inicio da Lista
            if (current == head) {
                head = tail = null;

            } else {
                // Remove o objeto Livro que está no final da Lista
                current.book = null;
                // cauda-> anterior se torna nova cauda
                tail = tail.previous;
                // próximo ponto da cauda para nulo
                tail.next = null;
                // Diminui o contador do tamanho da Lista
                this.sizeList--;
            }
        }
        return removedBook;
    }

    // Remove um livro do início da lista
    public Book removeBookAtTop() {
        Node current = head;
        Book removedBook = current.book;
        // Verifica se a lista esá vazia
        if (head == null) {
            System.out.println("\nA lista está vazia.\nDigite 's' para prosseguir...");
            input.next();

        } else {
            // Remove o objeto Livro que está no início da Lista
            current.book = null;
            // cabeça-> próxima se torna nova cabeça
            head = head.next;
            // ponto anterior da cabeça para nulo
            head.previous = null;
            // Diminui o contador do tamanho da Lista
            this.sizeList--;
            // }
        }
        setListPosition();
        return removedBook;
    }

    // Define posições de cada objeto do início ao fim
    public void setListPosition() {
        Node currentPosition = head;
        int position = 0;
        // Percorre a lista do início ao fim adicionando as posições
        while (currentPosition != null) {
            position++;
            (currentPosition.book).setPosition(position);
            currentPosition = currentPosition.next;
        }
    }

    // Retorna um Livro de acordo com a sua posição na lista
    public Book getBook(int position) {
        Node current = head;
        Book book = current.book;
        boolean findBook = false;

        while (current != null) {
            if (current.book.getPosition() == position) {
                book = current.book;
                findBook = true;
                return book;
            }

            current = current.next;
        }
        if (!findBook)
            System.out.println("Não foi encontrado livro a posição inserida.");

        return null;
    }

    // Ordenar por ordem alfabetica
    public void sortByTitle() {
        if (head == null) {
            System.out.println("\nA lista está vazia.\nDigite's' para prosseguir...");
            input.next();
            return;
        }

        // Cria uma lista temporária com todos os livros
        ArrayList<Book> tempList = new ArrayList<Book>();
        Node current = head;
        while (current != null) {
            tempList.add(current.book);
            current = current.next;
        }

        // Ordena a lista temporária de livros pelo título
        Collections.sort(tempList, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return b1.getTitle().compareToIgnoreCase(b2.getTitle());
            }
        });

        // Volta os livros ordenados para a lista, e imprime a lista ordenada
        current = head;
        System.out.println("\nLivros em ordem alfabética:");
        for (Book b : tempList) {
            current.book = b;
            current = current.next;
        }
        tempList.clear();
        setListPosition();
        printBooks();
    }

    // Listando livros de acordo com o intervalo de ano de publicação solicitados
    public void getYearTittle(int year1, int year2) {
        if (head == null) {
            System.out.println("\nA lista está vazia.\nDigite's' para prosseguir...");
            input.next();
            return;
        }
        Node current = head;
        boolean findYearTittle = false;
        System.out.println("\nTitulos publicados entre " + year1 + " á " + year2 + ":");
        while (current != null) {
            if ((current.book).getYear() >= year1 && (current.book).getYear() <= year2) {
                System.out.println(current.book.getTitle());
                findYearTittle = true;
            }
            current = current.next;
        }
        if (!findYearTittle)
            System.out.println("Não consta nenhum livro na lista com os anos informados.");

        System.out.println("\nDigite's' para prosseguir...");
        input.next();
    }

    // Imprimindo livros de acordo com palavra ou frase
    public void getWordTitle(String word) {
        if (head == null) {
            System.out.println("\nA lista está vazia.\nDigite's' para prosseguir...");
            input.next();
            return;
        }

        Node current = head;
        boolean findWordTittle = false;
        while (current != null) {
            if ((current.book).getTitle().toLowerCase().contains(word.toLowerCase())) {
                System.out.print(current.book + "");
                findWordTittle = true;
            }
            current = current.next;
        }
        if (!findWordTittle)
            System.out.println("Não foi encontrado nenhum livro com esta palavra.");

        System.out.println("\nDigite 's' para prosseguir...");
        input.next();
    }

    // Imprimindo titulos publicados pelo autor escolhido
    public void getAuthorBook(String author) {
        if (head == null) {
            System.out.println("\nA lista está vazia.\nDigite's' para prosseguir...");
            input.next();
            return;
        }
        Node current = head;
        boolean findAuthor = false;
        while (current != null) {
            for (int i = 0; i < (current.book).getAuthor().size(); i++) {

                if ((current.book).getAuthor().get(i).getName().toLowerCase().equals(author.toLowerCase())) {
                    System.out.println("Titulo: " + (current.book).getTitle());
                    findAuthor = true;
                }
            }
            current = current.next;
        }
        if (!findAuthor)
            System.out.println("Não foi encontrado livros para o autor inserido.");

        System.out.println("\nDigite 's' para sair");
        input.next();
    }

    // Imprimi todos os nós/Objetos da lista duplamente encadeada
    public void printBooks() {
        // O fluxo do nó apontará para a cabeça
        Node current = head;
        if (head == null) {
            System.out.println("\nA lista está vazia.\nDigite 's' para prosseguir...");
            input.next();
            return;
        }
        System.out.println("\nTotal de Livros: " + sizeList);
        while (current != null) {
            // Imprime cada Livro e segue para o próximo
            System.out.print(current.book + " ");
            current = current.next;
        }
        System.out.println("\nDigite 's' para prosseguir...");
        input.next();
    }

    // Verificando se já existe um livro igual na lista ao que está sendo
    // instanciado
    public boolean chekEqualsBooks(Book book) {
        Node current = head;
        while (current != null) {
            if (current.book.equals(book))
                return true;
            current = current.next;
        }
        return false;
    }
}
