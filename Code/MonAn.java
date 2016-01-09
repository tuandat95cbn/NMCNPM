import java.sql.*;

public class MonAn{
	private String id;
	private String tenMonAn;
	private String moTa;
	private Image hinhAnh;
	private double giaTien;
	private int trangThai;
	
	public void setId(String id){
		this.id = id;	
	}
	
	public void setTenMonAn(String ten){
		this.tenMonAn = ten;	
	}

	public void setMoTa(String moTa){
		this.moTa = moTa;	
	}
		
	public void setHinhAnh(Image hinhAnh){
		this.hinhAnh = hinhAnh;	
	}

	public void setGiaTien(double giaTien){
		this.giaTien = giaTien;	
	}

	public void setTrangThai(int trangThai){
		if(trangThai != 0 || trangThai !=1){
			System.out.println("Mien gia tri trang thai la (0,1)")		
		}
		else{
			this.trangThai = trangThai;		
		}
	}

	public void themMonAnVaoCSDL(){
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		try(	
			Connection connection = DriverManager.getConnection("jdc:postgresql://localhost:5432/postgres?user=postgres&password=123456");
		){
			PreparedStatement addUser = connection.prepareStatement("INSERT INTO MonAn VALUES(?,?,?,?,?,?)");
			addUser.setString(1,id);
			addUser.setString(2,tenMonAn);
			addUser.setString(3,moTa);
			addUser.setString(4,hinhAnh.getUrl());
			addUser.setDouble(5,giaTien);
			addUser.setInt(6,trangThai);
			addUser.addBatch();
			addUser.executeBatch();
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
	}
	
	public MonAn(String id, String ten, String moTa, Image hinhAnh, double giaTien, int trangThai){
		setID(id);
		setTenMonAn(ten);
		setMoTa(moTa);
		setHinhAnh(moTa);
		setGiaTien(moTa);
		setTrangThai(moTa);

		themMonAnVaoCSDL();
	}

	public MonAn(){};


	
}
