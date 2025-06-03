## ¿Qué ocurre cuando un lenguaje no provee manejo de excepciones? ¿Se podría simular? Explique cómo lo haría

Cuando un lenguaje no provee manejo de excepciones obliga al rpogramadar a mantener mas condiconales en su codigo, para que este no termine de manera abrupta debido a alguna excepcion.

Se posrain simular las excepciones definiendo algun tipo enumerativo (y si el lengujae no soporta enumerativos, mediante strings) y previo a realizar alguna operacion realizaria un chequeo de los datos, corroborando que cumplen las condiciones para que el programa no termine, en caso de que el checqueo sea falso, retornaria el tipo enumerativo definido, el cual esataria relacionado a un tipo de excepcion.