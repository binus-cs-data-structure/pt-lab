import java.util.*;

class Edge {
    String destination;
    int time;

    public Edge(String destination, int time) {
        this.destination = destination;
        this.time = time;
    }
}

public class GraphApp {
    private Map<String, List<Edge>> network = new HashMap<>();

    public void tambahRute(String asal, String tujuan, int waktu) {
        network.computeIfAbsent(asal, k -> new ArrayList<>()).add(new Edge(tujuan, waktu));
        network.computeIfAbsent(tujuan, k -> new ArrayList<>()).add(new Edge(asal, waktu)); // dua arah
    }

    public void tampilkanSemuaKota() {
        System.out.println("Daftar Kota yang Tersedia:");
        for (String kota : network.keySet()) {
            System.out.println("- " + kota);
        }
        System.out.println();
    }

    public void cariRuteTercepat(String asal, String tujuan) {
        Map<String, Integer> waktuTempuh = new HashMap<>();
        Map<String, String> sebelumnya = new HashMap<>();
        PriorityQueue<String> antrian = new PriorityQueue<>(Comparator.comparingInt(waktuTempuh::get));

        for (String kota : network.keySet()) {
            waktuTempuh.put(kota, Integer.MAX_VALUE);
            sebelumnya.put(kota, null);
        }

        waktuTempuh.put(asal, 0);
        antrian.add(asal);

        while (!antrian.isEmpty()) {
            String sekarang = antrian.poll();

            for (Edge rute : network.get(sekarang)) {
                int waktuBaru = waktuTempuh.get(sekarang) + rute.time;
                if (waktuBaru < waktuTempuh.get(rute.destination)) {
                    waktuTempuh.put(rute.destination, waktuBaru);
                    sebelumnya.put(rute.destination, sekarang);
                    antrian.add(rute.destination);
                }
            }
        }

        if (waktuTempuh.get(tujuan) == Integer.MAX_VALUE) {
            System.out.println("Tidak ada rute dari " + asal + " ke " + tujuan);
            return;
        }

        LinkedList<String> jalur = new LinkedList<>();
        for (String kota = tujuan; kota != null; kota = sebelumnya.get(kota)) {
            jalur.addFirst(kota);
        }

        System.out.println("Rute tercepat ditemukan: " + String.join(" -> ", jalur));
        System.out.println("Total waktu tempuh: " + waktuTempuh.get(tujuan) + " jam\n");
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        GraphApp distribusi = new GraphApp();

        // Tambahkan data rute (graph)
        distribusi.tambahRute("Jakarta", "Bandung", 3);
        distribusi.tambahRute("Jakarta", "Semarang", 5);
        distribusi.tambahRute("Bandung", "Yogyakarta", 6);
        distribusi.tambahRute("Semarang", "Yogyakarta", 4);
        distribusi.tambahRute("Semarang", "Surabaya", 4);
        distribusi.tambahRute("Yogyakarta", "Surabaya", 5);

        // Tampilkan kota yang tersedia
        distribusi.tampilkanSemuaKota();

        // Input user
        System.out.print("Masukkan kota asal: ");
        String asal = scanner.nextLine().trim();
        System.out.print("Masukkan kota tujuan: ");
        String tujuan = scanner.nextLine().trim();

        distribusi.cariRuteTercepat(asal, tujuan);
    }
}