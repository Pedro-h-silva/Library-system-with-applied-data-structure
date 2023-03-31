package projeto;

import java.util.Scanner;

class MenuAntigo {
  private Scanner input = new Scanner(System.in);
  private int option;


  public void showMainMenu() {
    System.out.println("Bem-vindo à biblioteca virtual!!!\n");
    System.out.println("Escolha a funcionalidade desejada:\n");
    System.out.println("1 - Cadastrar Livro\n");
    System.out.println("2 - Consultar de títulos de Livros\n");
    System.out.println("3 - Consultar por autor(a)\n");
    System.out.println("4 - Remover Livro\n");
    System.out.println("5 - Sair\n");
  }

//   public void getInputFromUser() {
//     this.option = input.nextInt();
//   }

//   public int getOption() {
//     return this.option;
//   }

//   public void showInvalidInputMessage() {
//     System.out.println("Opção inválida");
//   }

}   System.out.println("1 - Cadastrar Livro\n");
    System.out.println("2 - Consultar de títulos de Livros\n");
    System.out.println("3 - Consultar por autor(a)\n");
    System.out.println("4 - Remover Livro\n");
    System.out.println("5 - Sair\n");
  }

  public void getInputFromUser() {
    this.option = input.nextInt();
  }

  public int getOption() {
    return this.option;
  }

  public void showInvalidInputMessage() {
    System.out.println("Opção inválida");
  }

}