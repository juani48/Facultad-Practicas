program P7 E2;

TYPE
	
	cliente = record;
		codigo : integer;
		DNI : integer;
		apellido : string;
		nombre : string;
		poliza : integer[1..6];
		montoBasico : real;
		end;
		
	lista = ^nodo;
	nodo = record;
		elem : cliente;
		sig : lista;
		end;

	PolMonto = array [1..6] of real;
	
procedure CargarPoliza (var p : PolMonto); {cargar el monto adisional de cada poliza}
var
	i : integer;
begin
	for i = 1 to 6 do
		readln(p[i]);
end;

procedure LeerCliente (var c : cliente);
begin
	readln(c.codigo);
	readln(c.DNI);
	readln(c.apellido);
	readln(c.nombre);
	readln(c.poliza);
	readln(c.montoBasico);
end;	

procedure agregarAtras (var l : lista; var ult : lista,c : cliente); {agregar atras}
var
	nuevo : lista;
begin
	new(nuevo);
	nuevo^.elem := c;
	nuevo^.sig := nil;
	if(l = nil)then
		l := nuevo;
	else
		ult^.sig := nuevo;
	ult := nuevo;
end;

procedure cargarLista (var l : lista); {cargar cada elem de la lista}
var
	c : cliente;
	ult : lista;
begin
	repeat
		LeerCliente(c);
		agregarAtras(l,ult,c);
	until(c.codigo = 1122)
end;

procedure InforCli (l : lista; p : PolMonto); {2a de cada cliente}
var
	
begin
	writeln(l^.elem.DNI);
	writeln(l^.elem.apellido);	
	writeln(l^.elem.nombre);
	writeln(l^.elem.montoBasico + p[l^elem.poliza]);
end;

procedure DNI9 (l : lista); {2b de cada cliente}
var
	x, y, cont : integer;
begin
	y := l^.elem.dni
	while(y <> 0)do begin
		x := y MOD 10;
		 if(x = 9)then
			cont := cont + 1;
		y := y DIV 10;
	end;
	if(cont >= 2) then
		writeln(l^.elem.apellido, '',l^.elem.nombre);
end;

procedure recorrerLista (l : lista; p : PolMonto);
var

begin
	while(l <> nil)do begin
		InforCli(l,p);
		DNI9(l);
	end:
end;

procedure Eliminar (var l : lista; x : integer); {eliminar x cliente}
var
	ant,act : lista;
begin
	act := l;
	while(act <> nil) and (act^.elem.dni <> x)do begin
		ant := act;
		act := act^sig;
		end;
	if(act = l)then begin
		l := l^.sig;
		dispose(act);
	end
	else begin
		ant^sig := act^.sig;
		dispose(act);
	end;
end;


{programa principal}
VAR	
	l : lista;
	p : PolMonto;
	x : integer;
BEGIN
	l := nil;
	CargarPoliza(p)
	cargarLista(l); {cargo toda la lista}
	recorrerLista(l,p) {recorro lista para hacer 2a y 2b}
	Eliminar(l,x);
END.

