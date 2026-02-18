import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double saldoInicial = 1000; //saldo inicial
        String usuario; // voce digita seu usuario
        String senha = "123"; // senha padrao
        String continuar; // para continuar S ou N

        while (true) { // laço de repetição para o sistema do banco inteiro

            System.out.println("====> LOGIN <====");

            System.out.println("Antes de entrar na conta bancaria faça seu login.");
            System.out.println("Digite o seu nome: ");
            usuario = sc.nextLine(); // guarda o usuario que voce digita
            System.out.println("Digite sua senha (dica: 123): ");
            senha = sc.nextLine(); // guarda a senha que voce digita


            if (senha.equals("123")) { // se a senha for igual 123 voce entra no programa, se nao ele volta pra tela de login
                while (true) {
                    System.out.println("==== CONTA BANCARIA ====\n");
                    System.out.println("1 - Ver saldo");
                    System.out.println("2 - Depositar");
                    System.out.println("3 - Sacar");
                    System.out.println("0 - Sair\n");
                    System.out.print("Escolha uma opcao: ");
                    int opcao = sc.nextInt(); // guarda a opção que o usuario escolheu

                    // VER SALDO
                    if (opcao == 1) {
                        while (true) {
                            System.out.println("");
                            System.out.println("Olá " + usuario + " seu saldo é: " + saldoInicial + "\n");

                            System.out.println("Deseja voltar ao menu (S/N)?");
                            System.out.println("Caso digite N voce encerrara o programa.");
                            System.out.print("Escolha: ");
                            continuar = sc.next();

                            if (continuar.equalsIgnoreCase("S")) { // se o continuar for s o usuario sai do loop e volta pro menu principal
                                break; // quebra o while pra voltar pro menu
                            } else if (continuar.equalsIgnoreCase("N")) {
                                return; // fecha o sistema
                            } else {
                                // se nao digitar S nem N o sistema da opção invalida
                                System.out.println("Opcao invalida!");
                            }
                        }
                    }

                    // DEPOSITAR
                    else if (opcao == 2) {
                        while (true) {
                            System.out.println("");
                            System.out.println("Olá " + usuario + " digite o quanto voce quer depositar: ");
                            int grana = sc.nextInt(); // guarda o dinheiro que o usuario digita

                            saldoInicial = depositar(saldoInicial, grana); // aqui eu falo que o saldo inicial agora é igual o saldoInicial + a grana, metodo que eu criei no double depositar
                            System.out.println("Agora seu saldo é: " + saldoInicial + "\n");

                            System.out.println("Deseja voltar ao menu (S/N)?");
                            System.out.println("Caso digite N voce encerrara o programa.");
                            System.out.print("Escolha: ");
                            continuar = sc.next();

                            //mesma logica de antes
                            if (continuar.equalsIgnoreCase("S")) {
                                break;
                            } else if (continuar.equalsIgnoreCase("N")) {
                                return;
                            } else {
                                System.out.println("Opcao invalida!");
                            }
                        }
                    }
                    // SACAR
                    else if (opcao == 3) {

                        while (true) {
                            System.out.println("");
                            System.out.println("Olá " + usuario + " digite o quanto voce quer sacar: ");
                            int sacada = sc.nextInt(); // guarda o tanto que o usuario quer sacar

                            if (sacada > saldoInicial) { // se o valor que o usuario sacar for maior que o saldo, o codigo nao calcula e imprime que é impossivel sacar
                                System.out.println("Impossivel sacar um valor maior que seu saldo.");
                                break; // quebra o while e volta pro menu principal
                            } else { // se nao for maior ele saca o valor
                                saldoInicial = sacar(saldoInicial, sacada); // percebi que se isso ficasse fora do if ele descontava o saldo mesmo com o if kkkkkkkkk

                                //mesma logica de antes
                                System.out.println("Agora seu saldo é: " + saldoInicial);
                                System.out.println("Deseja voltar ao menu (S/N)?");
                                System.out.println("Caso digite N voce encerrara o programa.");
                                System.out.print("Escolha: ");
                                continuar = sc.next();
                                if (continuar.equalsIgnoreCase("S")) {
                                    break;
                                } else if (continuar.equalsIgnoreCase("N")) {
                                    return;
                                } else {
                                    System.out.println("Opcao invalida!");
                                }
                            }
                        }
                    }
                    //SAIR
                    else if (opcao == 0) {
                        System.out.println("Encerrando...");
                        return; //encerra o sistema
                    } else {
                        System.out.println("Opcao invalida!");
                    }
                }

            } else { // se errar a senha ele volta pra tela de login
                System.out.println("senha invalida!!!\n");
            }
            sc.close(); // fechar o scanner
        }
    }


    public static double verSaldo(double saldoAtual) {
        return saldoAtual;
    } 

    public static double depositar(double saldoAtual, double valorDeposito) {
        return saldoAtual + valorDeposito;
    }

    public static double sacar(double saldoAtual, double valorSacado) {
        return saldoAtual - valorSacado;
    }
}
