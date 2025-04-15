## Sea el siguiente programa en ADA, completar el cuadro siguiente indicando para cadavariable de que tipo es en cuanto al momento de ligadura de su l-valor, su r-valor al momento de alocación en memoria y para todos los identificadores cuál es su alcance y cual es su el tiempo de vida. Indicar para cada variable su r-valor al momento de alocación en memoria.

```ada
01: with text_io; use text_io;
02: Procedure Main is;
03: type vector is array(integer range <>);
04: a, n, p:integer;
05: v1:vector(1..100);
06: c1: constant integer:=10;
07: Procedure Uno is;
08: type puntero is access integer;
09: v2:vector(0..n);
10: c1, c2: character;
11: p,q: puntero;
12: begin
13: n:=4;
14: v2(n):= v2(1) + v1(5);
15: p:= new puntero;
16: q:= p;
17: free p;
18: free q;
19: end;
20: begin
21: n:=5;
22: Uno;
23: a:= n + 2;
24: end
```

| ID | Tipo | R-Valor | Alcance | T.V. |
|----|------|---------|---------|------|
|Main| | | 2...24 | 2...24 |
| a | Automatica | Basura | 5...24 | 1...24 |
| n | Automatica | Basura | 5...24 | 1...24 |
| p | Automatica | Basura | 5...10 - 19...24 | 1...24 |
| v1 | Automatica | Basura | 6...24 | 1...24 |
| c1 | Automatica | 10 | 7...10 - 19...24 | 1...24 |
| Uno | | | 7...24 | 7...19 |
| v2 | Semidinamica | Basura | 10...19 | 7...19 |
| c1 | Automatica | Basura | 11...19 | 7...19 |
| c2 | Automatica | Basura | 11...19 | 7...19 |
| p | Automatica | Basura | 12...19 | 7...19 |
| q | Automatica | Basura | 12...19 | 7...19 |
| p^ | Dinamica | Basura | 16...17 | 15...17 |
| q^ | Dinamica | Basura | 16...17 | 15...17 |

