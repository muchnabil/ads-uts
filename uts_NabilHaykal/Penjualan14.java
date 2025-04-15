package uts_NabilHaykal;
public class Penjualan14 {
    Barang14 barang;
    int jumlahBeli;
    public Penjualan14(Barang14 barang, int jumlahBeli) {
        this.barang = barang;
        this.jumlahBeli = jumlahBeli;
    }
    public int getTotalHarga() {
        return jumlahBeli * barang.hargaSatuan;
    }
}