int num = int.Parse(Console.ReadLine());
for (int i = 1; i <= num; i++)
{
    if (EsPrimo(i))
    {
        Console.WriteLine(i + " es primo");
    }
}

bool EsPrimo(int n)
{
    bool ok = true;
    int max = (int)Math.Sqrt(n);
    for (int i = 2; i < max; i++)
    {
        if (n % i != 0)
        {
            ok = false;
        }
    }
    return ok;
}
