package studio9;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import support.cse131.NotYetImplementedException;

import assignment7.Student;



public class UniversityDatabase {
	private final Map<String,Student> gary = new HashMap<String,Student>();
	
	

	public void addStudent(String accountName, Student student) {
		gary.put(accountName, student);
	}

	public int getStudentCount() {
		return gary.size();
	}

	public String lookupFullName(String accountName) {
		Student look =  gary.get(accountName);
		if(look!=null) {
			return look.getFullName();
		}
		else {
			return null;
		}
	}

	public double getTotalBearBucks() {
		double BB = 0;
		for(String k:gary.keySet()) {
			Student stood = gary.get(k);
			BB = BB+stood.getBearBucksBalance();
		}
		return BB;
	}
}
