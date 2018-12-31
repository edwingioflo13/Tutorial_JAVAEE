package susolabs.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import susolabs.entidades.Acceso;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-31T13:49:35")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> nombreusuario;
    public static volatile SingularAttribute<Usuario, String> clave;
    public static volatile ListAttribute<Usuario, Acceso> accesoList;

}