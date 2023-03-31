package projeto;

public class Author {
    private String name;
    private String contry;

    public Author(String name, String contry) {
        this.name = name;
        this.contry = contry;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return contry;
    }

    @Override
    public String toString() {
        return "Nome do Autor:" + name + " - País: " + contry + "";
    }

}
