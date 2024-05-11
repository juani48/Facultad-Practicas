using System;

namespace MyApp // Note: actual namespace depends on the project name.
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string? st = Console.ReadLine();
            int num = int.Parse(st);
            
            for(int i = num; i > 0; i--){
                if(num % i == 0){
                    Console.WriteLine(i);
                }
            }
            
        }
    }
}