import entities.Actor;

public class Main {
    public static void main(String[] args) {
        Actor actor = new Actor();
        actor.setName("John");
        System.out.println(actor);

        actor.hello();
    }
}
