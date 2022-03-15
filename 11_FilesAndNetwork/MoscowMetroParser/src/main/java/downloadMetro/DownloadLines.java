package downloadMetro;

public class DownloadLines {
    private final String number;
    private final String name;

    public DownloadLines(String number, String name) {
        this.number = number;
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}
