import javax.swing.JOptionPane;

public class KonversiSuhu {
    public static void main(String[] args) {
        // Meminta input suhu dalam Celcius melalui JOptionPane
        String inputCelcius = JOptionPane.showInputDialog("Masukkan suhu dalam Celcius:");
        
        // Mengonversi input dari String ke double
        double celcius = Double.parseDouble(inputCelcius);
        
        // Mengonversi Celcius ke Fahrenheit
        double fahrenheit = (celcius * 9/5) + 32;
        
        // Menampilkan hasil konversi menggunakan JOptionPane
        JOptionPane.showMessageDialog(null, "Suhu dalam Fahrenheit: " + fahrenheit);
    }
}
