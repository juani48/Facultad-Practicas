using System;
using System.Linq.Expressions;
using System.Text;

namespace MyApp // Note: actual namespace depends on the project name.
{
    internal class Program
    {
        static void Main(string[] args)
        {
            ej2();
        }

        public void ej1 (){
            Console.CursorVisible = false;
            ConsoleKeyInfo k = Console.ReadKey(true);
            while (k.Key != ConsoleKey.End)
            {
                Console.Clear();
                Console.Write($"{k.Modifiers}-{k.Key}-{k.KeyChar}");
                k = Console.ReadKey(true);
            }
        }

        static void ej2(){
            double[,] matriz = new double[,] {{1.5,2.5,0.3,1.4},{5.6,6.5,7.0,0.8},{9,10.12,11.2,12},{2.13,1.4,12.15,16.4}};
            string formatString = "0.000";
            //ImprimirMatriz(matriz);
            //GetDiagonalPrincipal(matriz);
        }
        //2
        static void ImprimirMatriz(double[,] matriz){
            int tF = matriz.GetLength(0);
            int tC = matriz.GetLength(1);
            for(int f = 0; f < tF; f++){
                for(int c = 0; c < tC; c++){
                    Console.Write(matriz[f,c] + "-");
                }
                Console.WriteLine("");
            }
        }
        //4 GetDiagonalSecundaria es es mismo coidgo pero el for es con f = dim (4) y c = 0, en cada ciclo c++ f--
        static double[] GetDiagonalPrincipal( double[,] matriz){
            int dimF = matriz.GetLength(0);
            int dimC = matriz.GetLength(1);
            double[] diag = new double[dimF];

            for(int f = 0; f < dimF; f++){
                dimC = matriz.GetLength(1);
                if(dimF == dimC)
                    diag[f] = matriz[f,f];
                else 
                    throw new ArgumentException("La matriz no es cuadrada");
            }
            return diag;
        }
    
        static double[][] GetArregloDeArreglo(double [,] matriz){
            int dimF = matriz.GetLength(0);
            int dimC;
            double[][] irregular = new double[dimF][];

            for(int f = 0; f < dimF; f++){
                dimC = matriz.GetLength(1);
                irregular[f] = new double[dimC];
                for(int c = 0; c < dimC; c++){
                    irregular[f][c] = matriz[f,c];
                }
            }
            return irregular;
        }

        static bool Balanceado(string exp){
            Stack<char> pila = new Stack<char>();
            for(int i = 0; i < exp.Length; i++){
                char c = exp[i];
                if(c =='{')
                    pila.Push(c);
                else if(c =='}')
                    try{
                        pila.Pop();
                    }
                    catch(Exception e){
                        Console.WriteLine("La expresion aritmetica no esta balanceada");
                    }       
            }
            if(pila.Count != 0){
                Console.WriteLine("La expresion aritmetica no esta balanceada");
                return false;
            }
            else return true;
        }

        static int ConvercionBinaria(int num){
            Stack<int> pila = new Stack<int>();
            int rest; int count = 0;
            
            while(num / 2 != 1){
                pila.Push(num%2);
                rest = num/2;
                num = rest;
                count++;
            }
            int[] binario =
        } 
        
    }
}