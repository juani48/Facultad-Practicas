## ¿Cuál es la forma de evaluación que utilizan los lenguajes funcionales?

La forma de evaluar es a través de un mecanismo de reducción o simplificación, independientemente la forma de evauluarlas, siempre se llegara al mismo resultado. Dentro de la reduccion exiten tres formas:
1. Orden aplicativo: Aunque no lo necesite siempre evalúa los argumentos.
2. Orden normal (lazy evaluation): No calcula más de lo necesario. La expresión no es evaluada hasta que su valor se necesite. Una expresión compartida no es evaluada más de una vez.
3. Diferida (Haskell).

