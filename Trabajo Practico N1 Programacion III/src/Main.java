import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //Punto 1
        System.out.println("PUNTO 1");
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> pares = numeros.stream().filter(n -> n % 2 == 0).toList();
        System.out.println("Lista de pares: " + pares);

        //Punto 2
        System.out.println("\nPUNTO 2");
        List<String> nombres = Arrays.asList("Fede", "Martu", "Mati");
        List<String> mayusculas = nombres.stream().map(String::toUpperCase).toList();
        System.out.println("Nombres en mayusculas: " + mayusculas);

        //Punto 3
        System.out.println("\nPUNTO 3");
        List<Integer> desordenados = Arrays.asList(2, 5, 4, 3, 6, 1);
        List<Integer> ordenados = desordenados.stream().sorted().toList();
        System.out.println("Lista ordenada de menor a mayor: \n" + ordenados);

        //Punto 4
        System.out.println("\nPUNTO 4");
        List<Integer> unoALdiez = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        long filtrado = unoALdiez.stream().filter(n -> n > 7).count();
        System.out.println("Resultado: " + filtrado + "\n");

        //Punto 5
        System.out.println("\nPUNTO 5");
        List<Integer> cinco = unoALdiez.stream().limit(5).toList();
        System.out.println("Filtrado a 5 numeros: " + cinco + "\n");

        //Punto 6
        System.out.println("\nPUNTO 6");
        List<String> frase = Arrays.asList("hola como estas?");
        List<Integer> largo = frase.stream().map(String::length).toList();
        System.out.println("Numero de caracteres: " + largo + "\n");

        //Punto 7
        System.out.println("\nPUNTO 7");
        String concatenados = nombres.stream().reduce((n1, n2) -> n1 + ", " + n2).orElse("");
        System.out.println("Nombres: " + concatenados + "\n");

        //Punto 8
        System.out.println("\nPUNTO 8");
        List<Integer> repetidos = Arrays.asList(1, 2, 3, 2, 4, 1, 5, 6);
        List<Integer> filtroNum = repetidos.stream().distinct().toList();
        System.out.println("Lista filtrada: " + filtroNum + "\n");

        //Punto 9
        System.out.println("\nPUNTO 9");
        List<Integer> max = unoALdiez.stream().sorted(Comparator.reverseOrder())
                .limit(3).toList();
        System.out.println("Maximos 3: " + max + "\n");

        //Punto 10
        System.out.println("\nPUNTO 10");
        List<String> caracteres = Arrays.asList("sol", "luna", "mar", "estrella");
        Map<Integer, List<String>> agrupadas = caracteres.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println("Caracteres: " + agrupadas + "\n");

        //Punto 11
        System.out.println("\nPUNTO 11");
        List<Integer> nums = Arrays.asList(2, 4, 6, 8, 10);
        int producto = nums.stream().reduce(1, (a,b) -> a * b);
        System.out.println("Producto final: " + producto + "\n");

        //Punto 12
        System.out.println("\nPUNTO 12");
        String masLargo = nombres.stream().reduce((n1, n2) -> n1.length() >= n2.length() ? n1 : n2)
                .orElse("");;
        System.out.println("Nombre mas largo: " + masLargo + "\n");

        //Punto 13
        System.out.println("\nPUNTO 13");
        List<Integer> enteros = Arrays.asList(1, 2, 3, 4, 5);
        String guiones = enteros.stream().map(String::valueOf).collect(Collectors.joining("-"));
        System.out.println("Numeros: " + guiones + "\n");

        //Punto 14
        System.out.println("\nPUNTO 14");
        Map<Boolean, List<Integer>> divididos = numeros.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("Divididos: " + divididos + "\n");

        //Punto 15
        System.out.println("\nPUNTO 15");
        int sumaCuadrados = numeros.stream().filter(n -> n % 2 != 0).map(n -> n * n)
                .reduce(0, Integer::sum);
        System.out.println("Resultado: " + sumaCuadrados);
    }
}