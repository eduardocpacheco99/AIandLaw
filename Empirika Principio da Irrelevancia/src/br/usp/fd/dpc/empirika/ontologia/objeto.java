package br.usp.fd.dpc.empirika.ontologia;

public class objeto {
int id;
public objeto(int id, boolean valorPessoal, String nome, String marca,
		double valor) {
	super();
	this.id = id;
	this.valorPessoal = valorPessoal;
	this.nome = nome;
	this.marca = marca;
	this.valor = valor;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public boolean isValorPessoal() {
	return valorPessoal;
}
public void setValorPessoal(boolean valorPessoal) {
	this.valorPessoal = valorPessoal;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getMarca() {
	return marca;
}
public void setMarca(String marca) {
	this.marca = marca;
}
public double getValor() {
	return valor;
}
public void setValor(double valor) {
	this.valor = valor;
}
boolean valorPessoal;
String nome;
String marca;
double valor;
}
