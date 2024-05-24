namespace Practica10_1;

public class Alumno
{
    public string Nombre { get; set; } = "";
    public int AlumnoId { get; set; }
    public List<Examen>? Examenes { get; set; }
}
