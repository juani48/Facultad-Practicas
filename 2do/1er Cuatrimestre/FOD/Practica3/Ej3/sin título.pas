program untitled;
uses
	SysUtils;
Const
	fisico = 'archivo_novelas.dat';
	fisico_txt = 'archivo_novelas.txt';
Type
	novela = record
		cod : integer;
		genero : string;
		nombre : string;
		duracion : double;
		director : string;
		precio : double;
		end;
	
	archivo = file of novela;

procedure cargarNovela(var x : novela);
begin
	write('Ingrese codigo de novela: ');
	readln(x.cod);
	x.genero := 'genero' + IntToStr(x.cod);
	x.nombre := 'nombre' + IntToStr(x.cod);
	x.duracion := x.cod;
	x.director := 'director' + IntToStr(x.cod);
	x.precio := x.cod;
	
end;

function buscar (var arch : archivo; var x : integer):boolean;
var
	aux : novela;
	ok : boolean;
begin
	reset(arch);
	read(arch,aux);
	while( not eof(arch))and(aux.cod <> x)do
		read(arch,aux);
	if(aux.cod = x)then begin
		x := filepos(arch) -1;
		ok := true;
	end
	else
		ok := false;
	buscar := ok;
	close(arch);
end;

procedure Inicializar(var arch : archivo);
var
	x : novela;
begin
	rewrite(arch);
	x.cod := 0;
	x.genero := 'nada';
	x.nombre := 'nada';
	x.duracion := 0;
	x.director := 'nada';
	x.precio := 0;
	write(arch,x);
	close(arch);
end;

procedure Alta (var arch : archivo);
var
	x : novela;
	pos : integer;
begin
	reset(arch);
	read(arch,x);
	if(x.cod <> 0)then begin
		pos := x.cod * -1;
		seek(arch,pos);
		read(arch,x);
		seek(arch,0);
		write(arch,x);
	end
	else
		pos := filesize(arch);
	seek(arch,pos);
	cargarNovela(x);
	write(arch,x);
	close(arch);
end;

procedure Baja (var arch : archivo; num : integer);
var
	x : novela;
	pos : integer;
begin
	writeln('Inicio la baja...');
	if(buscar(arch,num))then begin
		reset(arch);
		seek(arch,0);
		read(arch,x);
		if(x.cod = 0)then begin
			seek(arch,0);
			x.cod := num * -1;
			write(arch,x);
			seek(arch,num);
			read(arch,x);
			x.cod := 0;
			seek(arch, filepos(arch) -1);
			write(arch,x);
		end
		else begin
			pos := x.cod;
			x.cod := num * -1;
			seek(arch,0);
			write(arch,x);
			seek(arch,num);
			read(arch,x);
			x.cod := pos;
			seek(arch,filepos(arch) -1);
			write(arch,x);
		end;
	end
	else
		writeln('No existe el archivo a eliminar.');
	close(arch);
end;

procedure ImportarText (var arch : archivo; var txt : Text);
var
	x : novela;
begin
	reset(arch);
	seek(arch,1);
	rewrite(txt);
	while(not eof(arch))do begin
		read(arch,x);
		writeln(txt, x.cod,' ',x.duracion,' ',x.precio);
		writeln(txt, x.genero);
		writeln(txt, x.nombre);
		writeln(txt, x.director);
	end;
	close(arch);
	close(txt);
end;

procedure MostrarDat(var arch : archivo);
var
	x : novela;
begin
	reset(arch);
	while(not eof(arch))do begin
		read(arch,x);
		writeln('---->',x.cod,' ', x.duracion,' ', x.precio,' ',x.genero,' ',x.nombre,' ',x.director);
	end;
	close(arch);
end;

VAR
	arch : archivo;
	txt : Text;
	ok : boolean;
	num : integer;
BEGIN
	assign(arch,fisico);
	assign(txt, fisico_txt);
	//Inicializar(arch);
	ok := true;
	num := 0;
	while(ok)do begin
		writeln('-----------------------------------------------------');
		writeln('1-Alta. 2-Texto. 3-Baja. 4-Mostrar. 5-Resetear.'); read(num);
		if(num = 1)then begin
			Alta(arch);
		end
		else begin
			if(num = 2)then begin
				ImportarText(arch,txt);
			end
			else begin
				if(num = 3)then begin
					write('Ingrese un codigo: '); read(num);
					Baja(arch,num);
				end
				else begin
					if(num = 4)then begin
						MostrarDat(arch);
					end
					else begin
						if(num = 5)then
							Inicializar(arch)
						else
							ok := false;
					end;
				end;
			end;
		end;
	end;
END.

