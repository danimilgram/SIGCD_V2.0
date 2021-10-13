

import Logic.Formulario.BecaMunicipal;
import java.sql.SQLException;
import java.util.Optional;



public class application {


    public static void main(String[] args) throws SQLException, Exception {
        Optional<BecaMunicipal> bm = Data.Data.obtenerInstancia().getBecaMunicipal(678952802);
        if(bm.isPresent() )
            System.out.println("Existe");
        else
            System.out.println("No existe");
    }
    
}
