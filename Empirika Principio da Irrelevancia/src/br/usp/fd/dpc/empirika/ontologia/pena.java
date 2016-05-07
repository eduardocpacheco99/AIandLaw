package br.usp.fd.dpc.empirika.ontologia;

public class pena {
	
public pena(int idImputacao, int id, int penaTempo, int especiePenaTempo,
			int penaDinheiro) {
		super();
		IdImputacao = idImputacao;
		this.id = id;
		this.penaTempo = penaTempo;
		this.especiePenaTempo = especiePenaTempo;
		this.penaDinheiro = penaDinheiro;
	}
int IdImputacao;
int id;
int penaTempo;
int especiePenaTempo;
int penaDinheiro;
public int getIdImputacao() {
	return IdImputacao;
}
public void setIdImputacao(int idImputacao) {
	IdImputacao = idImputacao;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getPenaTempo() {
	return penaTempo;
}
public void setPenaTempo(int penaTempo) {
	this.penaTempo = penaTempo;
}
public int getEspeciePenaTempo() {
	return especiePenaTempo;
}
public void setEspeciePenaTempo(int especiePenaTempo) {
	this.especiePenaTempo = especiePenaTempo;
}
public int getPenaDinheiro() {
	return penaDinheiro;
}
public void setPenaDinheiro(int penaDinheiro) {
	this.penaDinheiro = penaDinheiro;
}


}
