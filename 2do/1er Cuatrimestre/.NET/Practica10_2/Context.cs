using Microsoft.EntityFrameworkCore;

namespace Practica10_2;

public class Context : DbContext
{
    public DbSet<Cliente> Clientes { get; set; }
    public DbSet<Juego> Juegos{ get; set; }
    public DbSet<Alquiler> Alquileres{ get; set; }

    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
    {
        optionsBuilder.UseSqlite("data source=LocalJuegos.sqlite");
    }
}
