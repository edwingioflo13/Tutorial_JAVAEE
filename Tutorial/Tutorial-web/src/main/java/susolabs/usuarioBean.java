/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package susolabs;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.DualListModel;
import susolabs.entidades.Acceso;
import susolabs.entidades.Usuario;
import susolabs.facade.AccesoFacadeLocal;
import susolabs.facade.UsuarioFacadeLocal;

/**
 *
 * @author t4nk
 */
@ManagedBean(name = "usuarioBean")
@RequestScoped
public class usuarioBean {

    /**
     * Creates a new instance of usuarioBean
     */
    @EJB
    private UsuarioFacadeLocal usuarioFacade;

    @EJB
    private AccesoFacadeLocal accesoFacade;

    private Usuario usuario = new Usuario();

    private List<Usuario> filtro;

    private DualListModel<String> accesos = new DualListModel<>();

    public usuarioBean() {
    }

    @PostConstruct
    public void init() {
        //Names Access
        List<Acceso> accesosTodos = accesoFacade.findAll();
        List<String> names = new ArrayList<>();
        List<String> namesTrget = new ArrayList<>();
        for (int i = 0; i < accesosTodos.size(); i++) {
            names.add(accesosTodos.get(i).getCodigoacceso());
        }
        this.accesos = new DualListModel<>(names, namesTrget);
    }

    public void guardar() {
        usuario.setAccesoList(getAccesos(accesos.getTarget()));
        usuario.setClave(sha256(usuario.getClave()));
        usuarioFacade.create(usuario);
        usuario = new Usuario();
        init();
    }

    public void eliminar(Usuario accesoEliminar) {
        usuarioFacade.remove(accesoEliminar);
    }

    public List<Usuario> buscar() {
        return usuarioFacade.findAll();
    }

    public List<Acceso> getAccesos(List<String> codes) {
        List<Acceso> re = new ArrayList<>();
        for (int i = 0; i < codes.size(); i++) {
            re.add(accesoFacade.find(codes.get(i)));
        }
        return re;
    }
    
        public static String sha256(String base) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString().toUpperCase();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getFiltro() {
        return filtro;
    }

    public void setFiltro(List<Usuario> filtro) {
        this.filtro = filtro;
    }

    public DualListModel<String> getAccesos() {
        return accesos;
    }

    public void setAccesos(DualListModel<String> accesos) {
        this.accesos = accesos;
    }



}
