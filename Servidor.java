
package miexamensito;
import java.io.*;
import java.net.*;

public class Servidor{

    public static void main(String[] args) {
        ServerSocket yo=null; 
        Socket cliente=null;
        BufferedReader entrada;
        DataOutputStream salida;
        String llego;
        try{
        yo= new ServerSocket(5000);
        System.out.println("El Servidor esta en linea");
        
        cliente=yo.accept();
        System.out.println("La conexion se ha establecido");
        
        entrada=new BufferedReader(new InputStreamReader(cliente.getInputStream()));
        salida= new DataOutputStream(cliente.getOutputStream());
        String x, y;
        do{
            llego=entrada.readLine();
            System.out.println("Llego "+llego);
            int num = Integer.parseInt(llego); 
            if(num%2==0){
                y ="El numerito es par";
                System.out.println(y);
            }else{
                x = "El numerito es inpar";
                System.out.println(x);}
        }while(llego.length()!=0);
        System.out.println("La conexion ha finalizado");
        
        entrada.close();
        cliente.close();
        yo.close();
        }catch(IOException e){
            System.err.println(e.getMessage());
            System.exit(1);
        }
       
        
    }
    
}

