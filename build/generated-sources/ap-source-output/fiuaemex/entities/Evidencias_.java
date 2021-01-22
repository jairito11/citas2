package fiuaemex.entities;

import fiuaemex.entities.Alumnos;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-01-22T03:35:17")
@StaticMetamodel(Evidencias.class)
public class Evidencias_ { 

    public static volatile SingularAttribute<Evidencias, String> descripcion;
    public static volatile SingularAttribute<Evidencias, Alumnos> alumnoId;
    public static volatile SingularAttribute<Evidencias, String> estatus;
    public static volatile SingularAttribute<Evidencias, Integer> id;
    public static volatile SingularAttribute<Evidencias, String> nombre;

}