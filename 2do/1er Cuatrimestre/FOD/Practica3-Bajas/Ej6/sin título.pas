program untitled;
Const
	fisico = 'archivo_prendas.dat';
	fisico_nuevo = 'archivo_nuevo.dat';
Type
	prenda = record
		cod_prenda : integer;
		descrpcion : string;
		colores : string;
		tipo_prenda : string;
		stock : integer;
		precio_unitario : double;
		end;
		
	maestro = file of prenda;

procedure cargarPrenda(var x : prenda);
begin
	readln(x.cod_prenda);
end;

procedure Alta(var arch : maestro);
var
	x : prenda;
begin
	cargarPrenda(x);
	reset(arch);
	seek(arch,filesize(arch));
	write(arch,x);
	close(arch);
end;

function Buscar (var arch : maestro; var num : integer): boolean;
var
	x : prenda;
	ok : boolean;
begin
	reset(arch);
	if(filesize(arch) > 0)then begin
		read(arch,x);
		while(not eof(arch))and(x.cod_prenda <> num)do begin
			read(arch,x);
		end;
		if(x.cod_prenda = num)then begin
			num := filepos(arch) -1;
			ok := true;
			writeln('Se encontro!');
		end
		else
			ok := false;
		close(arch);
		Buscar := ok;
	end;
end;

procedure Baja (var arch : maestro; num : integer);
var
	x : prenda;
begin
	if(Buscar(arch,num))then begin
		reset(arch);
		seek(arch,num);
		read(arch,x);
		x.cod_prenda := x.cod_prenda * -1;
		seek(arch,filepos(arch) -1);
		write(arch,x);
		writeln('Se elimino correctamente!');
		close(arch);
	end;
end;

procedure Desfragmentar (var arch : maestro; var new_arch : maestro);
var
	x : prenda;
begin
	reset(arch);
	writeln('a');
	rewrite(new_arch);
	writeln('b');
	while(not eof(arch))do begin
		read(arch,x);
		if(x.cod_prenda > 0)then begin
			writeln('Se agrega ',x.cod_prenda);
			write(new_arch, x);
		end;
	end;
	close(arch);
	close(new_arch);
	assign(arch,fisico_nuevo);
end;

procedure MostrarTodo(var arch : maestro);
var
	x : prenda;
begin
	reset(arch);
	while(not eof(arch))do begin
		read(arch,x);
		writeln('Codigo: ', x.cod_prenda);
	end;
	close(arch);
end;

var
	arch_maestro : maestro;
	new_archivo : maestro;
	num : integer;
BEGIN
	assign(arch_maestro,fisico);
	rewrite(arch_maestro);
	assign(new_archivo,fisico_nuevo);
	
	writeln('Alta');
	Alta(arch_maestro);
	writeln('Alta');
	Alta(arch_maestro);
	writeln('Alta');
	Alta(arch_maestro);
	writeln('Alta');
	Alta(arch_maestro);
	writeln('Alta');
	Alta(arch_maestro);
	writeln('Alta');
	Alta(arch_maestro);
	
	writeln('-------------------');
	MostrarTodo(arch_maestro);
	writeln('-------------------');
	
	writeln('Baja');
	readln(num);
	Baja(arch_maestro,num);
	writeln('Bajas');
	readln(num);
	Baja(arch_maestro,num);
	
	writeln('-------------------');
	MostrarTodo(arch_maestro);
	writeln('-------------------');
	
	Desfragmentar(arch_maestro, new_archivo);
	writeln('-------------------');
	MostrarTodo(arch_maestro);
	
END.

