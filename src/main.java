import java.io.*;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        obtenerPersonas();
    }

    private static ArrayList<persona> obtenerPersonas(){
        ArrayList<persona> arrPersonas=new ArrayList<>();
        String nombre;
        File file = new File("listadodenombresaleatorios.csv");
        try {
            BufferedReader bfR=new BufferedReader(new FileReader(file));
            //Para saltarme la primera linea que es la cabecera
            //bfR.readLine();
            //Bucle para recorrer las lineas del csv
            while ((nombre=bfR.readLine()) != null){
                //Creo una nueva persona
                persona person=new persona(nombre);
                //añado la persona al arrayList de personas
                arrPersonas.add(person);
                System.out.println(String.valueOf(person.nombre));
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
        double randomNum = Math.random() * ( maxValue - minValue);
        System.out.println("Random Number: "+randomNum);
        return  randomNum;
    }
    public static ArrayList<String> obtenerPersonasAleatorias
}


