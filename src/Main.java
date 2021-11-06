import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main (String [ ] args) {
        Scanner keyboard = new Scanner(System.in);
        try {
            FileWriter myWriter = new FileWriter("resultados.csv");
            myWriter.write("N;Version;TEjec;\n");
            String fileName;
            int nLines = 0;
            int version = 0;
            long startTime;
            long stopTime;
            long time;
            long small;
            long smallResult;
            BigInteger biggie;
            BigInteger bigresult;
            /* Leemos nombre de fichero y numero de entradas por teclado */
            System.out.println("Introduce el nombre del fichero de entrada: ");
            fileName = keyboard.next();
            while(nLines <= 0) {
                System.out.println("Introduce el numero de datos:");
                nLines = keyboard.nextInt();
            }
            String[] numeros;
            /* Leemos fichero */
            numeros = Primers.leerFichero(fileName, nLines);
            /* Empezamos a verificar cada numero leido */
            System.out.println("Version 1 o 2 ?");
            while(version != 1 && version != 2){
                version = keyboard.nextInt();
            }
            for(int i=0; i<nLines; i++) {

                biggie = new BigInteger(numeros[i]);
                if(biggie.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) > 0) {
                    if(version == 1) {
                        startTime = System.nanoTime();              // Capturamos tiempo ejecucion
                        bigresult = Primers.primerGranV1(biggie);
                        stopTime = System.nanoTime();
                    }
                    else {
                        startTime = System.nanoTime();
                        bigresult = Primers.primerGranV2(biggie);
                        stopTime = System.nanoTime();
                    }
                    /* Escribimos en fichero */
                    time = stopTime - startTime;
                    myWriter.write(bigresult + ";" + version + ";" + time + ";\n");
                }
                else {
                    small = Long.parseLong(numeros[i]);
                    if (version == 1) {
                        startTime = System.nanoTime();
                        smallResult = Primers.primerPetitV1(small);
                        stopTime = System.nanoTime();
                    } else {
                        startTime = System.nanoTime();
                        smallResult = Primers.primerPetitV2(small);
                        stopTime = System.nanoTime();
                    }
                    time = stopTime - startTime;
                    myWriter.write(smallResult + ";" + version + ";" + time + ";\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
