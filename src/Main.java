import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double saldoInicial = 1000;
        String usuario = "Gui";
        String continuar;

        while (true) {
            System.out.println("==== CONTA BANCARIA ====\n");
            System.out.println("1 - Ver saldo");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("0 - Sair\n");
            System.out.print("Escolha uma opcao: ");
            int opcao = sc.nextInt();

            // VER SALDO
            if (opcao == 1) {
                while (true) {
                    System.out.println("");
                    System.out.println("Olá " + usuario + " seu saldo é: " + saldoInicial + "\n");

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

            // DEPOSITAR
            else if (opcao == 2) {
                while (true) {
                    System.out.println("");
                    System.out.println("Olá " + usuario + " digite o quanto voce quer depositar: ");
                    int grana = sc.nextInt();

                    saldoInicial = depositar(saldoInicial, grana);
                    System.out.println("Agora seu saldo é: " + saldoInicial + "\n");

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
            // SACAR
            else if (opcao == 3) {

                while (true) {
                    System.out.println("");
                    System.out.println("Olá " + usuario + " digite o quanto voce quer sacar: ");
                    int sacada = sc.nextInt();

                    if (sacada > saldoInicial) {
                        System.out.println("Impossivel sacar um valor maior que seu saldo.");
                        break;
                    } else{
                        saldoInicial = sacar(saldoInicial, sacada); // percebi que se isso ficasse fora do if ele descontava o saldo mesmo com o if kkkkkkkkk
                        System.out.println("Agora seu saldo é: " + saldoInicial);
                        System.out.println("Deseja voltar ao menu (S/N)?");
                        System.out.println("Caso digite N voce encerrara o programa.");
                        System.out.print("Escolha: ");
                        continuar = sc.next();
                        if (continuar.equalsIgnoreCase("S")){
                            break;
                        } else if (continuar.equalsIgnoreCase("N")){
                            return;
                        } else{
                            System.out.println("Opcao invalida!");
                        }
                    }
                }
            }
            //SAIR
            else if (opcao == 0) {
                System.out.println("Encerrando...");
                break;
            } else {
                System.out.println("Opcao invalida!");
            }
        }
        sc.close();
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
