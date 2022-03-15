import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try {
            File folderSource;
            File folderDestination;

            while (true) {
                System.out.println("Введите путь к исходной папке :");
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String inputPath = reader.readLine().replace("\\", File.separator);
                folderSource = new File(inputPath);
                if (folderSource.isDirectory()) {
                    break;
                }
                System.out.println("Неверный путь! Введите корректный ");
            }
            while(true) {
                System.out.println("Введите путь к конечной папке :");
                BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
                String inputPath1 = reader1.readLine().replace("\\", File.separator);
                folderDestination = new File(inputPath1);
                if (folderDestination.isDirectory()) {
                    break;
                }
                System.out.println("Неверный путь! Введите корректный ");
            }
            FileUtils.copyFolder(String.valueOf(folderSource), String.valueOf(folderDestination));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
