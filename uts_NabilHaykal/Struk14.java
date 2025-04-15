package uts_NabilHaykal;
import java.util.List;
public class Struk14 {
    public static void cetak(List<Penjualan14> daftarPenjualan) {
        System.out.printf("%-6s %-12s %-12s %-14s %-12s\n", 
            "Kode", "Nama", "Jumlah Beli", "Harga Satuan", "Total");
        int totalKeseluruhan = 0;
        for (Penjualan14 transaksi : daftarPenjualan) {
            int totalPerItem = transaksi.getTotalHarga();
            totalKeseluruhan += totalPerItem;
            System.out.printf("%-6s %-12s %-12d %-14d %-12d\n",
                transaksi.barang.kode,
                transaksi.barang.nama,
                transaksi.jumlahBeli,
                transaksi.barang.hargaSatuan,
                totalPerItem
            );
        }
        System.out.println("Total Harga : " + totalKeseluruhan);
    }
}
