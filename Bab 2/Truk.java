public  class Truk{

	double muatan;
	double muatanmaks;


	// Constructor

	public Truk(double i){
		muatanmaks = i;
	}


	public double getMuatan(){
		return muatan;
	}

	public  double getMuatanMaks(){
		return muatanmaks -=muatan;
	}

	public double tambahMuatan(double berat)
	{


		muatan+=berat;
			if (muatan > 1000) {
				 muatan-=berat;	
			}

				return  muatan;
		
	}



}