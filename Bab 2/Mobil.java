public class Mobil {
    private String merek;
    private String model;
    private int tahun;
    private String warna;
    private int kapasitasMesin;

    // Constructor
    public Mobil(String merek, String model, int tahun, String warna, int kapasitasMesin) {
        this.merek = merek;
        this.model = model;
        this.tahun = tahun;
        this.warna = warna;
        this.kapasitasMesin = kapasitasMesin;
    }

    // Method untuk menampilkan informasi mobil
    public void infoMobil() {
        System.out.println("Merek: " + merek);
        System.out.println("Model: " + model);
        System.out.println("Tahun: " + tahun);
        System.out.println("Warna: " + warna);
        System.out.println("Kapasitas Mesin: " + kapasitasMesin + "cc");
        System.out.println("---------------------------");
    }
}
