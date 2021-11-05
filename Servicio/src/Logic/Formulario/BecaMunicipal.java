package Logic.Formulario;

import Logic.Persona.Direccion;
import Logic.Persona.Estudiante;
import java.sql.Timestamp;
import com.google.gson.GsonBuilder;
import com.google.gson.Gson;
import java.io.Serializable;

public class BecaMunicipal extends Formulario implements Serializable{

    private Estudiante estudiante;

    public BecaMunicipal() {
    }

    public BecaMunicipal(int IdFormulario, int estado, Timestamp fechaCreacion,
            Estudiante estudiante, String celular, String telefono, Direccion direccion) {
        super(IdFormulario, estado, fechaCreacion,celular,telefono,direccion);
        this.estudiante = estudiante;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    @Override
    public String toString() {
        return "BecaMunicipal{id=" + super.getIdFormulario() + ",estudiante=" + estudiante.toString() + ",estado=" + super.getEstado() + '}';
    }
    
    public String toGson(){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }
    
}

