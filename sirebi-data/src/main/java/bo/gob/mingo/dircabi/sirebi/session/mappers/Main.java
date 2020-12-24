/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.gob.mingo.dircabi.sirebi.session.mappers;


import bo.gob.mingo.dircabi.sirebi.session.Repositorio;
import bo.gob.mingo.dircabi.sirebi.session.vo.Auditoria;
import bo.gob.mingo.dircabi.sirebi.session.vo.Bien;
import bo.gob.mingo.dircabi.sirebi.session.vo.CategoriasSubBien;
import bo.gob.mingo.dircabi.sirebi.session.vo.Casos;
import bo.gob.mingo.dircabi.sirebi.session.vo.DatosMenu;
import bo.gob.mingo.dircabi.sirebi.session.vo.Oficina;
import bo.gob.mingo.dircabi.sirebi.session.vo.Usuario;


import java.text.ParseException;
import java.text.SimpleDateFormat;


import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Davicho
 */
public class Main {

    public static void main(String... arg) throws ParseException {
        
      /*  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date parsed =  format.parse("1970-12-22");
        java.sql.Date sql = new java.sql.Date(parsed.getTime());
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date parsed1 =  format1.parse("2019-12-30");
        java.sql.Date sql1 = new java.sql.Date(parsed1.getTime());
        List<PorCasos> lista;
        lista = Repositorio.listaBusquedaBienesAdeudados("GOBIERNO", sql,sql1 ,1,0);
        Iterator<PorCasos> iter = lista.iterator();
        while (iter.hasNext()) {
        System.out.println("FELCN CASO :" + iter.next().getCodCaso());
        }*/ /*List<CategoriasSubBien> lista;
        lista = Repositorio.listaTipobien(2);
        Iterator<CategoriasSubBien> iter = lista.iterator();
        while (iter.hasNext()) {
        System.out.println("FELCN CASO :" + iter.next().getCodigo());
        }
         */ /*List<DatosMenu> lista;
        //select * from public.filtro_por_bienes_adeudados_tabla('',null,null,'N',3,1,null);
        //lista = Repositorio.listaBien("SC-SCZ-01/002-SC-SCZ-01-0002/1995", 10);
        lista = Repositorio.listaDatosMenu(2);
        Iterator<DatosMenu> iter = lista.iterator();
        while (iter.hasNext()) {
        System.out.println("FELCN CASO :" + iter.next().getDescModulo());
        }
         */ /*
        System.out.print(Repositorio.cambiarPass("8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92", 10).getCambioClave());
         */ /*
        Repositorio.setAuditoria("REPORTE","rep_kardexbien",1,"", "CONSULTA",1, "TA-TRJ-01/001-TA-TRJ-01-0018/2011");
         */
         //select * from filtro_por_bienes_tabla(3,,null,null,null,null,null,null,array[0,6,0,0,0,0,0,0,0],array[2,4],1,0)
         //System.out.println("FELCN CASO :"+fecha);
        /*List<Casos> lista;
         //lista = Repositorio.listaBusquedaBienes(3, sql, sqlTS, null, null, null, null, null, null, array1, judicial, 1, 0);
         lista = Repositorio.listaBusquedaBienes(1, 1);
         Iterator<Casos> iter = lista.iterator();
         Casos a=new Casos();
         
         while (iter.hasNext()) {
             
             System.out.println("FELCN CASO :" + iter.next().getFechaRecepcion());
             System.out.println("FELCN CASO :" + iter.next().getFechaAperturaCaso());
             
         }*/
         List<Auditoria> lista;
         //lista = Repositorio.listaBusquedaBienes(3, sql, sqlTS, null, null, null, null, null, null, array1, judicial, 1, 0);
         lista = Repositorio.getAuditoria("iasalazar");
         Iterator<Auditoria> iter = lista.iterator();
         
         while (iter.hasNext()) {
             
             System.out.println("FELCN CASO :" + iter.next().getFechaMod());
             
             
         }
            
    }
}
