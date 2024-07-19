package Model;

import java.io.Serializable; //có thể được lưu trữ và truyền qua các kết nối mạng hoặc tệp tin.

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
// Lưu thông tin sinh viên

// dể chuyển đổi xml như mong muốn
@XmlRootElement(name = "student")
@XmlAccessorType(XmlAccessType.FIELD)
public class student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private byte age;
    private String address;
    private String phoneNumber;
    private double gpa;
    
    public student() {
		
	}
    
	/**
	 * @param id
	 * @param name
	 * @param age
	 * @param address
	 * @param phoneNumber
	 * @param gpa
	 */
	public student(int id, String name, byte age, String address, String phoneNumber, double gpa) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.gpa = gpa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte getAge() {
		return age;
	}

	public void setAge(byte age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double d) {
		this.gpa = d;
	}
    
    
}
