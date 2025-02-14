package conta;


public class Conta {
  private int numeroConta;
  private int digito;
  private String  titular;
  private String  cpf;
  public double saldo;

  public static Conta instance = null;

  private Conta(){}

  public static Conta getInstance() {
    if(null != instance){
      return instance;
    }

    instance = new Conta();
    return  instance;
  }

  public int getNumeroConta() {
    return numeroConta;
  }

  public void setNumeroConta(int numeroConta) {
    this.numeroConta = numeroConta;
  }

  public int getDigito() {
    return digito;
  }

  public void setDigito(int digito) {
    this.digito = digito;
  }

  public String getTitular() {
    return titular;
  }

  public void setTitular(String titular) {
    this.titular = titular;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String exibirConta(){
    return  "Conta: "+numeroConta+"/"+digito+" - "+titular+" ("+cpf+") - Saldo: R$" +String.format("%.2f", this.saldo);
  }

  public double depositar(double valor) {
    if(valor < 0){
      valor = Math.abs(valor);
    }

    this.saldo+=valor;

    return  this.saldo;
  }

  public boolean sacar(double valor) {
    if(valor < 0){
      valor = Math.abs(valor);
    }

    if(valor > this.saldo){
      return false;
    }

    this.saldo-=valor;

    return  true;
  }
}

