package Data;

import Logic.Persona.Direccion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class DireccionDao {

    public boolean addDireccion(String id, Direccion d) {
        try {
            String sql = "insert into direccion (idDireccion,distrito,barrio,direccionExacta)"
                    + " values(?,?,?,?)";
            PreparedStatement stm = Database.instance().prepareStatement(sql);
            stm.setString(1, id);
            stm.setString(2, d.getDistrito());
            stm.setString(3, d.getBarrio());
            stm.setString(4, d.getDireccionExacta());
            return Database.instance().executeUpdate(stm) > 0;
        } catch (SQLException e) {
            System.out.printf("No se pudo agregar direccion\n" + e.getMessage() + "\n");
            return false;
        }
    }

    public Optional<Direccion> getDireccion(String id) throws SQLException {
        String sql = "select * from direccion where idDireccion = ?";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, id);
        ResultSet rs = Database.instance().executeQuery(stm);
        Optional<Direccion> d = Optional.ofNullable(null);
        if (rs.next()) {
            Direccion d1 = new Direccion();
            d1.setBarrio(rs.getString("barrio"));
            d1.setDireccionExacta(rs.getString("direccionExacta"));
            d1.setDistrito(rs.getString("distrito"));
            d = Optional.ofNullable(d1);
        }
        return d;
    }
}
