package Logic.Formulario;


import Logic.Persona.Solicitante;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.Serializable;
import java.sql.Timestamp;

public class AyudaTemporal extends Formulario implements Serializable{

    private Solicitante solicitante;
    private String motivoAyuda;

    public AyudaTemporal() {
    }

    public AyudaTemporal(int IdFormulario, int estado, Timestamp fechaCreacion, Solicitante solicitante, String motivoAyuda) {
        super(IdFormulario, estado, fechaCreacion);
        this.solicitante = solicitante;
        this.motivoAyuda = motivoAyuda;
    }

    public Solicitante getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Solicitante solicitante) {
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