## STRUKTUR DATA OOP

| Nama  | Atik Putri Matulina  |
|-------|----------------------|
| Kelas | A                    |
| NRP   | 5027251128           |
| Mata Kuliah | Struktur Data dan Pemrograman Berorientasi Objek |

## PENJELASAN   
private double[] daftarNilai
Ini adalah sebuah array bertipe double. Array adalah struktur data yang menyimpan banyak nilai dalam satu variabel. 

    private String nama;
    private double[] daftarNilai;

    public Mahasiswa(String nama, double[] daftarNilai) {
        this.nama = nama;
        this.daftarNilai = daftarNilai;
    }

    public String getNama() { return nama; }
    public double[] getDaftarNilai() { return daftarNilai; }

    public abstract double hitungRataRata();}

## DIAGRAM HUBUNGAN ANTAR CLASS
        ┌─────────────────────────|
        │       Mahasiswa         │
        │ - nama: String          │
        │ - daftarNilai: double[] │
        │ + getNama()             │
        │ + getDaftarNilai()      │
        │ + hitungRataRata()      │ 
        └───────────┬─────────────┘
          ┌─────────┴──────────┐
┌─────────▼──────┐   ┌─────────▼────────┐
│MahasiswaReguler│   │MahasiswaBeasiswa │
