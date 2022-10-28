package hassan.essadik.cars_lease.client;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import hassan.essadik.cars_lease.contract.Contract;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="client")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(length = 20)
	private String fname;
	
	@Column(columnDefinition = "varchar(20) not null")
	private String lname;
	
	@Column(length = 200)
	private String address;
	
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	@Column(columnDefinition = "int default 0")
	private int fidelity;
	
	@OneToMany(mappedBy = "client" ,fetch = FetchType.LAZY)
	@JsonProperty(access = Access.WRITE_ONLY)
	private List<Contract> contracts;
}



/*
 * /api/v1/clients get 
 * /api/v1/clients post 
 * /api/v1/clients/{id} get
 * /api/v1/clients/{id} delete 
 * /api/v1/clients/{id} put(Mise à jour)
 * /api/v1/clients?fname= & lname= put(Mise à jour)
 */
