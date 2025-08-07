import java.util.HashMap;
import java.util.Scanner;

public class HashApp {
    private HashMap<String, Integer> hashTable = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("\nMenu Manajemen Data:");
            System.out.println("1. Tambah Data");
            System.out.println("2. Cari Data");
            System.out.println("3. Hapus Data");
            System.out.println("4. Tampilkan Semua Data");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");
            
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka antara 1-5!");
                continue;
            }
            
            switch (choice) {
                case 1:
                    System.out.print("Masukkan nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan usia: ");
                    try {
                        int usia = Integer.parseInt(scanner.nextLine());
                        hashTable.put(nama, usia);
                        System.out.println("Data berhasil ditambahkan!");
                    } catch (NumberFormatException e) {
                        System.out.println("Usia harus berupa angka!");
                    }
                    break;
                    
                case 2:
                    System.out.print("Masukkan nama yang dicari: ");
                    String keyDicari = scanner.nextLine();
                    if (hashTable.containsKey(keyDicari)) {
                        int nilai = hashTable.get(keyDicari);
                        System.out.println(keyDicari + " berusia " + nilai + " tahun.");
                    } else {
                        System.out.println(keyDicari + " tidak ditemukan.");
                    }
                    break;
                    
                case 3:
                    System.out.print("Masukkan nama yang akan dihapus: ");
                    String keyHapus = scanner.nextLine();
                    if (hashTable.containsKey(keyHapus)) {
                        hashTable.remove(keyHapus);
                        System.out.println(keyHapus + " berhasil dihapus.");
                    } else {
                        System.out.println(keyHapus + " tidak ditemukan.");
                    }
                    break;
                    
                case 4:
                    System.out.println("\nIsi Hash Table:");
                    if (hashTable.isEmpty()) {
                        System.out.println("Hash Table kosong.");
                    } else {
                        for (String key : hashTable.keySet()) {
                            System.out.println(key + ": " + hashTable.get(key) + " tahun");
                        }
                        System.out.println("Total elemen: " + hashTable.size());
                    }
                    break;
                    
                case 5:
                    return;
                    
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih 1-5.");
            }
        }
    }
}