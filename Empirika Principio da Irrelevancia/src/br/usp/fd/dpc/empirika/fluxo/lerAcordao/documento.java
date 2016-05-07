package br.usp.fd.dpc.empirika.fluxo.lerAcordao;


public class documento {
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Long getDate() {
		return date;
	}

	public void setDate(Long data) {
		this.date =  data;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	int id;
	Long date;
	String subject ;
	String file; 



	
}
