import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Day2 {

    // PART I METHOD
    public int productOfFinalHorizontalAndDepth() {
        try {
            File file = new File("data/Day2.txt");
            Scanner scanner = new Scanner(file);
            String line = "";

            int horiz = 0;
            int depth = 0;

            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                if (line.substring(0, line.indexOf(" ")).equals("forward"))
                    horiz += Integer.parseInt(line.substring(line.indexOf(" ") + 1));
                else if (line.substring(0, line.indexOf(" ")).equals("down"))
                    depth += Integer.parseInt(line.substring(line.indexOf(" ") + 1));
                else if (line.substring(0, line.indexOf(" ")).equals("up"))
                    depth -= Integer.parseInt(line.substring(line.indexOf(" ") + 1));
            }
            return horiz * depth;
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    // PART II METHOD
    public int aimProductOfFinalHorizontalAndDepth() {
        try {
            File file = new File("data/Day2.txt");
            Scanner scanner = new Scanner(file);
            String line = "";

            int horiz = 0;
            int depth = 0;
            int aim = 0;

            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                if (line.substring(0, line.indexOf(" ")).equals("forward")) {
                    horiz += Integer.parseInt(line.substring(line.indexOf(" ") + 1));
                    depth += (aim * Integer.parseInt(line.substring(line.indexOf(" ") + 1)));
                } else if (line.substring(0, line.indexOf(" ")).equals("down"))
                    aim += Integer.parseInt(line.substring(line.indexOf(" ") + 1));
                else if (line.substring(0, line.indexOf(" ")).equals("up"))
                    aim -= Integer.parseInt(line.substring(line.indexOf(" ") + 1));
            }
            return horiz * depth;
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

}