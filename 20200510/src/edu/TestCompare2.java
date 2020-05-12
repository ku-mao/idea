package edu;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Ca{
    public String rank;
    public String suit;
    public Ca(String rank, String suit) {
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
        if (!(obj instanceof Ca)) {
            return false;
        }
        //将类型强转
        Ca other = (Ca)obj;
        //比较相等
        return this.rank.equals(other.rank);
    }


    @Override
    public String toString() {
        return "Card{" +
                "rank='" + rank + '\'' +
                ", suit='" + suit + '\'' +
                '}';
    }

    public int converRank() {
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
}




class CardComparator implements Comparator<Ca> {

    @Override
    public int compare(Ca o1, Ca o2) {
        int rank1 = o1.converRank();
        int rank2 = o2.converRank();
        return rank1 - rank2;
    }
}
public class TestCompare2 {
    public static void main(String[] args) {

        List<Ca> list = new ArrayList <>();
        list.add(new Ca("A", "♥"));
        list.add(new Ca("K", "♥"));
        list.add(new Ca("10", "♥"));
        list.add(new Ca("J", "♥"));

        Collections.sort(list, new CardComparator());
        System.out.println(list);
    }
}
