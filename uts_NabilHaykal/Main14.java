package uts_NabilHaykal;
import java.util.Scanner;
public class Main14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TokoABC14 toko = new TokoABC14();
        int pilihan;
        do {
            System.out.println("\n========== MENU TOKO ABC ==========");
            System.out.println("1. Input Data Barang");
            System.out.println("2. Transaksi Penjualan");
            System.out.println("3. Urutkan Barang Berdasarkan Stok Terbanyak");
            System.out.println("4. Tampilkan Barang Terlaris");
            System.out.println("5. Tampilkan Semua Data Barang");
            System.out.println("0. Keluar");
            System.out.print("Silakan pilih menu : ");
            while (!scanner.hasNextInt()) {
                System.out.println("Input tidak valid. Masukkan angka!");
                scanner.next();
                System.out.print("Silakan pilih menu : ");
            }
            pilihan = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
            switch (pilihan) {
                case 1:
                    toko.inputBarang(scanner);
                    break;
                case 2:
                    toko.prosesPenjualan(scanner);
                    break;
                case 3:
                    toko.urutkanBerdasarkanStokTerbanyak();
                    break;
                case 4:
                    toko.tampilkanBarangPalingLaris();
                    break;
                case 5:
                    toko.tampilkanDaftarBarang();
                    break;
                case 0:
                    System.out.println("Terima kasih telah berbelanja di Toko ABC!");
                    break;
                default:
                    System.out.println("Menu tidak tersedia. Silakan pilih angka antara 0 - 5!");
            }
        } while (pilihan != 0);
    }
}