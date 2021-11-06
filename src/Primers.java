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

    public static Long primerPetitV1(Long numero) {

        long maxPrime = -1;

        while (numero % 2 == 0) {
            maxPrime = 2;
            numero >>= 1;
        }

        for (int i = 3; i <= Math.sqrt(numero); i += 2) {
            while (numero % i == 0) {
                maxPrime = i;
                numero = numero / i;
            }
        }

        if (numero > 2) {
            maxPrime = numero;
        }

        return maxPrime;
    }

    public static Long primerPetitV2(Long numero) {
        long primeFactor = 1L;
        long i = 2L;

        while (i <= numero / i) {
            if (numero % i == 0) {
                primeFactor = i;
                numero /= i;
            } else {
                i++;
            }
        }

        if (primeFactor < numero) primeFactor = numero;

        return primeFactor;
    }

    public static BigInteger primerGranV1(BigInteger numero) {
        //long maxPrime = -1;
        BigInteger maxPrime = new BigInteger("-1");

        while ((numero.mod(BigInteger.TWO)).compareTo(BigInteger.ZERO)==0) {
            maxPrime = BigInteger.TWO;
            numero = numero.divide(BigInteger.TWO);
        }
        //for (int i = 3; i <= Math.sqrt(numero); i += 2) {
        for(BigInteger i = new BigInteger("3");i.compareTo(numero.sqrt())<=0;i=i.add(BigInteger.TWO)){
            while ((numero.mod(i)).equals(BigInteger.ZERO)) {
                maxPrime = i;
                numero = numero.divide(i);
            }
        }

        if (numero.compareTo(BigInteger.TWO) > 0) {
            maxPrime = numero;
        }

        return maxPrime;
    }

    public static BigInteger primerGranV2(BigInteger numero) {
        BigInteger primeFactor = BigInteger.ONE;
        BigInteger i = new BigInteger("2");

        while (i.compareTo(numero.divide(i)) <= 0) {
            if (numero.mod(i).longValue() == 0) {
                primeFactor = i;
                numero = numero.divide(i);
            } else {
                i = i.add(BigInteger.ONE);
            }
        }

        if (primeFactor.compareTo(numero) < 0) primeFactor = numero;

        return primeFactor;
    }
}
