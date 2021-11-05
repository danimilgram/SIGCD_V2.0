package Logic.Formulario;


import Logic.Persona.Direccion;
import Logic.Persona.Persona;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.Serializable;
import java.sql.Timestamp;

public class AyudaTemporal extends Formulario implements Serializable{

    private Persona solicitante;
    private String motivoAyuda;

    public AyudaTemporal() {
    }

    public AyudaTemporal(int IdFormulario, int estado, Timestamp fechaCreacion, Persona solicitante, String motivoAyuda,
            String celular, String telefono, Direccion direccion) {
        super(IdFormulario, estado, fechaCreacion,celular,telefono,direccion);
        this.solicitante = solicitante;
        this.motivoAyuda = motivoAyuda;
    }

    public Persona getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Persona solicitante) {
        this.solicitante = solicitante;
    }

    public String getMotivoAyuda() {
        return motivoAyuda;
    }

    public void setMotivoAyuda(String motivoAyuda) {
        this.motivoAyuda = motivoAyuda;
    }

    @Override
    public String toString() {
        return "AyudaTemporal{" + "solicitante=" + solicitante + ", motivoAyuda=" + motivoAyuda + '}';
    }

    public String toGson(){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }
}