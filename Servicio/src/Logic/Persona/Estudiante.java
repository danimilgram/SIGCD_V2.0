package Logic.Persona;

import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

public class Estudiante extends Solicitante {

    private int gradoAcademico;
    private int edad;
    private String fechaNacimiento;
    private Solicitante madre;
    private Solicitante padre;

    public Estudiante() {
    }

    public Estudiante( String cedula, String nombre, String primerApellido,
            String segundoApellido, String telefonoHabitacion, String telefonoCelular,
            Direccion direccion, int gradoAcademico, int edad, String fechaNacimiento, Solicitante madre, Solicitante padre) {
        super( cedula, nombre, primerApellido, segundoApellido, telefonoHabitacion, telefonoCelular, direccion);
        this.gradoAcademico = gradoAcademico;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
        this.madre = madre;
        this.padre = padre;
    }

    public int getGradoAcademico() {
        return gradoAcademico;
    }

    public void setGradoAcademico(int gradoAcademico) {
        this.gradoAcademico = gradoAcademico;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Solicitante getMadre() {
        return madre;
    }

    public void setMadre(Solicitante madre) {
        this.madre = madre;
    }

    public Solicitante getPadre() {
        return padre;
    }

    public void setPadre(Solicitante padre) {
        this.padre = padre;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "gradoAcademico=" + gradoAcademico + ", edad=" + edad + ", fechaNacimiento=" + fechaNacimiento + ", madre=" + madre + ", padre=" + padre + '}';
    }
    
    public String toGson(){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }
}
