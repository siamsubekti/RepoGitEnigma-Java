package transportationLandSmall;

public class MobilMinibus extends TransportationDarat{
//	int fuel = 0;


	
public MobilMinibus(int kapasitas) {
		super(kapasitas);
		
	}

	public void tambahKapasitasMini() {
		super.setKapasitas(6);
	}
	
	public void setFuelMini(int fuel) {
		this.setFuel(20);
	}


	public void tintin() {
		System.out.println("thank you");
		
	}
	
	

}
