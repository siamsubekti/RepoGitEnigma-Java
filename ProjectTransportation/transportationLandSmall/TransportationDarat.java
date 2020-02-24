package transportationLandSmall;

import javax.swing.text.html.MinimalHTMLWriter;

public class TransportationDarat {
	private int kapasitas;
//	protected int jarakTempuh;
//	protected String kategori;
	private int fuel;
	private int roda;
	private String colour;
	
	public int getKapasitas() {
		return kapasitas;
	}
	

	public void setKapasitas(int kapasitas) {
		this.kapasitas = kapasitas;
	}

	public int getFuel() {
		return fuel;
	}


	public void setFuel(int fuel) {
		this.fuel = fuel;
	}


	public int getRoda() {
		return roda;
	}


	public void setRoda(int roda) {
		this.roda = roda;
	}


	public String getColour() {
		return colour;
	}


	public void setColour(String colour) {
		this.colour = colour;
	}
	
	public TransportationDarat(int kapasitas) { 
		
		this.kapasitas = kapasitas;
//		this.jarakTempuh = jarakTempuh;
//		this.kategori = kategori;
		this.fuel = fuel;
		this.colour = colour;
		this.roda = roda;
		
	}

	public void kapasitasMini() {
		System.out.println("kapasitas Mobil MiniBus " + kapasitas + " orang");
		System.out.println("Ukuran tangki bensin " + fuel + " liter");

	}

	public void kapasitasSedan() {
		System.out.println("kapasitas Mobil Sedan " + kapasitas + " orang");
	}
}
