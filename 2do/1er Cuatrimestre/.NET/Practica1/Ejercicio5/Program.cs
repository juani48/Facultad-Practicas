using System;
using System.Buffers;

namespace MyApp // Note: actual namespace depends on the project name.
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string ? st = Console.ReadLine();
            if(st == null)
            {
                Console.WriteLine("Buen dia mundo");
            }
            else
            {
                st.ToLower();
                switch(st)
                {
                case "juan":
                    Console.WriteLine("Hola amigo!");
                break;
                case "maria":
                    Console.WriteLine("Buen dia señora");
                break;
                case "alberto":
                    Console.WriteLine("Hola Alberto");
                break;
                default:
                    Console.WriteLine();
                break;
                }
            }
        }
    }
}