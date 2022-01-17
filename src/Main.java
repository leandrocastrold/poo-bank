import models.*;
import services.BancoService;
import services.ContaService;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static BancoService bancoService;
    private static Banco banco;

    public static void main(String[] args) {
        banco = new Banco("NE LUCROS SA");
        bancoService = new BancoService(banco);
        while (mostrarMenu() != 0) ;
    }

    public static int mostrarMenu() {
        System.out.println("\n[1]: CADASTRAR CONTA CORRENTE\n" +
                "[2]: CADASTRAR CONTA POUPANÇA\n" +
                "[3]: EXIBIR CONTAS CADASTRADAS\n" +
                "[4]: REALIZAR OPERAÇÕES EM CONTAS\n" +
                "[0]: SAIR\n\n" +
                "Escolha uma opção: ");

        int escolha = scanner.nextInt();
        scanner.nextLine();
        scanner.reset();
        switch (escolha) {
            case 1:
                Cliente clienteContaCorrente = criarCliente();
                ContaCorrente contaCorrente = new ContaCorrente(clienteContaCorrente);
                bancoService.adicionarConta(contaCorrente);
                System.out.println(contaCorrente);
                break;
            case 2:
                Cliente clienteContaPoupanca = criarCliente();
                ContaPoupanca contaPoupanca = new ContaPoupanca(clienteContaPoupanca);
                bancoService.adicionarConta(contaPoupanca);
                System.out.println(contaPoupanca);
                break;
            case 3:
                System.out.println("\nBANCO " + banco.getNome() + ":");
                bancoService.listarContas();
                break;
            case 4:
                mostrarMenuOperacoes();
                break;
            case 0:
                System.exit(0);
                break;
        }
        return escolha;
    }

    private static void mostrarMenuOperacoes() {
        System.out.println("OPERAÇÕES\n" +
                "[1]: DEPOSITAR\n" +
                "[2]: SACAR\n" +
                "[3]: TRANSFERIR\n" +
                "[0]: VOLTAR\n");
        System.out.print("Escolha uma opção: ");
        int numeroConta;
        String stringValor;
        int escolha = scanner.nextInt();

        scanner.nextLine();
        switch (escolha) {
            case 1:
                System.out.print("Número da conta: ");
                numeroConta = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Valor do depósito: ");
                stringValor = scanner.nextLine();
                BigDecimal valorDeposito = new BigDecimal(stringValor);
                Conta contaDeposito = localizarConta(numeroConta);
                ContaService contaServiceDeposito = new ContaService(contaDeposito);
                contaServiceDeposito.depositar(valorDeposito);
                break;

            case 2:
                System.out.print("Número da conta: ");
                numeroConta = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Valor do saque: ");
                stringValor = scanner.nextLine();
                BigDecimal valorSaque = new BigDecimal(stringValor);
                Conta contaSaque = localizarConta(numeroConta);
                ContaService contaServiceSaque = new ContaService(contaSaque);
                contaServiceSaque.depositar(valorSaque);
                break;

            case 3:
                System.out.print("Número da conta (ORIGEM): ");
                numeroConta = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Número da conta (DESTINATÁRIO): ");
                int numeroContaDestinatario = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Valor da transferência: ");
                String valorTranferencia = scanner.nextLine();
                Conta contaOrigem = localizarConta(numeroConta);
                Conta contaDestino = localizarConta(numeroContaDestinatario);
                ContaService contaOrigemService = new ContaService(contaOrigem);
                ContaService contaDestinoService = new ContaService(contaDestino);
                contaOrigemService.transferir(contaDestinoService, new BigDecimal(valorTranferencia));
                break;
            case 0:
                break;
        }
    }

    private static Conta localizarConta(int numeroConta) {

        for (Conta conta : banco.getContas()) {
            if (conta.getNumero() == numeroConta) {
                return conta;
            }
        }
        return null;
    }

    private static Cliente criarCliente() {
        System.out.print("\nNome de Cliente: ");
        String nome = scanner.nextLine();
        return new Cliente(nome);
    }


}
