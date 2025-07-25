package org.edudev.stacks_and_queues.stacks.challenges;

/**
 * @author Eduardo J
 * JDK 22.0.1 (Zulu) + Gradle 8.13 with preview features enabled.
 */

public final class Main {

    void main() {
        System.out.println("--------Cenário 1--------");
        testNavigation(new Browser(), new String[]{
                "get-current",
                "access,https://amazon.com",
                "access,https://cnn.com",
                "get-current",
                "back",
                "get-current",
                "back",
                "get-current",
                "back"
        });
        System.out.println("--------Cenário 1--------\n");

        System.out.println("--------Cenário 2--------");
        testNavigation(new Browser(), new String[]{
                "access,https://amazon.com",
                "access,https://cnn.com",
                "get-current",
                "forward"
        });
        System.out.println("--------Cenário 2--------\n");

        System.out.println("--------Cenário 3--------");
        testNavigation(new Browser(), new String[]{
                "access,https://amazon.com",
                "access,https://cnn.com",
                "access,https://gmail.com",
                "access,https://outlook.com",
                "get-current",
                "back",
                "back",
                "back",
                "get-current",
                "forward",
                "forward",
                "get-current"
        });
        System.out.println("--------Cenário 3--------\n");

        System.out.println("--------Cenário 4--------");
        testNavigation(new Browser(), new String[]{
                "access,https://amazon.com",
                "access,https://cnn.com",
                "access,https://gmail.com",
                "access,https://outlook.com",
                "get-current",
                "back",
                "back",
                "back",
                "get-current",
                "forward",
                "forward",
                "get-current",
                "access,https://devsuperior.com.br",
                "back",
                "forward",
                "get-current",
                "forward"
        });
        System.out.println("--------Cenário 4--------\n");

    }

    static void testNavigation(Browser browser, String[] commands) {
        for (var i = 0; i < commands.length; i++) {
            final var splitCommand = commands[i].split(",");
            final var action = splitCommand[0];

            try {
                switch (action) {
                    case "get-current" -> System.out.println(browser.getCurrentPage());
                    case "access" -> browser.access(splitCommand[1]);
                    case "back" -> browser.back();
                    case "forward" -> browser.forward();
                }
            } catch (final IllegalStateException e) {
                System.out.println(STR."Error: \{e.getMessage()}");
            }

        }
    }

}
