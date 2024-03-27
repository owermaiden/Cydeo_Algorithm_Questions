package Mentoring.game;

import java.util.*;

public class Game {

    public static void main(String[] args) {

        Player basketballPlayer = new BasketballPlayer();
        Player soccerPlayer = new SoccerPlayer();
        createTeam(soccerPlayer);
        createTeam(basketballPlayer);

        List<Integer> list = new Vector<>();
        list.add(10);
        list.add(10);
        doSomething(list);
        Set<Integer> set =  new HashSet<>(list);
        System.out.println(set);

    }

    public static void createTeam(Player player){
        List<Player> team = new ArrayList<>();
        team.add(player);
    }

    public static void doSomething(List<Integer> list){
        for (Integer num: list) {
            System.out.println(num);
        }
    }

}
