import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        initializeDeck();
    }

    // Aqui es el metodo para iniciar el mazo de cartas
    private void initializeDeck() {
        List<String> palos = Arrays.asList("Tréboles", "Corazones", "Picas", "Diamantes");
        List<String> colores = Arrays.asList("Rojo", "Negro");
        List<String> valores = Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "A", "J", "Q", "K");
    // Aqui se generan las posibles combinaciones de palos, colores y valores
        for (String palo : palos) {
            for (String color : colores) {
                for (String valor : valores) {
                    Card card = new Card(palo, color, valor);
                    cards.add(card);
                }
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
        System.out.println("Se ha mezclado el mazo.");
    }

    public void head() {
        if (cards.isEmpty()) {
            System.out.println("El mazo está vacío.");
            return;
        }
    // \
        Card card = cards.remove(0);
        System.out.printf("%s de %s, %s\n", card.getValor(), card.getPalo(), card.getColor());
        System.out.printf("Quedan %d cartas en el mazo.\n", cards.size());
    }

    public void pick() {
        if (cards.isEmpty()) {
            System.out.println("El mazo está vacío.");
            return;
        }

        int randomIndex = (int) (Math.random() * cards.size());
        Card card = cards.remove(randomIndex);
        System.out.printf("%s de %s, %s\n", card.getValor(), card.getPalo(), card.getColor());
        System.out.printf("Quedan %d cartas en el mazo.\n", cards.size());
    }

    public void hand() {
        if (cards.size() < 5) {
            System.out.println("No hay suficientes cartas en el mazo para repartir una mano.");
            return;
        }

        System.out.println("Mano:");

        for (int i = 0; i < 5; i++) {
            Card card = cards.remove(0);
            System.out.printf("%s de %s, %s\n", card.getValor(), card.getPalo(), card.getColor());
        }

        System.out.printf("Quedan %d cartas en el mazo.\n", cards.size());
    }
}

class Card {
    private String palo;
    private String color;
    private String valor;

    public Card(String palo, String color, String valor) {
        this.palo = palo;
        this.color = color;
        this.valor = valor;
    }

    public String getPalo() {
        return palo;
    }

    public String getColor() {
        return color;
    }

    public String getValor() {
        return valor;
    }
}

public class mazo {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();
        deck.head();
        deck.pick();
        deck.hand();
    }
}
