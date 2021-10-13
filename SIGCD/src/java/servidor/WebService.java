package servidor;

import Data.Data;
import com.google.gson.Gson;
import java.util.Optional;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import org.json.JSONException;
import org.json.JSONObject;


@Path("ws")
public class WebService {

    @Context
    private UriInfo context;

    public WebService() {
        data = Data.obtenerInstancia();
    }

    @GET
    @Path("/datosJSON/{id}")
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public String getJson(@PathParam("id") int id) throws JSONException {
        JSONObject resultado = new JSONObject();
        System.out.println(id);
        Optional<Logic.Formulario.AyudaTemporal> at = data.getAyudaTemporal(id);
        Optional<Logic.Formulario.BecaMunicipal> bm = data.getBecaMunicipal(id);
        
        if(at.isPresent()){
            resultado.put("respuesta", 1);
            resultado.put("solicitud", at.get().toGson());
            return new Gson().toJson(resultado);
        }
        if(bm.isPresent()){
            resultado.put("respuesta", 1);
            resultado.put("solicitud", bm.get().toGson());
            return new Gson().toJson(resultado);
        }
        resultado.put("respuesta", 2);
        return new Gson().toJson(resultado);
    }

    @PUT
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
    @POST
    @Path("/datosJSON/{tipo}/{solicitud}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String postJson(
            @PathParam("tipo") int tipo,
            @PathParam("solicitud") String objeto,
            @Context HttpServletResponse servletResponse) throws JSONException {
        JSONObject resultado = new JSONObject();
        switch(tipo){
                case 1:
                    Logic.Formulario.AyudaTemporal ayuda = new Gson().fromJson(objeto, Logic.Formulario.AyudaTemporal.class);
                    resultado.put("id", ayuda.getIdFormulario());
                    if(data.setAyudaTemporal(ayuda))
                        resultado.put("respuesta", 1);
                    else
                        resultado.put("respuesta", 2);
                    break;
                case 2:
                    Logic.Formulario.BecaMunicipal beca = new Gson().fromJson(objeto, Logic.Formulario.BecaMunicipal.class);
                    resultado.put("id", beca.getIdFormulario());
                    System.out.println(beca.toGson());
                    if(data.setBecaMunicipal(beca))
                        resultado.put("respuesta", 1);
                    else
                        resultado.put("respuesta", 2);
                    break;
        }
        return new Gson().toJson(resultado);
    }
    
    private final Data data;
}
