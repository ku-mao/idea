package edu;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Card implements Comparable<Card> {
    public String rank;
    public String suit;
    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }



    @Override
    public boolean equals(Object obj) {
        //看this 和 obj 身份是否相同
        if(this == obj) {
            return true;
        }
        //如果obj为空,则一定不相等
        if(obj == null) {
            return false;
        }
        //obj类型能否强转为Card
        if (!(obj instanceof Card)) {
            return false;
        }
        //将类型强转
        Card other = (Card)obj;
        //比较相等
        return this.rank.equals(other.rank);
    }



    @Override
    public int compareTo(Card o) {
        int rank1 = this.convertRank();
        int rank2 = o.convertRank();
        return rank1 - rank2;
    }

    private int convertRank() {
        if("A".equals(rank)) {
            return 14;
        }
        if("K".equals(rank)) {
            return 13;
        }
        if("Q".equals(rank)) {
            return 12;
        }
        if("J".equals(rank)) {
            return 11;
        }
        return Integer.parseInt(rank);
    }

    @Override
    public String toString() {
        return "Card{" +
                "rank='" + rank + '\'' +
                ", suit='" + suit + '\'' +
                '}';
    }
}

public class TestCompare {
    public static void main(String[] args) {
        Card card1 = new Card("10", "♥");
        Card card2 = new Card("10", "♠");
        Card card3 = card1;

//        System.out.println(card1 == card2);//false
//        System.out.println(card1 == card3);//true
//        System.out.println(card1.equals(card2));
//        System.out.println(card1.equals(card3));


        System.out.println(card1.compareTo(card2));

        List<Card> list = new ArrayList <>();
        list.add(new Card("A", "♥"));
        list.add(new Card("K", "♥"));
        list.add(new Card("10", "♥"));
        list.add(new Card("J", "♥"));

        Collections.sort(list);
        System.out.println(list);
    }
}
