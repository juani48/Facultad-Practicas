
using Practica10_2;

SQLiteConection.Inicializar();
var juego1 = new Juego()
    {
        Nombre = "Cama Elastica",
        Descripcion = "Medida de 2 x 2",
        Estado = "Bueno",
        PrecioPorDia = 1000
    };
var juego2 = new Juego()
    {
        Nombre = "Castillo",
        Descripcion = "Hasta 10 personas",
        Estado = "Nuevo",
        PrecioPorDia = 1200
    };

SQLiteConection.AgregarJuego(juego1);
SQLiteConection.AgregarJuego(juego2);
SQLiteConection.ListarJuegos();

var cliente1 = new Cliente()
    {
        DNI = "20569784",
        ApellidoYNombre = "Perez, Juan",
        Direccion = "48 e/ 5 y 6 N°520"
    };
var cliente2 = new Cliente()
    {
        DNI = "10569784",
        ApellidoYNombre = "Gonzalez, Alejandra",
        Direccion = "25 e/ 9 y 10 N°520",
        Mail = "gale@gmail.com",
        Telefono = "221-15-569874"
    };

SQLiteConection.AgregarCliente(cliente1);
SQLiteConection.AgregarCliente(cliente2);
SQLiteConection.ListarClientes();

var alquiler1 = new Alquiler()
    {
        IdCliente = 1,
        IdJuego = 1,
        Fecha = DateTime.Now.ToString()
    };
var alquiler2 = new Alquiler()
    {
        IdCliente = 1,
        IdJuego = 2,
        Fecha = DateTime.Now.ToString()
    };
SQLiteConection.AgregarAlquiler(alquiler1);
SQLiteConection.AgregarAlquiler(alquiler2);
SQLiteConection.ListarAlquileres();

SQLiteConection.ModificarCliente("10569784", "Gonzalez, Alejandra", "52 e/ 9 y 10 N°520", "gale@gmail.com", "221-15-569874");
SQLiteConection.ListarClientes();
SQLiteConection.EliminarCliente("10569784");
SQLiteConection.ListarClientes();
SQLiteConection.ModificarJuego(1, "Cama Elastica", "Medida de 2 x 2", "Roto", 1500);
SQLiteConection.ListarJuegos();
SQLiteConection.ModificarAlquiler(1, 1562.25, new DateTime(2021 / 11 / 12));
SQLiteConection.ListarAlquileres();