import java.util.Scanner;

class ProductNode {
    String name;
    int price;
    String type;
    ProductNode left, right;

    public ProductNode(String name, int price, String type) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.left = this.right = null;
    }
}

public class ProductApp {
    private ProductNode root;

    public void insert(String name, int price, String type) {
        root = insertRec(root, name, price, type);
    }

    private ProductNode insertRec(ProductNode node, String name, int price, String type) {
        if (node == null) return new ProductNode(name, price, type);
        if (price < node.price) node.left = insertRec(node.left, name, price, type);
        else node.right = insertRec(node.right, name, price, type);
        return node;
    }

    // Cari berdasarkan awalan nama produk
    public void searchByPrefix(String prefix) {
        System.out.println("\nHasil pencarian produk mie dengan awalan \"" + prefix + "\":");
        if (!searchByPrefixRec(root, prefix.toLowerCase())) {
            System.out.println("Tidak ada produk mie yang cocok.");
        }
    }

    private boolean searchByPrefixRec(ProductNode node, String prefix) {
        if (node == null) return false;

        boolean found = false;
        found |= searchByPrefixRec(node.left, prefix);

        if (node.name.toLowerCase().startsWith(prefix)) {
            System.out.println("- " + node.name + " (" + node.type + ") : Rp" + node.price);
            found = true;
        }

        found |= searchByPrefixRec(node.right, prefix);
        return found;
    }

    // Tampilkan semua produk dari harga termurah ke termahal
    public void displayAscending() {
        System.out.println("\nDaftar Harga Mie(Termurah ke Termahal):");
        inOrderTraversal(root);
    }

    private void inOrderTraversal(ProductNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.println("- " + node.name + " (" + node.type + ") : Rp" + node.price);
            inOrderTraversal(node.right);
        }
    }

    // Menjalankan aplikasi
    public void start() {
        Scanner scanner = new Scanner(System.in);
        ProductApp bst = new ProductApp();

        // Tambahkan banyak data produk mie
        bst.insert("Indomie Goreng", 3000, "Mie");
        bst.insert("Indomie Ayam Bawang", 3100, "Mie");
        bst.insert("Indomie Soto", 3200, "Mie");
        bst.insert("Indomie Kari Ayam", 3300, "Mie");
        bst.insert("Indomie Rendang", 3500, "Mie");
        bst.insert("Indomie Cabe Ijo", 3600, "Mie");
        bst.insert("Mie Sedaap Goreng", 3000, "Mie");
        bst.insert("Mie Sedaap Ayam Bawang", 3200, "Mie");
        bst.insert("Mie Sedaap Soto", 3300, "Mie");
        bst.insert("Supermi Ayam", 2800, "Mie");
        bst.insert("Supermi Soto", 2900, "Mie");
        bst.insert("Sarimi Isi 2 Ayam", 5000, "Mie");
        bst.insert("Sarimi Isi 2 Soto", 5200, "Mie");
        bst.insert("Pop Mie Ayam", 6000, "Mie");
        bst.insert("Pop Mie Pedas", 6200, "Mie");

        // Input pencarian
        System.out.print("Masukkan nama produk mie yang ingin dicari: ");
        String cariPrefix = scanner.nextLine();
        bst.searchByPrefix(cariPrefix);

        // Tampilkan semua data
        bst.displayAscending();
    }
}
