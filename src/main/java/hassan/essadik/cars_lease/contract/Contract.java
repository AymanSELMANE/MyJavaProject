package hassan.essadik.cars_lease.contract;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import hassan.essadik.cars_lease.car.Car;
import hassan.essadik.cars_lease.client.Client;
import hassan.essadik.cars_lease.invoice.Invoice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="contract")
public class Contract {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Temporal(TemporalType.DATE)
	private Date startLease;
	
	@Temporal(TemporalType.DATE)
	private Date endLease;
	
	private double totalPrice;
	private double advance;
	private double leftToPay;
	@Column(length = 30)
	private String placeOfReturn;
	
	@ManyToOne
	@JsonProperty(access= Access.READ_WRITE)
	private Car car;
	
	@OneToOne(mappedBy = "contract")
	@JsonProperty(access= Access.READ_WRITE)
	private Invoice invoice;
	
	@ManyToOne
	@JsonProperty(access= Access.READ_WRITE)
	private Client client;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
