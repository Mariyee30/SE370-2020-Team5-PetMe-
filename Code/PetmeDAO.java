package jdbcdemo;

import java.util.*;
import java.sql.*;
import java.io.*;


public class PetmeDAO {

	private Connection myConn;
	//constructor
	public PetmeDAO() throws Exception {

		// connect to database
		myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/petmedb", "root", "P3tM3@37");
		
		System.out.println("DB connection successful to: " + "jdbc:mysql://localhost:3306/petmedb");
	}
	

	
	public void addUser(Pet thePet) throws Exception {
		
		PreparedStatement myStmt = null;

		try {

				myStmt = myConn.prepareStatement("insert into logininfo "
					+ " (email, ownerFirstName, ownerLastName,phoneNum ) "
					+ " values (?,?,?,?)" );
			
				//setparames
				myStmt.setString(1, thePet.getEmail());
				myStmt.setString(2, thePet.getOfn());
				myStmt.setString(3, thePet.getOln());
				myStmt.setString(4, thePet.getPhone());

			
				//execute sql
				myStmt.executeUpdate();

		}
		finally {
			close(myStmt, null);
		}
	}
	

	
	

	public void updateUserInfo(String fn,String ln,String e,String p) throws Exception {
		PreparedStatement myStmt = null; 
		try {

			myStmt = myConn.prepareStatement("update logininfo"
				+ "set ownerLastName=?, phoneNum=?"
				+ "where email = 'laurengonz@gmail.com'");				
				
				myStmt.setString(1, ln);
				myStmt.setString(2, p);

				System.out.println("Changed Owner Last Name: " + ln);
				System.out.println("Changed Owner phone Number: " + p );
				myStmt.executeUpdate();
		}
		finally {
			close(myStmt, null);
		}
		
				
	}
	
	
	public List<Pet> getAllPets() throws Exception {
		List<Pet> list = new ArrayList<Pet>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("select * from logininfo");
			
			while (myRs.next()) {
				Pet tempPet = convertRowToPet(myRs);
				list.add(tempPet);
			}

			return list;		
		}
		finally {
			close(myStmt, myRs);
		}
	}
	
	
	public List<Pet> searchPets(String email) throws Exception {
		List<Pet> list = new ArrayList<Pet>();

		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {
			email += "%";
			myStmt = myConn.prepareStatement("select * from logininfo where email like ?");
			
			myStmt.setString(1, email);
			
			myRs = myStmt.executeQuery();
			
			while (myRs.next()) {
				Pet tempPet = convertRowToPet(myRs);
				list.add(tempPet);
			}
			
			return list;
		}
		finally {
			close(myStmt, myRs);
		}
	}
	
	
	private Pet convertRowToPet(ResultSet myRs) throws SQLException {
		
		String email = myRs.getString("email");
		String pass = myRs.getString("psw");
		
		/////////
		
		String oName = myRs.getString("ownerFirstName");
		String olName = myRs.getString("ownerLastName");
		String petName = myRs.getString("pName");
		String petAge = myRs.getString("pAge");
		String phoneNumber = myRs.getString("phoneNum");
		String petAnimal = myRs.getString("pAnimal");
		String petBreed = myRs.getString("pBreed");
		String petMedication = myRs.getString("pMed1");
		
		Pet tempPet = new Pet(email, oName, olName, phoneNumber );
		tempPet.setPsw(pass);
	//	tempPet.setOfn(oName);
	//	tempPet.setOln(olName);
		tempPet.setPfn(petName);
		tempPet.setAge(petAge);
//		tempPet.setPhone(phoneNumber);
		tempPet.setAnimal(petAnimal);
		tempPet.setBreed(petBreed);
		tempPet.setMed1(petMedication);
		
		return tempPet;
	}
	
	private static void close(Connection myConn, Statement myStmt, ResultSet myRs)
			throws SQLException {

		if (myRs != null) {
			myRs.close();
		}

		if (myStmt != null) {
			
		}
		
		if (myConn != null) {
			myConn.close();
		}
	}
	private void close(Statement myStmt, ResultSet myRs) throws SQLException {
		close(null, myStmt, myRs);		
	}

	public static void main(String[] args) throws Exception {
		
		PetmeDAO dao = new PetmeDAO();
		System.out.println("hello");
		System.out.println(dao.searchPets("df"));
	}
}
