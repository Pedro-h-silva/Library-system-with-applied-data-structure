package projeto;

public class ShowMenu {
    public static void showInitialMenu() {
        System.out.println(
                "Bem-vindo à biblioteca virtual!!!" +
                        "\n\nEscolha a funcionalidade desejada:\n" +
                        "\n1-Cadastrar Livro" + "\n2-Consultar de Livros" +
                        "\n3-Consultar por autor(a)" +
                        "\n4-Remover Livro\n5-Sair ");
    }

    public static void registerBookMenu() {
        System.out.println("\nDeseja cadastrar um Livro em qual posição da lista?"
                + "\n1.Início" +
                "\n2.Final" +
                "\n3.Voltar ao Menu Principal");
    }

    public static void consultBookMenu() {
        System.out.println("\nEscolha uma opção de consulta:\n" +
                "\n1.Consultar Livro por posição na Lista" +
                "\n2.Consultar títulos em ordem alfabética" +
                "\n3.Consultar títulos por palavras" +
                "\n4.Consultar Livros por ano de publicação" +
                "\n5.Retornar ao Menu Principal\n");
    }

    public static void backMainMenuMessage() {
        System.out.println("Voltando ao Menu Principal...");
    }

    public static void invalidOptionMessage() {
        System.out.println("\nOpção inválida! Tente novamente...");
    }

}
