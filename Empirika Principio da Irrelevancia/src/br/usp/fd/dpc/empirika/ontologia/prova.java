package br.usp.fd.dpc.empirika.ontologia;

public class prova {
	
public prova(int id, String nomeprova, boolean autoridade) {
		super();
		this.id = id;
		this.nomeprova = nomeprova;
		this.autoridade = autoridade;
	}
int id;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNomeprova() {
	return nomeprova;
}
public void setNomeprova(String nomeprova) {
	this.nomeprova = nomeprova;
}
public boolean isAutoridade() {
	return autoridade;
}
public void setAutoridade(boolean autoridade) {
	this.autoridade = autoridade;
}
String nomeprova;
boolean autoridade;
}
