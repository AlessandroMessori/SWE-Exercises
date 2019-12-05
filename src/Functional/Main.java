package Functional;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

class Player {
    private String name;
    private String surname;
    private int age;
    private Role role;


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getFullName() {
        return name + " " + surname + '\n';
    }

    public int getAge() {
        return age;
    }

    public Role getRole() {
        return role;
    }

    public Player(String name, String surname, int age, Role role) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.role = role;
    }
}


class Team {

    private ArrayList<Player> players;

    public void add(Player player) {
        players.add(player);
    }

    public void printTeam() {
        players.stream().forEach((Player player) -> System.out.println(player.getFullName()));
    }

    public float getAverageAge() {
        int sum = players.stream()
                .mapToInt(Player::getAge)
                .reduce(0, (int acc, int current) -> acc += current);


        return (float) sum / players.size();

    }

    private Team fromStream(Stream<Player> plrs) {
        Team team = new Team();

        plrs.forEach(team::add);
        return team;
    }

    public Team getRoles(Role role) {
        Stream<Player> plrs = players
                .stream()
                .filter((Player player) -> player.getRole() == role);
        return fromStream(plrs);
    }

    public Team() {
        players = new ArrayList<>();
    }


}


public class Main {

    public static void main(String[] args) {
        Team juventus = new Team();

        juventus.add(new Player("Wojciech", "Szczęsny", 29, Role.GOALKEEPER));
        juventus.add(new Player("Juan", "Cuadrado", 31, Role.DEFENDER));
        juventus.add(new Player("Leonardo", "Bonucci", 32, Role.DEFENDER));
        juventus.add(new Player("Matthijs", "De Ligt", 20, Role.DEFENDER));
        juventus.add(new Player("Alex", "Sandro", 28, Role.DEFENDER));
        juventus.add(new Player("Blaise", "Matuidi", 32, Role.MIDFIELDER));
        juventus.add(new Player("Miralem", "Pjanic", 29, Role.MIDFIELDER));
        juventus.add(new Player("Rodrigo", "Bentancur", 22, Role.MIDFIELDER));
        juventus.add(new Player("Federico", "Bernardeschi", 25, Role.FORWARD));
        juventus.add(new Player("Cristiano", "Ronaldo", 34, Role.FORWARD));
        juventus.add(new Player("Paulo", "Dybala", 26, Role.FORWARD));

        juventus.printTeam();
        System.out.println("Average Team Age:  " + juventus.getAverageAge());


        Arrays.asList(Role.values()).forEach(role -> {
            Team roleTeam = juventus.getRoles(role);
            System.out.println("Printing " + role.toString());
            roleTeam.printTeam();
            System.out.println("Average " + role.toString() + " Age:  " + roleTeam.getAverageAge());
        });


    }

}
