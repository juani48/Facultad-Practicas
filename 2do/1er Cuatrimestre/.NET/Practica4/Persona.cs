using System;
using System.Collections.Generic;
using System.Diagnostics.Contracts;
using System.Linq;
using System.Threading.Tasks;

namespace Practica4
{
    public class Persona (string nombre, int edad, int dni)
    { 
        string _nombre = nombre;
        int _edad = edad;
        int _dni = dni;
        
        public string Imrpimir(){
            return $"{_nombre,-10} {_edad,-3} {_dni,-10}";
        }

        public bool EsMayorQue(Persona p){
            return this._edad > p._edad;
        }
    }
}