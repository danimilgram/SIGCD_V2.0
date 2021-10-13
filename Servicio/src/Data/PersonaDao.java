package Data;

import Logic.Persona.Direccion;
import Logic.Persona.Estudiante;
import Logic.Persona.Solicitante;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class PersonaDao {

    //Persona - Solicitante
    public boolean addSolicitante(Solicitante S) {
        try {
            String sql = "insert into solicitante (cedula,nombre,primerApellido,"
                    + "segundoApellido,telefonoHabitacion,telefonoCelular,direccion)"
                    + " values(?,?,?,?,?,?,?)";
            PreparedStatement stm = Database.instance().prepareStatement(sql);
            dd.addDireccion(S.getCedula(), S.getDireccion());
            stm.setString(1, S.getCedula());
            stm.setString(2, S.getNombre());
            stm.setString(3, S.getPrimerApellido());
            stm.setString(4, S.getSegundoApellido());
            stm.setString(5, S.getTelefonoHabitacion());
            stm.setString(6, S.getTelefonoCelular());
            stm.setString(7, S.getCedula());
            return Database.instance().executeUpdate(stm) > 0;
        } catch (SQLException e) {
            System.out.printf("No se pudo agregar Solicitante\n" + e.getMessage() + "\n");
            return false;
        }
    }

    public Optional<Solicitante> getSolicitante(String id) throws SQLException {
        String sql = "select * from solicitante where cedula = ?";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, id);
        ResultSet rs = Database.instance().executeQuery(stm);
        Optional<Solicitante> s = Optional.ofNullable(null);
        if (rs.next()) {
            Solicitante s1 = new Solicitante();
            Direccion d = dd.getDireccion(id).orElse(new Direccion());
            s1.setCedula(rs.getString("cedula"));
            s1.setPrimerApellido(rs.getString("primerApellido"));
            s1.setTelefonoHabitacion(rs.getString("telefonoHabitacion"));
            s1.setTelefonoCelular(rs.getString("telefonoCelular"));
            s1.setDireccion(d);
            s = Optional.ofNullable(s1);
        }
        return s;
    }

    //Persona - Estudiante
    public boolean addEstudiante(Estudiante E) {
        try {
            String sql = "insert into estudiante(cedula,nombre,primerApellido,"
                    + "segundoApellido,telefonoHabitacion,telefonoCelular,direccion,gradoAcademico,edad,fechaNacimiento,madre,padre)"
                    + " values(?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stm = Database.instance().prepareStatement(sql);
            dd.addDireccion(E.getCedula(), E.getDireccion());
            this.addSolicitante(E.getMadre());
            this.addSolicitante(E.getPadre());
            stm.setString(1, E.getCedula());
            stm.setString(2, E.getNombre());
            stm.setString(3, E.getPrimerApellido());
            stm.setString(4, E.getSegundoApellido());
            stm.setString(5, E.getTelefonoHabitacion());
            stm.setString(6, E.getTelefonoCelular());
            stm.setString(7, E.getCedula());
            stm.setInt(8, E.getGradoAcademico());
            stm.setInt(9, E.getEdad());
            stm.setString(10, E.getFechaNacimiento());
            stm.setString(11, E.getMadre().getCedula());
            stm.setString(12, E.getPadre().getCedula());
            return Database.instance().executeUpdate(stm) > 0;
        } catch (SQLException e) {
            System.out.printf("No se pudo agregar Estudiante\n" + e.getMessage() + "\n");
            return false;
        }
    }

    public Optional<Estudiante> getEstudiante(String id) throws SQLException {
        String sql = "select * from estudiante where cedula = ?";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, id);
        ResultSet rs = Database.instance().executeQuery(stm);
        Optional<Estudiante> e = Optional.ofNullable(null);
        if (rs.next()) {
            Estudiante e1 = new Estudiante();
            Direccion d = dd.getDireccion(id).orElse(new Direccion());
            e1.setCedula(rs.getString("cedula"));
            e1.setPrimerApellido(rs.getString("primerApellido"));
            e1.setTelefonoHabitacion(rs.getString("telefonoHabitacion"));
            e1.setTelefonoCelular(rs.getString("telefonoCelular"));
            e1.setDireccion(d);
            e1.setEdad(rs.getInt("edad"));
            e1.setFechaNacimiento(rs.getString("fechaNacimiento"));
            e1.setMadre(this.getSolicitante(rs.getString("madre")).orElse(new Solicitante()));
            e1.setPadre(this.getSolicitante(rs.getString("padre")).orElse(new Solicitante()));
            e = Optional.ofNullable(e1);
        }
        return e;
    }

    private final DireccionDao dd = new DireccionDao();
}
