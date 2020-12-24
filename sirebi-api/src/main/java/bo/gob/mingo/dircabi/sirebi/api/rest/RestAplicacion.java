/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.gob.mingo.dircabi.sirebi.api.rest;

import bo.gob.mingo.dircabi.sirebi.api.rest.security.CorsResponseFilter;
import bo.gob.mingo.dircabi.sirebi.session.Repositorio;
import bo.gob.mingo.dircabi.sirebi.session.vo.Casos;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Clase principal el cual se encarga de iniciar los servicio RESTFULL
 * @author davicho
 */
@ApplicationPath("/rest")
public class RestAplicacion extends Application {

    public static final String VERSION = "1.0";
    public static List<Casos> listaInmebles = null;
    public static List<Casos> listaTransportes = null;
    public static List<Casos> listaElectronicos = null;
    public static List<Casos> listaValores = null;
    public static List<Casos> listaControladas = null;
    public static List<Casos> listaSemovientes = null;
    public static List<Casos> listaArmas = null;
    public static List<Casos> listaOtros = null;
    
    private Set<Class<?>> perRequestComponents = new HashSet<>(Arrays.asList(CorsResponseFilter.class));
    
    public RestAplicacion() {
        perRequestComponents.clear();
        getPerRequestComponent();
    }
   /**
    * 
    * @return  
    */
    public Set<Class<?>> getPerRequestComponents() {
        return perRequestComponents;
    }

    public void setPerRequestComponents(Set<Class<?>> perRequestComponents) {
        this.perRequestComponents = perRequestComponents;
    }
   /**
    * Inicializa las varibles que se utilizaran segun tipo de bien
    */
    public void getPerRequestComponent(){
       
        if (listaInmebles == null) {
            listaInmebles = Repositorio.listaBusquedaBienes(1, 1);
        } 
       if (listaTransportes == null) {
            listaTransportes = Repositorio.listaBusquedaBienes(1,2);
        } 
        if (listaElectronicos == null) {
            listaElectronicos = Repositorio.listaBusquedaBienes(1, 3);
        } 
         if (listaValores == null) {
            listaValores = Repositorio.listaBusquedaBienes(1, 4);
        } 
          if (listaControladas == null) {
            listaControladas = Repositorio.listaBusquedaBienes(1,5);
        } 
         if (listaSemovientes == null) {
            listaSemovientes = Repositorio.listaBusquedaBienes(1, 6);
        } 
         if (listaArmas == null) {
            listaArmas = Repositorio.listaBusquedaBienes(1, 7);
        } 
         if (listaOtros == null) {
            listaOtros = Repositorio.listaBusquedaBienes(1, 8);
        }  
     
    } 
    
    
}
