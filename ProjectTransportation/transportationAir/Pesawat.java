package transportationAir;

public class Pesawat {
	
	private Integer jarak;
	private int kapasitas;
	private int ticket;
	
	
	public Pesawat(int kapasitas) {
		this.jarak = 0;
		this.kapasitas = 0;
		this.ticket = 0;
	}
	
	
	public void jalan(int jarak) {
	if(jarak>0) {
		System.out.println("selamat jalan(kru pesawat)");
	}else {
		System.out.println("pesawat belum mulai jalan");
	
		
		}
	}
	
	public void kapasitas (int kapasitas) {
	if(kapasitas==0) {
		System.out.println("kapasitas kursi penuh");
	}else {
		System.out.println("kursi masih ada");
	}

}
}

