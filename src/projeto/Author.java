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
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Author other = (Author) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Nome do Autor:" + name + " - País: " + contry + "";
    }

}
