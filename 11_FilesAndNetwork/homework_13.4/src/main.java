import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) throws IOException {
        List<String> images = new ArrayList<>();
        Document document = Jsoup.connect("https://lenta.ru/").get();
        Elements img = document.select("img");
        for (Element element : img) {
            String image = element.attr("src");
            if (image.startsWith("https")) images.add(image);
        }
        downloadImages(images);
    }
    private static void downloadImages(List<String> images) throws IOException {
        String pathToSave = "images/";
        for (String path : images) {
            try (InputStream in = new URL(path).openStream()) {
                Files.createDirectories(Paths.get(pathToSave));
                Files.copy(in, Paths.get(pathToSave
                        + new File(path).getName()), StandardCopyOption.REPLACE_EXISTING);
            }
        }
        System.out.println("Скачивание завершено!\n" +
                "Список скаченных файлов: ");
        images.forEach(System.out::println);
    }
}