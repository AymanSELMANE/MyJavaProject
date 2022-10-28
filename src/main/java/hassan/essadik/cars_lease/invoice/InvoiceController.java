package hassan.essadik.cars_lease.invoice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/invoices")
public class InvoiceController  {
	@Autowired
	InvoiceService invoiceService;
	
	@GetMapping("/")
	public ResponseEntity<List<Invoice>> getAllInvoices(){
		try {
			List<Invoice> invoices = invoiceService.getAll();
			return new ResponseEntity<>(invoices, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Invoice> getById(@PathVariable("id") long id){
		Invoice invoice = invoiceService.getById(id);
		
		if(invoice != null) 
			return new ResponseEntity<>(invoice, HttpStatus.OK);
		else 
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@PostMapping("/")
	public ResponseEntity<Invoice> createInvoice(@RequestBody Invoice invoice){
		try {
			Invoice createdInvoice = invoiceService.save(invoice);
			return new ResponseEntity<>(invoice, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
