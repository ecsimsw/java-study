package javaPracticing.상속보단조합;

import java.util.List;

public class 문제점 {

    public static void main(String[] args) {
        EncryptedDocument encryptedDocument = new EncryptedDocument("value");

    }
}

class Player {
    private final List<Integer> cards;

    public Player(final List<Integer> cards) {
        this.cards = cards;
    }

    public int getCard() {
        return cards.get(0);
    }
}

class Dealer {

    private final Player player;

    public Dealer(final List<Integer> cards) {
        player = new Player(cards);
    }

    public int distributeCard() {
        return player.getCard();
    }
}

class Document {
    private final String content;

    public Document(String content) {
        System.out.println(content);
        this.content = content;
    }

    public int contentLength() {
        return content.length();
    }
}

class EncryptedDocument {
    private final Document document;

    public EncryptedDocument(String content) {
        document = new Document(content);
    }

    public String getLastCharacter() {
        return content().substring(document.contentLength() - 1, document.contentLength());
    }

    public String content() {
        // document 해독
        return "something";
    }
}

class temp {
    public static void main(String[] args) {
        Sub sub = new Sub();
    }
}

class Score {
    public int score = 0;

    public Score() {
        addScore(1);
        System.out.println(score);
    }

    public void addScore(int i) {

    }
}

class MathScore extends Score {

    public MathScore() {
        addScore(1);
        System.out.println(score);
    }

    @Override
    public void addScore(int i) {
        score += i;
    }
}

class Super {
    public Integer i = null;

    public Super() {
        printScore();
    }

    public void printScore() {

    }
}

class Sub extends Super {

    public Sub() {
        i = 1;
        printScore();
    }

    @Override
    public void printScore() {
        System.out.println(i);
    }
}