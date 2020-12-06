package Models;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-12-01T23:30:20")
@StaticMetamodel(Notificacion.class)
public class Notificacion_ { 

    public static volatile SingularAttribute<Notificacion, Integer> idnoti;
    public static volatile SingularAttribute<Notificacion, Date> fechaenvionoti;
    public static volatile SingularAttribute<Notificacion, Integer> tiponotificacionIdtiponotificacion;
    public static volatile SingularAttribute<Notificacion, Long> tercerosIdtercero;
    public static volatile SingularAttribute<Notificacion, String> terceroreceptor;
    public static volatile SingularAttribute<Notificacion, Integer> cuerponotificacionIdcuerponotificacion;

}