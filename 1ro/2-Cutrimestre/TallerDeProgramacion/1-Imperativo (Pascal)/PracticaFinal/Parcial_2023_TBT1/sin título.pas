program untitled;
Const
	diaMax = 31;
Type
	rangoDias = 1..diaMax;

	venta = record
		cod_cliente : integer;
		dia : rangoDias;
		cant_productos : integer;
		monto : double;
		end;
	
	lista = ^nodo1;
	nodo1 = record
		elem : venta;
		sig : lista;
		end;
	
	arbol= ^nodo2;
	nodo2 = record
		cod_cliente : integer;
		lista : lista;
		HD : arbol;
		HI : arbol;
		end;

procedure CargarVenta(var v : venta);
begin
	Randomize;
	readln(v.cant_productos);
	if(v.cant_productos <> 0)then begin
		v.cod_cliente := Random(99);
		v.dia := Random(32);
		v.monto := Random(100);
	end;
end;

procedure InsertarOrdenado(var l : lista; v : venta);
var
	ant, act, aux : lista;
begin
	new(aux);
	aux^.elem := v;
	act := l;
	while(act <> nil)and(act^.elem.cant_productos > v.cant_productos)do begin
		ant := act;
		act := act^.sig;
	end;
	if(act = l)then
		l := aux
	else
		ant^.sig := aux;
	aux^.sig := act;
end;

procedure NuevoNodo(var arb : arbol; v : venta);
begin
	new(arb);
	arb^.cod_cliente := v.cod_cliente;
	arb^.HD := nil;
	arb^.HI := nil;
	arb^.lista := nil;
	InsertarOrdenado(arb^.lista,v);
end;

procedure Agregar (var arb : arbol; v : venta);
begin
	if(arb = nil)then begin
		NuevoNodo(arb,v);
	end
	else begin
		if(arb^.cod_cliente = v.cod_cliente) then
			InsertarOrdenado(arb^.lista,v)
		else if(arb^.cod_cliente < v.cod_cliente)then
			Agregar(arb^.HD,v)
		else
			Agregar(arb^.HI,v);
	end;
end;

procedure CargarArbol(var arb : arbol);
var
	v : venta;
begin
	CargarVenta(v);
	while(v.cant_productos <> 0)do begin
		Agregar(arb,v);
		CargarVenta(v);
	end;
end;

function Busqueda (arb : arbol; cod : integer): lista;
begin
	if(arb <> nil)then begin
		if(arb^.cod_cliente = cod)then
			Busqueda:= arb^.lista
		else if(arb^.cod_cliente < cod)then
			Busqueda := Busqueda(arb^.HD,cod)
		else
			Busqueda := Busqueda(arb^.HI,cod);
	end
	else
		Busqueda := nil;
end;

function MayorMonto(l : lista):double;
begin
	MayorMonto := l^.elem.monto;
end;

VAR
	arb : arbol;
	codigo_cliente : integer;
BEGIN
	arb := nil;
	CargarArbol(arb);
	readln(codigo_cliente);
	writeln(MayorMonto(Busqueda(arb,codigo_cliente)));
END.

