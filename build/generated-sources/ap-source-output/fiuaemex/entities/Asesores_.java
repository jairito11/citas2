package fiuaemex.entities;

import fiuaemex.entities.Citas;
import fiuaemex.entities.Materias;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-01-21T06:12:57")
@StaticMetamodel(Asesores.class)
public class Asesores_ { 

    public static volatile SingularAttribute<Asesores, String> materno;
    public static volatile SingularAttribute<Asesores, String> password;
    public static volatile SingularAttribute<Asesores, String> paterno;
    public static volatile SingularAttribute<Asesores, String> correo;
    public static volatile SingularAttribute<Asesores, Integer> id;
    public static volatile SingularAttribute<Asesores, String> nombre;
    public static volatile SingularAttribute<Asesores, String> especialidad;
    public static volatile ListAttribute<Asesores, Citas> citasList;
    public static volatile SingularAttribute<Asesores, Materias> materias;

}