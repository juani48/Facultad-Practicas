namespace Practica10_1;

public class Ej3SQLite
{
    public static void Inicializar(){
        using var db = new Ej3Context();
        if(db.Database.EnsureCreated()){
            Console.WriteLine("Se creo la base de datos.");

            db.Add(new Curso(){
                Titulo = "Ingles"
            });

            db.Add(new Curso(){
                Titulo = "Matematicas"
            });

            db.Add(new Curso(){
                Titulo = "Historia"
            });

            db.Add(new Curso(){
                Titulo = "Geografia"
            });

            db.Add(new Curso(){
                Titulo = "Literatura"
            });

            db.Add(new Curso(){
                Titulo = "Contabilidad"
            });

            db.Add(new Alumno() {
                Nombre = "Juan",
                Examenes = new List<Examen>()}
            );
            
            db.Add(new Alumno() {
                Nombre = "Ana",
                Examenes = new List<Examen>(){
                    new Examen() {
                        Nota = 5,
                        CursoId = 1
                    },
                    new Examen() {
                        Nota = 8,
                        CursoId = 4
                    }
                }
            });

            db.Add(new Alumno(){
                Nombre = "Andres",
                Examenes = new List<Examen>(){
                    new Examen() {
                        Nota = 10,
                        CursoId = 4
                    }
                }
            });

            db.Add(new Alumno() {
                Nombre = "Paula",
                Examenes = new List<Examen>(){
                    new Examen(){
                        Nota = 7,
                        CursoId = 5
                    },
                    new Examen() {
                        Nota = 9,
                        CursoId = 3
                    }
                }
            });

            db.Add(new Alumno() {
                Nombre = "Sebastian",
                Examenes = new List<Examen>()
            });

            db.Add(new Alumno() {
                Nombre = "Maria",
                Examenes = new List<Examen>(){
                    new Examen(){
                        Nota = 9,
                        CursoId = 5
                    },
                    new Examen(){
                        Nota = 5,
                        CursoId = 4
                    }
                }
            });

            db.Add(new Alumno(){
                Nombre = "Camila",
                Examenes = new List<Examen>(){
                    new Examen(){
                        Nota = 5,
                        CursoId = 3
                    },
                    new Examen() {
                        Nota = 9,
                        CursoId = 5
                    }
                }
            });

            db.Add(new Alumno() {
                Nombre = "Ivan",
                Examenes = new List<Examen>()
            });

            db.Add(new Alumno(){
                Nombre = "Raul",
                Examenes = new List<Examen>(){
                    new Examen(){
                        Nota = 7,
                        CursoId = 1
                    },
                    new Examen(){
                        Nota = 1,
                        CursoId = 4
                    }
                }
            });
            
            db.SaveChanges();
        }
        else{
            Console.WriteLine("La base de datos ya existe.");
        }
    }
}
