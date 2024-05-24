using Microsoft.EntityFrameworkCore;
namespace Practica10_1;

public class Examen
{
    public int ExamenId { get; set; }
    public double Nota {get; set;}
    public int CursoId {get; set;}
    public int AlumnoId {get; set;}
}
