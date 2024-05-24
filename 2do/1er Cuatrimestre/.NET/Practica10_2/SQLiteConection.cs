using System.Data.Common;
using System.Net;

namespace Practica10_2;

public static class SQLiteConection
{
    public static void Inicializar(){
        using var db = new Context();

        if(db.Database.EnsureCreated()){
            Console.WriteLine("La base de datos fue crada.");
        }
    }

    public static void AgregarJuego(Juego juego){
        using var db = new Context();
        db.Add(juego);
        db.SaveChanges();
        Console.WriteLine($"-- Se agregó el juego \"{juego.Nombre}\" al que se le asignó el Id {juego.Id}");
    }
    public static void AgregarCliente(Cliente cliente){
        using var db = new Context();
        db.Add(cliente);
        db.SaveChanges();
        Console.WriteLine($"-- Se agregó el cliente \"{cliente.ApellidoYNombre}\" al que se le asignó el Id {cliente.Id}");
    }
    public static void AgregarAlquiler(Alquiler alquiler){
        using var db = new Context();
        db.Add(alquiler);
        db.SaveChanges();
        Console.WriteLine($"-- Se agregó un Alquiler al que se le asignó el Id {alquiler.Id}");
    }

    public static void ListarJuegos(){
        using var db = new Context();
        Console.WriteLine("-- Listado de Juegos --");
        db.Juegos.Select(j => new {
                            Id = j.Id,
                            Nombre = j.Nombre,
                            Descripcion = j.Descripcion,
                            Estado = j.Estado,
                            Precio = j.PrecioPorDia})
                .ToList()
                .ForEach(j => Console.WriteLine(j));
    }

    public static void ListarClientes(){
        using var db = new Context();
        Console.WriteLine("-- Listado de Clientes --");
        db.Clientes.Select(c => new {
                            Id = c.Id,
                            DNI = c.DNI,
                            Nombre = c.ApellidoYNombre,
                            Direccion = c.Direccion,
                            Tel = c.Telefono})
                .ToList()
                .ForEach(c => Console.WriteLine(c));
    }
    public static void ListarAlquileres(){
        using var db = new Context();
        Console.WriteLine("-- Listado de Alquileres --");
        var query = db.Alquileres.Join(db.Clientes,
                                    a => a.IdCliente,
                                    c => c.Id,
                                    (a, c) => new {
                                        Id = a.Id,
                                        Fecha = a.Fecha,
                                        FechaDevolucion = a.FechaDevolucion,
                                        Cliente = c.ApellidoYNombre,
                                        Juego = a.IdJuego,
                                        Monto = a.CostoTotal
                                    });
        query.Join(db.Juegos,
                    q => q.Juego,
                    j => j.Id,
                    (q,j) => new {
                        Id = q.Id,
                        Fecha = q.Fecha,
                        FechaDevolucion = q.FechaDevolucion,
                        Cliente = q.Cliente,
                        Juego = j.Nombre,
                        Monto = q.Monto
                    })
            .ToList()
            .ForEach(q => Console.WriteLine(q));
    }

    public static void ModificarCliente(string dni, string nombre, string dir, string mail, string tel){
        using var db = new Context();
        var query = db.Clientes.Where(c => c.DNI == dni && c.ApellidoYNombre == nombre)
                    .SingleOrDefault();
        if(query != null){
            query.Direccion = dir;
            query.Mail = mail;
            query.Telefono = tel;
            db.SaveChanges();
            Console.WriteLine($"-- Se modifico el Cliente con DNI: {query.DNI} y ID: {query.Id} --");
        }
        else{
            Console.WriteLine($"-- No existe el Cliente con DNI: {dni} y nombre: {nombre} --");
        }
    }
    public static void EliminarCliente(string dni){
        using var db = new Context();
        var query = db.Clientes.Where(c => c.DNI == dni)
                    .SingleOrDefault();
        if(query != null){
            db.Remove(query);
            db.SaveChanges();
            Console.WriteLine($"-- Se elimino el Cliente con DNI: {query.DNI} y ID: {query.Id} --");
        }
        else{
            Console.WriteLine($"-- No existe el Cliente con DNI: {dni} --");
        }
    }
    public static void ModificarJuego(int id, string nombre, string descripcion, string estado, double precio){
        using var db = new Context();
        var query = db.Juegos.Where(j => j.Id == id && j.Nombre == nombre)
                            .SingleOrDefault();
        if(query != null){
            query.Descripcion = descripcion;
            query.Estado = estado;
            query.PrecioPorDia = precio;
            db.SaveChanges();
            Console.WriteLine($"-- Se modificó el Juego con ID: {query.Id} --");
        }
        else{
            Console.WriteLine($"-- No existe el Juego con ID: {id} --");
        }
    }

    public static void ModificarAlquiler(int id, double precio, DateTime fecha){
        using var db = new Context();
        var query = db.Alquileres.Where(a => a.Id == id)
                            .SingleOrDefault();
        if(query != null){
            query.FechaDevolucion = fecha.ToString("dd/MM/yy");
            query.CostoTotal = precio;
            db.SaveChanges();
            Console.WriteLine($"-- Se modificó el Alquiler con ID: {query.Id} --");
        }
        else{
            Console.WriteLine($"-- No existe el Alquiler con ID: {id} --");
        }
    }
}
