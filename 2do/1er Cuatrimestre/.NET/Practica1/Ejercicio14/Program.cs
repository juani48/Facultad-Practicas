using System;

namespace MyApp // Note: actual namespace depends on the project name.
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int a = 1;
            int b = 2;

            int num = (a < b) ? a : b;

            Console.WriteLine(num);
        }
    }
}