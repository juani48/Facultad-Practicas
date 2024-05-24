int[] vector = [1, 3, 4, 5, 9, 4, 3, 4, 5, 1, 1, 4, 9, 4, 3, 1];
vector.GroupBy(n => n)
    .OrderBy(group => group.Count())
    .ToList()
    .ForEach(group => Console.WriteLine($"Grupo: {group.Key} -- Cantidad: {group.Count()}"));
