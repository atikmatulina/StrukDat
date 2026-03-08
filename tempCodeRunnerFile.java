import java.util.Scanner;

// 1. ABSTRACTION: Class abstrak sebagai kerangka dasar
abstract class Mahasiswa {
    private String nama;
    // 2. ENCAPSULATION: Atribut privat agar tidak dimanipulasi langsung
    private double[] nilai;

    public Mahasiswa(String nama, double[] nilai) {
        this.nama = nama;
        this.nilai = nilai;
    }

    public String getNama() { return nama; }
    public double[] getNilai() { return nilai; }

    // Metode abstrak yang harus diimplementasikan oleh anak cucunya
    public abstract double hitungRataRata();
}

// 3. INHERITANCE: MahasiswaReguler mewarisi Mahasiswa
class MahasiswaReguler extends Mahasiswa {
    public MahasiswaReguler(String nama, double[] nilai) {
        super(nama, nilai);
    }

    // 4. POLYMORPHISM: Implementasi rata-rata standar
    @Override
    public double hitungRataRata() {
        double total = 0;
        for (double n : getNilai()) {
            total += n;
        }
        return total / getNilai().length;
    }
}

public class SistemNilai {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== Input Data Mahasiswa ===");
        System.out.print("Masukkan Nama: ");
        String nama = input.nextLine();

        System.out.print("Masukkan jumlah mata kuliah: ");
        int jumlahMk = input.nextInt();
        double[] nilaiInput = new double[jumlahMk];

        for (int i = 0; i < jumlahMk; i++) {
            System.out.print("Masukkan nilai ke-" + (i + 1) + ": ");
            nilaiInput[i] = input.nextDouble();
        }

        // Membuat objek menggunakan konsep Polymorphism
        Mahasiswa mhs = new MahasiswaReguler(nama, nilaiInput);

        System.out.println("\n--- Hasil Perhitungan ---");
        System.out.println("Nama Mahasiswa: " + mhs.getNama());
        // Memanggil metode hitungRataRata() tanpa perlu tahu rumus di dalamnya (Abstraction)
        System.out.printf("Rata-rata Nilai: %.2f\n", mhs.hitungRataRata());

        input.close();
    }
}