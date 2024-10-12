## ID: Inscripción a Posgrados.
### TITULO: Como alumno, quiero inscribirme a los posgrados, para poder cursarlos.
Reglas de Negocios: El alumno debe pagar con tarjeta la inscripción.

## Criterios de Aceptación (Inscripción a Posgrados)

### Escenario 1: Inscripción exitosa.
- Dado: Que las condiciones son adecuadas para un pago exitoso.
- Cuando: El alumno ingrese selecciones el posgrado ‘ABC’ y presione “Inscribir”. 
- Entonces: El sistema redirige al alumno al pago de la inscripción, espera respuesta e inscribe al alumno y devuelve los comprobantes de pago e inscripción.

### Escenario 2: Inscripción fallida por error de pago.
- Dado: Que las condiciones son adecuadas para un pago exitoso.
- Cuando: El alumno ingrese selecciones el posgrado ‘ABC’ y presione “Inscribir”. 
- Entonces: El sistema redirige al alumno al pago de la inscripción, espera respuesta e informa “Inscripción fallida, error al pagar la inscripción”.