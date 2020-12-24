/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.gob.mingo.dircabi.sirebi.api.rest.v1;

import bo.gob.mingo.dircabi.sirebi.api.rest.security.AbstractResource;
import bo.gob.mingo.dircabi.sirebi.api.rest.util.Utility;
import bo.gob.mingo.dircabi.sirebi.session.Repositorio;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
//import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Date;
/**
 *
 * @author Davicho
 */
@Path("app")
public class Aplicaciones extends AbstractResource {
     Date fecha=null;
     static final String NOMBRE_ARCHIVO_BIENES="Reporte_BIENES_";
     static final String NOMBRE_ARCHIVO_FELCN="Reporte_FELCN_";
     
     public  String nombreArchivo(){
     
       Date  fecha=new Date();
       SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy_HH_mm_ss");
      return sdf.format(fecha);
     
     }
     /**
      * Clase que se encarga de generar PDF segun los parametros mecionados
      * @param codBien
      * @param idUsuario
      * @param idOficina
      * @return
      * @throws Exception
      */
    @GET
    @Path("/pdf/{codBien:.*}/{idUsuario}/{idOficina}")
    @Produces("application/pdf")
    public Response pdf(@PathParam("codBien") String codBien,@PathParam("idUsuario") String idUsuario,@PathParam("idOficina") String idOficina) throws Exception {
            URL url = new URL(Utility.pdf(codBien,idUsuario));   
           //  Repositorio.setAuditoria("GENERADOR DE KARDEX", "pdf.pdf", Integer.parseInt(idUsuario),"LOCAL", "IMPRESO", Integer.parseInt(idOficina), codBien);               
            return Utility.downloadApp(url,"pdf_"+nombreArchivo()+".pdf").build();    
   }
/**
 * Metodo Get que se enarga de generar un pdf Masivo segun el codigo del caso.
 * @param codCaso
 * @param idUsuario
 * @return
 * @throws Exception
 */
    @GET
    @Path("/pdf/m/{codCaso:.*}/{idUsuario}")
    @Produces("application/pdf")
    public Response pdfMasivo(@PathParam("codCaso") String codCaso,@PathParam("idUsuario") String idUsuario) throws Exception {
            URL url = new URL(Utility.pdfMasivo(codCaso,idUsuario));   
             //Repositorio.setAuditoria("GENERADOR DE KARDEX", "pdf.pdf", Integer.parseInt(idUsuario),"LOCAL", "IMPRESO", Integer.parseInt(idOficina), codBien);               
            return Utility.downloadApp(url,codCaso+"_"+nombreArchivo()+".pdf").build(); 
            
   }
   /**
    * Clase que se encarga de generar pdf segun el filtro de la grilla del frontEnd que se hizo
    * @param codOficina
    * @param categoria
    * @param nroFelcn
    * @param fechaCasoDesde
    * @param fechaCasoHasta
    * @param nombreCaso
    * @param subCategoria
    * @param tipoBien
    * @param oficinaCaso
    * @param oficinaRecepcion
    * @param fechaBienDesde
    * @param fechaBienHasta
    * @param estadoAdministrativo
    * @param estadoJuridico
    * @param idUsuario
    * @return
    * @throws Exception
    */
    @GET
    @Path("/pdf/g")
    @Produces("application/pdf")
    public Response pdfGrilla(@QueryParam("codOficina") Integer codOficina,
           @QueryParam("categoria") Integer categoria,
           @QueryParam("nroFelcn") String nroFelcn,
           @QueryParam("fechaCasoDesde") String fechaCasoDesde,
           @QueryParam("fechaCasoHasta") String fechaCasoHasta,
           @QueryParam("nombreCaso") String nombreCaso,
           @QueryParam("subCategoria") String subCategoria,
           @QueryParam("tipoBien") String tipoBien,
           @QueryParam("oficinaCaso") String oficinaCaso,
           @QueryParam("oficinaRecepcion") String oficinaRecepcion,
           @QueryParam("fechaBienDesde") String fechaBienDesde,
           @QueryParam("fechaBienHasta") String fechaBienHasta,
           @QueryParam("estadoAdministrativo") String estadoAdministrativo,
           @QueryParam("estadoJuridico") String estadoJuridico,
           @QueryParam("idUsuario") String idUsuario) throws Exception {
           nroFelcn=URLEncoder.encode(nroFelcn,StandardCharsets.UTF_8.toString());
           nombreCaso=URLEncoder.encode(nombreCaso,StandardCharsets.UTF_8.toString());
           subCategoria=URLEncoder.encode(subCategoria,StandardCharsets.UTF_8.toString());
           tipoBien=URLEncoder.encode(tipoBien,StandardCharsets.UTF_8.toString());
           oficinaRecepcion=URLEncoder.encode(oficinaRecepcion,StandardCharsets.UTF_8.toString());
           estadoAdministrativo=URLEncoder.encode(estadoAdministrativo,StandardCharsets.UTF_8.toString());
           estadoJuridico=URLEncoder.encode(estadoJuridico,StandardCharsets.UTF_8.toString());
           oficinaCaso=URLEncoder.encode(oficinaCaso,StandardCharsets.UTF_8.toString());
           URL url = new URL(Utility.pdfGrilla(codOficina,categoria,fechaCasoDesde,fechaCasoHasta,nroFelcn,nombreCaso,subCategoria,tipoBien,oficinaCaso,oficinaRecepcion,fechaBienDesde,fechaBienHasta,estadoAdministrativo,estadoJuridico));   
          /*Repositorio.setAuditoria("GENERADOR DE KARDEX", "pdf.pdf", idUsuario,"LOCAL", "IMPRESO",oficinaCaso, "codOficina:"+codOficina+"categoria:"+categoria+"nroFelcn:"+nroFelcn
          +"fechaCasoDesde:"+fechaCasoDesde+"fechaCasoHasta:"+fechaCasoHasta+"nombreCaso:"+nombreCaso+"subCategoria:"+subCategoria+"tipoBien:"+oficinaCaso+"oficinaRecepcion:"+"fechaBienDesde:"+fechaBienDesde+"fechaBienHasta:"+fechaBienHasta+
                  "estadoAdministrativo:"+estadoAdministrativo+"estadoJuridico:"+estadoJuridico+"oficinaRecepcion:"+oficinaRecepcion); */
          
            //System.out.println(fechaComoCadena);
            return Utility.downloadApp(url,NOMBRE_ARCHIVO_BIENES+nombreArchivo()+".pdf").build();   
            
         
   }
   
   /**
    * Clase que se encarga de generar archivo excel segun el filtro de la gr
    * @param codOficina
    * @param categoria
    * @param nroFelcn
    * @param fechaCasoDesde
    * @param fechaCasoHasta
    * @param nombreCaso
    * @param subCategoria
    * @param tipoBien
    * @param oficinaCaso
    * @param oficinaRecepcion
    * @param fechaBienDesde
    * @param fechaBienHasta
    * @param estadoAdministrativo
    * @param estadoJuridico
    * @param idUsuario
    * @return
    * @throws Exception
    */
   @GET
   @Path("/excel/g")
   @Produces("application/vnd.ms-excel")
    public Response pdfGrillaExcel(@QueryParam("codOficina") Integer codOficina,
           @QueryParam("categoria") Integer categoria,
           @QueryParam("nroFelcn") String nroFelcn,
           @QueryParam("fechaCasoDesde") String fechaCasoDesde,
           @QueryParam("fechaCasoHasta") String fechaCasoHasta,
           @QueryParam("nombreCaso") String nombreCaso,
           @QueryParam("subCategoria") String subCategoria,
           @QueryParam("tipoBien") String tipoBien,
           @QueryParam("oficinaCaso") String oficinaCaso,
           @QueryParam("oficinaRecepcion") String oficinaRecepcion,
           @QueryParam("fechaBienDesde") String fechaBienDesde,
           @QueryParam("fechaBienHasta") String fechaBienHasta,
           @QueryParam("estadoAdministrativo") String estadoAdministrativo,
           @QueryParam("estadoJuridico") String estadoJuridico,
           @QueryParam("idUsuario") String idUsuario) throws Exception {
           nroFelcn=URLEncoder.encode(nroFelcn,StandardCharsets.UTF_8.toString());
           nombreCaso=URLEncoder.encode(nombreCaso,StandardCharsets.UTF_8.toString());
           subCategoria=URLEncoder.encode(subCategoria,StandardCharsets.UTF_8.toString());
           tipoBien=URLEncoder.encode(tipoBien,StandardCharsets.UTF_8.toString());
           oficinaCaso=URLEncoder.encode(oficinaCaso,StandardCharsets.UTF_8.toString());
           oficinaRecepcion=URLEncoder.encode(oficinaRecepcion,StandardCharsets.UTF_8.toString());
           estadoAdministrativo=URLEncoder.encode(estadoAdministrativo,StandardCharsets.UTF_8.toString());
           estadoJuridico=URLEncoder.encode(estadoJuridico,StandardCharsets.UTF_8.toString());
         
          URL url = new URL(Utility.pdfGrillaExcel(codOficina,categoria,fechaCasoDesde,fechaCasoHasta,nroFelcn,nombreCaso,subCategoria,tipoBien,oficinaCaso,oficinaRecepcion,fechaBienDesde,fechaBienHasta,estadoAdministrativo,estadoJuridico));   
         /* Repositorio.setAuditoria("GENERADOR DE KARDEX", "Reporte.xls", idUsuario,"LOCAL", "IMPRESO", oficinaCaso, "codOficina:"+codOficina+"categoria:"+categoria+"nroFelcn:"+nroFelcn
           +"fechaCasoDesde:"+fechaCasoDesde+"fechaCasoHasta:"+fechaCasoHasta+"nombreCaso:"+nombreCaso+"subCategoria:"+subCategoria+"tipoBien:"+oficinaCaso+"oficinaRecepcion:"+"fechaBienDesde:"+fechaBienDesde+"fechaBienHasta:"+fechaBienHasta+
                   "estadoAdministrativo:"+estadoAdministrativo+"estadoJuridico:"+estadoJuridico+"oficinaRecepcion:"+oficinaRecepcion);  */
            return Utility.downloadApp(url,NOMBRE_ARCHIVO_BIENES+nombreArchivo()+".xls").build();    
   } 
    
   
    /**
     * Metodo que devuelve listado de bienes, apartir de codigo del caso  
     * @param codCaso
     * @param nombreCaso
     * @param nrofile
     * @param idOficina
     * @param idUsurio
     * @return 
     * @throws Exception
     */
    
   @GET
   @Path("/flcn/{codCaso:.*}/{nombreCaso:.*}/{nrofile:.*}/{idOfina}/{idUsurio}")
   @Produces("application/vnd.ms-excel")
    public Response felcn(@PathParam("codCaso") String codCaso,@PathParam("nombreCaso") String nombreCaso,@PathParam("nrofile") String nrofile,@PathParam("idOfina") String idOficina,@PathParam("idUsurio") String idUsurio) throws Exception {
           URL url = new URL(Utility.flcn(codCaso,nombreCaso,nrofile,idOficina,idUsurio));   
         //  Repositorio.setAuditoria("GENERADOR DE EXCEL", "POR CASO FELCN Flcn.xls", Integer.parseInt(idUsurio),"LOCAL", "IMPRESO", Integer.parseInt(idOficina), "Caso :"+codCaso+ "nrofile :"+nrofile);                
           return Utility.downloadApp(url,"FELCN"+nombreArchivo()+".xls").build();          
    } 
   /**
    * Metodo que devuelve los bienes segun el nombre del implicado (parametros) 
    * @param nombre
    * @param tipoImplicado
    * @param idOficina
    * @param idUsurio
    * @return
    * @throws Exception
    */
   @GET
   @Path("/implicados/{nombre:.*}/{tipoImplicado}/{idOficina}/{idUsurio}")
   @Produces("application/vnd.ms-excel")
    public Response implicados(@PathParam("nombre") String nombre,@PathParam("tipoImplicado") String tipoImplicado,@PathParam("idOficina") String idOficina,@PathParam("idUsurio") String idUsurio) throws Exception {
            URL url = new URL(Utility.implicado(nombre,tipoImplicado,idOficina,idUsurio));   
          // Repositorio.setAuditoria("GENERADOR DE EXCEL", "POR IMPLICADOS Implicados.xls", Integer.parseInt(idUsurio),"LOCAL", "IMPRESO", Integer.parseInt(idOficina), "Implicado :"+nombre+ "tipoImplicado :"+tipoImplicado);                
            return Utility.downloadApp(url,"IMPLICADOS"+nombreArchivo()+".xls").build();              
    } 
   /**
    * 
    * @param dato
    * @param idOficina
    * @param idUsuario
    * @return
    * @throws Exception
    */
   @GET
   @Path("inventarios/{dato}/{idOficina}/{idUsuario}")
   @Produces("application/vnd.ms-excel")
    public Response inventario(@PathParam("dato") String dato,@PathParam("idOficina") String idOficina,@PathParam("idUsuario") String idUsuario) throws Exception {
             URL url = new URL(Utility.inventario(dato,idOficina,idUsuario));   
          // Repositorio.setAuditoria("GENERADOR DE EXCEL", "POR INVENTARIO Inventario.xls", Integer.parseInt(idUsuario),"LOCAL", "IMPRESO", Integer.parseInt(idOficina), "Inventario :"+dato+ "Oficina :"+idOficina);                
             return Utility.downloadApp(url,"INVENTARIO"+nombreArchivo()+".xls").build();              
    }    
   /**
    * GET que se encarga de realizar la lista de bines adeudados segun parametros   
    * @param razonSocial Razon Social
    * @param fechaInicio Fecha Inicio
    * @param fechaFin  Fecha Fin
    * @param idOficinaBien id de la oficina del bien
    * @param idOficinaCaso id de la oficina caso
    * @param vencido  fecha vencimiento
    * @param idUsuario id usuario
    * @return
    * @throws Exception
    */
   @GET
   @Path("/adeudados/{razonSocial:.*}/{fechaInicio:.*}/{fechaFin:.*}/{idOficinaBien}/{idOficinaCaso}/{vencido}/{idUsuario}") 
   @Produces("application/vnd.ms-excel")
   public Response bienesAduedados(@PathParam("razonSocial") String razonSocial,@PathParam("fechaInicio") String fechaInicio, @PathParam("fechaFin") String fechaFin,@PathParam("idOficinaBien") String idOficinaBien,@PathParam("idOficinaCaso") String idOficinaCaso,@PathParam("vencido") String vencido,@PathParam("idUsuario") String idUsuario) throws Exception {
           URL url = new URL(Utility.adeudados(razonSocial,fechaInicio,fechaFin,idOficinaBien,idOficinaCaso,vencido,idUsuario));   
        //   Repositorio.setAuditoria("GENERADOR DE EXCEL", "POR BIENES ADEUDADOS Adeudados.xls", Integer.parseInt(idUsuario),"LOCAL", "IMPRESO", Integer.parseInt(idOficinaCaso), "razonSocial :"+razonSocial+ "fechaInicio :"+fechaInicio+"fechaFIN :"+fechaFin);                
           return Utility.downloadApp(url,"ADEUDADOS"+nombreArchivo()+".xls").build();
    }     
   /**
    * GET el cual se encarga de generar el archivo en excel, segun los parametros introducidos           
    * @param codOficina
    * @param fechaDesde
    * @param fechaHasta
    * @param categoria
    * @param subcategoria
    * @param tipoBien
    * @param codOficinab
    * @param fechaDesdeb
    * @param fechaHastab
    * @param estAdm
    * @param estJud
    * @param oficina
    * @param idUsuario
    * @return
    * @throws Exception
    */
   @GET
   @Path("/bienes") 
   @Produces("application/vnd.ms-excel")
   public Response bienes(@QueryParam("codOficina") String codOficina,
           @QueryParam("fechaDesde") String fechaDesde,
           @QueryParam("fechaHasta") String fechaHasta,
           @QueryParam("categoria") String categoria,
           @QueryParam("subcategoria") String subcategoria,
           @QueryParam("tipoBien") String tipoBien,
           @QueryParam("codOficinab") String codOficinab,
           @QueryParam("fechaDesdeb") String fechaDesdeb,
           @QueryParam("fechaHastab") String fechaHastab,
           @QueryParam("estAdm") List<Integer> estAdm,
           @QueryParam("estJud") List<Integer> estJud,
           @QueryParam("oficina") String oficina,
           @QueryParam("idUsuario") String idUsuario) throws Exception {
           URL url = new URL(Utility.urlBien(codOficinab, fechaDesdeb, fechaHasta, fechaHastab, tipoBien, oficina, subcategoria, codOficina, fechaDesde, categoria,estJud, estAdm,idUsuario));
           
       /*    Repositorio.setAuditoria("GENERADOR DE EXCEL", "POR BIENES Bienes.xls", Integer.parseInt(idUsuario),"LOCAL", "IMPRESO", Integer.parseInt(oficina), " codOficina="+codOficina+
                   " fechaDesde="+fechaDesde+" fechaHasta"+fechaHasta+" categoria="+categoria+" subcategoria="+subcategoria+" tipoBien="+tipoBien+" codOficinab:"+codOficinab+" fechaDesdeb:"+fechaDesdeb+
           " fechaHastab:"+fechaHastab+" estAdm:"+estAdm+" estJud:"+estJud+" oficina:"+oficina+" idUsuario="+idUsuario);                */
           return Utility.downloadApp(url,"Bienes.xls").build();
       }
   
  
}



