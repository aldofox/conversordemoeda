import java.io.IOException;

public class Principal {
    public static void main(String[] args) {
        Menu menu = new Menu();
        ConversoDeMoeda converter = new ConversoDeMoeda();

        int opcao;
        double valorMoeda;
        String moedaAtual1 = "";
        String moedaConvertida1 = "";
        String moedaAtual1Nome = "";
        String moedaConvertida1Nome = "";

        do {
            menu.opcaoMenu();
            opcao = menu.opcaoUsuario();
            switch (opcao) {
                case 1:
                    moedaAtual1 = "USD";
                    moedaConvertida1 = "BRL";
                    moedaAtual1Nome = "Dolares";
                    moedaConvertida1Nome = "Reais";

                    break;
                case 2:
                    moedaAtual1 = "ARS";
                    moedaConvertida1 = "USD";
                    moedaAtual1Nome = "Peso Argentino";
                    moedaConvertida1Nome = "Dolares";
                    break;
                case 3:
                    moedaAtual1 = "BOB";
                    moedaConvertida1 = "USD";
                    moedaAtual1Nome = "Boliviano boliviano";
                    moedaConvertida1Nome = "Dolares";
                    break;
                case 4:
                    moedaAtual1 = "CLP";
                    moedaConvertida1 = "USD";
                    moedaAtual1Nome = "Peso Chileno";
                    moedaConvertida1Nome = "Dolares";
                    break;
                case 5:
                    moedaAtual1 = "COP";
                    moedaConvertida1 = "USD";
                    moedaAtual1Nome = "Peso Colombiano";
                    moedaConvertida1Nome = "Dolares";

                    break;
                case 6:
                    moedaAtual1 = "BRL";
                    moedaConvertida1 = "USD";
                    moedaAtual1Nome = "Reais";
                    moedaConvertida1Nome = "Dolares";

                    break;
                case 7:
                    System.out.println("Saindo. Fuiii");
                    break;
                default:
                    System.out.println("Opção Invalidade. Vamos outra vez.");
                    continue;
            }
            if (opcao >= 1 && opcao <= 6) {
                valorMoeda = menu.getValor();
                try {
                    double rates = converter.getTaxaCambio(moedaAtual1, moedaConvertida1);
                    double converteValor = valorMoeda * rates;
                    System.out.printf("O Valor de %.2f %s é equivalente %.2f %s", valorMoeda, moedaAtual1Nome, converteValor, moedaConvertida1Nome);
                } catch (IOException | InterruptedException e) {
                    System.err.println("Erro ao acessar a API: " + e.getMessage());
                } catch (IllegalArgumentException e) {
                    System.err.println("Erro: " + e.getMessage());
                }
            }
        } while (opcao !=7);
        menu.closeScanner();
    }
}