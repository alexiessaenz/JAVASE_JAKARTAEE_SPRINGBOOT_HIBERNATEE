import entities.Actor1;

public class Main {
    public static void main(String[] args) {
        Actor1 actor = new Actor1();
        actor.setName("John");
        System.out.println(actor);

        actor.hello();
    }
}
