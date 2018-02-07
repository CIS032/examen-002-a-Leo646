import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author leonardo
 */
public class ListaProfesores {
    
    ArrayList<Profesor> lista = new ArrayList<>();

    public void agregar(Profesor profe) {
        lista.add(profe);
    }

    public String listar() {
        String out = "";
        for (Profesor profesor : lista) {
            out += profesor + "\n";
        }
        return out;
    }

    public void grabar() {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(new File("Lista.csv"), true));
            //pw.println("CEDULA;NOMBRES;APELLIDOS;TIPO PROFESOR;HORAS CLASE;HORAS COMPLEMENTARIAS");
            for (Profesor profesor : lista) {
                String out = profesor.getCedula() + ";" + profesor.getNombres() + ";" + profesor.getApellidos() + ";";
                if (profesor instanceof ProfesorTiempoCompleto) {
                    out += "Tiepo completo";
                }
                if (profesor instanceof ProfesorMedioTiempo) {
                    out += "Medio timepo";
                }
                if (profesor instanceof ProfesorTiempoParcial) {
                    out += "Tiempo Parcial";
                }
                out += ";" + profesor.getHorasClase() + ";" + profesor.horasComplementarias();
                pw.println(out);
            }
            pw.close();
        } catch (IOException ex) {
            Logger.getLogger(ListaProfesores.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static String leer(){
        String temp = "";
        String aux;
        try {
            BufferedReader leer = new BufferedReader(new FileReader("Lista.csv"));
            while ((aux = leer.readLine()) != null) {
                temp += aux + "\n";
            }
            System.out.println("Figuras:\n" + temp);
            
        } catch (Exception e) {
        }
        return temp;
    }
    
}
