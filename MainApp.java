import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=== MENU UTAMA ===");
            System.out.println("1. Sistem Distribusi Barang (Graph)");
            System.out.println("2. Data Produk dan Harga (BST)");
            System.out.println("3. Sistem Manajemen Data (Hash Table)");
            System.out.println("4. Tutup Aplikasi");
            System.out.print("Pilih aplikasi (1-3): ");
            String pilihan = scanner.nextLine();

            switch (pilihan) {
                case "1":
                    GraphApp graphApp = new GraphApp();
                    graphApp.start();
                    break;
                case "2":
                    ProductApp bstApp = new ProductApp(); 
                    bstApp.start();
                    break;
                case "3":
                    HashApp hashApp = new HashApp(); 
                    hashApp.start();
                    break;
                case "4":
                    System.out.println("Terima kasih, sampai jumpa!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid.\n");
            }
        }
    }
}
