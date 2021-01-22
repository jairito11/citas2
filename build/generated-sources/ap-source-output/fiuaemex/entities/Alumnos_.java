package fiuaemex.entities;

import fiuaemex.entities.Citas;
import fiuaemex.entities.Evidencias;
import fiuaemex.entities.Materias;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-01-22T03:35:17")
@StaticMetamodel(Alumnos.class)
public class Alumnos_ { 

    public static volatile SingularAttribute<Alumnos, String> nivelEducativo;
    public static volatile SingularAttribute<Alumnos, String> paterno;
    public static volatile SingularAttribute<Alumnos, String> nombre;
    public static volatile SingularAttribute<Alumnos, String> materno;
    public static volatile ListAttribute<Alumnos, Evidencias> evidenciasList;
    public static volatile SingularAttribute<Alumnos, String> password;
    public static volatile SingularAttribute<Alumnos, Integer> avance;
    public static volatile SingularAttribute<Alumnos, String> correo;
    public static volatile SingularAttribute<Alumnos, String> matricula;
    public static volatile SingularAttribute<Alumnos, Materias> materiaId;
    public static volatile SingularAttribute<Alumnos, Integer> id;
    public static volatile SingularAttribute<Alumnos, String> telefono;
    public static volatile ListAttribute<Alumnos, Citas> citasList;

}