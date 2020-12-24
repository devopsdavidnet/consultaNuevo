
package bo.gob.mingo.dircabi.sirebi.session;


import bo.gob.mingo.dircabi.sirebi.session.mappers.PorCasosMapper;
import bo.gob.mingo.dircabi.sirebi.session.vo.Auditoria;
import bo.gob.mingo.dircabi.sirebi.session.vo.Bien;
import bo.gob.mingo.dircabi.sirebi.session.vo.CategoriasSubBien;
import bo.gob.mingo.dircabi.sirebi.session.vo.Casos;
import bo.gob.mingo.dircabi.sirebi.session.vo.DatosMenu;
import bo.gob.mingo.dircabi.sirebi.session.vo.Oficina;
import bo.gob.mingo.dircabi.sirebi.session.vo.Password;
import bo.gob.mingo.dircabi.sirebi.session.vo.Usuario;
import java.sql.Date;
import java.util.Collections;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Davicho
 */
public class Repositorio {
    /**
     * Declaracion de variable estatica LOGGER encargado de cargar el repositorio
     */
    private static final Logger LOGGER = LogManager.getLogger(Repositorio.class.getName());
   /**
    * Constructor de la claseRepositorio 
    */
    public Repositorio() {
    }
   /**
    * Funcion que retorna una lista bines, segun el codfigo de oficina y categoria
    * @param codOficina
    * @param categoria
    * @return 
    */
     public static List<Casos> listaBusquedaBienes(Integer codOficina,Integer categoria) {
       
       List<Casos> result = Collections.emptyList();
        try (SqlSession myBatisSession = Session.getSqlSessionFactory().openSession()) {
            PorCasosMapper mapper = myBatisSession.getMapper(PorCasosMapper.class);
            
          result = mapper.getBusquedaBienes(codOficina, categoria);
        } catch (Exception e) {
            LOGGER.error("listaBusquedaBienes() Error !!! " + e);

        }
        return result;
    
     }
    
 /**
  * Retorna una lista de lista bienes filtado por caso o nombreCaso o nroFile según la ofícina 
  * @param caso
  * @param nombreCaso
  * @param nrofile
  * @param oficina
  * @param pagina
  * @return 
  */

    public static List<Casos> listaBusquedaCaso(String caso,String nombreCaso,String nrofile, Integer oficina, Integer pagina) {
        List<Casos> result = Collections.emptyList();
        try (SqlSession myBatisSession = Session.getSqlSessionFactory().openSession()) {
            PorCasosMapper mapper = myBatisSession.getMapper(PorCasosMapper.class);
            result = mapper.getBusquedaCaso(caso,nombreCaso,nrofile,oficina, pagina);
        } catch (Exception e) {
            LOGGER.error("listaBusquedaCaso() Error !!! " + e);

        }
        return result;
    }
   /**
    * Retona un a lista de bienes segun el tipo de implicado que se tiene en los parametros
    * @param nombreImplicado
    * @param tipoImplicado
    * @param oficina
    * @param pagina
    * @return    
    */
    public static List<Casos> listaBusquedaImplicado(String nombreImplicado, Integer tipoImplicado, Integer oficina, Integer pagina) {
        List<Casos> result = Collections.emptyList();
        try (SqlSession myBatisSession = Session.getSqlSessionFactory().openSession()) {
            PorCasosMapper mapper = myBatisSession.getMapper(PorCasosMapper.class);
            result = mapper.getBusquedaImplicado(nombreImplicado, tipoImplicado, oficina, pagina);
        } catch (Exception e) {
            LOGGER.error("listaBusquedaImplicado() Error !!! " + e);

        }
        return result;
    }
  /**
   * Funcion que se encarga realizar la busqueda de bines por inventario segun los parametros introducidos
   * @param valor
   * @param oficina
   * @param pagina
   * @return 
   */
    public static List<Casos> listaBusquedaInventario(String valor, Integer oficina, Integer pagina) {
        List<Casos> result = Collections.emptyList();
        try (SqlSession myBatisSession = Session.getSqlSessionFactory().openSession()) {
            PorCasosMapper mapper = myBatisSession.getMapper(PorCasosMapper.class);
            result = mapper.getBusquedaInventario(valor, oficina, pagina);
        } catch (Exception e) {
            LOGGER.error("listaBusquedaInventario() Error !!! " + e);
        }
        return result;
    }
   /**
    * funcion que se encarga retorna todos lo bienes adeudados segun los parametros de busqueda especificados
    * @param dato
    * @param fechaInicio
    * @param fechaFin
    * @param vencido
    * @param oficinaBien
    * @param oficina
    * @param pagina
    * @return  
    */
    public static List<Casos> listaBusquedaBienesAdeudados(String dato, Date fechaInicio, Date fechaFin,String vencido,Integer oficinaBien, Integer oficina, Integer pagina) {
        List<Casos> result = Collections.emptyList();
        try (SqlSession myBatisSession = Session.getSqlSessionFactory().openSession()) {
            PorCasosMapper mapper = myBatisSession.getMapper(PorCasosMapper.class);
            result = mapper.getBusquedaBienesAdeudados(dato, fechaInicio, fechaFin,vencido,oficinaBien,oficina, pagina);
        } catch (Exception e) {
            LOGGER.error("listaBienesAdeudados() Error !!! " + e);
        }
        return result;
    }
    /**
     * Funcion que se encarga de obtener los datos de los usuarios 
     * @param usuario
     * @param password
     * @return 
     */
    public static Usuario obtenerUsuario(String usuario, String password) {
        Usuario result = null;
        try (SqlSession myBatisSession = Session.getSqlSessionFactory().openSession()) {
            PorCasosMapper mapper = myBatisSession.getMapper(PorCasosMapper.class);
            result = mapper.getUsuario(usuario, password);
        } catch (Exception e) {
            LOGGER.error("obtenerUsuario() Error !!! " + e);
        }
        return result;
    }
    /**
     * Funcion que se encarga de retornar una lista de categorias
     * @return 
     */
    public static List<CategoriasSubBien> listaCategorias() {
        List<CategoriasSubBien> result = Collections.emptyList();
        try (SqlSession myBatisSession = Session.getSqlSessionFactory().openSession()) {
            PorCasosMapper mapper = myBatisSession.getMapper(PorCasosMapper.class);
            result = mapper.getCategorias();
        } catch (Exception e) {
            LOGGER.error("listaBienesAdeudados() Error !!! " + e);
        }
        return result;
    }
    /***
     * Funcion que se encarga de traer las subcategorias
     * @param codCategoria
     * @return 
     */
    public static List<CategoriasSubBien> listaSubCategorias(Integer codCategoria) {
        List<CategoriasSubBien> result = Collections.emptyList();
        try (SqlSession myBatisSession = Session.getSqlSessionFactory().openSession()) {
            PorCasosMapper mapper = myBatisSession.getMapper(PorCasosMapper.class);
            result = mapper.getSubCategorias(codCategoria);
        } catch (Exception e) {
            LOGGER.error("listaBienesAdeudados() Error !!! " + e);
        }
        return result;
    }
    /**
     * Funcion que se encarga de listar las oficinas existentes
     * @param codigo
     * @return 
     */
    public static List<Oficina> listaOficina(Integer codigo) {
        List<Oficina> result = Collections.emptyList();
        try (SqlSession myBatisSession = Session.getSqlSessionFactory().openSession()) {
            PorCasosMapper mapper = myBatisSession.getMapper(PorCasosMapper.class);
            result = mapper.getOficina(codigo);
        } catch (Exception e) {
            LOGGER.error("listaOficina Error !!! " + e);
        }
        return result;
    }
    
    /**
     * Funcion que se encargar de listar los bienes de bienes
     * @param codTipoBien
     * @return 
     */
    public static List<CategoriasSubBien> listaTipobien(Integer codTipoBien) {
        List<CategoriasSubBien> result = Collections.emptyList();
        try (SqlSession myBatisSession = Session.getSqlSessionFactory().openSession()) {
            PorCasosMapper mapper = myBatisSession.getMapper(PorCasosMapper.class);
            result = mapper.getTipobien(codTipoBien);
        } catch (Exception e) {
            LOGGER.error("listaBienesAdeudados() Error !!! " + e);
        }
        return result;
    }
    /**
     * Funcion que se encarga de listar los bienes segun los parametros
     * @param codCaso
     * @param numRegistro
     * @return 
     */
    public static List<Bien> listaBien(String codCaso,Integer numRegistro) {
        List<Bien> result = Collections.emptyList();
        try (SqlSession myBatisSession = Session.getSqlSessionFactory().openSession()) {
            PorCasosMapper mapper = myBatisSession.getMapper(PorCasosMapper.class);
            result = mapper.getBien(codCaso, numRegistro);
        } catch (Exception e) {
            LOGGER.error("listaBienesAdeudados() Error !!! " + e);
        }
        return result;
    }
    /**
     * Funcion que se encarga de realizar el cambio de cantraseña segun los parametros introducidos.
     * @param newpass
     * @param id
     * @return 
     */
    
    public static Password cambiarPass(String newpass,Integer id) {
        //List<Bien> result = Collections.emptyList();
        Password result=null;
        try (SqlSession myBatisSession = Session.getSqlSessionFactory().openSession()) {
            PorCasosMapper mapper = myBatisSession.getMapper(PorCasosMapper.class);
           result = mapper.actPass(newpass, id);
        } catch (Exception e) {
            LOGGER.error("cambiarPass Error !!! " + e);
        }
        return result;
    }
    /**
     * Funcion que se encarga de guardar en las talbas de auditoria
     * @param codRep
     * @param nombreAudi
     * @param idUsuario
     * @param ip
     * @param transaccion
     * @param idOficina
     * @param parametroBusqueda 
     */
    public static void setAuditoria(String codRep,String nombreAudi,Integer idUsuario,String ip,String transaccion,Integer idOficina,String parametroBusqueda ) {
        
        try (SqlSession myBatisSession = Session.getSqlSessionFactory().openSession()) {
            PorCasosMapper mapper = myBatisSession.getMapper(PorCasosMapper.class);
           mapper.setAuditoria(codRep,nombreAudi,idUsuario,ip,transaccion,idOficina,parametroBusqueda);
        } catch (Exception e) {
            LOGGER.error("setAuditoria  Error !!! " + e);
        }
        
    }
    /**
     * Funcion que se encarga los menus segun el parametro rol que tenga 
     * @param idRol
     * @return 
     */
     public static List<DatosMenu> listaDatosMenu(Integer idRol) {
        List<DatosMenu> result = Collections.emptyList();
        try (SqlSession myBatisSession = Session.getSqlSessionFactory().openSession()) {
            PorCasosMapper mapper = myBatisSession.getMapper(PorCasosMapper.class);
            result = mapper.getDatosMenu(idRol);
        } catch (Exception e) {
            LOGGER.error("listaDatosMenu() Error !!! " + e);
        }
        return result;
    }
   public static List<Auditoria> getAuditoria(String  loginUsuario) {
        List<Auditoria> result = Collections.emptyList();
        try (SqlSession myBatisSession = Session.getSqlSessionFactory().openSession()) {
            PorCasosMapper mapper = myBatisSession.getMapper(PorCasosMapper.class);
            result = mapper.getAuditoria(loginUsuario);
        } catch (Exception e) {
            LOGGER.error("Auditoria Error !!! " + e);
        }
        return result;
    }  
    
}
