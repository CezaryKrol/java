import java.util.Random;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random generator = new Random();
        // generowanie przeciwnika
        String enemyName;
        int num = generator.nextInt(5);
        switch (num) {
            case 0:
                enemyName = "Pikaczu";
                break;
            case 1:
                enemyName = "Myszka Miki";
                break;
            case 2:
                enemyName = "Szrek";
                break;
            case 3:
                enemyName = "Spejson";
                break;
            default:
                enemyName = "Reksio";
                break;


        }

        int enemyAttack = generator.nextInt(8) + 1;
        System.out.println("Punkty ataku przeciwnika " + enemyName + ": " + enemyAttack);
        int enemyDefense = generator.nextInt(15) + 3;
        System.out.println("Punkty obrony przeciwnika " + enemyName + ": " + enemyDefense);
        int enemyDamage = generator.nextInt(3) + 1;
        System.out.println("Zadawane obrazenia " + enemyName + ": " + enemyDamage);
        int enemyLife = generator.nextInt(20) + 15;
        System.out.println("Punkty zycia przeciwnika " + enemyName + ": " + enemyLife);

        int yourAttack = generator.nextInt(6) + 5;
        System.out.println("Twoje punkty ataku: " + yourAttack);
        int yourDefense = generator.nextInt(10) + 6;
        System.out.println("Twoje punkty obrony: " + yourDefense);
        int yourDamage = generator.nextInt(3) + 2;
        System.out.println("Twoje zadawane obrazenia: " + yourDamage);
        int yourLife = generator.nextInt(20) + 20;
        System.out.println("Twoje punkty zycia: " + yourLife);

        boolean runaway = false;

        // rozpoczecie pojedynku
        do {
            boolean attacker = generator.nextBoolean();
            if (attacker) {
                System.out.println("Atakujesz");
                int draw = generator.nextInt(6) + 1 + generator.nextInt(6) + 1;
                int attackValue = yourAttack + draw;
                System.out.println("Wylosowane punkty ataku: " + draw);
                System.out.println("Twoj atak: " + attackValue);
                if (attackValue > enemyDefense) {
                    System.out.println("Udalo sie zaatakowac przeciwnika!");
                    enemyLife = enemyLife - yourDamage;
                    System.out.println(enemyName + " pozostalo : " + enemyLife + " punktow zycia");
                } else {
                    System.out.println("Twoj atak byl za slaby!.");
                }
            } else {
                System.out.println(enemyName + " atakuje.");
                int dice = generator.nextInt(6) + 1 + generator.nextInt(6) + 1;
                int attackValue = enemyAttack + dice;
                System.out.println("Wylosowane punkty ataku:" + dice);
                System.out.println(enemyName + " atakuje za : " + attackValue + " punktow");
                if (attackValue > yourDefense) {
                    System.out.println(enemyName + " przeprowadzil udany atak!");
                    yourLife = yourLife - enemyDamage;
                    System.out.println("Zostalo Ci: " + yourLife + " punktow zycia");
                } else {
                    System.out.println(enemyName + " atak sie nie powiodl.");
                }
            }
            // kontynuacja gry
            System.out.println("Nacisnij ENTER aby przejsc do kolejnej rundy!(Jesli nacisniesz 'run' zaczniesz od nowa)");
            String command = sc.nextLine();
            if ("run".equals(command)) {
                runaway = true;
            }
        } while ((yourLife > 0) && (enemyLife > 0) && !runaway);
        if (yourLife <= 0) {
            System.out.println("Przegrales, zwyciezyl:" + enemyName);
        }
        if (enemyLife <= 0) {
            System.out.println("Pokonales: " + enemyName + ". Gratulacje!");
        }
    }

}
