## 30 - Obtener una muestra de 5 rutas aleatorias de la coleccion.
```js
db.routes.aggregate([ { $sample: { size: 5 } } ])
```
## 31 - Extender la consulta anterior para incluir en el resultado toda la informacion de cada una de las stops. Tener en cuenta que pueden ligarse por su codigo.
```js
db.routes.aggregate([
  { $sample: { size: 5 } },
  {
    $lookup: {
      from: "stops",
      localField: "stops",
      foreignField: "codigo",
      as: "stops_info"
    }
  }
])
```
## 32 - Obtener la informacion de las rutas (incluyendo la de sus stops) que tengan un precio mayor o igual a $90.000.
```js
db.routes.aggregate([
  { $match: { precio: { $gte: 90000 } } },
  {
    $lookup: {
      from: "stops",
      localField: "stops",
      foreignField: "codigo",
      as: "stops_info"
    }
  }
])
```
## 33 - Obtener la informacion de las rutas que tengan 5 stops o mas.
```js
db.routes.aggregate([
  { $match: { $expr: { $gte: [ { $size: "$stops" }, 5 ] } } }
])
```
## 34 - Obtener la informacion de las rutas que tengan incluido en su nombre el string "111".
```js
db.routes.aggregate([
  { $match: { nombre: { $regex: "111", $options: "i" } } }
])
```
## 35 - Obtener solo las stops de la ruta con nombre "Route100".
```js
db.routes.aggregate([
  { $match: { nombre: "Route100" } },
  { $unwind: "$stops" },
  {
    $lookup: {
      from: "stops",
      localField: "stops",
      foreignField: "codigo",
      as: "stop_info"
    }
  },
  { $replaceRoot: { newRoot: { $arrayElemAt: ["$stop_info", 0] } } }
])
```
## 36 - Obtener la informacion del stop que mas apariciones tiene en rutas.
```js
db.routes.aggregate([
  { $unwind: "$stops" },
  { $group: { _id: "$stops", count: { $sum: 1 } } },
  { $sort: { count: -1 } },
  { $limit: 1 },
  {
    $lookup: {
      from: "stops",
      localField: "_id",
      foreignField: "codigo",
      as: "stop_info"
    }
  },
  { $unwind: "$stop_info" },
  { $project: { _id: 0, stop: "$stop_info", apariciones: "$count" } }
])
```
## 37 - Obtener las rutas con precio inferior a $15.000. Agregar a cada una una nueva propiedad que especifique la cantidad de stops que posee. Crear una nueva coleccion llamada "rutas_economicas" y almacenar estos elementos.
```js
db.routes.aggregate([
  { $match: { precio: { $lt: 15000 } } },
  { $addFields: { cantidad_stops: { $size: "$stops" } } },
  { $out: "rutas_economicas" }
])
```
## 38 - Por cada stop existente en la coleccion, calcular el precio promedio de las rutas que la incluyen.
```js
db.routes.aggregate([
  { $unwind: "$stops" },
  {
    $group: {
      _id: "$stops",
      precio_promedio: { $avg: "$precio" }
    }
  },
  {
    $lookup: {
      from: "stops",
      localField: "_id",
      foreignField: "codigo",
      as: "stop_info"
    }
  },
  { $unwind: "$stop_info" },
  {
    $project: {
      _id: 0,
      stop_codigo: "$_id",
      stop_nombre: "$stop_info.nombre",   // ajustar campo real
      precio_promedio: 1
    }
  }
])
```