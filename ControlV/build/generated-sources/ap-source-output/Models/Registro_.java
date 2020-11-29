package Models;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-11-29T17:43:35")
@StaticMetamodel(Registro.class)
public class Registro_ { 

    public static volatile SingularAttribute<Registro, Date> horaFecha;
    public static volatile SingularAttribute<Registro, String> vehiculoMatricula;
    public static volatile SingularAttribute<Registro, Integer> pesototal;
    public static volatile SingularAttribute<Registro, Integer> idregistro;
    public static volatile SingularAttribute<Registro, String> origen;
    public static volatile SingularAttribute<Registro, String> destino;
    public static volatile SingularAttribute<Registro, Integer> tipomovimientoIdtipomovimiento;

}