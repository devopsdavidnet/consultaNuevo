/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.gob.mingo.dircabi.sirebi.session.vo;

/**
 *
 * @author Davicho
 */
public class Usuario {
    String apellidoP;
    String apellidoM;
    String nombres;
    String carnetIdentidad;
    Integer idOficina;
    String oficina;
    String idRestriccion;
    Integer idPerfilpred;
    String  emailUsuario;
    Integer idUsuario;

    public String getCarnetIdentidad() {
        return carnetIdentidad;
    }

    public void setCarnetIdentidad(String carnetIdentidad) {
        this.carnetIdentidad = carnetIdentidad;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
    public Usuario() {
    }

    public String getOficina() {
        return oficina;
    }

    public void setOficina(String oficina) {
        this.oficina = oficina;
    }

    
    
    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Integer getIdOficina() {
        return idOficina;
    }

    public void setIdOficina(Integer idOficina) {
        this.idOficina = idOficina;
    }

    public String getIdRestriccion() {
        return idRestriccion;
    }

    public void setIdRestriccion(String idRestriccion) {
        this.idRestriccion = idRestriccion;
    }

    public Integer getIdPerfilpred() {
        return idPerfilpred;
    }

    public void setIdPerfilpred(Integer idPerfilpred) {
        this.idPerfilpred = idPerfilpred;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    
    
}
