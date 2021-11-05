package Data;

import Logic.Formulario.BecaMunicipal;
import Logic.Persona.Direccion;
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
        OBecaMunicipal.setDireccion(d.getDireccion(resultSet.getInt("idBecaMunicipal")).orElse(new Direccion()));
        OBecaMunicipal.setEstado(resultSet.getInt("estado"));
        OBecaMunicipal.setFechaCreacion(resultSet.getTimestamp("fechaCreacion"));
        OBecaMunicipal.setIdFormulario(resultSet.getInt("idBecaMunicipal"));
        OBecaMunicipal.setTelefonoCelular(resultSet.getString("TelefonoCelular"));
        OBecaMunicipal.setTelefonoHabitacion(resultSet.getString("TelefonoHabitacion"));
        Optional<BecaMunicipal> bm = Optional.ofNullable(OBecaMunicipal);
        return bm;

    }

    public boolean create(BecaMunicipal OBecaMunicipal) throws SQLException {
        String sql = "insert into becaMunicipal (estudiante,estado,fechaCreacion,"
                + "idBecaMunicipal,TelefonoCelular,TelefonoHabitacion)"
                + " values(?,?,?,?,?,?)";
        PreparedStatement ps = Database.instance().prepareStatement(sql);
        p.addEstudiante(OBecaMunicipal.getEstudiante());
        d.addDireccion(OBecaMunicipal.getIdFormulario(), OBecaMunicipal.getDireccion());
        ps.setString(1, OBecaMunicipal.getEstudiante().getCedula());
        ps.setInt(2, OBecaMunicipal.getEstado());
        ps.setTimestamp(3, OBecaMunicipal.getFechaCreacion());
        ps.setInt(4, OBecaMunicipal.getIdFormulario());
        ps.setString(5, OBecaMunicipal.getTelefonoCelular());
        ps.setString(6, OBecaMunicipal.getTelefonoHabitacion());
        if (ps.executeUpdate() > 0) {
            return true;
        }
        return false;
    }

    private final PersonaDao p = new PersonaDao();
    private final DireccionDao d = new DireccionDao();
}
