package br.usp.fd.dpc.empirika.ontologia;
import java.util.List;



public class caso {
	int id;
	String registro;
	String meioProcessual; 
	String numero;
	String comarca;
	String sujeitoAtivo;
	String sujeitoPassivo;
	String objeto;
	decisao decisaoprimeirainstancia;
	String camara;
	String decisao;
	List<decisao> votosDesembargadores;
	List<objeto> objetos;
	double valorTotal;
	double penaTotal;
	List<prova> provas;
    List<condicao> condicoes;
    List<verbete> verbetes;
    public caso(){}
	public caso(
			int id,
			String registro,
			String meioProcessual,
			String numero,
			String comarca,
			String sujeitoAtivo,
			String sujeitoPassivo,
			String objeto,
			br.usp.fd.dpc.empirika.ontologia.decisao decisaoprimeirainstancia,
			String camara,
			String decisao,
			List<br.usp.fd.dpc.empirika.ontologia.decisao> votosDesembargadores,
			List<br.usp.fd.dpc.empirika.ontologia.objeto> objetos,
			double valorTotal, double penaTotal, List<prova> provas,
			List<condicao> condicoes, List<verbete> verbetes) {
		super();
		this.id = id;
		this.registro = registro;
		this.meioProcessual = meioProcessual;
		this.numero = numero;
		this.comarca = comarca;
		this.sujeitoAtivo = sujeitoAtivo;
		this.sujeitoPassivo = sujeitoPassivo;
		this.objeto = objeto;
		this.decisaoprimeirainstancia = decisaoprimeirainstancia;
		this.camara = camara;
		this.decisao = decisao;
		this.votosDesembargadores = votosDesembargadores;
		this.objetos = objetos;
		this.valorTotal = valorTotal;
		this.penaTotal = penaTotal;
		this.provas = provas;
		this.condicoes = condicoes;
		this.verbetes = verbetes;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRegistro() {
		return registro;
	}
	public void setRegistro(String registro) {
		this.registro = registro;
	}
	public String getMeioProcessual() {
		return meioProcessual;
	}
	public void setMeioProcessual(String meioProcessual) {
		this.meioProcessual = meioProcessual;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComarca() {
		return comarca;
	}
	public void setComarca(String comarca) {
		this.comarca = comarca;
	}
	public String getSujeitoAtivo() {
		return sujeitoAtivo;
	}
	public void setSujeitoAtivo(String sujeitoAtivo) {
		this.sujeitoAtivo = sujeitoAtivo;
	}
	public String getSujeitoPassivo() {
		return sujeitoPassivo;
	}
	public void setSujeitoPassivo(String sujeitoPassivo) {
		this.sujeitoPassivo = sujeitoPassivo;
	}
	public String getObjeto() {
		return objeto;
	}
	public void setObjeto(String objeto) {
		this.objeto = objeto;
	}
	public decisao getDecisaoprimeirainstancia() {
		return decisaoprimeirainstancia;
	}
	public void setDecisaoprimeirainstancia(decisao decisaoprimeirainstancia) {
		this.decisaoprimeirainstancia = decisaoprimeirainstancia;
	}
	public String getCamara() {
		return camara;
	}
	public void setCamara(String camara) {
		this.camara = camara;
	}
	public String getDecisao() {
		return decisao;
	}
	public void setDecisao(String decisao) {
		this.decisao = decisao;
	}
	public List<decisao> getVotosDesembargadores() {
		return votosDesembargadores;
	}
	public void setVotosDesembargadores(List<decisao> votosDesembargadores) {
		this.votosDesembargadores = votosDesembargadores;
	}
	public List<objeto> getObjetos() {
		return objetos;
	}
	public void setObjetos(List<objeto> objetos) {
		this.objetos = objetos;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public double getPenaTotal() {
		return penaTotal;
	}
	public void setPenaTotal(double penaTotal) {
		this.penaTotal = penaTotal;
	}
	public List<prova> getProvas() {
		return provas;
	}
	public void setProvas(List<prova> provas) {
		this.provas = provas;
	}
	public List<condicao> getCondicoes() {
		return condicoes;
	}
	public void setCondicoes(List<condicao> condicoes) {
		this.condicoes = condicoes;
	}
	public List<verbete> getVerbetes() {
		return verbetes;
	}
	public void setVerbetes(List<verbete> verbetes) {
		this.verbetes = verbetes;
	}
	
}
