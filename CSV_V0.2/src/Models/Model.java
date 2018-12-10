
package Models;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Views.View;

public class Model {
    
    private String nombre = "";
    private String email = "";
    private String path = "C:\\Users\\76053\\Documents\\Escuela";
    boolean bandera = true;
    private int fila = 0;
    private int posicion = 0;
    ArrayList <String> agenda = new ArrayList <String>();
    
    View view;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    
}
    
    public void readFile(){
        try{
                String row; 
            try (FileReader file = new FileReader(path); BufferedReader bufferedReader = new BufferedReader(file)){
                while ((row = bufferedReader.readLine()) != null){    
                    agenda.add(row);
                }
                bufferedReader.close();
            } 
        }catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(view,"No se econtró el archivo" + ex.getMessage());
        } catch (IOException ex) {
                JOptionPane.showMessageDialog(view,"Error" + ex.getMessage());
        }
    
    }
    
    public void primero(){
            String lista = agenda.get(fila);
            String datos [] = lista.split(",");
            posicion = fila;
            nombre = datos[0];
            email = datos[1];
    }
    
    public void anterior(){
        if (posicion > 0){
            posicion = posicion -1;
            String lista = agenda.get(posicion);
            String datos [] = lista.split(",");
            nombre = datos[0];
            email = datos[1];
        }
        else{
             JOptionPane.showMessageDialog(view, "Primer registro");
        }
    }
    public void siguiente(){
        if (posicion < (agenda.size()-1)){
            posicion = posicion + 1;
            String lista = agenda.get(posicion);
            String datos [] = lista.split(",");
            nombre = datos[0];
            email = datos[1];
        }
        else{
             JOptionPane.showMessageDialog(view, "Ultimo registro");
        }
    }
    
    public void ultimo(){
        int ultimo = (agenda.size()-1);
        String lista = agenda.get(ultimo);
        String datos [] = lista.split(",");
        posicion = ultimo;
        nombre = datos[0];
        email = datos[1];
    }
    
    
public void writeFile(){
        try{
                File file = new File(path);
                FileWriter fileWriter = new FileWriter (file,bandera);
                try (PrintWriter printWriter  = new PrintWriter(fileWriter)){
                        printWriter.println(nombre + "," + email);
                        printWriter.close();
                        JOptionPane.showMessageDialog(view,"Se modificó correctamente");
            }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(view,"Error" + ex.getMessage());
                }
            }
    }

