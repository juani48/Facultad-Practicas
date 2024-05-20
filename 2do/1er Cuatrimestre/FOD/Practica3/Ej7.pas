program ej7;
Uses sysutils;
type
    especie = record
      cod : integer;
      nombre :string;
      familia : string;
      descripcion : string;
      zona : string;
    end;

    archivo = file of especie;

procedure cargarEspecieAutomatico(var x : especie; num :integer);
begin
    //write('Ingrese codigo de la especie: ');
    //readln(x.cod);
    x.cod := num;
    x.nombre := 'nombre ' + IntToStr(x.cod);
    x.familia := 'familia ' + IntToStr(x.cod);
    x.descripcion := 'descripcion ' + IntToStr(x.cod);
    x.zona := 'zona ' + IntToStr(x.cod);
end;

procedure CargaAutomatica(var arch : archivo);
var
    num : integer;
    x : especie;
begin
    rewrite(arch);
    num := 0;
    while(num <> -1)do begin
        writeln('Ingrese un codigo:');
        readln(num);
        if(num <> -1)then begin
            cargarEspecieAutomatico(x,num);
            write(arch,x);
        end;
    end;
    close(arch);
end;

procedure Mostrar (var arch : archivo);
var
    x : especie;
begin
    reset(arch);
    while(not eof(arch))do begin
        read(arch,x);
        writeln('Especie: ', x.cod);
    end;
    close(arch);
end;

function Buscar (var arch : archivo; var num : integer): boolean;
var
    x : especie;
    ok : boolean;
begin
    reset(arch);
    if(not eof(arch))then begin
        read(arch,x);
        while(not eof(arch))and(x.cod <> num)do
            read(arch,x);
        if(x.cod = num)then begin
            ok := true;
            num := filepos(arch) -1;
        end
        else
            ok := false;
        close(arch);
        BUscar := ok;
    end;
end;

procedure Baja (var arch : archivo; num : integer);
var
    x : especie;
begin
    if(Buscar(arch,num))then begin
        reset(arch);
        seek(arch,num);
        read(arch,x);
        x.cod := x.cod * -1;
        seek(arch,filepos(arch) - 1);
        write(arch,x);
    end;
    close(arch);
end;

procedure Compactar (var arch : archivo);
var
    x : especie;
    num :integer;
begin
    reset(arch);
    while(not eof(arch))do begin
        read(arch,x);
        if(x.cod < -1)then begin
            num := filepos(arch) - 1;
            seek(arch, filesize(arch)- 1);
            read(arch,x);
            seek(arch, num);
            write(arch,x);
            seek(arch,filesize(arch) - 1);
            truncate(arch);
            seek(arch,num + 1);
        end;
    end;
    close(arch);
end;

var
    arch : archivo;
    num : integer;
begin
    Randomize;
    assign(arch, 'archivo_especies.dat');
    CargaAutomatica(arch);
    Mostrar(arch);
    writeln('---------------');
    writeln('Baja');
    readln(num);
    Baja(arch,num);
    writeln('Baja');
    readln(num);
    Baja(arch,num);
    writeln('Baja');
    readln(num);
    Baja(arch,num);
    writeln('---------------');
    Mostrar(arch);
    writeln('---------------');

    writeln('Compactando...');
    Compactar(arch);
    Mostrar(arch);
end.
