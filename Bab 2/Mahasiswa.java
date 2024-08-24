public class Mahasiswa{
	
	int nrp; 

	String nama;


	// Constructor 

	public Mahasiswa(int i , String n ){
		nrp = i; 
		nama = n; 
	}


	// Function getNrp 

	public  int getNrp(){
		return nrp;
	}

	// function GetNama 

	public String getnama(){
		return	nama;
	}
}