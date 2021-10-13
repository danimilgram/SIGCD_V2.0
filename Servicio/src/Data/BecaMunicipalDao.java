package Data;

import Logic.Formulario.BecaMunicipal;
import Logic.Persona.Estudiante;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

public class BecaMunicipalDao {

    public Optional<BecaMunicipal> read(int id) throws Exception {
        String sql = "select * from becaMunicipal where idBecaMunicipal = ?";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setInt(1, id);
        ResultSet resultSet = Database.instance().executeQuery(stm);
        Optional<BecaMunicipal> bm = Optional.ofNullable(null);
        if (resultSet.next()) {
            return from(resultSet);
        } else {
            return bm;
        }
    }

    public Optional<BecaMunicipal> from(ResultSet resultSet) throws SQLException {
        BecaMunicipal OBecaMunicipal = new BecaMunicipal();
        OBecaMunicipal.setEstudiante(p.getEstudiante(resultSet.getString("estudiante")).orElse(new Estudiante()));
        OBecaMunicipal.setEstado(resultSet.getInt("estado"));
        OBecaMunicipal.setFechaCreacion(resultSet.getTimestamp("fechaCreacion"));
        OBecaMunicipal.setIdFormulario(resultSet.getInt("idBecaMunicipal"));
        Optional<BecaMunicipal> bm = Optional.ofNullable(OBecaMunicipal);
        return bm;

    }

    public boolean create(BecaMunicipal OBecaMunicipal) throws SQLException {
        String sql = "insert into becaMunicipal (estudiante,estado,fechaCreacion,idBecaMunicipal)"
                + " values(?,?,?,?)";
        PreparedStatement ps = Database.instance().prepareStatement(sql);
        p.addEstudiante(OBecaMunicipal.getEstudiante());
        ps.setString(1, OBecaMunicipal.getEstudiante().getCedula());
        ps.setInt(2, OBecaMunicipal.getEstado());
        ps.setTimestamp(3, OBecaMunicipal.getFechaCreacion());
        ps.setInt(4, OBecaMunicipal.getIdFormulario());
        if (ps.executeUpdate() > 0) {
            return true;
        }
        return false;
    }

//    public ArrayList<BecaMunicipal> readAll() throws Exception {
//        String sql = "SELECT * from pelicula;";
//        PreparedStatement stm = Database.instance().prepareStatement(sql);
//        ResultSet resultSet = Database.instance().executeQuery(stm);
//        ArrayList<BecaMunicipal> listaBecaMunicipal = new ArrayList<BecaMunicipal>();
//        while (resultSet.next()) {
//            listaBecaMunicipal.add(from(resultSet));
//        }
//        return listaBecaMunicipal;
//    }
//
//    public void close() {
//    }
    private final PersonaDao p = new PersonaDao();
}
