/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author leonardo
 */
public class ProfesorTiempoParcial extends Profesor {
    public ProfesorTiempoParcial(String cedula, String nombres, String apellidos, int horasClase, String carrera, int horaSemanales) {
        super(cedula, nombres, apellidos, horasClase, carrera);
        this.horaSemanales = horaSemanales;
    }

    private int horaSemanales;

    public int getHoraSemanales() {
        return horaSemanales;
    }

    public void setHoraSemanales(int horaSemanales) {
        this.horaSemanales = horaSemanales;
    }

    @Override
    public int horasComplementarias() {
        //horas semanales - horas clase
        return this.getHoraSemanales() - this.getHorasClase();
    }
@Override
    public String toString() {
        return this.getCedula() + " - " + this.getNombres() + " " + this.getApellidos()+ " - " + this.getCarrera() + " - " + this.getHorasClase() + " -> Tiempo Parcial";
    }
}
