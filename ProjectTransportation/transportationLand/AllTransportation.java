package transportationLand;

import java.util.Scanner;

import transportationAir.Pesawat;
import transportationLandSmall.MobilMinibus;
import transportationLandSmall.MobilSedan;
import transportationLandSmall.TransportationDarat;

public class AllTransportation {

	public static void main(String[] args) {
		int kapasitas1 = 6;
		int kapasitas2 = 4;
		int kapasitas3 = 20;
		
//		Scanner masukan = new Scanner (System.in);
//		String x;
//		System.out.println("====Perjalanan====");
//		
//		System.out.println("Mau berpergian menggunakan transportasi apa ?");
//		System.out.println("1.Mobil");
//		System.out.println("2.Pesawat");
//		System.out.println("3.Kereta");
//		System.out.println("ketik sini : ");
//		x = masukan.next();
				
			Pesawat nama = new Pesawat(kapasitas1);
			
			nama.jalan(7);
			nama.kapasitas(2);
			
//			TransportationDarat nama2 = new TransportationDarat();
//			nama2.print();
//			
//			System.out.println(nama2.print());
			
//			MobilSedan nama2 = new MobilSedan();
//			
//			nama2.tintin();
//			System.out.println(nama.jalan(0) + x);
			
//			MobilMinibus miniBus = new MobilMinibus(10);
//			miniBus.tambahKapasitasMini();
//			miniBus.kapasitasMini();
			MobilMinibus miniBus = new MobilMinibus(10);
			miniBus.tambahKapasitasMini();
			miniBus.setFuelMini(5);
			miniBus.kapasitasMini();
			
			MobilSedan sedan = new MobilSedan(4);
			sedan.tambahKapasitasSedan();
			sedan.kapasitasSedan();


	}
	
	

}

