package uts_NabilHaykal;
public class Barang14 {
    String kode, nama;
    int stok, hargaSatuan, totalTerjual;
    public Barang14(String kode, String nama, int stok, int hargaSatuan) {
        this.kode = kode;
        this.nama = nama;
        this.stok = stok;
        this.hargaSatuan = hargaSatuan;
        this.totalTerjual = 0;
    }
    public void kurangiStok(int jumlah) {
        this.stok -= jumlah;
        this.totalTerjual += jumlah;
    }
}
