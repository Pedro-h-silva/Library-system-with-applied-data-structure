package projeto;

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
    public void sortBookList() {
        if (head == null) {
            System.out.println("\nA lista está vazia.\nDigite's' para prosseguir...");
            input.next();
            return;
        }
        if (head == tail) {
            printBooks();
            return;

        } else {
            // Book book = current.book;
            Node current = head;
            Node currentBook = head;
            int compare;
            // enquanto atual não for nulo
            while (current != null) {

                while (current.next != null) {
                    compare = (((Book) current.book).getTitle())
                            .compareToIgnoreCase(((Book) current.next.book).getTitle());

                    if (compare < 0) {
                        head.previous = currentBook;
                        currentBook.next = head;
                        head = currentBook;
                        head.previous = null;
                    }
                    // else if (compare > 0 && current.next == tail) {
                    // aux = current;
                    // current = current.next;
                    // tail = aux;
                    // }
                }
                current = current.next;
            }
            setListPosition();
            printBooks();
        }
    }

    public void getYearTittle(int year1, int year2) {
        Node current = head;
        if (head == null) {
            System.out.println("\nA lista está vazia.\nDigite's' para prosseguir...");
            input.next();
            return;
        }
        System.out.println("Titulos publicados entre " + year1 + "á" + year2);
        while (current != null) {
            if (((Book) current.book).getYear() >= year1 && ((Book) current.book).getYear() <= year2) {
                System.out.println(current.book.getTitle());
            }
            current = current.next;
        }
        System.out.println("\nDigite's' para prosseguir...");
        input.next();
    }

    public void getWordTitle(String word) {
        if (head == null) {
            System.out.println("\nA lista está vazia.\nDigite's' para prosseguir...");
            input.next();
            return;
        }

        Node current = head;
        while (current != null) {
            if ((current.book).getTitle().contains(word))
                System.out.print(current.book + "");

            current = current.next;
        }
        System.out.println("Digite 's' para prosseguir...");
        input.next();
    }

    public void getAuthorBook(String author) {
        if (head == null) {
            System.out.println("\nA lista está vazia.\nDigite's' para prosseguir...");
            input.next();
            return;
        }
        Node current = head;

        while (current != null) {
            if ((current.book).getTitle() == author)
                System.out.println((current.book).getTitle());

            current = current.next;
        }
        System.out.println("Digite 's' para");
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
}
