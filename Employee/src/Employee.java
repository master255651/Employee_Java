 public class Employee extends Person {
	
	private String _nameEmployer;
	private int _experience;
	
	public Employee(String name, String surname, int age, String nameEmployer, int experience) {
		super(name, surname, age);
		this._nameEmployer = nameEmployer;
		this._experience = experience;
	}
	
	public void ShowEmployer () {
		System.out.println("Name employer: " + _nameEmployer);
	}
	
	public void ShowExperience () {
		System.out.println("Employee experience: " + _experience);
	}
	
	public String GetInfoForFile() {
		String LineText = _name + " " + _surname + " " + _age + " " + _nameEmployer + " " + _experience + "\n";
		return LineText;
	}
}