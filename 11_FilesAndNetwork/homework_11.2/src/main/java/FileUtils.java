import java.io.*;

public class FileUtils {
    public static void copyFolder(String sourceDirectory, String destinationDirectory) {
        try {

            File folderSource = new File(sourceDirectory);
            File folderDestination = new File(destinationDirectory);

            if (folderSource.isDirectory()) {
                if (!folderDestination.exists()) {
                    folderDestination.mkdir();
                }

                String[] files = folderSource.list();

                for (String file : files) {
                    String srcFile = String.valueOf(new File(folderSource, file));
                    String destFile = String.valueOf(new File(folderDestination, file));
                    copyFolder(srcFile, destFile);
                }
            } else {
                InputStream in = new FileInputStream(folderSource);
                OutputStream out = new FileOutputStream(folderDestination);

                byte[] buffer = new byte[1024];
                int length;
                while ((length = in.read(buffer)) > 0) {
                    out.write(buffer, 0, length);
                }

                in.close();
                out.close();
                System.out.println("Копирование выполнено!");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}