package br.usp.fd.dpc.empirika.fluxo.extrairDadosCaso;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONObject;

import br.usp.fd.dpc.empirika.MySQLAccess;
import br.usp.fd.dpc.empirika.ontologia.caso;

public class extrator {
	public static void extrair(String s){
		caso c = new caso();
		registro(s,c);
		meioProcessual(s,c);
		sujeito(s,c);
	}
	public extrator(){}
public static void main(String args[]) throws Exception{
	MySQLAccess sql = new MySQLAccess();
	System.out.println("teste");
	System.out.println(sql.readDataBase().get(0).getSubject());
	meioProcessual(sql.readDataBase().get(0).getSubject(), new caso());
}
public static void registro(String s, caso c){

	JSONObject my_obj = new JSONObject(s);

	Pattern p = Pattern.compile("Registro: (.+?)7");
  // System.out.println(my_obj.getString("result"));
	Matcher m = p.matcher(my_obj.getString("result"));
    m.find();
    String text = m.group(1);
    c.setRegistro(text);	
    System.out.println( c.getRegistro() );
   
}
public static void meioProcessual(String s,caso c){
	Pattern p = Pattern.compile("autos do (.+?)nº");
    Matcher m = p.matcher(s);
    m.find();
    String text = m.group(1);
    c.setMeioProcessual(text);	
}
public static String numeroProcesso(String s){
	Pattern p = Pattern.compile("nº \n\n(.+?)da ");
    Matcher m = p.matcher(s);
    m.find();
    String text = m.group(1);
   return text;	
}
public static String comarca(String s){
	Pattern p = Pattern.compile("Comarca de(.+?)\\, ");
    Matcher m = p.matcher(s);
    m.find();
    String text = m.group(1);
   return text;	
}
public static void sujeito(String s, caso c){
	String text,text1;
	text = "";text1="";
	switch(c.getMeioProcessual().replace("\n","")){
	case "Apelação":
		Pattern p = Pattern.compile("Apelante: (.+?)\n ");
		Matcher m = p.matcher(s);
		m.find();
	 text  = m.group(1);
		Pattern p1 = Pattern.compile("Apelado: (.+?)\n ");
		Matcher m1 = p1.matcher(s);
		m1.find();
	 text1  = m1.group(1);
		c.setSujeitoAtivo(text);
		c.setSujeitoPassivo(text1);
	 break;
		
	case "Recurso em Sentido Estrito":
		Pattern p2 = Pattern.compile("Recorrente: (.+?)\n ");
		Matcher m2 = p2.matcher(s);
		m2.find();
	 text  = m2.group(1);
		Pattern p3 = Pattern.compile("Recorrido: (.+?)\n ");
		Matcher m3 = p3.matcher(s);
		m3.find();
	 text1  = m3.group(1);
		c.setSujeitoAtivo(text);
		c.setSujeitoPassivo(text1);
	 break;
	}   

}

/*
 * 
 *public static void main(String[] args) {
    final String str = "<tag>apple</tag><b>hello</b><tag>orange</tag><tag>pear</tag>";
    System.out.println(Arrays.toString(getTagValues(str).toArray())); // Prints [apple, orange, pear]
}

private static final Pattern TAG_REGEX = Pattern.compile("<tag>(.+?)</tag>");

private static List<String> getTagValues(final String str) {
    final List<String> tagValues = new ArrayList<String>();
    final Matcher matcher = TAG_REGEX.matcher(str);
    while (matcher.find()) {
        tagValues.add(matcher.group(1));
    }
    return tagValues;
} 
 * ?/
 */

}
