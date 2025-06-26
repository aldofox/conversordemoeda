import java.util.Scanner;

public class Menu {
    private final Scanner scanner;

    public Menu(){
        this.scanner = new Scanner(System.in);
    }

    public void  opcaoMenu() {
        //System.out.println("========================================================================");
        System.out.println();
        System.out.println("Ola Sejam Bem Vindo ao Nosso Conversor de Moedas. Por Aldo da Silveira");
        System.out.println("=========================================================================");
        System.out.println("Abaixo você tem as opções de Escolha para a Conversão.");
        System.out.println("--------------------------------------------------------");
        System.out.println("1. Dolar para Real");
        System.out.println("2. Peso Argentino para Dolar");
        System.out.println("3. Boliviano boliviano para Dolar");
        System.out.println("4. Peso Chileno para Dolar");
        System.out.println("5. Peso Colombiano para Dolar");
        System.out.println("6. Real para Dolar");
        System.out.println("7. Sair");
        System.out.println("Favor Escolher um das opções acima.");
        System.out.println("------------------------------------------------------------------------------");
    }
    public int opcaoUsuario(){
        while (!scanner.hasNext()){
            System.out.println("Opção Invalida.");
            scanner.next();
        }
        return scanner.nextInt();
    }
    public double getValor(){
        System.out.println("Digite o Valor para Conversão");
        while (!scanner.hasNextDouble()){
            System.out.println("OPA. Valor invalido, Separar a casas decimais com ponto e nãocom virgula.");
            scanner.nextDouble();
        }
        return scanner.nextDouble();
    }
    public void closeScanner(){
        this.scanner.close();
    }
}
