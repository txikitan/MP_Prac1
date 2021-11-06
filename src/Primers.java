import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class Primers {

    public static String[] leerFichero (String fileName, int nLines) throws FileNotFoundException {
        String[] numeros = new String[nLines];
        int i=0;
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            numeros[i]=scanner.nextLine();
            i++;
        }
        scanner.close();
        return numeros;
    }

     public static long primerPetitV2(long numero) {

        // All prime numbers are odd except two
        if(numero==2) return 2L;
        else if (isPrime(numero)) return numero;
        else if (numero % 2 != 0)
            numero -= 2;
        else
            numero--;
        long i, j;
        for (i = numero; i >= 2; i -= 2) {
            if (i % 2 == 0)
                continue;
            for (j = 3; j <= Math.sqrt(i); j += 2) {
                if (i % j == 0)
                    break;
            }
            if (j > Math.sqrt(i))
                return i;
        }
        // It will only be executed when n is 3
        return 2L;
    }

    public static BigInteger primerGranV2(BigInteger numero) {
        // All prime numbers are odd except two
        if(numero.equals(BigInteger.TWO)) return BigInteger.TWO;
        else if (isPrime(numero)) return numero;
        else if (numero % 2 != 0)
            numero -= 2;
        else
            numero--;
        long i, j;
        for (i = numero; i >= 2; i -= 2) {
            if (i % 2 == 0)
                continue;
            for (j = 3; j <= Math.sqrt(i); j += 2) {
                if (i % j == 0)
                    break;
            }
            if (j > Math.sqrt(i))
                return i;
        }
        // It will only be executed when n is 3
        return 2L;
    }
    /**EL V1 simplemente se coloca en n-1 y va llamando a isPrime hasta que lo encuentre. **/


     */
    private static boolean isPrime(long n)
    {
        // Check if n is a multiple of 2
        else if (n % 2 == 0)
            return false;

        // If not, then just check the odds
        for (int i = 3; i <= Math.sqrt(n); i += 2)
        {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    private static boolean isPrime(BigInteger n)
    {
        // Check if n is a multiple of 2
        else if (n % 2 == 0)
        return false;

        // If not, then just check the odds
        for (int i = 3; i <= Math.sqrt(n); i += 2)
        {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
