package fiuaemex.entities;

import fiuaemex.entities.Alumnos;
import fiuaemex.entities.Asesores;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-01-22T01:27:36")
@StaticMetamodel(Citas.class)
public class Citas_ { 

    public static volatile SingularAttribute<Citas, String> descripcion;
    public static volatile SingularAttribute<Citas, Date> fecha;
    public static volatile SingularAttribute<Citas, Alumnos> alumnoId;
    public static volatile SingularAttribute<Citas, String> estatus;
    public static volatile SingularAttribute<Citas, String> asistencia;
    public static volatile SingularAttribute<Citas, String> hora;
    public static volatile SingularAttribute<Citas, Integer> id;
    public static volatile SingularAttribute<Citas, Asesores> asesorId;

}