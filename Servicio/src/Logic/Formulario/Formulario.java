package Logic.Formulario;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.Serializable;
import java.sql.Timestamp;

public class Formulario implements Serializable{

    private int IdFormulario;
    private int estado;
    private Timestamp fechaCreacion;

    public Formulario() {
    }

    public Formulario(int IdFormulario, int estado, Timestamp fechaCreacion) {
        this.IdFormulario = IdFormulario;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
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

    @Override
    public String toString() {
        return "Formulario{" + "Id=" + IdFormulario + ", estado=" + estado + ", fechaCreacion=" + fechaCreacion + '}';
    }

    public String toGson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }
}
