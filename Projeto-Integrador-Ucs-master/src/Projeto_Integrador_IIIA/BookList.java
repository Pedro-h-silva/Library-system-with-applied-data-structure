package Projeto_Integrador_IIIA;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
            // próximo ponto da cauda para nulocurrentPosition
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
                return removedBook;

            } else {
                // Remove o objeto Livro que está no final da Lista
                current.book = null;
                // cauda-> anterior se torna nova cauda
                tail = tail.previous;
                // próximo ponto da cauda para nulo
                tail.next = null;
                // Diminui o contador do tamanho da Lista
                this.sizeList--;
                return removedBook;
            }
        }
        return removedBook;
    }

    // Define posições de cada objeto do início ao fim
    public void setListPosition() {
        Node currentPosition = head;
        int position = 0;
        // Percorre a lista do início ao fim adicionando as posições
        while (currentPosition != null) {
            position++;
            ((Book) currentPosition.book).setPosition(position);
            currentPosition = currentPosition.next;
        }
    }

    // Retorna um Livro de acordo com a sua posição na lista
    public Book getBook(int position) {
        Node current = head;
        Book book = current.book;

        while (current != null) {
            if (((Book) current.book).getPosition() == position) {
                book = current.book;
                break;
            } else
                current = current.next;
        }
        return book;
    }

    // Retorna false se estiver vazia, e true tiver algum Livro
    public boolean checkList() {
        if (head == null) {
            return false;
        }
        return true;
    }

    // Ordenar por ordem alfabetica
    public void sortByTitle() {
    // Cria uma lista temporária com todos os livros
    ArrayList<Book> tempList = new ArrayList<Book>();
    Node current = head;
    while (current != null) {
        tempList.add(current.book);
        current = current.next;
    }

    // Ordena a lista de livros pelo título
    Collections.sort(tempList, new Comparator<Book>() {
        @Override
        public int compare(Book b1, Book b2) {
            return b1.getTitle().compareToIgnoreCase(b2.getTitle());
        }
    });

    // Exibe a lista ordenada
    System.out.println("\nLivros em ordem alfabética:");
    for (Book b : tempList) {
        System.out.println(b);
    }
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
}
