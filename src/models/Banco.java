package models;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	public Banco(String nome) {
		this.nome = nome;
		this.contas = new ArrayList<>();
	}

	private String nome;
	private List<Conta> contas;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

}
