using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.InteropServices.Marshalling;
using System.Threading.Tasks;

namespace Practica4
{
    public class Hora (int hs, int min, int sec)
    {
        int _hs = hs;
        int _min = min;
        int _sec = sec;

        public string Imprimir(){
            return $"{_hs} horas, {_min} minutos, {_sec} segundos";
        }
    }
}