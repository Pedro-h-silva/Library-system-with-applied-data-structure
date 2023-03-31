package Projeto_Integrador_IIIA;

import java.util.Scanner;
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

