package br.usp.fd.dpc.empirika.ontologia;

public class verbete {
// doutrina, jurisprudência e outros são verbetes	
int id;
public verbete(int id, String verbete, String categoria) {
	super();
	this.id = id;
	this.verbete = verbete;
	this.categoria = categoria;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getVerbete() {
	return verbete;
}
public void setVerbete(String verbete) {
	this.verbete = verbete;
}
public String getCategoria() {
	return categoria;
}
public void setCategoria(String categoria) {
	this.categoria = categoria;
}
String verbete;
String categoria;
}
