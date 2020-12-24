/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.gob.mingo.dircabi.sirebi.session.mappers;




import bo.gob.mingo.dircabi.sirebi.session.vo.Auditoria;
import bo.gob.mingo.dircabi.sirebi.session.vo.Bien;
import bo.gob.mingo.dircabi.sirebi.session.vo.CategoriasSubBien;


import bo.gob.mingo.dircabi.sirebi.session.vo.Casos;
import bo.gob.mingo.dircabi.sirebi.session.vo.DatosMenu;
import bo.gob.mingo.dircabi.sirebi.session.vo.Oficina;
import bo.gob.mingo.dircabi.sirebi.session.vo.Password;
import bo.gob.mingo.dircabi.sirebi.session.vo.Usuario;
import java.util.List;
import java.sql.Date;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * @author Davicho
 */
@Mapper
public interface PorCasosMapper {
    List<Casos> getBusquedaBienes(@Param("codOficina") Integer codOficina,@Param("categoria") Integer categoria);                 
    List<Casos> getBusquedaCaso(@Param("caso") String caso,@Param("nombreCaso") String nombreCaso,@Param("nrofile") String nrofile,@Param("oficina") Integer oficina, @Param("pagina") Integer pagina);                 
    List<Casos> getBusquedaImplicado(@Param("nombreImplicado") String nombreImplicado,@Param("tipoImplicado") Integer tipoImplicado,@Param("oficina") Integer oficina, @Param("pagina") Integer pagina);                 
    List<Casos> getBusquedaInventario(@Param("valor") String valor,@Param("oficina") Integer oficina, @Param("pagina") Integer pagina);
    List<Casos> getBusquedaBienesAdeudados(@Param("dato") String dato,@Param("fechaInicio") Date fechaInicio,@Param("fechaFin") Date fechaFin,@Param("vencido") String vencido,@Param("oficinaBien") Integer oficinaBien,@Param("oficina") Integer oficina, @Param("pagina") Integer pagina);
    Usuario getUsuario(@Param("usuario") String usuario,@Param("password") String password);
    List<CategoriasSubBien> getCategorias();
    List<CategoriasSubBien> getSubCategorias(@Param("codCategoria") Integer codCategoria);
    List<Oficina> getOficina(@Param("codigo") Integer codigo);
    List<CategoriasSubBien> getTipobien(@Param("codTipoBien") Integer codTipoBien);
    List<Bien> getBien(@Param("codCaso") String codCaso,@Param("numRegistro") Integer numRegistro);
    Password actPass(@Param("newpass") String newpass,@Param("id") Integer id);
    void setAuditoria(@Param("codRep") String codRep,@Param("nombreAudi") String nombreAudi,@Param("idUsuario") int idUsuario,@Param("ip") String ip,
            @Param("transaccion") String transaccion,@Param("idOficina") int idOficina,@Param("parametroBusqueda") String parametroBusqueda);
     List<DatosMenu> getDatosMenu(@Param("idRol") Integer idRol);
List<Auditoria> getAuditoria(@Param("loginUsuario") String loginUsuario);
}
