## 9 - Crear una nueva base de datos llamada "tours" y una coleccion llamada "recorridos".

En MongoDB, la base de datos y la colección se crean de manera implícita al insertar el primer documento. Para crearlas explícitamente, puedes usar:
```javascript
use tours
db.createCollection("recorridos")
```
Pero la forma más práctica es cambiar a la base de datos y luego insertar un documento; MongoDB creará tanto la BD como la colección automáticamente:
```sh
use tours
```
## 10 - En la nueva coleccion, utilizando el comando correspondiente, insertar el siguiente documento:
```javascript
db.recorridos.insertOne({
    "nombre": "City Tour",
    "precio": 200,
    "stops": ["Diagonal Norte", "Avenida de Mayo", "Plaza del Congreso"],
    "totalKm": 5
})
```
## 11 - Recuperar la informacion insertada usando db.recorridos.find() (puede agregarse .pretty() al final para ver los datos indentados). ¿Que diferencia se observa entre el documento insertado y el documento recuperado?
Para visualizar el documento recién insertado:
```javascript
db.recorridos.find().pretty()
```
Diferencia observada: El documento recuperado incluye un campo adicional _id (de tipo ObjectId), que MongoDB asigna automáticamente como clave primaria única para cada documento. Este campo no estaba presente en el documento insertado originalmente.
## 12 - Agregar a la coleccion, utilizando un solo comando, los documentos especificados en el archivo "material_adicional_1.json" adjunto a esta practica.
Primero, es necesario salir del shell de MongoDB y ejecutar el siguiente comando en la terminal del sistema (suponiendo que el archivo se encuentra en el directorio actual):
```bash
mongoimport --db tours --collection recorridos --file material_adicional_1.json
```
Si el archivo contiene múltiples documentos en formato JSON (uno por línea o un arreglo), este comando los insertará todos en la colección recorridos de la base de datos tours.
## 13 - Actualizar el recorrido "Cultural Odyssey" para que su total de kilometros sea 12.
```js
db.recorridos.updateOne(
    { "nombre": "Cultural Odyssey" },
    { $set: { "totalKm": 12 } }
)
```
## 14 - Actualizar el listado de stops del recorrido "Delta Tour" para agregar "Tigre".
```js
db.recorridos.updateOne(
    { "nombre": "Delta Tour" },
    { $push: { "stops": "Tigre" } }
)
```
## 15 - Aumentar un 10% el precio de todos los recorridos.
```js
db.recorridos.updateMany(
    {},
    { $mul: { "precio": 1.10 } }
)
```
## 16 - Eliminar el recorrido con nombre "Temporal Route".
```js
db.recorridos.deleteOne({ "nombre": "Temporal Route" })
```
## 17 - Crear el array de etiquetas (tags) para la ruta "Urban Exploration" y agregar el elemento "Gastronomia" a dicho arreglo.
```js
db.recorridos.updateOne(
    { "nombre": "Urban Exploration" },
    { $push: { "tags": "Gastronomia" } }
)
```
## 18 - Obtener la ruta con nombre "Museum Tour".
```js
db.recorridos.find({ "nombre": "Museum Tour" })
```
## 19 - Las rutas con precio superior a $60.000.
```js
db.recorridos.find({ "precio": { $gt: 60000 } })
```
## 20 - Las rutas con precio superior a $50.000 y con un total de kilometros mayor a 10.
```js
db.recorridos.find({
    "precio": { $gt: 50000 },
    "totalKm": { $gt: 10 }
})
```
## 21 - Las rutas que incluyan el stop "San Telmo".22.​Las rutas que incluyan el stop "Recoleta" y no el stop "Plaza Italia".
```js
db.recorridos.find({ "stops": "San Telmo" })
```
## 22 - Las rutas que incluyan el stop "Recoleta" y no el stop "Plaza Italia"
```js
db.recorridos.find({
    "stops": "Recoleta",
    "stops": { $ne: "Plaza Italia" }
})
```
## 23 - El nombre y el total de km (si es que posee) de las rutas que incluyan el stop "Delta" y tengan un precio menor a $50.000.
```js
db.recorridos.find(
    {
        "stops": "Delta",
        "precio": { $lt: 50000 }
    },
    {
        "nombre": 1,
        "totalKm": 1,
        "_id": 0
    }
)
```
## 24 - Las rutas que incluyen tanto "San Telmo" como "Recoleta" y "Avenida de Mayo" entre sus stops.
```js
db.recorridos.find({
    "stops": { $all: ["San Telmo", "Recoleta", "Avenida de Mayo"] }
})
```
## 25 - Solo el nombre de las rutas que dispongan de mas de 5 stops.
```js
db.recorridos.find(
    { $expr: { $gt: [{ $size: "$stops" }, 5] } },
    { "nombre": 1, "_id": 0 }
)
```
## 26 - Las rutas que no tengan definido el total de sus kilometros.
```js
db.recorridos.find({ "totalKm": { $exists: false } })
```
## 27 - Los nombres y el listado de stops de aquellas rutas que incluyen algun museo en sus recorridos.
```js
db.recorridos.find(
    { "stops": { $regex: /Museo/i } },
    { "nombre": 1, "stops": 1, "_id": 0 }
)
```
## 28 - La cantidad total de elementos que posee la coleccion.
```js
db.recorridos.countDocuments()
```

