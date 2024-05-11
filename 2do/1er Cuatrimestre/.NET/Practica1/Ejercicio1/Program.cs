using System;

namespace MyApp // Note: actual namespace depends on the project name.
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string st = "Hola Mundo";

            foreach(var item in st){
                if(Console.ReadKey(true).Key == ConsoleKey.Enter){
                    Console.Write(item);
                }
            }
        }
    }
}