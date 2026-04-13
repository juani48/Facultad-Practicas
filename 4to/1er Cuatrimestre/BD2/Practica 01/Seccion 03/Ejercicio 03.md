## 45 - ​¿Que diferencia hay entre HQL/JPQL y SQL nativo? ¿Qué entidades, atributos y relaciones entienden HQL/JPQL que SQL no conoce directamente?

La diferencia entre HQL/JPQL y SQL nativo es fundamentalmente del nivel de abstracción y el modelo con el que interactuan. SQL opera directamente sobre el modelo relacional (tablas, columnas y claves), mientras que HQL/JPQL interactua con el modelo de objetos del dominio y Hibernate/JPA se encargar de traducir las consultas en HQL/JPQL a SQL.

HQL/JPQL puede entender entidades, atributos, relaciones y herencia entre entidades dentro de consultas, puediendo realizar navegacion entre atributos.