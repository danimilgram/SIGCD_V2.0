package Logic.Persona;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.Serializable;

public class Direccion implements Serializable{

    private String distrito;
    private String barrio;
    private String direccionExacta;

    public Direccion() {
    }

    public Direccion(String distrito, String barrio, String direccionExacta) {
        this.distrito = distrito;
        this.barrio = barrio;
        this.direccionExacta = direccionExacta;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getDireccionExacta() {
        return direccionExacta;
    }

    public void setDireccionExacta(String direccionExacta) {
        this.direccionExacta = direccionExacta;
    }

    @Override
    public String toString() {
        return "Direccion{" + "distrito=" + distrito + ", barrio=" + barrio + ", direccionExacta=" + direccionExacta + '}';
    }
    
    public String toGson(){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }
}