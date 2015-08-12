package com.example.zapfarma1;

import android.R.integer;

public class Remedios {

	private integer Id;
	private String Ativo;
	private String NomeRemedio;
	
	
	public String getNomeRemedio() {
		return NomeRemedio;
	}
	public void setNomeRemedio(String nomeRemedio) {
		this.NomeRemedio = nomeRemedio;
	}
	public String getAtivo() {
		return Ativo;
	}
	public void setAtivo(String ativo) {
		this.Ativo = ativo;
	}
	public integer getId() {
		return Id;
	}
	public void setId(integer id) {
		this.Id = id;
	}
	
	
	
}
