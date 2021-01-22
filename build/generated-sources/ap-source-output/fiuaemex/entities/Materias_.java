package fiuaemex.entities;

import fiuaemex.entities.Alumnos;
import fiuaemex.entities.Asesores;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-01-22T01:27:36")
@StaticMetamodel(Materias.class)
public class Materias_ { 

    public static volatile SingularAttribute<Materias, String> descripcion;
    public static volatile ListAttribute<Materias, Alumnos> alumnosList;
    public static volatile SingularAttribute<Materias, Integer> id;
    public static volatile SingularAttribute<Materias, String> nombre;
    public static volatile SingularAttribute<Materias, Asesores> asesorId;

}