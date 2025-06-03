## Sea el siguiente programa escrito en Pascal:
```pascal
Procedure Manejador();
begin
    ...
end;
Procedure P(X:Proc);
begin
    ...
    if Error then X;
    ...
end;
Procedure A;
begin
    ...
    P(Manejador);
    ...
end;
```

### ¿Qué modelo de manejo de excepciones está simulando? ¿Qué necesitaría el programa para que encuadre con los lenguajes que no utilizan este modelo? Justifique la respuesta.

Se intenta simular al modelo de reanudacion. El pgroama necesaria solamente definir el manejador y al producirse la excepcion, dentro del bloque de captura de la excepcion, se realiza el llamada al manejador.

