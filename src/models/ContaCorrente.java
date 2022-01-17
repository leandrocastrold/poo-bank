package models;

public class ContaCorrente extends Conta {

	public ContaCorrente(Cliente cliente) {
		super(cliente);
	}

	public void imprimirExtrato() {
		System.out.println("=== Extrato Models.Conta Corrente ===");
	}

	@Override
	public String toString() {
		return super.toString() + " Tipo: Corrente";
	}
}
