package Data;

import Logic.Formulario.AyudaTemporal;
import Logic.Formulario.BecaMunicipal;
import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Data {
    
    public static Data obtenerInstancia(){
       return instancia = instancia == null ? new Data() : instancia;
    }
    
    
    public Optional<AyudaTemporal> getAyudaTemporal(int id){
        try{
            return Optional.ofNullable(at.read(id));
        }catch(Exception e ){
            System.err.println(e.getMessage());
            return Optional.ofNullable(null);
        }
    } 
    
    public boolean setAyudaTemporal(AyudaTemporal tem){
        try{
            return at.create(tem);
        }catch(SQLException e){
            System.err.println(e.getMessage());
            return false;
        }
    }
    
    public Optional<BecaMunicipal> getBecaMunicipal(int id){
        try {
            return bm.read(id);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return Optional.ofNullable(null);
        }
    } 
    
    public boolean setBecaMunicipal(BecaMunicipal tem){
        try{
            return bm.create(tem);
        }catch(SQLException e){
            System.err.println(e.getMessage());
            return false;
        }
    }
    
    
    private static Data instancia;
    private final AyudaTemporalDao at = new AyudaTemporalDao();
    private final BecaMunicipalDao bm = new BecaMunicipalDao();
}
