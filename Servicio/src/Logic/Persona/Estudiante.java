package Logic.Persona;

import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

public class Estudiante extends Persona{

    private int gradoAcademico;
    private int edad;
    private String fechaNacimiento;
    private Persona encargado;

    public Estudiante() {
    }

    public Estudiante( String cedula, String nombre, String primerApellido,
            String segundoApellido,int gradoAcademico, int edad, String fechaNacimiento,Persona encargado) {
        super( cedula, nombre, primerApellido, segundoApellido);
        this.gradoAcademico = gradoAcademico;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
        this.encargado = encargado;
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

    public Persona getEncargado() {
        return encargado;
    }

    public void setEncargado(Persona encargado) {
        this.encargado = encargado;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "gradoAcademico=" + gradoAcademico + ", edad=" + edad + ", fechaNacimiento=" + fechaNacimiento + ", encargado=" + encargado + '}';
    }
    
    public String toGson(){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }
}
