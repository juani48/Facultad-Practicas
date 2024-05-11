program untitled;
Const
	horasMax = 8;
Type
	cantHoras = 1..horasMax;
	dias = 1..31;
	meses = 1..12;
	
	horas = record
		numero : integer;
		dia : integer;
		mes : integer;
		cant : cantHoras;
		end;
	arbol = ^nodo;
	nodo = record
		elem : horas;
		HD : arbol;
		HI : arbol;
		end;
		
	lista = ^nodo1;
	nodo1 = record
		elem : horas;
		sig : lista;
		end;

procedure cargarHoras (var x : horas);
begin
	writeln('inicio de carga de las horas');
	x.numero := Random(101);
	if(x.numero <> 0)then begin
		x.dia := 1 + Random(31);
		x.mes := 1 + Random(12);
		x.cant := 1 + Random(horasMax);
	end;
end;

procedure nuevoNodo (var arb : arbol; x : horas);
begin
	new(arb);
	arb^.elem := x;
	arb^.HD := nil;
	arb^.HI := nil;
end;

procedure agregar (var arb : arbol; x : horas);
begin
	if(arb = nil)then
		nuevoNodo(arb,x)
	else
		if(x.numero > arb^.elem.numero)then
			agregar(arb^.HD,x)
		else
			agregar(arb^.HI,x);
end;

procedure cargarArbol (var arb : arbol);
var
	x : horas;
begin
	cargarHoras(x);
	while(x.numero <> 0)do begin
		agregar(arb,x);
		writeln('nueva carga de horas');
		cargarHoras(x);
	end;
	writeln('fin de la carga de horas');
end;

procedure AgregarAdelante (var l : lista; x : horas);
var
	nuevo : lista;
begin
	new(nuevo);
	nuevo^.elem := x;
	nuevo^.sig := l;
	l := nuevo;
end;

procedure EntreNumeros (arb : arbol; var l : lista; sup : integer; inf : integer);
begin
	if(arb <> nil)then
		if(arb^.elem.numero <= sup)and(arb^.elem.numero >= inf)then begin
			AgregarAdelante(l,arb^.elem);
			EntreNumeros(arb^.HD,l,sup,inf);
			EntreNumeros(arb^.HI,l,sup,inf);
		end
		else
			if(arb^.elem.numero > sup)then
				EntreNumeros(arb^.HI,l,sup,inf);
end;

procedure puntoB (arb : arbol; var l : lista);
var
	sup, inf, x : integer;
begin
	writeln('ingrese un extremo superior');
	readln(sup);
	writeln('ingese un extremo inferior');
	readln(inf);
	if(inf > sup)then begin
		x := sup;
		sup := inf;
		inf := x;
	end;
	EntreNumeros(arb,l,sup,inf);
	writeln('se a terminado de cargar la lista con los horarios entre los rangos');
end;

function recorrerLista (l : lista): integer;
begin
	if(l <> nil)then
		recorrerLista := l^.elem.cant + recorrerLista(l^.sig)
	else
		recorrerLista := 0;
end;

VAR
	arb : arbol;
	l : lista;
	totalHoras : integer;
BEGIN
	Randomize;
	arb := nil;
	l := nil;
	cargarArbol(arb);
	
	puntoB(arb,l);
	totalHoras := recorrerLista(l);
	writeln('las horas totales trabajadas son: ',totalHoras);
END.

