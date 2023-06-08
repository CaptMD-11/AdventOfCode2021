import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1 {

    // PART I METHOD
    public int numberGreaterThanPrevious() {
        try {
            File file = new File("data/Day1.txt");
            Scanner scanner = new Scanner(file);
            String line = "";
            ArrayList<Integer> list = new ArrayList<Integer>();

            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                list.add(Integer.parseInt(line));
            }
            int count = 0;
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i) > list.get(i - 1))
                    count++;
            }
            return count;
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    // PART II METHOD
    public int sumLargerThanPrevious() {
        try {
            File file = new File("data/Day1.txt");
            Scanner scanner = new Scanner(file);
            String line = "";
            ArrayList<Integer> nums = new ArrayList<Integer>();
            ArrayList<Integer> sums = new ArrayList<Integer>();

            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                nums.add(Integer.parseInt(line));
            }
            for (int i = 0; i < nums.size() - 2; i++) {
                sums.add(nums.get(i) + nums.get(i + 1) + nums.get(i + 2));
            }
            int count = 0;
            for (int i = 1; i < sums.size(); i++) {
                if (sums.get(i) > sums.get(i - 1))
                    count++;
            }
            return count;
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

}
