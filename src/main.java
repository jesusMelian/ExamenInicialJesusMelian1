import java.io.*;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        //obtenerPersonas();
        //System.out.println(contarPersonas(obtenerPersonas()));
        //System.out.println(obtenerNumAleatorio(0, contarPersonas(obtenerPersonas())));
        System.out.println("TAMAÑO: " +obtenerPersonasAleatorias().size());
        for (int i = 0; i < 10; i++) {
            System.out.println(obtenerPersonasAleatorias().get(i));
        }

    }

    private static ArrayList<persona> obtenerPersonas(){
        ArrayList<persona> arrPersonas=new ArrayList<>();
        String nombre;
        File file = new File("listadodenombresaleatorios.csv");
        //System.out.println("es: " +file.getAbsolutePath());
        try {
            BufferedReader bfR=new BufferedReader(new FileReader(file));
            //Para saltarme la primera linea que es la cabecera
            bfR.readLine();
            //Bucle para recorrer las lineas del csv
            while ((nombre=bfR.readLine()) != null){
                //Creo una nueva persona
                persona person=new persona(nombre);
                //añado la persona al arrayList de personas
                arrPersonas.add(person);
                //System.out.println(String.valueOf(person.nombre));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return arrPersonas;
    }

    private static int contarPersonas(ArrayList<persona> arrPersona){
        return arrPersona.size();
    }

    private static double obtenerNumAleatorio(int minValue, int maxValue){
        double randomNum = Math.random() * (maxValue - minValue);
        System.out.println("Random Number: "+randomNum);
        return  randomNum;
    }

    public static ArrayList<String> obtenerPersonasAleatorias(){
        double numAleatorio=0;
        ArrayList<String> arr10Personas=new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            //obtengo un número aleatorio dentro del rango.
            numAleatorio=obtenerNumAleatorio(0, contarPersonas(obtenerPersonas()));

            System.out.println(i+"- "+ obtenerPersonas().get((int) numAleatorio).nombre);
            arr10Personas.add(obtenerPersonas().get((int) numAleatorio).nombre);
        }
        return  arr10Personas;
    }

    public static aniadirNotasAAlumno
}


