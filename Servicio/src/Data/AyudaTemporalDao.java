package Data;

import Logic.Formulario.AyudaTemporal;
import Logic.Persona.Direccion;
import Logic.Persona.Persona;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class AyudaTemporalDao {

    public AyudaTemporal read(int idAyudaTemporal) throws Exception {
        String sql = "select * from AyudaTemporal where idAyudaTemporal=?";
        PreparedStatement preparedStatement = Database.instance().prepareStatement(sql);
        preparedStatement.setInt(1, idAyudaTemporal);
        ResultSet resultSet = Database.instance().executeQuery(preparedStatement);
        if (resultSet.next()) {
            return from(resultSet);
        } else {
            return null;
        }
    }

    public AyudaTemporal from(ResultSet resultSet) {
        try {
            AyudaTemporal ayudaTemporal = new AyudaTemporal();
            Optional<Persona> s1 = p.getSolicitante(resultSet.getString("solicitante"));
            Optional<Direccion> d1 = d.getDireccion(resultSet.getInt("idAyudaTemporal"));
            Persona s = s1.orElse(new Persona());
            ayudaTemporal.setIdFormulario(resultSet.getInt("idAyudaTemporal"));
            ayudaTemporal.setEstado(resultSet.getInt("estado"));
            ayudaTemporal.setSolicitante(s);
            ayudaTemporal.setMotivoAyuda(resultSet.getString("motivoAyuda"));
            ayudaTemporal.setFechaCreacion(resultSet.getTimestamp("fechaCreacion"));
            ayudaTemporal.setTelefonoCelular(resultSet.getString("TelefonoCelular"));
            ayudaTemporal.setTelefonoHabitacion(resultSet.getString("TelefonoHabitacion"));
            ayudaTemporal.setDireccion(d1.orElse(new Direccion()));
            return ayudaTemporal;
        } catch (SQLException ex) {
            return null;
        }
    }

    public boolean create(AyudaTemporal ayudaTemporal) throws SQLException {
        String ayudaTemporalSQL = "insert into AyudaTemporal (idAyudaTemporal,estado,solicitante,motivoAyuda,fechaCreacion,"
                + "TelefonoHabitacion,TelefonoCelular)"
                + " values(?,?,?,?,?,?,?)";
        Database database = Database.instance();
        Persona solicitante = ayudaTemporal.getSolicitante();
        p.addSolicitante(solicitante);
        d.addDireccion(ayudaTemporal.getIdFormulario(), ayudaTemporal.getDireccion());
        PreparedStatement preparedStatementAT;
        preparedStatementAT = database.getConnection().prepareStatement(ayudaTemporalSQL);
        preparedStatementAT.setInt(1, ayudaTemporal.getIdFormulario());
        preparedStatementAT.setInt(2, ayudaTemporal.getEstado());
        preparedStatementAT.setString(3, solicitante.getCedula());
        preparedStatementAT.setString(4, ayudaTemporal.getMotivoAyuda());
        preparedStatementAT.setTimestamp(5, ayudaTemporal.getFechaCreacion());
        preparedStatementAT.setString(6, ayudaTemporal.getTelefonoHabitacion());
        preparedStatementAT.setString(7, ayudaTemporal.getTelefonoCelular());
        return preparedStatementAT.executeUpdate() > 0;
    }

    public ArrayList<AyudaTemporal> readAll() throws Exception {
        String sql = "SELECT * from AyudaTemporal";
        PreparedStatement preparedStatement = Database.instance().prepareStatement(sql);
        ResultSet resultSet = Database.instance().executeQuery(preparedStatement);
        ArrayList<AyudaTemporal> listaAyudaTemporal = new ArrayList<AyudaTemporal>();
        while (resultSet.next()) {
            listaAyudaTemporal.add(from(resultSet));
        }
        return listaAyudaTemporal;
    }

    private final PersonaDao p = new PersonaDao();
    private final DireccionDao d = new DireccionDao();
}
