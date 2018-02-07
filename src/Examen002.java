import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author leonardo
 */
public class Examen002 {
    public static void main(String[] args) {
        // TODO code application logic here
        ListaProfesores lista = new ListaProfesores();
        int opt;
        do {
            opt = Integer.parseInt(JOptionPane.showInputDialog("MENÚ\n"
                    + "1. Agregar docente\n"
                    + "2. Lista de docentes\n"
                    + "3. Grabar\n"
                    + "4. Salir"));
            switch (opt) {
                case 1: //Agregar docente
                    String tipos[] = {"Tiempo Completo", "Medio Tiempo", "Tiempo Parcial"};
                    int tipo = JOptionPane.showOptionDialog(null, "Seleccione el tipo de docente", "TIPO DOCENTE", 0, JOptionPane.QUESTION_MESSAGE, new ImageIcon(), tipos, tipos[0]);
                    String nombres = JOptionPane.showInputDialog("Ingrese el nombre del docente");
                    String apellidos = JOptionPane.showInputDialog("Ingrese el apellido del docente " + nombres);
                    String cedula = JOptionPane.showInputDialog("Ingrese la cedula del docente " + nombres + " " + apellidos);
                    String carrera = ("Ingrese la carrera en la que imparte el/la docente " + nombres + " " + apellidos);
                    if (tipo == 0) {
                        int horasClase = Integer.parseInt(JOptionPane.showInputDialog("Ingrese las horas que imparte el/la docente " + nombres + " " + apellidos + "\n estas deben ser de 3 a 16 horas "));
                        if (horasClase > 2 & horasClase < 17) {
                            lista.agregar(new ProfesorTiempoCompleto(cedula, nombres, apellidos, horasClase, carrera));
                        } else {
                            JOptionPane.showMessageDialog(null, "El docente de tiempo completo debe impartir desde 3 horas hasta 16 horas clase", "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    if (tipo == 1) {
                        int horasClase = Integer.parseInt(JOptionPane.showInputDialog("Ingrese las horas que imparte el/la docente " + nombres + " " + apellidos + "\n estas deben ser 10 horas "));
                        if (horasClase == 10) {
                            lista.agregar(new ProfesorMedioTiempo(cedula, nombres, apellidos, horasClase, carrera));
                        } else {
                            JOptionPane.showMessageDialog(null, "El docente de medio tiempo debe impartir 10 horas clase", "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    if (tipo == 2) {
                        int horasSemanales = Integer.parseInt(JOptionPane.showInputDialog("Ingrese las horas semanales de trabajo del docente " + nombres + " " + apellidos + "\n estas deben ser menos de 20 horas Semanales"));
                        int horasClase = Integer.parseInt(JOptionPane.showInputDialog("Ingrese las horas que imparte el/la docente " + nombres + " " + apellidos + "\n estas deben ser de 2 a 9 horas "));
                        if ((horasClase > 1 & horasClase < 10) & horasSemanales < 20) {
                            lista.agregar(new ProfesorTiempoParcial(cedula, nombres, apellidos, horasClase, carrera, horasSemanales));
                        } else {
                            JOptionPane.showMessageDialog(null, "El docente de tiempo parcial trabaja menos de 20 horas a la semana y debe impartir de 2 a 9 horas clase.", "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    break;
                case 2: //Lista de docentes
                    System.out.println(lista.listar());
                    break;
                case 3: //grabar
                    lista.grabar();
                case 4: //salir
                    lista.grabar();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Seleccione una opcion que este dentro del menú", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } while (opt != 4);
    }
}
