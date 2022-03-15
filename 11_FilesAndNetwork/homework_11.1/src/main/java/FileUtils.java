import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {

    public static long calculateFolderSize(String path) {
        try {
        Path p = Paths.get(String.valueOf(path));
        long dirSize = Files.walk(p)
                .map(Path::toFile)
                .filter(File::isFile)
                .mapToLong(File::length)
                .sum();
        return dirSize;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static String conversion(long originalSize) {
        final String[] units = {" bytes", " Kb", " Mb", " Gb", " Tb", " Pb"};
        int unitIndex = 0;
        double tempSize = (double) originalSize / 1024;

        while (tempSize > 1) {
            tempSize = tempSize / 1024;
            unitIndex++;
        }

        if (unitIndex == 0) {
            return originalSize + units[unitIndex];
        } else {
            return (Math.round(10 * originalSize / (Math.pow(1024, (unitIndex)))) / 10.0) + units[unitIndex];
        }
    }
}

/*public static long calculateFolderSize(File folder){
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
