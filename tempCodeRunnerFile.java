abstract class Mahasiswa {
    private String nama; //menyimpan nama mahasiswa
    private double[] daftarNilai; // array untuk menyimpan nilai banyak mahasiswa sekaligus 

    public Mahasiswa(String nama, double[] daftarNilai) { // konstruktor untuk inisialisasi nama dan daftar nilai
        this.nama = nama;
        this.daftarNilai = daftarNilai; // untuk menyimpan nilai yang diinputkan oleh user ke dalam array daftarNilai
    }

    // untuk mendapatkan nama mahasiswa dan daftar nilai 
    public String getNama() { return nama; } 
    public double[] getDaftarNilai() { return daftarNilai; }  

    public abstract double hitungRataRata(); // untuk menghitung rata rata nilai mahasiswa
}

class MahasiswaReguler extends Mahasiswa { // kelas untuk mahasiswa reguler yang mewarisi kelas Mahasiswa
    public MahasiswaReguler(String nama, double[] nilai) {
        super(nama, nilai);
    }

    @Override // untuk menghitung rata rata nilai mahasiswa reguler 
    public double hitungRataRata() {
        double total = 0; // untuk menyimpan total nilai mahasiswa reguler
        for (double n : getDaftarNilai()) { // untuk menghitung total nilai mahasiswa reguler dengan menjumlahkan semua nilai yang ada di dalam array daftarNilai
            total += n;    // untuk menjumlahkan semua nilai yang ada di dalam array daftarNilai dan menyimpannya ke dalam variabel total
        }
        return total / getDaftarNilai().length;
    }
}

class MahasiswaBeasiswa extends Mahasiswa {
    public MahasiswaBeasiswa(String nama, double[] nilai) { // konstruktor untuk inisialisasi nama dan daftar nilai mahasiswa beasiswa
        super(nama, nilai); // untuk menyimpan nilai yang diinputkan oleh user ke dalam array daftarNilai
    }


    @Override
    public double hitungRataRata() { // untuk menghitung nilai rata rata mahasiswa beasiswa 
        double total = 0;
        for (double n : getDaftarNilai()) {
            total += n;
        }
        return (total / getDaftarNilai().length) + 5.0; // untuk menghitung rata rata nilai mahasiswa beasiswa dengan menjumlahkan semua nilai yang ada di dalam array daftarNilai kemudian dibagi dengan jumlah mata kuliah yang diinput sebelumnya dan ditambahkan dengan bonus +5 poin
    }
}

public class tugasstrukdat {
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); // untuk membaca input dari user

        System.out.println("=== Sistem Input Nilai Mahasiswa ===");
        
        System.out.print("Masukkan Nama Mahasiswa: ");
        String nama = scanner.nextLine(); // untuk menginput nama mahasiswa

        System.out.println("Jenis Mahasiswa:"); 
        System.out.println("1. Reguler"); // untuk memilih jenis mahasiswa apakah reguler atau beasiswa
        System.out.println("2. Beasiswa (Bonus +5 poin)"); // untuk memilih jenis mahasiswa apakah reguler atau beasiswa, jika pilih beasiswa maka akan mendapatkan bonus +5 poin pada rata-rata nilai yang dihitung
        System.out.print("Pilih (1/2): "); // memilih jenis mahasiswa apakah reguler atau beasiswa
        int pilihan = scanner.nextInt();

        System.out.print("Masukkan jumlah mata kuliah: ");
        int jmlMk = scanner.nextInt(); // untuk menginput jumlah mata kuliah yang diambil oleh mahasiswa, 
        double[] nilaiInput = new double[jmlMk];    // untuk membuat array nilaiInput dengan ukuran sesuai dengan jumlah mata kuliah yang diinput sebelumnya

        // untuk menginput nilai mahasiswa sesuai dengan jumlah mata kuliah yang diinput sebelumnya 
        for (int i = 0; i < jmlMk; i++) {
            System.out.print("Masukkan nilai ke-" + (i + 1) + ": "); 
            nilaiInput[i] = scanner.nextDouble();
        }
        Mahasiswa mhs;

        // untuk membuat objek mahasiswa sesuai dengan pilihan jenis mahasiswa yang diinput sebelumnya, jika pilihan 2 maka akan membuat objek MahasiswaBeasiswa, jika tidak maka akan membuat objek MahasiswaReguler
        if (pilihan == 2) {
            mhs = new MahasiswaBeasiswa(nama, nilaiInput);
        } else {
            mhs = new MahasiswaReguler(nama, nilaiInput);
        }

        System.out.println("\n--- Hasil Perhitungan ---");
        System.out.println("Nama: " + mhs.getNama());
        System.out.printf("Rata-rata: %.2f\n", mhs.hitungRataRata());

        scanner.close();
    }
}
