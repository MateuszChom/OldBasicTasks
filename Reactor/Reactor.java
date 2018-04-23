import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Reactor {
        static String f = "";
        static long tm = 0;
        static String diff = "hard";
       
        public static void main(String[] args){
                System.out.println("Difficulty has been set to "+diff+" by default.");
                System.out.println("Welcome to the Reaction Testing, hope you will enjoy");
                f = readLine("Type in 'hard' (1) or 'harder' (2) to change difficulty (with no typos).\nPress enter to start. Once the game starts the page will remain blank for a random amount of time.\nOnce the text appear just click enter and see how much amouth of time you needed.\n");
                if (false == f.equals("")){
                if (f.equals("hard") || f.equals("1")){
                        diff = "hard";
                        System.out.println("Difficulty set to hard!");
                } else if (f.equals("harder") || f.equals("2")){
                        diff = "harder";
                        System.out.println("Difficulty set to harder!");
                } else {
                        f = readLine("Difficulty not changed.");
                        }main(args);
                }
                game();
        }
            public static void game(){
                String gap = "";
                double t =  Math.random();
                double g =  Math.random();
                double time = (int) (t*700);
                int spaces = (int) (g*135);
                for (int x=0;x<=spaces;x++){
                        gap = gap+" ";
                }
                if (time <100){
                        time = time + 200;
                } else if (time < 300){
                        time = time + 100;
                }
                try {
                        Thread.sleep((long) (time*10));
                } catch (InterruptedException e) {
                       
                }
                if (diff.equals("hard")){
                        gap = "";
                }
                System.out.println(gap+"::::::::::::::::::::::::::::::::::::::::::::::");
                System.out.println(gap+"!!!!!!!!!!!!!!!--PRESS NOW--!!!!!!!!!!!!!!!!!!");
                System.out.println(gap+"::::::::::::::::::::::::::::::::::::::::::::::");
                score();
            while (true){
                f = readLine("\nPlay again? enter y (yes) or n (no): \n");
            if (f.equals("yes") || f.equals("y")){
                System.out.println("-----------------------------------------------------------------------------\n");
                game();
            } else if (f.equals("no") || (f.equals("n"))) {
                System.out.println("Thank you, hope you got good reaction :)");
                System.exit(0);
            } else {
                System.out.println("I am only boolean being, just 'yes' and 'no' are understandable for me.");
            }
        }}
       
        public static void score() {
                    tm = System.currentTimeMillis();
                    try {
                        readLine("");
                    }
                    finally {
                        tm = System.currentTimeMillis()-tm;
                        if (tm < 50){
                        System.out.println("Hold on! You are faster than a light, nah I am kidding you pressed enter too fast!");
                    } else {
                        System.out.println("You reaction time is at "+tm+"ms");
                    }
        }}
        public static String readLine(String prompt) {
            String input = "";
            System.out.print(prompt);
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            try {
 
              input = br.readLine();
 
            } catch (IOException ioe) {
            }
            return input;
          }
 
}