public boolean thayDoiTTMonAn(int trangThai) {
	
		boolean xd=false;
		
		if (dsMonAn==null) return false;
		
		if((trangThai<-1) && (trangThai >2)) return false;
		
		Iterator<MonAn> it = dsMonAn.iterator();
		
		while(it.hasNext()){
			
			if (checkTT(it)==false) {
				
				it.trangThai=trangThai;
				xd=true
			}
			it.next();
		}
		if (xd==false) System.out.printf("Khong thay doi gi");
		
}