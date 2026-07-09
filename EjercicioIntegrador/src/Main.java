import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Superheroe> liga = new ArrayList<>();
        liga.add(new Superheroe("Spiderman", "Lanzar Telarañas", false, 85));
        liga.add(new Superheroe("Superman", "Vuela y tiene superpoderes varios", true, 95));
        liga.add(new Superheroe("Batman", "Detective multimillonario", true, 65));
        liga.add(new Superheroe("Ironman", "Ingeniero multimilloario", false, 70));
        liga.add(new Superheroe("hulk", "Super fuerza", false, 90));

        List<Superheroe> conCapa = liga.stream()
                .filter(heroe -> heroe.isTieneCapa())
                .collect(Collectors.toList());
        conCapa.forEach(heroe -> System.out.println(heroe.getNombre()));
        // Resultado esperado: Superman, Batman

        List<String> nombresEnMayusculayOrdenados = liga.stream()
                .map(Superheroe::getNombre)
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(nombresEnMayusculayOrdenados);
        // Resultado esperado: [BATMAN, HULK, IRONMAN, SPIDERMAN, SUPERMAN]

        Optional<Superheroe> elMasPoderoso = liga.stream()
                .max(Comparator.comparingInt(Superheroe::getPoder));
        elMasPoderoso.ifPresent(heroe ->
                System.out.println(heroe.getNombre() + " - poder: " + heroe.getPoder())
        );
        // Resultado esperado: Superman - poder: 95

        OptionalDouble promediodePoder = liga.stream()
                .mapToInt(Superheroe::getPoder)   // Stream → IntStream
                .average();
        promediodePoder.ifPresent(poder ->
                System.out.println("Promedio: " + poder)
        );
        // Resultado esperado: Promedio: 81.0

        Map<Boolean, List<Superheroe>> gruposdeCapas = liga.stream()
                .collect(
                        Collectors.partitioningBy(Superheroe::isTieneCapa)
                );

        System.out.println("Con capa:  " + gruposdeCapas.get(true));
        System.out.println("Sin capa:  " + gruposdeCapas.get(false));
        // Con capa:  [Superman, Batman]
        // Sin capa:  [Spiderman, Ironman, Hulk]
    }
}