program Ej8;
Const
    fisico = 'Archivo_distribuciones.dat';
Type
    distribucion = record
        nombre : string;
        ano : string;
        version : integer;
        desarrolladores : integer;
        descrpcion : string;
    end;

    archivo = file of distribucion;

procedure Inicializar (var arch : archivo);
var
    x : distribucion;
begin
    rewrite(arch);
    x.desarrolladores := 0;
    x.nombre := '';
    x.ano := '';
    x.descrpcion := '';
    x.version := 0;
    write(arch,x);
end;

function ExisteDistribucion(var arch : archivo;var num : integer; nombre : string): boolean;
var
    x : distribucion;
    ok : boolean;
begin
    reset(arch);
    if(not eof(arch))then begin
        read(arch,x);
        while(not eof(arch))and(x.nombre <> nombre)do
            read(arch,x);
        if(x.nombre = nombre)then begin
            ok := true;
            num := filepos(arch) - 1;
        end
        else
            ok := false;
        close(arch);
        ExisteDistribucion := ok;
    end;
end;

procedure Alta (var arch : archivo; x : distribucion);
var 
    aux : distribucion;
    num : integer;
begin
    reset(arch);
    read(arch,aux);
    if(aux.desarrolladores = 0)then begin
        seek(arch,filesize(arch));
        write(arch,x);
    end
    else begin
        num := aux.desarrolladores * -1;
        seek(arch,num);
        read(arch,aux);
        seek(arch,filepos(arch) - 1);
        write(arch,x);
        seek(arch,0);
        write(arch,aux);
    end;
    close(arch);
end;

procedure AltaDistribucion(var arch : archivo);
var
    x : distribucion;
    num : integer;
begin
    write('Ingrese el nombre: '); readln(x.nombre);
    //resto de valores
    write('Ingrese los desarrollasores: '); readln(x.desarrolladores);
    if(ExisteDistribucion(arch,num,x.nombre))then begin
        writeln('Ya existe la distribucion.');
    end
    else begin
        Alta(arch,x);
        writeln('Ditribucion agregada.');
    end;
end;

procedure Baja (var arch : archivo; num : integer);
var
    aux : distribucion;
    pos : integer;
begin
    reset(arch);
    //enlazar la cabecera con el nuevo registro eliminado
    read(arch,aux);
    pos := aux.desarrolladores;
    aux.desarrolladores := num * -1;
    seek(arch,filepos(arch) - 1);
    write(arch,aux);
    //eliminar el registro y enlzarlo con el que antes era el primero
    seek(arch,num);
    read(arch,aux);
    aux.desarrolladores := pos;
    seek(arch,filepos(arch) - 1);
    write(arch,aux);

    close(arch);
end;

procedure BajaDistribucion(var arch : archivo);
var
    nombre : string;
    num : integer;
begin
    write('Ingrese el nombre: '); readln(nombre);
    if(ExisteDistribucion(arch,num,nombre))then begin
        Baja(arch,num);
        writeln('Baja realizada.');
    end
    else   
        writeln('La distribucion no existe.');
end;

procedure Mostar (var arch : archivo);
var
    x : distribucion;
begin
    reset(arch);
    while(not eof(arch))do begin
        read(arch,x);
        writeln('Nombre: ', x.nombre,' --- Desarrolladores: ', x.desarrolladores);
    end;
    close(arch);
end;

var
    arch : archivo;
    num : integer;
    ok : boolean;
begin
    num := 0;
    ok := true;
    assign(arch,fisico);
    while(ok)do begin
        write('1_Alta --- 2_Baja --- 3_Mostar --- 4_Inicializar ---: ');readln(num);
        case num of
            1: AltaDistribucion(arch);
            2: BajaDistribucion(arch);
            3: Mostar(arch);
            4: Inicializar(arch);
            else ok := false;
        end;
        writeln('--------------');
    end;
end.