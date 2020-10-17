package TreeExercise;

public class StartUp {

    public static void main(String[] args) {
        new StartUp().run();
    }

    private void run() {
        Person alice = new Person("Alice", 1900);
        {
            Person bob = new Person("Bob", 1920);
            alice.addChild(bob);

            {
                Person carol = new Person("Carol", 1939);
                bob.addChild(carol);
                Person dave = new Person("Dave", 1955);
                carol.addChild(dave);
                Person david = new Person("David", 1958);
                carol.addChild(david);
            }
            {
                Person cedric = new Person("Cedric", 1940);
                bob.addChild(cedric);

                Person davina = new Person("Davina", 1944);
                cedric.addChild(davina);
                Person dirk = new Person("Dirk", 1945);
                cedric.addChild(dirk);
            }


        }
        {
            Person bobette = new Person("Bobette", 1922);
            alice.addChild(bobette);

            {
                Person caroline = new Person("Caroline", 1938);
                bobette.addChild(caroline);

                Person dieter = new Person("Dieter", 1961);
                caroline.addChild(dieter);
                Person django = new Person("Django", 1961);
                caroline.addChild(django);
            }
            {
                Person carlo = new Person("Carlo", 1938);
                bobette.addChild(carlo);


                Person doris = new Person("Doris", 1965);
                carlo.addChild(doris);
                Person dolf = new Person("Dolf", 1966);
                carlo.addChild(dolf);
                Person danira = new Person("Danira", 1967);
                carlo.addChild(danira);
                Person dante = new Person("Dante", 1968);
                carlo.addChild(dante);
            }
            {
                Person cecile = new Person("Cecile", 1940);
                bobette.addChild(cecile);

                Person diederick = new Person("Diederick", 1962);
                cecile.addChild(diederick);
                Person daan = new Person("Daan", 1963);
                cecile.addChild(daan);
            }
        }

        System.out.println(alice.toLongString());
        System.out.println("----------------------------------------");
        alice.addMoney(1000);
        alice.die();
        alice.getChildren().get(0).die();
        System.out.println("----------------------------------------");
        System.out.println("The closest heir is " + alice.closedHeir());
        System.out.println("----------------------------------------");
        System.out.println("The oldest heir is " + alice.oldestHeir());
        System.out.println("----------------------------------------");
    }
}
