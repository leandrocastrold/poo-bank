package models;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    public void imprimirExtrato() {
        System.out.println("=== Extrato Models.Conta Poupan�a ===");
    }

    @Override
    public String toString() {
        return super.toString() + " Tipo: Poupança";
    }
}
