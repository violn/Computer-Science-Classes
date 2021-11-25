public class TestAssignment
{
	public static void main(String[] args)
	{
		print("Start Test");
		printPersonDetails();
	}

	private static void printPersonDetails()
	{
		Person p1 = new Person();
		Person p2 = new Person();
		Person p3 = new Person();
		Person p4 = new Person();
		
		p1.setFirstName("Jerry");
		p1.setLastName("Scienfield");
		p1.setDateOfBirth("04/29/1954");
		p1.setGender("M");
		p1.setOccupation("Comedian");
		p1.setCellPhone("678-438-8525");
		p1.setAddress(new TestAddress("1183 Lonely Oak Drive", null, "Mobile", "Alabama", 36693));
		
		p2.setFirstName("Solána");
		p2.setLastName("Rowe");
		p2.setDateOfBirth("11/8/1989");
		p2.setGender("F");
		p2.setOccupation("Singer");
		p2.setCellPhone("334-257-0724");
		p2.setAddress(new TestAddress("2130 Barfield Lane", "Apt 23", "Indianopolis", "Indiana", 46225));
		
		p3.setFirstName("Alan");
		p3.setLastName("Turing");
		p3.setDateOfBirth("06/23/1912");
		p3.setGender("M");
		p3.setOccupation("Mathematician");
		p3.setCellPhone("443-779-1967");
		p3.setAddress(new TestAddress("751 Scheuvront Drive", null, "Denver", "Colorado", 80020));
		
		p4.setFirstName("DeAndre");
		p4.setLastName("Way");
		p4.setDateOfBirth("07/28/1990");
		p4.setGender("M");
		p4.setOccupation("Rapper");
		p4.setCellPhone("208-943-2190");
		p4.setAddress(new TestAddress("459 Bernardo Street", "Unit 6", "Prairie Creek", "Indiana", 47869));

		print(p1);
		print(p2);
		print(p3);
		print(p4);
	}

	private static void print(Object obj)
	{
		System.out.println("------------------------");
		System.out.println(obj);
		System.out.println("------------------------");
	}
}
