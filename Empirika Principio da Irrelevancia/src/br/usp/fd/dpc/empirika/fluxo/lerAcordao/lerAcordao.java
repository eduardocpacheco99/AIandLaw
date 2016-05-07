package br.usp.fd.dpc.empirika.fluxo.lerAcordao;

import java.io.BufferedReader;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import br.usp.fd.dpc.empirika.MySQLAccess;
 
 
public class lerAcordao {
 
    static public class MultipartUtility {
        private final String boundary;
        private static final String LINE_FEED = "\r\n";
        private HttpURLConnection httpConn;
        private String charset;
        private OutputStream outputStream;
        private PrintWriter writer;
 
        /**
         * This constructor initializes a new HTTP POST request with content type
         * is set to multipart/form-data
         * @param requestURL
         * @param charset
         * @throws IOException
         */
        public MultipartUtility(String requestURL, String charset, String token)
                throws IOException {
            this.charset = charset;
 
            // creates a unique boundary based on time stamp
            boundary = "===" + System.currentTimeMillis() + "===";
 
            URL url = new URL(requestURL);
            httpConn = (HttpURLConnection) url.openConnection();
            httpConn.setUseCaches(false);
            httpConn.setDoOutput(true); // indicates POST method
            httpConn.setDoInput(true);
            httpConn.setRequestProperty("Content-Type",
                    "multipart/form-data; boundary=" + boundary);
            httpConn.setRequestProperty("User-Agent", "CodeJava Agent");
            httpConn.setRequestProperty("Authorization", token);
            outputStream = httpConn.getOutputStream();
            writer = new PrintWriter(new OutputStreamWriter(outputStream, charset),
                    true);
        }
 
        /**
         * Adds a form field to the request
         * @param name field name
         * @param value field value
         */
        public void addFormField(String name, String value) {
            writer.append("--" + boundary).append(LINE_FEED);
            writer.append("Content-Disposition: form-data; name=\"" + name + "\"")
                    .append(LINE_FEED);
            writer.append("Content-Type: text/plain; charset=" + charset).append(
                    LINE_FEED);
            writer.append(LINE_FEED);
            writer.append(value).append(LINE_FEED);
            writer.flush();
        }
 
        /**
         * Adds a upload file section to the request
         * @param fieldName name attribute in <input type="file" name="..." />
         * @param uploadFile a File to be uploaded
         * @throws IOException
         */
        public void addFilePart(String fieldName, File uploadFile)
                throws IOException {
            String fileName = uploadFile.getName();
            writer.append("--" + boundary).append(LINE_FEED);
            writer.append(
                    "Content-Disposition: form-data; name=\"" + fieldName
                            + "\"; filename=\"" + fileName + "\"")
                    .append(LINE_FEED);
            writer.append(
                    "Content-Type: "
                            + URLConnection.guessContentTypeFromName(fileName))
                    .append(LINE_FEED);
            writer.append("Content-Transfer-Encoding: binary").append(LINE_FEED);
            writer.append(LINE_FEED);
            writer.flush();
 
            FileInputStream inputStream = new FileInputStream(uploadFile);
            byte[] buffer = new byte[4096];
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.flush();
            inputStream.close();
 
            writer.append(LINE_FEED);
            writer.flush();
        }
 
        /**
         * Adds a header field to the request.
         * @param name - name of the header field
         * @param value - value of the header field
         */
        public void addHeaderField(String name, String value) {
            writer.append(name + ": " + value).append(LINE_FEED);
            writer.flush();
        }
 
        /**
         * Completes the request and receives response from the server.
         * @return a list of Strings as response in case the server returned
         * status OK, otherwise an exception is thrown.
         * @throws IOException
         */
        public List<String> finish() throws IOException {
            List<String> response = new ArrayList<String>();
 
            writer.append(LINE_FEED).flush();
            writer.append("--" + boundary + "--").append(LINE_FEED);
            writer.close();
 
            // checks server's status code first
            int status = httpConn.getResponseCode();
            if (status == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(
                        httpConn.getInputStream()));
                String line = null;
                while ((line = reader.readLine()) != null) {
                    response.add(line);
                }
                reader.close();
                httpConn.disconnect();
            } else {
                throw new IOException("Server returned non-OK status: " + status);
            }
 
            return response;
        }
    }
 
    public static void main(String[] args) throws Exception {
        String charset = "UTF-8";
        String requestURL = "https://api.monkeylearn.com/v2/extractors/ex_8tMs2MDB/extract/";
        String nome = "C:/arquivos.txt";
        List<String> arquivos = new ArrayList<String>();
        
        
        try { 
        	FileReader arq = new FileReader(nome);
        BufferedReader lerArq = new BufferedReader(arq);
        String linha = lerArq.readLine();
        // lê a primeira linha // a variável "linha" recebe o valor "null" quando o processo // de repetição atingir o final do arquivo texto 
        while (linha != null) { 
        	System.out.printf("%s\n", linha); 
        	linha = lerArq.readLine(); 
        	arquivos.add(linha);
        	// lê da segunda até a última linha 
        } arq.close(); } catch (IOException e) { System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage()); }
        
        
        	
        
        for (String arq : arquivos){
        	  File uploadFile1 = new File("C://Users//Du//Documents//Edu//Pesquisa preliminar///"+arq);
              
        	System.out.println(arq);
        	 documento documento = new documento();
             documento.setFile(uploadFile1.getAbsolutePath());
             documento.setSubject("");
            
        	try {
            MultipartUtility multipart = new MultipartUtility(requestURL, charset, "Token b717276704fcbaf1e54421814e8d92ddb7b1d3ef");
 
            multipart.addFormField("name", "file");
            multipart.addFormField("filename", "C://Users//Du//Documents//Edu//Pesquisa preliminar///"+arq);
 
            multipart.addFilePart("file", uploadFile1);
 
            List<String> response = multipart.finish();
 
            System.out.println("SERVER REPLIED:");
 
            for (String line : response) {
 
         System.out.println(documento.getId());
         documento.setSubject(documento.getSubject() + unescapeJava(line));
            	
            	 }
        } catch (IOException ex) {
            System.err.println(ex);
        }
        
 //System.out.println("resultado final de documento: " + documento.getSubject());
        MySQLAccess dao = new MySQLAccess();
    dao.writeDataBase(documento);
        
   //  for(documentoBean doc :   dao.readDataBase() ){
    //	 System.out.println(doc.getSubject());
    
     //}
        }
        
    }
    
    public static String unescapeJava(String escaped) {
        if(escaped.indexOf("\\u")==-1)
            return escaped;

        String processed="";

        int position=escaped.indexOf("\\u");
        while(position!=-1) {
            if(position!=0)
                processed+=escaped.substring(0,position);
            String token=escaped.substring(position+2,position+6);
            escaped=escaped.substring(position+6);
            processed+=(char)Integer.parseInt(token,16);
            position=escaped.indexOf("\\u");
        }
        processed+=escaped;

        return processed;
    }
}
 
