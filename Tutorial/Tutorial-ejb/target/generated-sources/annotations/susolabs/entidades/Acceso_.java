package susolabs.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import susolabs.entidades.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-31T13:49:35")
@StaticMetamodel(Acceso.class)
public class Acceso_ { 

    public static volatile SingularAttribute<Acceso, String> descripcion;
    public static volatile ListAttribute<Acceso, Usuario> usuarioList;
    public static volatile SingularAttribute<Acceso, String> codigoacceso;

}