package assignment7;

public class Student {
	private String first,last;
	private int ID;
	private int a_creds = 0;
	private int p_creds = 0;
	private double TGQP = 0;
	private double BB = 0;

	/**
	 * 
	 * @param first
	 * @param last
	 * @param iD
	 */
	public Student(String first, String last, int iD) {
		super();
		this.first = first;
		this.last = last;
		ID = iD;
	}
	/**
	 * 
	 * @return
	 */
	public String getFullName() {
		return first+" "+last;
	}

	public int getId() {
		return ID;
	}

	public void submitGrade(double grade, int credits){
		a_creds = a_creds+credits;
		TGQP = TGQP+grade*credits;
		if (grade>=1.7) {
			p_creds = p_creds+credits;
		}
	}

	public int getTotalAttemptedCredits() {
		return a_creds;
	}

	public int getTotalPassingCredits() {
		return p_creds;
	}

	public double calculateGradePointAverage() {
		return (TGQP/a_creds);
	}


	public String getClassStanding() {
		if (p_creds>=90) {
			return "Senior";
		}
		else if (p_creds>=60) {
			return "Junior";
		}
		else if (p_creds>=30) {
			return "Sophomore";
		}
		else {
			return "First Year";
		}
	}

	public boolean isEligibleForPhiBetaKappa() {
		if (TGQP/a_creds>=3.60 && p_creds>=98) {
			return true;
		}
		else if (TGQP/a_creds>=3.80 && p_creds>=75){
			return true;
		}
		else {
			return false;
		}
	}

	public void depositBearBucks(double amount) {
		BB = BB+amount;
	}

	public void deductBearBucks(double amount) {
		BB = BB-amount;
	}

	public double getBearBucksBalance() {
		return BB;
	}

	public double cashOutBearBucks() {
		double prebb = BB;
		BB = 0;
		if (prebb<10) {
			return 0;
		}
		else {
			return prebb-10;
		}
	}
	
	

	public  Student createLegacy(String firstName, Student other, boolean isHyphenated, int id) {
		
		double SBB = 0;
		SBB = this.cashOutBearBucks()+ other.cashOutBearBucks();
		
		if (isHyphenated) {
			Student new_student = new Student(firstName,this.last + "-"+ other.last,id);
			new_student.depositBearBucks(SBB);
			return new_student;
		}
		else {
			Student new_student = new Student(firstName,this.last,id);
			new_student.depositBearBucks(SBB);
			return new_student;
		}
		
		
	}

	@Override
	public String toString() {
		return first + " "+ last  + ID;
	}
	
	


}
