/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.gob.mingo.dircabi.sirebi.api.rest.util;

import java.net.URL;
import java.util.List;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import javax.ws.rs.core.Response;
import java.sql.Date;

/**
 *
 * @author davicho
 */
public class Utility {

    private static final String METHOD = "GET";
    private static final String ACCPET = "Accept";
    private static final String CONTENT = "Content-Disposition";
    private static final String APLICATIONS = "application/vnd.ms-excel";
    private static final String FILENAME = "attachment; filename=";
    private static final String URL = "http://10.10.0.18:8080/jasperserver/rest_v2/reports/reports/dircabi/";
    private static final String USER = "?j_username=consulta";
    private static final String PASSWORD = "&j_password=consulta";
    private static final String EXCELBIEN = "rep_bien_tabla.xlsx";
    private static final String EXCELADEUDADO = "rep_bien_adeudado_tabla.xlsx";
    private static final String EXCELINVENTARIO = "rep_inventario_tabla.xlsx";
    private static final String EXCELIMPLICADO = "rep_implicado_tabla.xlsx";
    private static final String EXCELFLCN = "rep_caso_tabla.xlsx";
    private static final String PDF = "rep_kardexbien.pdf";
    private static final String PDE = "rep_kardexbien_por_caso.pdf";
    private static final String PDG = "rep_bien_tabla_cat.pdf";
    private static final String PDFE = "rep_bien_tabla_cat.xlsx";
                                       
    
                                
    

    public Utility() {

    }
    /**
     * 
     * @param codOficinab
     * @param fechaDesdeb
     * @param fechaHasta
     * @param fechaHastab
     * @param tipoBien
     * @param oficina
     * @param subcategoria
     * @param codOficina
     * @param fechaDesde
     * @param categoria
     * @param estJud
     * @param estAdm
     * @param idUsuario
     * @return
     */
    public static String urlBien(String codOficinab, String fechaDesdeb, String fechaHasta, String fechaHastab, String tipoBien, String oficina, String subcategoria, String codOficina, String fechaDesde, String categoria, List<Integer> estJud, List<Integer> estAdm, String idUsuario) {
        String staAd = "";
        String staJud = "";
        if (codOficina == null) {
            codOficina = "";
        }
        if (fechaDesde == null) {
            fechaDesde = "";
        }
        if (fechaHasta == null) {
            fechaHasta = "";
        }
        if (categoria == null) {
            categoria = "";
        }
        if (subcategoria == null) {
            subcategoria = "";
        }
        if (tipoBien == null) {
            tipoBien = "";
        }
        if (codOficinab == null) {
            codOficinab = "";
        }
        if (fechaDesdeb == null) {
            fechaDesdeb = "";
        }
        if (fechaHastab == null) {
            fechaHastab = "";
        }
        if (oficina == null) {
            oficina = "";
        }
        for (Integer valor : estAdm) {
            staAd = staAd + "&pa_statusadm=" + valor;
        }
        for (Integer valor : estJud) {
            staJud = staJud + "&pa_statusjud=" + valor;
        }
        String url = URL + EXCELBIEN + USER + PASSWORD;
        url = url + "&pa_bcodoficina=" + codOficinab + "&pa_bfecha_desde=" + fechaDesdeb + "&pa_fecha_hasta=" + fechaHasta + "&pa_bfecha_hasta=" + fechaHastab + "&pa_tipobien=" + tipoBien
                + "&pa_oficina=" + oficina + "&pa_subcategoria=" + subcategoria + "&pa_codoficina=" + codOficina + "&pa_fecha_desde=" + fechaDesde + "&pa_categoria=" + categoria + staJud + staAd;
        return url;
    }
   /**
    * 
    * @param codCaso
    * @param nombreCaso
    * @param nrofile
    * @param idOficina
    * @param idUsurio
    * @return
    */
    public static String flcn(String codCaso, String nombreCaso, String nrofile,String idOficina, String idUsurio) {
        
         if (codCaso == null) {
            codCaso = "";
        }
        if (nrofile == null) {
            nrofile = "";
        }
        if (nombreCaso == null) {
        	nombreCaso = "";
        }
        String url = URL + EXCELFLCN + USER + PASSWORD;
        
        url = url + "&pa_caso="+ codCaso +"&pa_nombre_caso="+nombreCaso+"&pa_nrofile="+nrofile+"&pa_codoficina=" + idOficina;
 
        return url;
    }
   /**
    * 
    * @param codBien
    * @param usuario
    * @return
    */
    public static String pdf(String codBien, String usuario) {
        String url = URL + PDF + USER + PASSWORD;
        url = url + "&pa_cod_bien=" + codBien+"&pa_usuario="+usuario;
        return url;
    }
   /**
    * 
    * @param codCaso
    * @param usuario
    * @return
    */
    public static String pdfMasivo(String codCaso, String usuario) {
        String url = URL + PDE + USER + PASSWORD;
        url = url + "&pa_cod_caso=" + codCaso+"&pa_usuario="+usuario;
        return url;
    }
    /**
     * 
     * @param codOficina
     * @param categoria
     * @param fechaCasoDesde
     * @param fechaCasoHasta
     * @param nroFelcn
     * @param nombreCaso
     * @param subCategoria
     * @param tipoBien
     * @param oficinaCaso
     * @param oficinaRecepcion
     * @param fechaBienDesde
     * @param fechaBienHasta
     * @param estadoAdministrativo
     * @param estadoJuridico
     * @return
     */
    public static String pdfGrilla(Integer codOficina, Integer categoria,String fechaCasoDesde,String fechaCasoHasta,String nroFelcn,String nombreCaso,String subCategoria,String tipoBien,
           String oficinaCaso,String oficinaRecepcion,String fechaBienDesde,String fechaBienHasta,String estadoAdministrativo,String estadoJuridico){
           String url = URL + PDG + USER + PASSWORD;
           url = url + "&pa_codoficina="+codOficina+"&pa_categoria="+categoria+"&pa_oficinacaso_desc="+oficinaCaso+"&pa_nombre_caso="+nombreCaso+"&pa_estadojuridico_desc="+
                   estadoJuridico+"&pa_subcategoria_desc="+subCategoria+"&pa_oficinarecepcion_desc="+oficinaRecepcion+"&pa_tipobien_desc="+tipoBien+"&pa_estadoadministrativo_desc="+
                   estadoAdministrativo+"&pa_fechacaso_hasta="+fechaCasoHasta+"&pa_fechacaso_desde="+fechaCasoDesde+"&pa_nrofelcn="+nroFelcn+"&pa_fechabien_desde="+fechaBienDesde
                   +"&pa_fechabien_hasta="+fechaBienHasta;
        return url;
          
    }
    /**
     * 
     * @param codOficina
     * @param categoria
     * @param fechaCasoDesde
     * @param fechaCasoHasta
     * @param nroFelcn
     * @param nombreCaso
     * @param subCategoria
     * @param tipoBien
     * @param oficinaCaso
     * @param oficinaRecepcion
     * @param fechaBienDesde
     * @param fechaBienHasta
     * @param estadoAdministrativo
     * @param estadoJuridico
     * @return
     */
    public static String pdfGrillaExcel(Integer codOficina, Integer categoria,String fechaCasoDesde,String fechaCasoHasta,String nroFelcn,String nombreCaso,String subCategoria,String tipoBien,
           String oficinaCaso,String oficinaRecepcion,String fechaBienDesde,String fechaBienHasta,String estadoAdministrativo,String estadoJuridico){
           String url = URL + PDFE + USER + PASSWORD;
           url = url + "&pa_codoficina="+codOficina+"&pa_categoria="+categoria+"&pa_oficinacaso_desc="+oficinaCaso+"&pa_nombre_caso="+nombreCaso+"&pa_estadojuridico_desc="+
                   estadoJuridico+"&pa_subcategoria_desc="+subCategoria+"&pa_oficinarecepcion_desc="+oficinaRecepcion+"&pa_tipobien_desc="+tipoBien+"&pa_estadoadministrativo_desc="+
                   estadoAdministrativo+"&pa_fechacaso_hasta="+fechaCasoHasta+"&pa_fechacaso_desde="+fechaCasoDesde+"&pa_nrofelcn="+nroFelcn+"&pa_fechabien_desde="+fechaBienDesde
                   +"&pa_fechabien_hasta="+fechaBienHasta;
        return url;
          
    }        
    /**
     *         
     * @param nombre
     * @param tipoImplicado
     * @param idOficina
     * @param idUsurio
     * @return
     */
    public static String implicado(String nombre, String tipoImplicado, String idOficina, String idUsurio) {
     String url = URL + EXCELIMPLICADO + USER + PASSWORD;
     url = url + "&pa_nombre=" + nombre + "&pa_tipoimpl=" + tipoImplicado + "&pa_oficina=" + idOficina;
     url = url.replaceAll(" ", "%20");
        return url;
    }
    /**
     * 
     * @param razonSocial
     * @param fechaInicio
     * @param fechaFin
     * @param idOficinaBien
     * @param idOficinaCaso
     * @param vencido
     * @param idUsurio
     * @return
     */
    public static String adeudados(String razonSocial, String fechaInicio, String fechaFin,String idOficinaBien,String idOficinaCaso,String vencido, String idUsurio) {
        if (fechaInicio == null) {
            fechaInicio = "";
        }
        if (fechaFin == null) {
            fechaFin = "";
        }
        String url = URL + EXCELADEUDADO + USER + PASSWORD;                
        url = url + "&pa_razonsocial=" + razonSocial + "&pa_fecha_desde=" + fechaInicio + "&pa_fecha_hasta="+fechaFin+"&pa_oficina_bien="+idOficinaBien+"&pa_oficina=" + idOficinaCaso +"&pa_vencido="+vencido;
        url = url.replaceAll(" ", "%20");
        return url;
    }
    /**
     * 
     * @param dato
     * @param idOficina
     * @param idUsurio
     * @return
     */
    public static String inventario(String dato, String idOficina, String idUsurio) {
        String url = URL + EXCELINVENTARIO + USER + PASSWORD;
        url = url + "&pa_oficina=" + idOficina + "&pa_dato=" + dato;
        url = url.replaceAll(" ", "%20");
        return url;
    }
    /**
     * Clase que se encarga de verificar si se puede conectar a la url. y convertir un pdf o excel en un ARRAY de bytes.
     * @param url
     * @param name
     * @return
     */
    public static Response.ResponseBuilder downloadApp(URL url, String name) {
        ByteArrayOutputStream baos = null;
        try {
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(METHOD);
            conn.setRequestProperty(ACCPET, APLICATIONS);
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("error : HTTP " + conn.getResponseCode());
            }
            InputStream is = conn.getInputStream();
            baos = new ByteArrayOutputStream();
            int len;
            byte[] buffer = new byte[4096];
            while ((len = is.read(buffer, 0, buffer.length)) != -1) {
                baos.write(buffer, 0, len);
            }
            conn.disconnect();

        } catch (Exception e) {
            System.out.println("Exception " + e);
        }

        byte[] bytes = baos.toByteArray();
        Response.ResponseBuilder response = Response.ok((Object) bytes);
        response.header(CONTENT, FILENAME + name);
        return response;

    }

}
