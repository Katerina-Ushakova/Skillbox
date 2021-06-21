import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {
    public static long getFoldersSize(File folder) throws IOException {
        Path path = Paths.get(String.valueOf(folder));
        long dirSize = Files.walk(path)
                .map(Path::toFile)
                .filter(File::isFile)
                .mapToLong(File::length)
                .sum();
        return dirSize;
    }

    public static String calculateFolderSize(String originalSize) {
        long size = Long.parseLong(originalSize);
        final String[] units = {" bytes", " Kb", " Mb", " Gb", " Tb", " Pb"};
        int unitIndex = 0;
        double tempSize = (double) size / 1024;

        while (tempSize > 1) {
            tempSize = tempSize / 1024;
            unitIndex++;
        }
        if (unitIndex == 0) {
            return originalSize + units[unitIndex];
        } else {
            return (Math.round(10 * size / (Math.pow(1024, (unitIndex)))) / 10.0) + units[unitIndex];
        }
    }
}



/*public static long getFoldersSize(File folder){
        final long[] foldersSize = {0};
        try {
            Path path = Paths.get(String.valueOf(folder));
            Files.walkFileTree(folder.toPath(), new SimpleFileVisitor<>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                    foldersSize[0] += file.toFile().length();
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException e) {
                    System.err.printf("Visiting failed, skip: %9s (???) bytes\t- %s\n", file.toFile().length(), file);
                    return FileVisitResult.SKIP_SUBTREE;
                }
            });
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return String.valueOf(foldersSize[0]);
        }*/
