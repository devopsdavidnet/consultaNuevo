/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.gob.mingo.dircabi.sirebi.api.rest.v1;

import bo.gob.mingo.dircabi.sirebi.api.rest.RestAplicacion;
import bo.gob.mingo.dircabi.sirebi.api.rest.model.Credenciales;
import bo.gob.mingo.dircabi.sirebi.api.rest.security.AbstractResource;
import bo.gob.mingo.dircabi.sirebi.session.Repositorio;
import bo.gob.mingo.dircabi.sirebi.session.vo.Bien;
import bo.gob.mingo.dircabi.sirebi.session.vo.CategoriasSubBien;
import bo.gob.mingo.dircabi.sirebi.session.vo.Casos;
import bo.gob.mingo.dircabi.sirebi.session.vo.DatosMenu;
import bo.gob.mingo.dircabi.sirebi.session.vo.Oficina;
import bo.gob.mingo.dircabi.sirebi.session.vo.Usuario;
import com.google.common.hash.Hashing;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static org.apache.logging.log4j.core.layout.PatternLayout.KEY;

/**
 *
 * @author Davicho
 */
@Path("view")
public class Recursos extends AbstractResource {

    private static List<Casos> lista = null;
    public static List<Casos> listaInmebles = null;
    public static List<Casos> listaTransportes = null;
    public static List<Casos> listaElectronicos = null;
    public static List<Casos> listaValores = null;
    public static List<Casos> listaControladas = null;
    public static List<Casos> listaSemovientes = null;
    public static List<Casos> listaArmas = null;
    public static List<Casos> listaOtros = null;
    private static List<Bien> listaBien;
    private static List<DatosMenu> listaDatosMenu;
    private static List<CategoriasSubBien> listaCatSubBien;
    private static List<Oficina> listaOficina;
    private static Usuario usuario = null;
  
    
   /**
    * Constructor que se encarga de inicializar las variables 
    */
        
   public Recursos(){
   listaInmebles = RestAplicacion.listaInmebles;
   listaTransportes = RestAplicacion.listaTransportes;
   listaElectronicos = RestAplicacion.listaElectronicos;
   listaValores = RestAplicacion.listaValores;
   listaControladas = RestAplicacion.listaControladas;
   listaSemovientes = RestAplicacion.listaSemovientes;
   listaArmas = RestAplicacion.listaArmas;
   listaOtros = RestAplicacion.listaOtros;
    }
    private ArrayList<Casos> casos;  
    @GET
    @Path("v11/")
    @Produces({MediaType.APPLICATION_JSON})
    public Response filtroPorBienesss(
           @QueryParam("codOficina") Integer codOficina,
           @QueryParam("categoria") Integer categoria,
           @QueryParam("idUsuario") Integer idUsuario) throws IOException {
 
  // System.out.println("ID del usuario"+usuario.getIdOficina());   	
     if(categoria==1){
         
       /* for (Casos obj:listaInmebles){
         System.out.println(obj.getAdministrativo().contains("A"));
         
         }*/
        return Response.ok(listaInmebles).build(); 
     }
     if(categoria==2){
      return Response.ok(listaTransportes).build(); 
     }
     if(categoria==3){
      return Response.ok(listaElectronicos).build();    
     }
     if(categoria==4){
      return Response.ok(listaValores).build();       
     }
     if(categoria==5){
      return Response.ok(listaControladas).build();          
     }
     if(categoria==6){
      return Response.ok(listaSemovientes).build();             
     }
     if(categoria==7){
      return Response.ok(listaArmas).build();                
     }
     if(categoria==8){
      return Response.ok(listaOtros).build();                   
     }
            
       /* Repositorio.setAuditoria("CONSULTA ", "POR BIENES", idUsuario, "LOCAL", "BUSQUEDA", 0, " codOficina:" + codOficina + " fechaDesde:" + null + " fechaHasta" + null
                + " categoria:" + categoria + " subcategoria:" + 0 + " tipoBien" + 0 + " codOficinaBien:" + codOficinab + " fechaDesdeBien:" + null + " fechaHastaBien:" + null
                + " estAdm:" + 0 + " estJud:" + 0 + " oficina:" + 0 + " Pagina:" + 0);*/

        return Response.ok(null).build();
    }

    /**
     * 
     * @param caso
     * @param nombreCaso
     * @param nrofile
     * @param oficina
     * @param pagina
     * @param IdUsuario
     * @return
     * @throws IOException
     */
    
    @GET
    @Path("v3/{caso:.*}/{nombreCaso:.*}/{nrofile:.*}/{oficina}/{pagina}/{IdUsuario}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response filtroPorCasoTabla(@PathParam("caso") String caso, @PathParam("nombreCaso") String nombreCaso, @PathParam("nrofile") String nrofile, @PathParam("oficina") Integer oficina, @PathParam("pagina") Integer pagina, @PathParam("IdUsuario") Integer IdUsuario) throws IOException {
        lista = Repositorio.listaBusquedaCaso(caso, nombreCaso, nrofile, oficina, pagina);
      //  Repositorio.setAuditoria("CONSULTA ", "CASO FELCN", IdUsuario, "LOCAL", "BUSQUEDA", oficina, caso);
        return Response.ok(lista).build();
    }
     /**
      * 
      * @param nombreImplicado
      * @param tipoImplicado
      * @param oficina
      * @param pagina
      * @param IdUsuario
      * @return
      * @throws IOException
      */
    @GET
    @Path("v2/{nombreImplicado}/{tipoImplicado}/{oficina}/{pagina}/{IdUsuario}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response filtroPorImplicadoTabla(@PathParam("nombreImplicado") String nombreImplicado, @PathParam("tipoImplicado") Integer tipoImplicado, @PathParam("oficina") Integer oficina, @PathParam("pagina") Integer pagina, @PathParam("IdUsuario") Integer IdUsuario) throws IOException {
        lista = Repositorio.listaBusquedaImplicado(nombreImplicado, tipoImplicado, oficina, pagina);
       // Repositorio.setAuditoria("CONSULTA ", "POR IMPLICADO", IdUsuario, "LOCAL", "BUSQUEDA", oficina, nombreImplicado + " TIPO IMPLICADO: " + tipoImplicado);
        return Response.ok(lista).build();
    }
    /**
     * 
     * @param valor
     * @param oficina
     * @param pagina
     * @param IdUsuario
     * @return
     * @throws IOException
     */
    @GET
    @Path("v1/{valor:.*}/{oficina}/{pagina}/{IdUsuario}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response filtroPorInventarioTabla(@PathParam("valor") String valor, @PathParam("oficina") int oficina, @PathParam("pagina") int pagina, @PathParam("IdUsuario") Integer IdUsuario) throws IOException {
        lista = Repositorio.listaBusquedaInventario(valor, oficina, pagina);
      //  Repositorio.setAuditoria("CONSULTA ", "POR INVENTARIO", IdUsuario, "LOCAL", "BUSQUEDA", oficina, valor);
        return Response.ok(lista).build();
    }
   /**
    * Funcion que verifica si existe registrado el usuario.
    * @param usuario
    * @param pass
    * @return 
    */
    public Usuario verificaUsuario(String usuario, String pass) {
        Usuario usua = Repositorio.obtenerUsuario(usuario, pass);
        return usua;
    }
    /**
     * Servicio POST el cual verifica si existe el objeto Credencial
     * @param credenciales
     * @return
     * @throws IOException
     */
    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response filtroLogin(Credenciales credenciales) throws IOException {
        String res = "1";
        usuario = verificaUsuario(credenciales.getUsuario(), credenciales.getPassword());
        if (usuario != null) {
            //Repositorio.setAuditoria("LOGIN", credenciales.getUsuario(), usuario.getIdUsuario(), " ", "INICIO", usuario.getIdOficina(), " ");
         }
      return Response.ok().entity(usuario).build();
     }
    
    /**
     * GET que se encarga de verificar si el usuario 
     * @param usuario
     * @param password
     * @param newpassword
     * @return
     * @throws IOException
     */

    @GET
    @Path("cambiop/{usuario}/{password}/{newpassword}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response cambiaContrasenia(@PathParam("usuario") String usuario, @PathParam("password") String password, @PathParam("newpassword") String newpassword) throws IOException {
        boolean sw = false;
        Usuario usua = null;
        usua = verificaUsuario(usuario, password);
        if (usua != null) {
            sw = Repositorio.cambiarPass(newpassword, usua.getIdUsuario()).getCambioClave();
        }
        return Response.ok(sw).build();
    }
    /**
     * funcion que lista de bienes adeudados segun los parametros @param
     * @param dato
     * @param fechaInicio
     * @param fechaFin
     * @param vencido
     * @param oficinaBien
     * @param oficina
     * @param pagina
     * @param IdUsuario
     * @return 
     * @throws IOException
     */

    @GET
    @Path("v4/{dato:.*}/{fechaInicio:.*}/{fechaFin:.*}/{vencido}/{oficinaBien}/{oficina}/{pagina}/{IdUsuario}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response filtroBienesAdeudados(@PathParam("dato") String dato, @PathParam("fechaInicio") Date fechaInicio, @PathParam("fechaFin") Date fechaFin, @PathParam("vencido") String vencido, @PathParam("oficinaBien") Integer oficinaBien, @PathParam("oficina") Integer oficina, @PathParam("pagina") Integer pagina, @PathParam("IdUsuario") Integer IdUsuario) throws IOException {
        lista = Repositorio.listaBusquedaBienesAdeudados(dato, fechaInicio, fechaFin, vencido, oficinaBien, oficina, pagina);
      //  Repositorio.setAuditoria("CONSULTA ", "BIENES ADEUDADOS", IdUsuario, "LOCAL", "BUSQUEDA", oficina, dato + "OFICINA:" + oficina + "FECHA INICIO:" + fechaInicio + "FECHA FIN :" + fechaFin);
        return Response.ok(lista).build();
    }
    /**
     * GET que se encarga de mostrar las categorias
     * @return LISTA DE CATORIAS
     * @throws IOException
     */

    @GET
    @Path("/v5/categorias")
    @Produces({MediaType.APPLICATION_JSON})
    public Response filtroCategorias() throws IOException {
        listaCatSubBien = Repositorio.listaCategorias();
        return Response.ok(listaCatSubBien).build();
    }
     /**
      * GET que retorna la subcatetoria segun el @param 
      * @param codigo
      * @return 
      * @throws IOException
      */
    @GET
    @Path("v6/subcategoria/{codigo}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response filtroSubCategorias(@PathParam("codigo") Integer codigo) throws IOException {
        listaCatSubBien = Repositorio.listaSubCategorias(codigo);
        return Response.ok(listaCatSubBien).build();
    }
     /**
      * GET que retorna   
      * @param codigo
      * @return RETONA JSON DE CODIGO DE OFICINA
      * @throws IOException
      */
    @GET
    @Path("oficina/{codigo}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response filtroOficina(@PathParam("codigo") Integer codigo) throws IOException {
        listaOficina = Repositorio.listaOficina(codigo);
        return Response.ok(listaOficina).build();
    }
   /**
    * 
    * @param codigo
    * @return 
    * @throws IOException
    */
    @GET
    @Path("v7/tipobien/{codigo}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response filtroTipoBien(@PathParam("codigo") Integer codigo) throws IOException {
        listaCatSubBien = Repositorio.listaTipobien(codigo);
        return Response.ok(listaCatSubBien).build();
    }
    
    /**
     * 
     * @param codCaso
     * @param numRegistro
     * @return SERVICIO DE TIPO GET EL CUAL RETORNA UN ARRAY DE JSON 
     * @throws IOException
     */
    @GET
    @Path("v8/bien/{codCaso:.*}/{numRegistro}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response filtroBien(@PathParam("codCaso") String codCaso, @PathParam("numRegistro") Integer numRegistro) throws IOException {
        listaBien = Repositorio.listaBien(codCaso, numRegistro);
        return Response.ok(listaBien).build();
    }
    /**
     * 
     * @param tipo
     * @param nombre
     * @param idUsuario
     * @param ip
     * @param accion
     * @param idOficina
     * @param parametroBusqueda
     * @return 
     * @throws IOException
     */
    @GET
    @Path("audi/{tipo}/{nombre}/{idUsuario}/{ip}/{accion}/{idOficina}/{parametroBusqueda:.*}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response auditoria(@PathParam("tipo") String tipo, @PathParam("nombre") String nombre, @PathParam("idUsuario") Integer idUsuario,
            @PathParam("ip") String ip, @PathParam("accion") String accion, @PathParam("idOficina") Integer idOficina,
            @PathParam("parametroBusqueda") String parametroBusqueda) throws IOException {
       // Repositorio.setAuditoria(tipo, nombre, idUsuario, ip, accion, idOficina, parametroBusqueda);
        return Response.ok().build();
    }
    /**
     * 
     * @param credenciales
     * @return
     */
    @POST
    @Path("/auth")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response validar(Credenciales credenciales) {
        String res = "1";
        usuario = Repositorio.obtenerUsuario(credenciales.getUsuario(), credenciales.getPassword());
        if (usuario == null) {
            res = "0";
        } else {
            String HASH = "AHGC-12BD-1328-75HF-HD64";
            long tiempo = System.currentTimeMillis();
            String jwt = Jwts.builder()
                    .signWith(SignatureAlgorithm.HS256, KEY)
                    .setSubject("David Apaza")
                    .setIssuedAt(new Date(tiempo))
                    .setExpiration(new Date(tiempo + 900000)) //15 minutos
                    .claim("email", "davichoapaza@gmail.com")
                    .compact();
            JsonObject json = Json.createObjectBuilder() //para retornar el jwt
                    .add("token", HASH).build();
            return Response.status(Response.Status.CREATED).entity(json).build();
        }
        JsonObject json = Json.createObjectBuilder() //para retornar el jwt
                .add("mensaje", "Datos incorrectos").build();
        return Response.status(Response.Status.UNAUTHORIZED).entity(json).build();
    }
     /**
      * 
      * @param idRol
      * @return
      * @throws IOException
      */
    @GET
    @Path("menu/{idRol}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response filtroDatosMenu(@PathParam("idRol") Integer idRol) throws IOException {
        listaDatosMenu = Repositorio.listaDatosMenu(idRol);
        return Response.ok(listaDatosMenu).build();
    }

}
