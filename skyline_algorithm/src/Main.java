public class Main {
    public static void main(String[] args) {
        Building [] arr = {new Building(1, 11, 5), new Building(2, 6, 7),
                new Building(3, 13, 9),
                new Building(12, 7, 16), new Building(14, 3, 25),
                new Building(19, 18, 22),
                new Building(23, 13, 29), new Building(24, 4, 28)};
        int n = arr.length;
        skyline skyline = new skyline(n);
        // Find skyline for given buildings and print the skyline
        skyline ptr = skyline.findSkyline(arr, 0, n-1);
        System.out.println(" Skyline for given buildings is \n");
        ptr.print();
    }
}
