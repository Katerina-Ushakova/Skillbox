import core.Station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class RouteCalculator {
    private StationIndex stationIndex;

    private static double interStationDuration = 2.5; //переменная интервала между станциями
    private static double interConnectionDuration = 3.5; // переменная интервала пересадочная станция

    public RouteCalculator(StationIndex stationIndex) {
        this.stationIndex = stationIndex;
    } //создания объекта класса

    public List<Station> getShortestRoute(Station from, Station to) // метод получения самой короткой дороги
    {
        List<Station> route = getRouteOnTheLine(from, to); // метод без пересадок
        if (route != null) {
            return route;
        }
        route = getRouteWithOneConnection(from, to); // метод с одной пересадкой
        if (route != null && route.size() != 0) {
            return route;
        }

        route = getRouteWithTwoConnections(from, to); // метод с двумя пересадками
        return route;

    }

    public static double calculateDuration(List<Station> route) // метод подсчитывания времени в дороге
    {
        double duration = 0;
        Station previousStation = null;
        for (int i = 0; i < route.size(); i++)  // проходимся по всем станциям нашей дороги
        {
            Station station = route.get(i);
            if (i > 0) {
                duration += previousStation.getLine().equals(station.getLine()) ?
                        interStationDuration : interConnectionDuration; // если линия предыдущей станции такая же как и линия нынешней станции, то + 2.5, иначе + 3.5
            }
            previousStation = station;
        }
        return duration;
    }

    //=========================================================================

    private List<Station> getRouteOnTheLine(Station from, Station to) // метод получения дороги без пересадок
    {
        if (!from.getLine().equals(to.getLine())) { // проверка находятся ли станции на одной линии
            return null;
        }
        ArrayList<Station> route = new ArrayList<>(); //создаем лист"путь"
        List<Station> stations = from.getLine().getStations(); //создаем  лист станции
        int direction = 0;
        for (Station station : stations) // цикл прохоит по всему листу станции сдобавлением станций в лист "путь"
        {
            if (direction == 0) {
                if (station.equals(from)) {  // стравнивает станцию с начальной и конечной
                    direction = 1;
                } else if (station.equals(to)) {
                    direction = -1;
                }
            }

            if (direction != 0) { // добавления станций в лист "путь"
                route.add(station);
            }

            if ((direction == 1 && station.equals(to)) ||
                    (direction == -1 && station.equals(from))) {  // если значение раво -1 или 1 и станция начальная или конечная, то цикл прекращается
                break;
            }
        }
        if (direction == -1) { // если значение -1 то мы переворачиваем лист
            Collections.reverse(route);
        }
        return route;
    }

    private List<Station> getRouteWithOneConnection(Station from, Station to) // метод получения дороги с одной пересадкой
    {
        if (from.getLine().equals(to.getLine())) {  // проверка находятся ли станции на одной линии
            return null;
        }

        ArrayList<Station> route = new ArrayList<>(); // создаем лист "путь"

        List<Station> fromLineStations = from.getLine().getStations(); // создаем лист станций от начальной станции
        List<Station> toLineStations = to.getLine().getStations(); // создаем лист станций до конечной станции
        for (Station srcStation : fromLineStations) // цикл по всем станциям линии начальной станции
        {
            for (Station dstStation : toLineStations) // цикл по всем станциям линии конечной станции
            {
                if (isConnected(srcStation, dstStation)) // проверка на существование пересадки
                {
                    ArrayList<Station> way = new ArrayList<>(); // создаем лист дороги, чтобы затем добавить с основной лист "путь"
                    way.addAll(getRouteOnTheLine(from, srcStation)); // добавление станиций от начальной станции до пересадки
                    way.addAll(getRouteOnTheLine(dstStation, to)); // добавление станций от пересадки до конечной станции
                    if (route.isEmpty() || route.size() > way.size()) // проверка устой ли лист "путь" или длинее листа дороги
                    {
                        route.clear(); // удаляет все из листа
                        route.addAll(way); // добавление всех станций в лист
                    }
                }
            }
        }
        if (route.isEmpty()) {
            return null;
        }
        return route;
    }

    private boolean isConnected(Station station1, Station station2) // не понимаю это метод
    {
        Set<Station> connected = stationIndex.getConnectedStations(station1);
        return connected.contains(station2);
    }

    private List<Station> getRouteViaConnectedLine(Station from, Station to) // метод получание дороги между пересаждками
    {
        Set<Station> fromConnected = stationIndex.getConnectedStations(from); // создание линии  начальной пересадки
        Set<Station> toConnected = stationIndex.getConnectedStations(to); // создание линии конечной пересадки
        for (Station srcStation : fromConnected) {
            for (Station dstStation : toConnected) {
                if (srcStation.getLine().equals(dstStation.getLine())) { // если сравниваем линии начальной пересадки и конечной
                    return getRouteOnTheLine(srcStation, dstStation); // если равны, то мы получаем дорогу по станция станций между ними
                }
            }
        }
        return null; //почему мы здесь возвращаем null?
    }

    private List<Station> getRouteWithTwoConnections(Station from, Station to) {
        if (from.getLine().equals(to.getLine())) { // если линия начальной пересадки и конечной пересадки равны, то возвращается null
            return null;
        }

        ArrayList<Station> route = new ArrayList<>();

        List<Station> fromLineStations = from.getLine().getStations();
        List<Station> toLineStations = to.getLine().getStations();
        for (Station srcStation : fromLineStations) {
            for (Station dstStation : toLineStations) {
                List<Station> connectedLineRoute =
                        getRouteViaConnectedLine(srcStation, dstStation); // создаем лист дороги со станциями меду пересадками
                if (connectedLineRoute == null) {
                    continue;
                }
                ArrayList<Station> way = new ArrayList<>(); // создаем лист дороги, чтобы затем добавить с основной лист "путь"
                way.addAll(getRouteOnTheLine(from, srcStation));  // добавление станиций от начальной станции до пересадки
                way.addAll(connectedLineRoute); // добаление станций между пересадками
                way.addAll(getRouteOnTheLine(dstStation, to)); // добавление станций от пересадки до конечной станции
                if (route.isEmpty() || route.size() > way.size()) // проверка устой ли лист "путь" или длинее листа дороги
                {
                    route.clear(); // удаляет все из лист
                    route.addAll(way); // добавление всех станций в лист
                }
            }
        }

        return route;
    }
}