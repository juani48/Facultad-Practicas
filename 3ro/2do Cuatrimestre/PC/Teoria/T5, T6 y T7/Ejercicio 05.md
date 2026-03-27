## ¿En qué consiste la comunicación guardada (introducida por CSP) y cuál es su utilidad? Describa cómo es la ejecución de sentencias de alternativa e iteración que contienen comunicaciones guardadas.

La comunicacion guardada que ofrece CSP permite a los procesos "escuchar" varios canales de comunicacion al mismo tiempo y elegir de forma no determinista cual canal atender.

En una comunicacion guardada hay tres escenarios posibles: La comunicacion guardada tiene exito, lo que indica que la guarda (una condicion boolena) es verdadera y hay un procesos queriendo comunicarse por el canal escuchado, de esta forma, se realiza la comunicacion y la seria de sentencias que se hayan asociado a la comunicacion guardada. Otro caso es que la guarda se bloque, donde la guardia sea verdadera pero no haya procesos queriendo comunicarse por el canal, de esta forma el proceso se demora en la comunicion guardada hasta que alguna guarda falle o hasta que un procesos quiera comunicarse por algun canal escuchado. Por ultimo, una comunicacion guardada falla cuando la guarda es falsa, indepenedientemente de si hay procesos o no en el canal.


