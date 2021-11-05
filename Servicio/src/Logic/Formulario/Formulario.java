package Logic.Formulario;

import Logic.Persona.Direccion;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.Serializable;
import java.sql.Timestamp;

public class Formulario implements Serializable{

    private int IdFormulario;
    private int estado;
    private Timestamp fechaCreacion;
    private String telefonoHabitacion;
    private String telefonoCelular;
    private Direccion direccion;

    public Formulario() {
    }

    public Formulario(int IdFormulario, int estado, Timestamp fechaCreacion,String celular, String telefono, Direccion direccion) {
        this.IdFormulario = IdFormulario;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.telefonoCelular = celular;
        this.telefonoHabitacion = telefono;
        this.direccion = direccion;
    }

    public int getIdFormulario() {
        return IdFormulario;
    }

    public void setIdFormulario(int IdFormulario) {
        this.IdFormulario = IdFormulario;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
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
        return "Formulario{" + "Id=" + IdFormulario + ", estado=" + estado + ", fechaCreacion=" + fechaCreacion + '}';
    }

    public String toGson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }
}
