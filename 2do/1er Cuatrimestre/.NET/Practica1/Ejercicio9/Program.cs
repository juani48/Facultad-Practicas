using System;

namespace MyApp // Note: actual namespace depends on the project name.
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string ? st1 = Console.ReadLine();
            string ? st2 = Console.ReadLine();
            if((st1 != null)&&(st2 != null)){

                if(st1.Length == st2.Length){

                    int n = st1.Length;
                    int cont = 0;
                    while(n != 0){

                        if (st1[cont] == st2[n-1]){
                            n--;
                            cont++;
                        }
                        else{
                            break;
                        }
                    }
                    if(n == 0){
                        Console.WriteLine("Los numeros son simetricos");
                    }
                    else{
                        Console.WriteLine("Los numeros no son simetricos");
                    }
                }
                else{
                    Console.WriteLine("Los numeros ingresados no son de igual largo");
                }
            }
            else{
                Console.WriteLine("Alguno de los valores ingresados no existe");
            }
            
        }
    }
}