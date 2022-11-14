import java.util.scanner;

class Main {
  public static void main(String[] args) {

    Scanner entrada = new Scanner(System.in);

    double salarioBase = 0.0;
    double salario = 0.0;
    double gratificacao = 0.0;
    double imposto  = 0.0;
    
    System.out.println("Digite o seu salário base:");
    salarioBase = entrada.nextDouble();
    
    gratificacao = salarioBase + 50;
    imposto = salarioBase * 0.1;
    salario = gratificacao - imposto;
   
    System.out.println("O salário é de R$ " + salario + ".");
  
  }
}
