package br.usp.fd.dpc.empirika.ontologia;

public class imputacao {
String caso;
String	lei;
String artigo;
String paragrafo;
String inciso;
pena pena;
boolean acolhido;

public imputacao(){}

public String getLei() {
	return lei;
}

public void setLei(String lei) {
	this.lei = lei;
}

public String getArtigo() {
	return artigo;
}

public void setArtigo(String artigo) {
	this.artigo = artigo;
}

public String getParagrafo() {
	return paragrafo;
}

public void setParagrafo(String paragrafo) {
	this.paragrafo = paragrafo;
}

public String getInciso() {
	return inciso;
}

public void setInciso(String inciso) {
	this.inciso = inciso;
}

public String getCaso() {
	return caso;
}

public void setCaso(String caso) {
	this.caso = caso;
}

public boolean isAcolhido() {
	return acolhido;
}

public void setAcolhido(boolean acolhido) {
	this.acolhido = acolhido;
}

}
