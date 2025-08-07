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

class ProductBST {
    private ProductNode root;

    // Tambah produk ke BST
    public void addProduct(String name, int price, String type) {
        root = insertRec(root, name, price, type);
    }

    // Proses rekursif untuk insert
    private ProductNode insertRec(ProductNode node, String name, int price, String type) {
        if (node == null) return new ProductNode(name, price, type);
        if (price < node.price) node.left = insertRec(node.left, name, price, type);
        else node.right = insertRec(node.right, name, price, type);
        return node;
    }

    // Tampilkan produk dari harga termurah
    public void showProductsAscending() {
        System.out.println("\nDaftar Produk (Termurah ke Termahal):");
        inOrderTraversal(root);
    }

    // Inorder traversal BST
    private void inOrderTraversal(ProductNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.println("- " + node.name + " (" + node.type + ") : Rp" + node.price);
            inOrderTraversal(node.right);
        }
    }

    // Cari produk berdasarkan awalan nama
    public void listMatchingProduct(String prefix) {
        System.out.println("\nHasil pencarian produk dengan awalan \"" + prefix + "\":");
        listMatchingRec(root, prefix.toLowerCase());
    }

    // Traversal dan cek awalan nama
    private void listMatchingRec(ProductNode node, String prefix) {
        if (node != null) {
            listMatchingRec(node.left, prefix);
            if (node.name.toLowerCase().startsWith(prefix)) {
                System.out.println("- " + node.name + " (" + node.type + ") : Rp" + node.price);
            }
            listMatchingRec(node.right, prefix);
        }
    }

    // Tambah produk dari inputan
    public void addNewProductInteractive() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nama produk: ");
        String name = sc.nextLine();
        System.out.print("Harga produk: ");
        int price = sc.nextInt();
        sc.nextLine();
        System.out.print("Jenis produk: ");
        String type = sc.nextLine();
        addProduct(name, price, type);
        System.out.println("Produk berhasil ditambahkan.");
    }

    // Hapus produk dari inputan
    public void deleteProductInteractive() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan nama produk yang ingin dihapus: ");
        String name = sc.nextLine();
        root = deleteProduct(root, name);
    }

    //hapus node berdasarkan nama
    private ProductNode deleteProduct(ProductNode node, String name) {
        if (node == null) return null;

        if (node.name.equalsIgnoreCase(name)) {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            ProductNode minNode = getMin(node.right);
            node.name = minNode.name;
            node.price = minNode.price;
            node.type = minNode.type;
            node.right = deleteProduct(node.right, minNode.name);
        } else {
            node.left = deleteProduct(node.left, name);
            node.right = deleteProduct(node.right, name);
        }
        return node;
    }

    // Ambil node dengan nilai terkecil (paling kiri)
    private ProductNode getMin(ProductNode node) {
        while (node.left != null) node = node.left;
        return node;
    }
}
