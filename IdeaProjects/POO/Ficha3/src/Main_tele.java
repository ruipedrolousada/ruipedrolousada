public class Main_tele {

    public static void telemovel() {

        Telemovel t1 = new Telemovel();

        t1.instalaApp("Instagram", 20);
        t1.instalaApp("Facebook", 100);
        t1.removeApp("instagram", 20);
        t1.recebeMsg("olá");
        t1.recebeMsg("RNFIREQYHNRYEQBFNRYEB");
        t1.recebeMsg("bom");
        String res = t1.maiorMsg();
        System.out.println(res);
        System.out.println(t1.toString());

    }

        public static void main (String[]args){
            telemovel();
        }
}

