import java.io.IOException;
import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    public void menu() {
        boolean exibeMenu = true;
        while (exibeMenu) {
            System.out.println("""
                ------------------------------------------------------
                Bem vindo ao Conversor de Moeda !
                ------------------------------------------------------
                
                1) [USD] para [BRL]
                2) [EUR] para [BRL]
                3) [ARS] para [BRL]
                4) [BRL] para [USD]
                5) [BRL] para [EUR]
                6) [BRL] para [ARS]
                7) Sair
                -------------------------------------------------------
                """);

            System.out.println("Escolha uma opção de conversão:");
            String opcao = sc.next();

            switch (opcao) {
                case "1":
                    this.converter("USD","BRL");
                    break;

                case "2":
                    this.converter("EUR","BRL");
                    break;

                case "3":
                    this.converter("ARS","BRL");
                    break;

                case "4":
                    this.converter("BRL","USD" );
                    break;

                case "5":
                    this.converter("BRL","EUR");
                    break;

                case "6":
                    this.converter("BRL","ARS" );
                    break;

                default:
                    if(opcao.equals("7")) {
                        System.out.println("Obrigado !!");
                        exibeMenu = false;
                    } else {
                        System.out.println("Opção Inválida ! Selecione uma opção valida, ou, Opção \"7\" para sair. ");
                    }
                    break;

            }


        }
    }
    public void converter (String baseCode, String targetCode) {
        System.out.println("Informe um valor para conversão: ");
        try {
            double valor = this.sc.nextDouble();
            Conversor conversor = new Conversor(baseCode, targetCode, valor);
            Api api = new Api(conversor);
            System.out.println(api.callApi());
        } catch (Exception e) {
            System.out.println("Valor digitado é inválido... Utilize ',' para converter numeros decimais.");
        }



    }
}
