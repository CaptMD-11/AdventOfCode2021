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

            scanner.close();

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
        return "equal";
    }

    // PART II METHOD
    public double lifeSupportRating() {
        try {
            File file = new File("data/Day3.txt");
            Scanner scanner = new Scanner(file);
            String line = "";
            ArrayList<String> binaryNums = new ArrayList<String>();
            ArrayList<String> oxygenNums = new ArrayList<String>();
            ArrayList<String> scrubberNums = new ArrayList<String>();

            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                binaryNums.add(line);
            }

            scanner.close();

            for (int i = 0; i < binaryNums.size(); i++) {
                oxygenNums.add(binaryNums.get(i));
                scrubberNums.add(binaryNums.get(i));
            }

            while (oxygenNums.size() > 1) {
                for (int i = 0; i < binaryNums.get(0).length(); i++) {
                    String mostCommonDigitOxygen = mostCommonNthCharacter(oxygenNums, i);
                    if (mostCommonDigitOxygen.equals("equal")) {
                        for (int j = oxygenNums.size() - 1; j > -1; j--) {
                            if (oxygenNums.get(j).substring(i, i + 1).equals("0") && oxygenNums.size() > 1)
                                oxygenNums.remove(j);
                        }
                    } else {
                        for (int j = oxygenNums.size() - 1; j > -1; j--) {
                            if (!oxygenNums.get(j).substring(i, i + 1).equals(mostCommonDigitOxygen)
                                    && oxygenNums.size() > 1)
                                oxygenNums.remove(j);
                        }
                    }

                }
            }

            while (scrubberNums.size() > 1) {
                for (int i = 0; i < binaryNums.get(0).length(); i++) {
                    String mostCommonDigitScrubber = mostCommonNthCharacter(scrubberNums, i);
                    if (mostCommonDigitScrubber.equals("equal")) {
                        for (int j = scrubberNums.size() - 1; j > -1; j--) {
                            if (scrubberNums.get(j).substring(i, i + 1).equals("1") && scrubberNums.size() > 1)
                                scrubberNums.remove(j);
                        }
                    } else {
                        for (int j = scrubberNums.size() - 1; j > -1; j--) {
                            if (scrubberNums.get(j).substring(i, i + 1).equals(mostCommonDigitScrubber)
                                    && scrubberNums.size() > 1)
                                scrubberNums.remove(j);
                        }
                    }

                }
            }

            return Integer.parseInt(oxygenNums.get(0), 2) * Integer.parseInt(scrubberNums.get(0), 2);

        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

}