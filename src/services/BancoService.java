package services;

import models.Banco;
import models.Conta;

import java.util.List;

public class BancoService {

    private final Banco banco;

    public BancoService(Banco banco) {
        this.banco = banco;
    }

    public void adicionarConta(Conta conta) {
        List<Conta> contas = this.banco.getContas();
        contas.add(conta);
        banco.setContas(contas);
        System.out.println("Conta: " + conta.getCliente().getNome() + " adicionada");
    }

    public void listarContas() {
        this.banco.getContas().forEach(System.out::println);
    }
}
