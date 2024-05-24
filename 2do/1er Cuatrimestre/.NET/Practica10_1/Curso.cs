namespace Practica10_1;

public class Curso
{
    public int CursoId { get; set; }
    public string Titulo { get; set; } = "";
    public List<Examen>? Examenes {get; set;}
}
