/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.gob.mingo.dircabi.sirebi.session.vo;

/**
 *
 * @author david
 */
public class DatosMenu {
   private String descModulo;
   private String menuPadre;
    private Integer idMenuPadre;
    private Integer idMenu;
    private String nameMenu;
    private String linkMenu;

    public String getDescModulo() {
        return descModulo;
    }

    public void setDescModulo(String descModulo) {
        this.descModulo = descModulo;
    }

    public String getMenuPadre() {
        return menuPadre;
    }

    public void setMenuPadre(String menuPadre) {
        this.menuPadre = menuPadre;
    }

    public Integer getIdMenuPadre() {
        return idMenuPadre;
    }

    public void setIdMenuPadre(Integer idMenuPadre) {
        this.idMenuPadre = idMenuPadre;
    }

    public Integer getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public String getNameMenu() {
        return nameMenu;
    }

    public void setNameMenu(String nameMenu) {
        this.nameMenu = nameMenu;
    }

    public String getLinkMenu() {
        return linkMenu;
    }

    public void setLinkMenu(String linkMenu) {
        this.linkMenu = linkMenu;
    }

    public DatosMenu(String descModulo, String menuPadre, Integer idMenuPadre, Integer idMenu, String nameMenu, String linkMenu) {
        this.descModulo = descModulo;
        this.menuPadre = menuPadre;
        this.idMenuPadre = idMenuPadre;
        this.idMenu = idMenu;
        this.nameMenu = nameMenu;
        this.linkMenu = linkMenu;
    }
    
    
    
}
