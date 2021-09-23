import java.io.*;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        ejecutar();
    }

    //EJECUTA LA APLICACIOn
    public static  void ejecutar(){
        crearArchivoDeNotas();
        aniadirNotasAAlumno(obtenerPersonasAleatorias());
    }

    //CREA EL ARCHIVO DE SALIDA DE ALUMNOS Y NOTAS
    public static void crearArchivoDeNotas(){
        File file2 = new File("listadodenombresynotas.csv");
        if (file2.exists()){
            if(file2.delete()){
                System.out.println("SE HA BORRADO EL ARCHIVO");
            }else{
                System.out.println("NO SE HA BORRADO EL ARCHIVO");
            }
            try {
                file2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            try {
                file2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private static ArrayList<persona> obtenerPersonas(){
        ArrayList<persona> arrPersonas=new ArrayList<>();
        String nombre;
        File file = new File("listadodenombresaleatorios.csv");
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
        return  randomNum;
    }

    public static String[] obtenerPersonasAleatorias(){
        double numAleatorio=0;
        String[] arr10Personas=new String[10];

        for (int i = 0; i < 10; i++) {
            //obtengo un número aleatorio dentro del rango.
            numAleatorio=obtenerNumAleatorio(0, contarPersonas(obtenerPersonas()));
            numAleatorio=Math.round(numAleatorio*100.0)/100.0;

            arr10Personas[i]=obtenerPersonas().get((int) numAleatorio).nombre;
        }
        return  arr10Personas;
    }

    public static void aniadirNotasAAlumno(String[] arrPersona){
        Double [] notas= new Double[4];
        String sNotas="";
        String linea="NOMBRE, NOTA1,NOTA2,NOTA3,NOTA4, MEDIA \n";
        double numAleatorio=0;
        for (int e = 0; e < 10; e++) {
            for (int i = 0; i < notas.length; i++) {
                numAleatorio = obtenerNumAleatorio(0, 10);
                //Para ponerle 2 decimales
                numAleatorio=Math.round(numAleatorio*100.0)/100.0;
                sNotas = sNotas + numAleatorio + ", ";
                notas[i]=numAleatorio;
            }
            //Escribimos la linea en el archivo
            escribirEnArchivo(linea);
            //ponemos la linea en blanco
            linea="";
            //ponemos el contenido de la linea
            linea=obtenerPersonasAleatorias()[e]+", " + sNotas + calcularMedia(notas)+"\n";

            //Reiniciamos el contenido de sNotas
            sNotas="";
        }
    }

    //Escribe en el archivo los nombres y las notas
    public static void escribirEnArchivo(String linea){
        File file = new File("listadodenombresynotas.csv");
        try {
            BufferedWriter bfW=new BufferedWriter(new FileWriter(file, true));
            //Escribo la linea
            bfW.write(linea);
            bfW.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Calcula la media
    public static double calcularMedia(Double[] notas){
        double media=0;
        for (int i = 0; i < notas.length; i++) {
            media=notas[i]+media;
        }
        media=media/notas.length;
        return media;
    }
}


