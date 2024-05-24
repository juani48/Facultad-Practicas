using Microsoft.EntityFrameworkCore;
namespace Practica10_1;

public class Ej3Context : DbContext
{
    public DbSet<Alumno> Alumnos {get; set;}
    public DbSet<Examen> Examenes {get; set;}
    public DbSet<Curso> Cursos {get; set;}

    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder){
        optionsBuilder.UseSqlite("data source=Escuela.sqlite");
    }
}
