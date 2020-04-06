import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Scanner;


public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String pathFile = scanner.next();
        Solution solution = new Solution();
        solution.countLines(pathFile);

    }

    public int countLines(String pathFile) throws IOException {
        Path path = Paths.get(pathFile);
        File file = new File(pathFile);
        if (Files.notExists(path) || pathFile.isBlank()) {
            return 0;
        }

        if (file.isDirectory()) {
            int rootSum = 0;
            for (File sub : Objects.requireNonNull(file.listFiles())) {
                rootSum = rootSum + countLines(sub.getPath());
            }
            System.out.println(file.getName() + " " + rootSum);
            return rootSum;
        } else {

            int count = (int) Files.lines(path)
                    .filter(f -> !f.isEmpty())
                    .filter(f -> !f.startsWith("//"))
                    .filter(f -> !f.contains("/*"))
                    .filter(f -> !f.contains("*"))
                    .count();
            System.out.println(file.getName() + ": " + count);
            return count;

        }
    }
}
