import conta.Conta;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    Conta conta =  Conta.getInstance();
    conta.setTitular("Bruno M");
    conta.setCpf("121.122.123-24");
    conta.setNumeroConta(25478);
    conta.setDigito(9);

    double valorTransacao;
    int opcao;

    System.out.println("---------------------------MOREIRA-BANK---------------------------");
    System.out.println("Digite 1-Depositar 2-Sacar 3-Extrato 4-Sair");

    do {
      System.out.println();
      opcao=input.nextInt();


      switch (opcao){
        case 1:
          System.out.println("Digite o valor do deposito: ");
          valorTransacao = input.nextDouble();
          conta.depositar(valorTransacao);
          System.out.printf("Voce depositou R$ %.2f | Saldo atual R$ %.2f\n", valorTransacao, conta.saldo);
          System.out.println("------------------------------------------------------");
          break;
        case 2:
          System.out.println("Digite o valor do saque: ");
          valorTransacao = input.nextDouble();
          boolean sucesso =conta.sacar(valorTransacao);
          if(sucesso) {
            System.out.printf("Voce sacou R$ %.2f | Saldo atual R$ %.2f\n", valorTransacao, conta.saldo);
          }else{
            System.out.println("Não é possível fazer o saque pois voce não tem saldo seu pobre!");
          }
          System.out.println("------------------------------------------------------");
          break;
        case 3:
          String dadosConta = conta.exibirConta();
          System.out.println(dadosConta);
          System.out.println("------------------------------------------------------");
          break;
        case 4:
          System.out.println("Valeu seu quebrado, até a proxima!");
          input.close();
          break;
        default:
          System.out.println("Opção inválida! Digite 1-Depositar 2-Sacar 3-Extrato 4-Sair");
      }

    }while (opcao != 4);
  }
}