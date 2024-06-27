program untitled;
Const
	fisico = 'ArchivoFlores.dat';
Type
	reg_flor = record
		nombre: String[45];
		codigo:integer;
	end;
	
	tArchFlores = file of reg_flor;

procedure Inicializar (var arch : tArchFlores);
var
	x : reg_flor;
begin
	rewrite(arch);
	x.codigo := 0;
	x.nombre := 'nill';
	write(arch,x);
	close(arch);
end;

procedure agregarFlor(var arch : tArchFlores; nombre : string; codigo : integer);
var
	x : reg_flor;
	pos : integer;
begin
	reset(arch);
	read(arch,x);
	if(x.codigo = 0)then begin
		pos := filesize(arch);
	end
	else begin
		pos := x.codigo * -1;
		seek(arch,pos);
		read(arch,x);
		seek(arch,0);
		write(arch,x);
	end;
	seek(arch,pos);
	x.codigo := codigo;
	x.nombre := nombre;
	write(arch,x);
	close(arch);
end;

procedure Mostrar (var arch : tArchFlores);
var
	x : reg_flor;
begin
	reset(arch);
	while(not eof(arch))do begin
		read(arch,x);
		if(x.codigo > 0)then 
			writeln('Codigo: ', x.codigo, ' nombre: ', x.nombre);
	end;
	close(arch);
end;

procedure MostrarTodo(var arch : tArchFlores);
var
	x : reg_flor;
begin
	reset(arch);
	while(not eof(arch))do begin
		read(arch,x);
		writeln('Codigo: ', x.codigo, ' - Nombre: ', x.nombre);
	end;
	close(arch);
end;

function buscar (var arch : tArchFlores; flor : reg_flor):boolean;
var
	x : reg_flor;
	ok : boolean;
begin
	reset(arch);
	read(arch,x);
	while(not eof(arch))and(x.codigo <> flor.codigo)do
		read(arch,x);
	if(x.codigo = flor.codigo)then begin
		ok := true;
		flor.codigo := filepos(arch);
	end
	else
		ok := false;
	
	close(arch);
	buscar := ok;
end;

procedure eliminarFlor (var arch: tArchFlores; flor:reg_flor);
var
	x : reg_flor;
	pos : integer;
begin
	if(buscar(arch,flor))then begin
		reset(arch);
		read(arch,x);
		if(x.codigo = 0)then begin
			x.codigo := flor.codigo * -1;
			seek(arch, filepos(arch) -1);
			write(arch,x);
			seek(arch, flor.codigo);
			read(arch,x);
			x.codigo := 0;
			seek(arch, filepos(arch) -1);
			write(arch,x);
		end
		else begin
			pos := x.codigo * -1;
			x.codigo := flor.codigo * -1;
			seek(arch, filepos(arch) -1);
			write(arch,x);
			seek(arch,flor.codigo);
			read(arch,x);
			flor.codigo := pos * -1;
			seek(arch, filepos(arch) -1);
			write(arch,flor);
		end;
	end;
	close(arch);
end;

VAR
	arch : tArchFlores;
	flor :reg_flor;
	num : integer;
	ok : boolean;
BEGIN
	assign(arch,fisico);
	ok := true;
	num := 0;
	while(ok)do begin
		writeln('-----------------------------------------------------');
		write('1-Alta. 2-Baja. 3-Mostrar. 4-MostrarTodo. 5-Resetear: '); readln(num);
		if(num = 1)then begin
			write('Ingrese un codigo: '); readln(num);
			agregarFlor(arch,'flor',num);
		end
		else begin
			if(num = 2)then begin
				write('Ingrese un codigo: '); readln(flor.codigo);
				flor.nombre := 'nill';
				eliminarFlor(arch,flor);
			end
			else begin
				if(num = 3)then begin
					Mostrar(arch);
				end
				else begin
					if(num = 4)then begin
						MostrarTodo(arch);
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

