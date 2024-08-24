public  class Tabungan{


	int saldo;

	public  Tabungan(int initSaldo){
		saldo = initSaldo;
	}


	public int getSaldo(){
		return saldo;
	}

	public boolean ambilUang(int jumlah){
	    int  tempSaldo = saldo - jumlah;


		if (tempSaldo > 0) {

		saldo -= jumlah;
			
		}



		return ((tempSaldo < 0) ?  false : true);
	}

	public void simpanUang(int jumlah){

		saldo +=jumlah;

	}
}