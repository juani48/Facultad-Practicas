namespace Practica10_2;

public class Alquiler
{
    public int Id { get; set; }
    public int IdCliente { get; set; }
    public int IdJuego { get; set; }
    public string Fecha { get; set; } = "";
    public string FechaTentativaDevolucion { get; set; } = "";
    public string FechaDevolucion { get; set;} = " /   / ";
    public double CostoTotal  { get; set; } = 0;
}
