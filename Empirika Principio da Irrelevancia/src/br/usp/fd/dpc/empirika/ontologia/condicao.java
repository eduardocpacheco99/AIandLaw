package br.usp.fd.dpc.empirika.ontologia;

public class condicao {
// colocar fuga, residência, estabelecimento comercial
	int id;
	
	public condicao(int id, String condicao) {
	super();
	this.id = id;
	this.condicao = condicao;
}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCondicao() {
		return condicao;
	}

	public void setCondicao(String condicao) {
		this.condicao = condicao;
	}

	String condicao;
}
