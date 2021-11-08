/* METODOLOGIAS DE LA PROGRAMACION - PRACTICA 1
     Fichero main que usa la clase Primers para resolver el fichero de entrada y escribir el de salida

     Gabriel Garcia gabriel.garcia@estudiants.urv.cat
 */

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main (String [ ] args) {
        Scanner keyboard = new Scanner(System.in);
        String fileName;
        int nLines = 0;
        int version = 0;
        double startTime;
        double stopTime;
        double time;
        long small;
        long smallResult;
        BigInteger biggie;
        BigInteger bigresult;
        String[] numeros;
        try {
            FileWriter myWriter = new FileWriter("resultados.csv",false);
            myWriter.write("Resultado;Version;TEjec(s);\n");
            /* Leemos nombre de fichero y numero de entradas por teclado */
            System.out.println("Introduce el nombre del fichero de entrada: ");
            fileName = keyboard.next();
            while(nLines <= 0) {
                System.out.println("Introduce el numero de datos:");
                nLines = keyboard.nextInt();
            }
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
                    startTime = System.nanoTime();              // Capturamos tiempo ejecucion
                    bigresult = Primers.primerGran(biggie,version);
                    stopTime = System.nanoTime();
                    /* Escribimos en fichero */
                    time = (stopTime - startTime)/1000000000;
                    myWriter.write(bigresult + ";" + version + ";" + time + ";\n");
                }
                else {
                    small = Long.parseLong(numeros[i]);
                    startTime = System.nanoTime();
                    smallResult = Primers.primerPetit(small,version);
                    stopTime = System.nanoTime();
                    time = (stopTime - startTime)/1000000000;
                    myWriter.write(smallResult + ";" + version + ";" + time + ";\n");
                    }

                }
            myWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

}
