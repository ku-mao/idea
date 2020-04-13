package edu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

//通过这个类来模拟创建一副牌,洗牌,发牌;
public class Poker {
    private static class Card {
        private String suit;//花色
        private String rank;//数字

        private Card(String suit, String rank) {
            this.suit = suit;
            this.rank = rank;
        }

        @Override
        public String toString() {
           // return "(" + suit + rank + ")";
            return String.format("(%s%s)",suit,rank);
        }
    }

    //构建一副牌
    private static List<Card> buyPoker() {
        String[] suits = {"♥", "♣", "♦", "♠"};
        List<Card> poker = new ArrayList <>();
        for (int i = 0; i < 4; i++) {
            for(int j = 2; j <= 10; j++){
                Card card = new Card(suits[i],"" + j);
                poker.add(card);
            }
            poker.add(new Card(suits[i],"J"));
            poker.add(new Card(suits[i],"Q"));
            poker.add(new Card(suits[i],"K"));
            poker.add(new Card(suits[i],"A"));
        }
        return poker;
    }

    public static void shuffle(List<Card> poker) {
        Random random = new Random();
        for(int i = poker.size() - 1; i > 0; i--) {
            int r = random.nextInt(i);
            swap(poker,i,r);
        }
    }
    private static void swap(List<Card> poker, int i,int j) {
        Card tmp = poker.get(i);
        poker.set(i,poker.get(j));
        poker.set(j,tmp);
    }


    public static void main(String[] args) {
        //1.先买一副牌
        List<Card> poker = buyPoker();
        //2.洗牌
        //shuffle(poker);
        Collections.shuffle(poker);
        System.out.println(poker);
        //3.发牌 把牌交给4个玩家,每个玩家发13张
        List<List<Card>> plays = new ArrayList <>();
        plays.add(new ArrayList <Card>());
        plays.add(new ArrayList <Card>());
        plays.add(new ArrayList <Card>());
        plays.add(new ArrayList <Card>());
        //先给每个人发第一张,所以最外层循环是第几张牌
        //轮流发牌
        for (int cardIndex = 0; cardIndex < 13; cardIndex++) {
            for(int playIndex = 0; playIndex < 4; playIndex++) {
                List<Card> player = plays.get(playIndex);
                //把每张牌的最上面的发给玩家
                player.add(poker.remove(0));
            }
        }
        System.out.println("玩家1的牌: ");
        System.out.println(plays.get(0));
        System.out.println("玩家2的牌: ");
        System.out.println(plays.get(1));
        System.out.println("玩家3的牌: ");
        System.out.println(plays.get(2));
        System.out.println("玩家4的牌: ");
        System.out.println(plays.get(3));
    }
}