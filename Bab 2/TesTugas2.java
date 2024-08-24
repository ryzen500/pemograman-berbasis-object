public class TesTugas2{


		public static void main(String[] args){

				       // Membuat empat buah objek Mobil dengan simulasi pegawai baru insert data 
        Mobil mobil1 = new Mobil("Toyota", "Avanza", 2020, "Hitam", 1500);
        Mobil mobil2 = new Mobil("Honda", "Civic", 2018, "Merah", 1800);
        Mobil mobil3 = new Mobil("Suzuki", "Ertiga", 2019, "Putih", 1400);
        Mobil mobil4 = new Mobil("Mitsubishi", "Xpander", 2021, "Silver", 1600);

        // Menampilkan informasi 
        mobil1.infoMobil();
        mobil2.infoMobil();
        mobil3.infoMobil();
        mobil4.infoMobil();
		}


}