import java.util.Scanner;

class ProductApp {
    public void start() {
        Scanner sc = new Scanner(System.in);
        ProductBST bst = new ProductBST();

        // Data awal
        bst.addProduct("Indomie Goreng", 3000, "Mie");
        bst.addProduct("Indomie Ayam Bawang", 2800, "Mie");
        bst.addProduct("Mie Sedaap Kari Ayam", 2900, "Mie");
        bst.addProduct("Mie Lemonilo", 4500, "Mie");
        bst.addProduct("Supermi Soto", 2700, "Mie");
        bst.addProduct("Sarimi Isi 2", 5000, "Mie");
        bst.addProduct("Pop Mie Ayam", 6000, "Mie");

        while (true) {
            System.out.println("\n=== MENU PRODUK ===");
            System.out.println("1. Lihat semua produk (Harga Termurah -> Termahal)");
            System.out.println("2. Cari produk berdasarkan awal nama");
            System.out.println("3. Tambah produk baru");
            System.out.println("4. Hapus produk");
            System.out.println("5. Kembali ke Menu Utama");
            System.out.print("Pilih menu: ");
            int pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    bst.showProductsAscending();
                    break;
                case 2:
                    System.out.print("Masukkan kata awal nama produk: ");
                    String nama = sc.nextLine();
                    bst.listMatchingProduct(nama);
                    break;
                case 3:
                    bst.addNewProductInteractive();
                    break;
                case 4:
                    bst.deleteProductInteractive();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
