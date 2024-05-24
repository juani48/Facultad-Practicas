using Practica10_1;
using Microsoft.EntityFrameworkCore;
using System.Data;
using Microsoft.EntityFrameworkCore.Diagnostics;


//Ej3SQLite.Inicializar();
using var db = new Ej3Context();

//a)
/*
db.Alumnos.Where(a => a.Examenes != null && a.Examenes.Count > 0)
        .OrderBy(a => a.Nombre)
        .ToList()
        .ForEach(a => Console.WriteLine(a.Nombre));

*/


//b)
/*
db.Cursos.Where(c => c.Examenes != null && c.Examenes.Count > 0)
    .Select(c => new {Titulo = c.Titulo, Cantidad = c.Examenes.Count })
    .OrderBy(c => c.Cantidad)
    .ToList()
    .ForEach((c) => Console.WriteLine(c));
*/


//c)

var query = db.Examenes.Join(db.Alumnos,
                                e => e.AlumnoId,
                                a => a.AlumnoId,
                                (e, a) => new {
                                        Alumno = a.Nombre,
                                        Curso = e.CursoId,
                                        Nota = e.Nota
                                });
query.Join(db.Cursos,
                q => q.Curso,
                c => c.CursoId,
                (q, c) => new{
                        Alumno = q.Alumno,
                        Curso = c.Titulo,
                        Nota = q.Nota
                })
        .ToList()
        .ForEach(q => Console.WriteLine(q));
