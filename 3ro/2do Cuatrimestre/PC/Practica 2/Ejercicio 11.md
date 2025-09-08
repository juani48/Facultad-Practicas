## En un vacunatorio hay un empleado de salud para vacunar a 50 personas. El empleado de salud atiende a las personas de acuerdo con el orden de llegada y de a 5 personas a la vez. Es decir, que cuando está libre debe esperar a que haya al menos 5 personas esperando, luego vacuna a las 5 primeras personas, y al terminar las deja ir para esperar por otras 5. Cuando ha atendido a las 50 personas el empleado de salud se retira. 
> Todos los procesos deben terminar su ejecución; suponga que el empleado tienen una función VacunarPersona() que simula que el empleado está vacunando a UNA persona.

```c
sem priv[50] := (50 0);
sem m_mutex := 0; lugares := 5;
cola C; sem c_mutex := 1;

process Persona[i = 0 to 50-1]{
    P(lugares); // Espera si no hay lugar
    P(c_mutex); push(C, i); V(c_mutex); // Se pone en la "fila"
    V(m_mutex); // Avisa que esta esperando
    P(priv(i)); // Espera a ser atendido
    V(lugares); // Deja el lugar libre
}

process Medico{
    for (int i := 0; i < 10; i++){

        // Espera a 5 personas
        for (int j := 0; j < 5; j++){
            P(m_mutex);
        }

        // Vacuna a 5 personas
        for (int j := 0; j < 5; j++){
            VacunarPersona()
        }

        // Deja ir a las 5 personas
        for (int j := 0; j < 5; j++){
            P(c_mutex); int id := pop(C); V(c_mutex);
            V(priv[id]);
        }
    }
}
```