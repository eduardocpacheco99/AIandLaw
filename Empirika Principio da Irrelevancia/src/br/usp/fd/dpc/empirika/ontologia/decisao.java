package br.usp.fd.dpc.empirika.ontologia;


public class decisao {
	int id;
	public String getRecorrerEmLiberdade() {
		return recorrerEmLiberdade;
	}
	public void setRecorrerEmLiberdade(String recorrerEmLiberdade) {
		this.recorrerEmLiberdade = recorrerEmLiberdade;
	}
	String recorrerEmLiberdade;
public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
public decisao(juiz juiz, imputacao imputacao, String decisao,
			int penaTempo, String especiePenaTempo, int penaDinheiro, String recorreremLiberdade) {
		super();
		this.juiz = juiz;
		this.imputacao = imputacao;
		this.decisao = decisao;
		this.penaTempo = penaTempo;
		this.especiePenaTempo = especiePenaTempo;
		this.penaDinheiro = penaDinheiro;
		this.recorrerEmLiberdade = recorreremLiberdade;
	}
juiz juiz;
public juiz getJuiz() {
	return juiz;
}
public void setJuiz(juiz juiz) {
	this.juiz = juiz;
}
public imputacao getImputacao() {
	return imputacao;
}
public void setImputacao(imputacao imputacao) {
	this.imputacao = imputacao;
}
public String getDecisao() {
	return decisao;
}
public void setDecisao(String decisao) {
	this.decisao = decisao;
}
public int getPenaTempo() {
	return penaTempo;
}
public void setPenaTempo(int penaTempo) {
	this.penaTempo = penaTempo;
}
public String getEspeciePenaTempo() {
	return especiePenaTempo;
}
public void setEspeciePenaTempo(String especiePenaTempo) {
	this.especiePenaTempo = especiePenaTempo;
}
public int getPenaDinheiro() {
	return penaDinheiro;
}
public void setPenaDinheiro(int penaDinheiro) {
	this.penaDinheiro = penaDinheiro;
}
imputacao imputacao;
String decisao;
int penaTempo;
String especiePenaTempo;
int penaDinheiro;
}
