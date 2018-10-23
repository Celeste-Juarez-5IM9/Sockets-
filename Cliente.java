
package miexamensito;
import java.io.*;
import java.net.*;
public class Cliente {
    public static void main(String[] comandos){
        Socket yo = null;
        PrintWriter alservidor;
        BufferedReader delteclado;
        DataInputStream delservidor;
        String teclado;
        
        try{
            try{
            yo = new Socket("localhost" , 5000);
            
        }catch(UnknownHostException e){
            System.out.println(e.getMessage());
            System.exit(1);
        }
        
        System.out.println("Ya se conecto el cliente");
        delteclado = new BufferedReader(new InputStreamReader(System.in));
        alservidor = new PrintWriter(yo.getOutputStream(),true);
        delservidor = new DataInputStream(yo.getInputStream());
        
        
        do{
            System.out.println("Digita un numero: ");
            teclado=delteclado.readLine();
            alservidor.println(teclado);
            
        }while(teclado.length()!=0);
        
        System.out.println("Ya termino de enviar");
        
        delservidor.close();
        delteclado.close();
        alservidor.close();
        yo.close();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
    
    
    
    

    private Reader InputStreamReader(InputStream in) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
