package jdbcdemo;

public class Pet {
	
	private String age;
	private String pfn;//pet first name
	private String ofn;//owner first name
	private String oln;//owner last name 
	private String phone;//phone number
	private String email;
	private String animal;
	private String breed;
	private String med1;
	private String psw;

	public Pet(String email, String ofn, String oln, String phone) 
	{
		super();
		
		this.age = "x";
		this.pfn = "x";
		this.animal = "x";
		this.ofn = ofn;
		this.oln = oln;
		this.phone= phone;
		this.email = email;
		this.psw = "x";
		this.breed= "x";
		this.med1= "none";
	}
//
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	public String getPfn() {
		return pfn;
	}

	public void setPfn(String pfn) {
		this.pfn = pfn;
	}
	
	public String getOfn() {
		return ofn;
	}

	public void setOfn(String ofn) {
		this.ofn = ofn;
	}
	
	public String getOln() {
		return oln;
	}

	public void setOln(String oln) {
		this.oln = oln;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAnimal() {
		return animal;
	}
	public void setAnimal(String animal) {
		this.animal = animal;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public String getMed1() {
		return med1;
	}
	public void setMed1(String med1) {
		this.med1 = med1;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String Psw) {
		this.psw = Psw;
	}
	//@Override
	public String toString() {
		String out = ("USER1" + email +", "+ psw + "," + ofn +","+ oln +","+ pfn + ", " + age + " , " + phone + " , " + animal + " , " + breed + " , " + med1 );
		//String out = "hello";
		return out;
				
				//("Pet [age=%s, pfn=%s, ofn=%s, oln=%s]",
					//	age, pfn, ofn, oln);
	}
	
//
	
}
