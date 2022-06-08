// Program Transitive Closure Menggunakan Algoritma Floyd Warshall

import java.util.*;//untuk memanggil data inputan 
import java.lang.*;//menghubungkan perintah program java dengan kompiler
import java.io.*;//input output pada java

public class ayo {
    final static int V = 4 ;
    // Mencetak grafik transitif closure[][] menggunakan Floyd
    // Algoritma Warshall
    void transitiveClosure(int graph[][])
    {
        /* matriks[][] akan menjadi output matriks yang akhirnya
        memiliki jarak terpendek antara setiap pasangan
        sudut */
        int matriks[][] = new int [V][V];
        int i,j,k;

        /* Inisialisasi matriks solusi sama dengan grafik input
        matriks. Atau kita dapat mengatakan nilai awal terpendek
        jarak didasarkan pada jalur terpendek dengan mempertimbangkan
        tidak ada titik tengah. */
        for( i = 0; i<V; i++)
            for(j = 0; j<V;j++)
                matriks[i][j] = graph[i][j];

        /* Tambahkan semua simpul satu per satu ke himpunan perantara
        sudut.
        ---> Sebelum memulai pengulangan, kami memiliki keterjangkauan
        nilai untuk semua pasangan simpul sedemikian rupa sehingga
        nilai keterjangkauannya hanya mempertimbangkan simpul di
        atur {0, 1, 2, .. k-1} sebagai simpul perantara.
        ----> Setelah akhir iterasi, simpul no. k adalah
        ditambahkan ke himpunan simpul perantara dan
        himpunan menjadi {0, 1, 2, .. k} */
        for (k = 0 ; k<V;k++)
        {
            // Pilih semua simpul sebagai sumber satu per satu
            for ( i=0;i<V;i++)
            {
                // Pilih semua simpul sebagai tujuan untuk
                // sumber yang dipilih di atas
                for( j = 0 ; j<V;j++)
                {
                    // Jika simpul k berada pada lintasan dari i ke j,
                    // lalu pastikan nilai reach[i][j] adalah 1
                    matriks[i][j] = (matriks[i][j]!=0) ||
                        ((matriks[i][k]!=0)&&(matriks[k][j]!=0))?1:0;
                }
            }
        }
        // Cetak matriks jarak terpendek
        printSolution(matriks);  
    }

    /* Fungsi untuk mencetak solusi */
    void printSolution ( int reach[][])
    {
        System.out.println("Matriks berikut adalah penutupan transitif "+" dari grafik yang diberikan");
        for (int i =0; i < V; i++)
        {
            for(int j = 0; j<V; j++)
            {
                if(i==j)
                    System.out.println("1");
                else
                    System.out.println(reach[i][j]+" ");
            }
            System.out.println();
        }
    }

    // Kode Pengemudi
    public static void main(String[] args) 
    {
        
        /* Mari kita buat grafik berbobot berikut:
           10
        (0)------->(3)
        |         /|\
      5 |          |
        |          | 1
        \|/        |
        (1)------->(2)
           3           */
/* Mari kita buat grafik berbobot berikut:

              10
         (0)------->(3)
          |         /|\
        5 |          |
          |          | 1
         \|/         |
         (1)------->(2)
            3           */
        int graph[][] = new int[][]{{0,1,0,1},
                                    {0,0,1,0},
                                    {0,0,0,1},
                                    {0,0,0,0}};
                                    
        ayo g = new ayo();
        g.transitiveClosure(graph);
     


    }
}
    
