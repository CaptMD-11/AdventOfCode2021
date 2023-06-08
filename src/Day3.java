import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Day3 {

    // PART I METHOD
    public double powerConsumption() {
        try {
            File file = new File("data/Day3.txt");
            Scanner scanner = new Scanner(file);
            String line = "";
            ArrayList<String> list = new ArrayList<String>();

            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                list.add(line);
            }

            String gammaRateStr = "";
            String epsilonRateStr = "";

            for (int i = 0; i < 12; i++) {
                gammaRateStr += mostCommonNthCharacter(list, i);
            }

            for (int i = 0; i < gammaRateStr.length(); i++) {
                if (gammaRateStr.substring(i, i + 1).equals("1"))
                    epsilonRateStr += "0";
                else
                    epsilonRateStr += "1";
            }

            return Integer.parseInt(gammaRateStr, 2) * Integer.parseInt(epsilonRateStr, 2);

        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public String mostCommonNthCharacter(ArrayList<String> list, int n) {
        int count0 = 0;
        int count1 = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).substring(n, n + 1).equals("0"))
                count0++;
            else if (list.get(i).substring(n, n + 1).equals("1"))
                count1++;
        }
        if (count1 > count0)
            return "1";
        if (count1 < count0)
            return "0";
        return null;
    }

}