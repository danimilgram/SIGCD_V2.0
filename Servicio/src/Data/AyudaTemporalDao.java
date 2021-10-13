package Data;

import Logic.Formulario.AyudaTemporal;
import Logic.Persona.Solicitante;
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
            Optional<Solicitante> s1 = p.getSolicitante(resultSet.getString("solicitante"));
            Solicitante s = s1.orElse(new Solicitante());
            ayudaTemporal.setIdFormulario(resultSet.getInt("idAyudaTemporal"));
            ayudaTemporal.setEstado(resultSet.getInt("estado"));
            ayudaTemporal.setSolicitante(s);
            ayudaTemporal.setMotivoAyuda(resultSet.getString("motivoAyuda"));
            ayudaTemporal.setFechaCreacion(resultSet.getTimestamp("fechaCreacion"));
            return ayudaTemporal;
        } catch (SQLException ex) {
            return null;
        }
    }

    public boolean create(AyudaTemporal ayudaTemporal) throws SQLException {
        String ayudaTemporalSQL = "insert into AyudaTemporal (idAyudaTemporal,estado,solicitante,motivoAyuda,fechaCreacion)"
                + " values(?,?,?,?,?)";
        Database database = Database.instance();
        Solicitante solicitante = ayudaTemporal.getSolicitante();
        p.addSolicitante(solicitante);
        PreparedStatement preparedStatementAT;
        preparedStatementAT = database.getConnection().prepareStatement(ayudaTemporalSQL);
        preparedStatementAT.setInt(1, ayudaTemporal.getIdFormulario());
        preparedStatementAT.setInt(2, ayudaTemporal.getEstado());
        preparedStatementAT.setString(3, solicitante.getCedula());
        preparedStatementAT.setString(4, ayudaTemporal.getMotivoAyuda());
        preparedStatementAT.setTimestamp(5, ayudaTemporal.getFechaCreacion());
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
}
