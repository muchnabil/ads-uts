package uts_NabilHaykal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
public class TokoABC14 {
    List<Barang14> daftarBarang = new ArrayList<>();
    public void inputBarang(Scanner scanner) {
        System.out.print("Input jumlah barang yang ingin dimasukkan : ");
        int jumlahBarang = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < jumlahBarang; i++) {
            System.out.println("\nData barang ke -" + (i + 1));
            System.out.print("Kode barang: ");
            String kode = scanner.nextLine();
            System.out.print("Nama barang: ");
            String nama = scanner.nextLine();
            System.out.print("Stok awal: ");
            int stok = scanner.nextInt();
            System.out.print("Harga satuan: ");
            int harga = scanner.nextInt();
            scanner.nextLine();
            Barang14 barang = new Barang14(kode, nama, stok, harga);
            daftarBarang.add(barang);
        }
    }
    public Barang14 cariBarang(String kode) {
        for (Barang14 barang : daftarBarang) {
            if (barang.kode.equalsIgnoreCase(kode)) {
                return barang;
            }
        }
        return null;
    }
    public void prosesPenjualan(Scanner scanner) {
        List<Penjualan14> daftarPenjualan = new ArrayList<>();
        while (true) {
            System.out.print("\nMasukkan kode barang yang ingin dibeli (ketik 'selesai' untuk mengakhiri) : ");
            String kode = scanner.nextLine();
            if (kode.equalsIgnoreCase("selesai")) break;
            Barang14 barangDibeli = cariBarang(kode);
            if (barangDibeli == null) {
                System.out.println("Barang dengan kode tersebut tidak ditemukan!");
                continue;
            }
            System.out.print("Jumlah yang ingin dibeli : ");
            int jumlahBeli = scanner.nextInt();
            scanner.nextLine();
            if (jumlahBeli > barangDibeli.stok) {
                System.out.println("Maaf, stok tidak mencukupi.");
            } else {
                barangDibeli.kurangiStok(jumlahBeli);
                daftarPenjualan.add(new Penjualan14(barangDibeli, jumlahBeli));
                System.out.println("Barang berhasil ditambahkan ke struk!");
            }
        }
        if (!daftarPenjualan.isEmpty()) {
            System.out.println("\n========== STRUK PENJUALAN ==========");
            Struk14.cetak(daftarPenjualan);
            System.out.println("======================================");
        } else {
            System.out.println("Tidak ada barang yang dibeli!");
        }
    }
    public void tampilkanDaftarBarang() {
        System.out.println("\n========== DAFTAR BARANG ==========");
        System.out.printf("%-6s %-15s %-6s %-12s\n", "Kode", "Nama", "Stok", "Harga");
        for (Barang14 barang : daftarBarang) {
            System.out.printf("%-6s %-15s %-6d %-12d\n",
                barang.kode, barang.nama, barang.stok, barang.hargaSatuan);
        }
    }
    public void urutkanBerdasarkanStokTerbanyak() {
        daftarBarang.sort((a, b) -> Integer.compare(b.stok, a.stok));
        System.out.println("\nData barang setelah diurutkan berdasarkan stok terbanyak :");
        tampilkanDaftarBarang();
    }
    public void tampilkanBarangPalingLaris() {
        if (daftarBarang.isEmpty()) {
            System.out.println("Belum ada data barang!");
            return;
        }
        Barang14 barangTerlaris = Collections.max(daftarBarang,
            Comparator.comparingInt(barang -> barang.totalTerjual));
        if (barangTerlaris.totalTerjual == 0) {
            System.out.println("Belum ada barang yang terjual!");
        } else {
            System.out.println("\n========== BARANG TERLARIS ==========");
            System.out.printf("Kode    : %s\n", barangTerlaris.kode);
            System.out.printf("Nama    : %s\n", barangTerlaris.nama);
            System.out.printf("Terjual : %d\n", barangTerlaris.totalTerjual);
        }
    }
}