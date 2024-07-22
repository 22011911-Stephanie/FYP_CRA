/**
 * 
 * I declare that this code was written by me, slenc. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Slency
 * Student ID: 22009748
 * Class: E63C
 * Date created: 2024-Jul-21 3:39:35 pm 
 * 
 */

package e66d.slency.fyp;

/**
 * @author slenc
 *
 */

 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Email;


@Entity
public class Member{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@NotEmpty(message = "Name should not be empty")
    private String name;

    @NotEmpty(message = "Username should not be empty")
    private String username;

    @NotEmpty(message = "Your password cannot be empty!")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", 
             message = "Password must be at least 8 characters long, including alphabetic, numeric, and at least one special character")
    private String password;

    @Email(message = "Email should be in a valid format")
    @NotEmpty(message = "Email should not be empty")
    private String email;

    @Pattern(regexp = "^\\d{8}$", message = "Contact number you have provided is not valid!")
    private int contactNumber;

    @NotEmpty(message = "Company name should not be empty")
    private String companyName;

    @Email(message = "Company email should be in a valid format")
    @NotEmpty(message = "Company email should not be empty")
    private String companyEmail;
	
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

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyEmail() {
		return companyEmail;
	}

	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}

}
