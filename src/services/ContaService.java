package services;

import models.Conta;

import java.math.BigDecimal;

public class ContaService {

    private Conta conta;

    public ContaService(Conta conta) {
        this.conta = conta;
    }

    public void depositar(BigDecimal valor) {
        BigDecimal novoSaldo = this.conta.getSaldo().add(valor);
        this.conta.setSaldo(novoSaldo);
        System.out.println(this.conta.getCliente().getNome() +": Depósito realizado. Novo saldo: " + this.conta.getSaldo());
    }

    public void transferir(ContaService destService, BigDecimal valor) {
        if (this.conta.getSaldo().compareTo(valor) >= 0) {
            destService.depositar(valor);
            sacar(valor);
            System.out.println(this.conta.getCliente().getNome() +": Transferência realizada. Novo saldo: " + this.conta.getSaldo());
        }
    }

    public void sacar(BigDecimal valor) {
        if (this.conta.getSaldo().compareTo(valor) >= 0) {
            BigDecimal novoSaldo = this.conta.getSaldo().subtract(valor);
            this.conta.setSaldo(novoSaldo);
            System.out.println(this.conta.getCliente().getNome() + ": Saque realizado. Novo Salvo: " + this.conta.getSaldo());
        }
    }


}
