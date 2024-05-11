using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Practica4
{
    public class Ecuacion2
    {
        double _a;
        double _b;
        double _c;

        public Ecuacion2(double num1, double num2, double num3){
            _a = num1;
            _b = num2;
            _c = num3;
        }

        public double GetDiscriminante(){
            double x = _b *_b;
            double y = _a * _c * 4;
            return x - y;
        }
        public int GetCantidadRaices(){
            double x = GetDiscriminante();
            int y = x switch { < 0 => 0, 0 => 1, >0 => 2};
            return y;
        }
    }
}