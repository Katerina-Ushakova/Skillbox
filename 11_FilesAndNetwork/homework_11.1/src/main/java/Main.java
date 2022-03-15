import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try {
            File folderName;

            for (; ; ) {
                System.out.println("Введите путь до папки :");
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String inputPath = reader.readLine().replace("\\", File.separator);
                folderName = new File(inputPath);
                if (folderName.isDirectory()) {
                    break;
                }
                System.out.println("Неверный путь! Введите корректный ");
            }

            long folderSize = (FileUtils.calculateFolderSize(String.valueOf(folderName)));
            System.out.println("\nРазмер папки " + folderName + " = " + FileUtils.conversion(folderSize));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}


