using System;

namespace MyApp // Note: actual namespace depends on the project name.
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string ? st = Console.ReadLine();
            
            while((st != null)&(st != "")){
                Console.WriteLine(st.Length);
                st = Console.ReadLine();
            }
        }
    }
}