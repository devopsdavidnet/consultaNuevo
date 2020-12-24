/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.gob.mingo.dircabi.sirebi.api.rest.security;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.UriInfo;
import bo.gob.mingo.dircabi.sirebi.api.rest.RestAplicacion;
import javax.servlet.ServletContext;
/**
 * Clase para crear la clase Abstractas para los servicios rest
 * @author Davicho
 */
public abstract class AbstractResource {
	@Context
	protected UriInfo uriInfo;
	
	@Context
	protected HttpHeaders httpHeaders;
	
	@Context
	protected ServletContext servletContext;
	
	@Path("/version")
	@GET
	public String getVersion(){
		return RestAplicacion.VERSION;
	}
}