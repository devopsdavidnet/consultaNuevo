/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.gob.mingo.dircabi.sirebi.session.vo;

/**
 *
 * @author davicho
 */
public class Auditoria {
    
   Integer idUsuario; // id_usuario integer,
   String loginUsuario;    //login_usuario character varying, 
   String estado;       //estado character varying, 
   String fechaCre;    //fecha_cre character varying, 
   String fechaMod;  //fecha_mod character varying

    public Auditoria() {
    }
   
   

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getLoginUsuario() {
        return loginUsuario;
    }

    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaCre() {
        return fechaCre;
    }

    public void setFechaCre(String fechaCre) {
        this.fechaCre = fechaCre;
    }

    public String getFechaMod() {
        return fechaMod;
    }

    public void setFechaMod(String fechaMod) {
        this.fechaMod = fechaMod;
    }
   
   
    
}
