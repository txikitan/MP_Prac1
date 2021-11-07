/* METODOLOGIAS DE LA PROGRAMACION - PRACTICA 1
     Clase primers que implementa los metodos necesarios para que desde main se pueda leer fichero y verificar la
     primalidad de cada uno de los numeros de dicho fichero.

     Gabriel Garcia gabriel.garcia@estudiants.urv.cat
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class Primers {

    /*Metodo que lee fichero de entrada y devuelve array de strings con los numeros capturados en dicho formato */
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

    /* Dos metodos de calculo de primero mas cercano a N, uno para BigInteger y el otro para long.
        Variaran en la ejecucion segun se haya elegido una version u otra para el calculo de la primalidad.
     */
     public static long primerPetit(long numero, int version) {

        // All prime numbers are odd except two
        if(numero==2) return 2L;
        else if (version == 2 && isPrimeV2(numero)) {
                return numero;
        }
        else if(isPrimeV1(numero)) return numero;
        else if (numero % 2 != 0)
            numero -= 2;
        else
            numero--;
        long i;
        for (i = numero; i >= 2; i -= 2) {
            if (i % 2 == 0) {
                continue;
            }
            if(version==2 && isPrimeV2(i)) return i;
            else if(isPrimeV1(i)) return i;
        }
        // It will only be executed when n is 3
         return 2L;
    }

    public static BigInteger primerGran(BigInteger numero, int version) {
        BigInteger mod2 = numero.mod(BigInteger.TWO);
        // All prime numbers are odd except two

        if(numero.equals(BigInteger.TWO)) return BigInteger.TWO;
        else if (version == 2 && isPrimeV2(numero)) {
            return numero;
        }
        else if(isPrimeV1(numero)) return numero;
        else if ( mod2.compareTo(BigInteger.ZERO)!=0)
            numero = numero.subtract(BigInteger.TWO);
        else
            numero = numero.subtract(BigInteger.ONE);
        BigInteger i;
        for (i = numero; i.compareTo(BigInteger.TWO)>=0; i=i.subtract(BigInteger.TWO)) {
            BigInteger imod2 = i.mod(BigInteger.TWO);
            if (imod2.compareTo(BigInteger.ZERO)==0) {
                continue;
            }
            if(version==2 && isPrimeV2(i)) return i;
            else if(isPrimeV1(i)) return i;
        }
        // It will only be executed when n is 3
        return BigInteger.TWO;
    }

    /*DOS VERSIONES DE LOS METODOS PARA CHECKEAR SI ES PRIMO O NO
        V2 = Solucion de Naive
        V1 = Fuerza bruta
     */
    private static boolean isPrimeV2 (long n) {
        long j;
        // Check if n is a multiple of 2
        if (n % 2 == 0)
            return false;

        // If not, then just check the odds
        for (j = 3; j <= Math.sqrt(n); j += 2)
        {
            if (n % j == 0)
                break;
        }
        return j > Math.sqrt(n);
    }

    private static boolean isPrimeV2 (BigInteger n) {
        BigInteger j;
        // Check if n is a multiple of 2
        if (n.mod(n).equals(BigInteger.ZERO))
            return false;

        BigInteger square = n.sqrt();

        // If not, then just check the odds
        for (j = new BigInteger("3"); j.compareTo(square)<1; j=j.add(BigInteger.TWO))
        {
            if (n.mod(j).compareTo(BigInteger.ZERO)==0)
                break;
        }
        return j.compareTo(square) > 0;
    }

    private static boolean isPrimeV1(long n) {
        for(long u = n-1; u>=2; u--){
            if(n % u == 0) return false;
        }
        return true;
    }

    private static boolean isPrimeV1(BigInteger n){
        for(BigInteger u = n.subtract(BigInteger.ONE); u.compareTo(BigInteger.TWO)>=0;u=u.subtract(BigInteger.ONE)){
            BigInteger umod2 = u.mod(BigInteger.TWO);
            if(umod2.compareTo(BigInteger.ZERO) == 0) return false;
        }
        return true;
    }
}
