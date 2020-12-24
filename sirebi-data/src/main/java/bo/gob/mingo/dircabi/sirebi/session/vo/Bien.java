/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.gob.mingo.dircabi.sirebi.session.vo;

import java.math.BigDecimal;

/**
 *
 * @author Davicho
 */
public class Bien {
    Integer codCaracteristica;
    String descCaracteristica;
    String detalle;
    String unidad;  
    BigDecimal detalleNum; 
    String codEstado;
    String observaciones; 

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getCodEstado() {
        return codEstado;
    }

    public void setCodEstado(String codEstado) {
        this.codEstado = codEstado;
    }
    
    public Integer getCodCaracteristica() {
        return codCaracteristica;
    }

    public void setCodCaracteristica(Integer codCaracteristica) {
        this.codCaracteristica = codCaracteristica;
    }

    public String getDescCaracteristica() {
        return descCaracteristica;
    }

    public void setDescCaracteristica(String descCaracteristica) {
        this.descCaracteristica = descCaracteristica;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

   
    public BigDecimal getDetalleNum() {
        return detalleNum;
    }

    public void setDetalleNum(BigDecimal detalleNum) {
        this.detalleNum = detalleNum;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
  
   
    
}
