public class Person {

	protected String _name;
	protected String _surname;
	protected int _age;
	
	public Person (String name,String surname,int age){
		this._name = name;
		this._surname = surname;
		this._age = age;
	}
	
	public Person()
	{
		_name = "No_Name";
		_surname = "No_Surname";
		_age = 0;
	}
	
	public String GetName() {
		return _name;
	}
	
	public String GetSurname() {
		return _surname;
	}
	
	public int GetAge() {
		return _age;
	}
	
	public void Afisare() {
		System.out.println("Name:" + _name + "\nSurname:" + _surname + "\nAge:" + _age);
	}
	
	public String GetInfoForFile() {
		String LineText = _name + " " + _surname + " " + _age + "\n";
		return LineText;
	}
 
}