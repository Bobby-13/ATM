import java.io.Serializable;

public class Customer_Details implements Serializable{
    @Override
	public String toString() {
		return "Customer_Details [id=" + id + ", Name=" + Name + ", pin=" + pin + ", AccBal=" + AccBal + "]";
	}
	private int id;
    private String Name;
    private int pin;
    private int AccBal;
	public Customer_Details(int id, String name, int pin, int accBal) {
	
		this.id = id;
		Name = name;
		this.pin = pin;
		AccBal = accBal;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public int getAccBal() {
		return AccBal;
	}
	public void setAccBal(int accBal) {
		AccBal = accBal;
	}
}
