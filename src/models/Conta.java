package models;

import java.math.BigDecimal;

public abstract class Conta{
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected BigDecimal saldo;
	protected Cliente cliente;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.saldo = new BigDecimal("0");
		this.cliente = cliente;
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	@Override
	public String toString() {
		return "Conta{" +
				"agencia=" + agencia +
				", numero=" + numero +
				", saldo=" + saldo +
				", cliente=" + cliente.getNome() +
				'}';
	}
}
