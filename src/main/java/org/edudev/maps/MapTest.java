package org.edudev.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapTest {

    void main() {
        Map<String, String> cookies = new HashMap<>();

        cookies.put("user", "maria34");
        cookies.put("email", "maria@gmail.com");
        cookies.put("last-login", "2024-07-04T21:42:40.353283800Z");

        System.out.println(cookies.get("user"));
        System.out.println();

        for(var value: cookies.values()) {
            System.out.println(value);
        }

        System.out.println();

        for(Entry<String, String> entry: cookies.entrySet()) {
            System.out.println(STR."\{entry.getKey()} : \{entry.getValue()}");
        }

        System.out.println();
        System.out.println(STR."Contêm a chave email? \{cookies.containsKey("email")}");
        var removed = cookies.remove("email");
        System.out.println(STR."Valor removido da chave email: \{removed}");
        System.out.println(STR."Contêm a chave email? \{cookies.containsKey("email")}");
        System.out.println(STR."Valor da chave email: \{cookies.get("email")}");
        System.out.println();

        for(var key: cookies.keySet()) {
            System.out.println(key);
        }
        System.out.println();

        System.out.println(STR."Map está vazio? \{cookies.isEmpty()}");
        System.out.println(STR."Tamanho do map: \{cookies.size()}");
    }
}
