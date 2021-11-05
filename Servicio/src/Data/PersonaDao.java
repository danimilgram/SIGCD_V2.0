package Data;

import Logic.Persona.Estudiante;
import Logic.Persona.Persona;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class PersonaDao {

    //Persona - Solicitante
    public boolean addSolicitante(Persona S) {
        try {
            String sql = "insert into solicitante (cedula,nombre,primerApellido,"
                    + "segundoApellido)"
                    + " values(?,?,?,?)";
            PreparedStatement stm = Database.instance().prepareStatement(sql);
            stm.setString(1, S.getCedula());
            stm.setString(2, S.getNombre());
            stm.setString(3, S.getPrimerApellido());
            stm.setString(4, S.getSegundoApellido());
            return Database.instance().executeUpdate(stm) > 0;
        } catch (SQLException e) {
            System.out.printf("No se pudo agregar Solicitante\n" + e.getMessage() + "\n");
            return false;
        }
    }

    public Optional<Persona> getSolicitante(String id) throws SQLException {
        String sql = "select * from solicitante where cedula = ?";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, id);
        ResultSet rs = Database.instance().executeQuery(stm);
        Optional<Persona> s = Optional.ofNullable(null);
        if (rs.next()) {
            Persona s1 = new Persona();
            s1.setCedula(rs.getString("cedula"));
            s1.setPrimerApellido(rs.getString("primerApellido"));
            s = Optional.ofNullable(s1);
        }
        return s;
    }

    //Persona - Estudiante
    public boolean addEstudiante(Estudiante E) {
        try {
            String sql = "insert into estudiante(cedula,nombre,primerApellido,"
                    + "segundoApellido,gradoAcademico,edad,fechaNacimiento,encargado)"
                    + " values(?,?,?,?,?,?,?,?)";
            PreparedStatement stm = Database.instance().prepareStatement(sql);
            this.addSolicitante(E.getEncargado());
            stm.setString(1, E.getCedula());
            stm.setString(2, E.getNombre());
            stm.setString(3, E.getPrimerApellido());
            stm.setString(4, E.getSegundoApellido());
            stm.setInt(5, E.getGradoAcademico());
            stm.setInt(6, E.getEdad());
            stm.setString(7, E.getFechaNacimiento());
            stm.setString(8, E.getEncargado().getCedula());
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
            e1.setCedula(rs.getString("cedula"));
            e1.setPrimerApellido(rs.getString("primerApellido"));
            e1.setEdad(rs.getInt("edad"));
            e1.setFechaNacimiento(rs.getString("fechaNacimiento"));
            e1.setEncargado(this.getSolicitante(rs.getString("encargado")).orElse(new Persona()));
            e = Optional.ofNullable(e1);
        }
        return e;
    }
}
