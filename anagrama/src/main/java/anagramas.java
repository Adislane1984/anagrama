import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class anagramas {

    public static Map<String, Integer> contar(String frase)
    {
        Map<String, Integer> map = new TreeMap<>();
        for(char item : frase.toCharArray())
        {
            Integer s = map.get(String.valueOf(item));
            if (s != null)
            {
                map.put(String.valueOf(item), ++s);
            }
            else
            {
                map.put(String.valueOf(item), 1);
            }
        }
        return map;
    }

    public static void Imprimir(Map<String, Integer> items) {
        for (Map.Entry<String, Integer> a : items.entrySet()) {
            System.out.println(a.getKey() + ": " + a.getValue());
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a Palavra");
        String palavra = scanner.next();

        Map<String, Integer> map = contar(palavra.replace(" ", "").toLowerCase());

        ArrayList<String> anagramas = new ArrayList<String>();

        for(int i = 0; i <palavra.length(); i++) {
            for(int j = 1; j < palavra.length(); j++) {
                if(palavra.charAt(i) == palavra.charAt(j) && i !=j && i < j) {
                    if(palavra.charAt(i) == palavra.charAt(i+1)) {
                        String x = palavra.substring(i, i + 1);
                        anagramas.add(x);
                    } else {
                        String y = palavra.substring(i, j);
                        String z = palavra.substring(i + 1, j + 1);
                        String h = palavra.substring(i, i + 1);
                        anagramas.add(h);
                        anagramas.add(y);
                        anagramas.add(z);
                    }
                }
            }
        }
        Imprimir(map);
        System.out.println(anagramas);
    }
}