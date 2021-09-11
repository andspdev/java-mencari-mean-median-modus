import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * Program Java - Mencari Mean, Median, dan Modus
 * Dari Andreas Pandu Pamungkas
 * Dibuat pada tanggal: 11 September 2021
 *
 */

public class Main
{

    public static void main(String[] args)
    {
        int input;
        Scanner scan = new Scanner(System.in);

        // Input bilangan banyak data
        System.out.print("Masukkan berapa banyak data: ");
        input = scan.nextInt();

        // Cek apakah nilai dari input > 0
        if (input > 0)
        {
            // Input masing-masing data berdasarkan nilai arraynya

            System.out.println("\nMasukkan isi data berupa angka:");
            int[] data =  new int[input];
            for (int i = 0; i < input; i++)
            {
                System.out.print("- Isi Data ke-" +(i + 1)+ " = ");
                data[i] = scan.nextInt();
            }

            // Tampilkan hasil perhitungannya -> mean, median dan modus
            System.out.println("\nHasil Perhitungan:");
            System.out.printf("- Mean\t\t= %.1f%n", mean(data));
            System.out.printf("- Median\t= %.1f%n", median(data));
            System.out.printf("- Modus\t\t= %s%n", modus(data, input));
        }
        else
            // Jika input <= 0 maka keluar pesan kesalahan
            System.err.println("Silahkan masukkan banyak data lebih dari 0");
    }


    static String modus(int[] data, int input)
    {
        int c;
        int[] b = new int[input];

        // Pencarian data untuk menentukan modus
        for (int i = 0; i < input; i++)
        {
            c = 1;

            if (data[i] == -1)
                b[i] = 0;
            else
            {
                for (int j = i+1; j < input; j++)
                {
                    if (data[i] == data[j])
                    {
                        c++;
                        data[j] = -1;
                    }
                }

                b[i] = c;
            }
        }

        int m = b[0];
        for (int i = 1; i < input; i++)
        {
            if (b[i] >= m)
                m = b[i];
        }

        String[] outputHasil = new String[input];
        for (int i = 0; i < input; i++)
        {
            if (b[i] == m)
                outputHasil[i] = String.valueOf(data[i]);
        }
        //

        // Menghapus nilai "null" pada array outputHasil
        String[] modus = Arrays.stream(outputHasil).filter(Objects::nonNull).toArray(String[]::new);


        // Memberikan "," pada masing-masing angka
        return String.join(", ", modus);
    }


    // Fungsi untuk mencari median dari data
    static double median(int[] dataArr)
    {
        double median;
        int[] data = urutkan(dataArr);

        if (data.length % 2 == 1)
            median = data[data.length / 2];
        else
            median = ((double) (data[data.length / 2] + data[(data.length / 2) - 1])) / 2;

        return median;
    }


    // Fungsi untuk Mean -> rata-rata
    static double mean(int[] data)
    {
        int tambah = 0;
        for (int dataTambah : data)
        {
            // Menjumlah seluruh data array
            tambah += dataTambah;
        }

        // Mulai Melakukan perhitungan rata-rata
        return tambah / (double) data.length;
    }


    // Fungsi untuk mengurutkan
    static int[] urutkan(int[] data)
    {
        int temp;
        for (int i = 0; i < data.length-1; i++)
        {
            for (int j = data.length-1; j > i; j--)
            {
                if (data[j-1] > data[j])
                {
                    temp        = data[j];
                    data[j]     = data[j-1];
                    data[j-1]   = temp;
                }
            }
        }

        return data;
    }
}
