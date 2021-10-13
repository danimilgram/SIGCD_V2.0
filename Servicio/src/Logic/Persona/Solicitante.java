package Logic.Persona;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.Serializable;

public class Solicitante extends Persona implements Serializable{

    private String telefonoHabitacion;
    private String telefonoCelular;
    private Direccion direccion;

    public Solicitante() {
    }

    public Solicitante(String cedula, String nombre, String primerApellido, String segundoApellido, String telefonoHabitacion, String telefonoCelular, Direccion direccion) {
        super(cedula, nombre, primerApellido, segundoApellido);
        this.telefonoHabitacion = telefonoHabitacion;
        this.telefonoCelular = telefonoCelular;
        this.direccion = direccion;
    }

    public String getTelefonoHabitacion() {
        return telefonoHabitacion;
    }

    public void setTelefonoHabitacion(String telefonoHabitacion) {
        this.telefonoHabitacion = telefonoHabitacion;
    }

    public String getTelefonoCelular() {
        return telefonoCelular;
    }

    public void setTelefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Solicitante{" + "telefonoHabitacion=" + telefonoHabitacion + ", telefonoCelular=" + telefonoCelular + ", direccion=" + direccion.toString() + '}';
    }

    public String toGson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }
}
