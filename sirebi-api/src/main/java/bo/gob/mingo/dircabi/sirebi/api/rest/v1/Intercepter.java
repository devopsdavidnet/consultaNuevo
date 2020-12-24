/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
package bo.gob.mingo.dircabi.sirebi.api.rest.v1;
import java.io.IOException;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
/**
 *
 * @author Davicho
 */
/*
@Provider
@PreMatching
public class Intercepter implements ContainerRequestFilter{

    @Override
    public void filter(ContainerRequestContext crc) throws IOException {
        String url=crc.getUriInfo().getAbsolutePath().toString();
       
        if(url.contains("/rest/view/auth"))
            return;
         String token=crc.getHeaderString("Authorization");
        if(token==null){
             JsonObject json=Json.createObjectBuilder()  //para retornar el jwt
                         .add("mensaje","Credenciales son necesarias").build();
             crc.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity(json).type(MediaType.APPLICATION_JSON).build());
             return;
          }
           if(!token.equals("AHGC-12BD-1328-75HF-HD64")){
               JsonObject json=Json.createObjectBuilder()  //para retornar el jwt
                         .add("mensaje","Credenciales Incorrectas").build();
             crc.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity(json).type(MediaType.APPLICATION_JSON).build());
             return; 
          }
    }
    
}
*/