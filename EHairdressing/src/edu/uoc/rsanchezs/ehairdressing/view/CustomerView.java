package edu.uoc.rsanchezs.ehairdressing.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;

import com.opencsv.CSVReader;

import edu.uoc.rsanchezs.ehairdressing.model.Address;
import edu.uoc.rsanchezs.ehairdressing.model.Customer;
import edu.uoc.rsanchezs.ehairdressing.service.CustomerService;
import edu.uoc.rsanchezs.ehairdressing.util.Loggable;

@Named
@RequestScoped
@Loggable
public class CustomerView extends AbstractBean implements Serializable {

	private static final long serialVersionUID = 1488471499773712565L;

	@Inject
	private CustomerService customerService;

	private Customer customer;
	private Customer selectedCustomer;
	private Address address;
	private List<Customer> customers;

	public CustomerView() {
		super();
	}
	/**
	 * Method to initialize the fields.
	 */
	@PostConstruct
	public void init() {
		customers = new ArrayList<Customer>();
		customers = customerService.findAllCustomers();
		customer = new Customer();
		selectedCustomer = new Customer();
		address = new Address();
	}

	
	/**
	 * Creates a Customer
	 * @return A outcome String that refresh the page
	 */
	public String doCreateCustomer() {
		customer.setAddress(address);
		customerService.createCustomer(customer);
		return "/admin/customers/view?faces-redirect=true";
	}
	/**
	 * Deletes a Customer
	 * @return A outcome String that refresh the page
	 */
	public String doDeleteCustomer() {
		customerService.remove(selectedCustomer);
		return "/admin/customers/view?faces-redirect=true";
	}
	
	/**
	 * Update a Customer
	 * @return A outcome String that refresh the page
	 */
	public String doUpdateCustomer() {
		customerService.merge(selectedCustomer);
		return "/admin/customers/view?faces-redirect=true";
	}

	/**
	 * Retrieves the uploaded file and persits to the database
	 * @param event
	 */
	public void handleFileUpload(FileUploadEvent event) {

		try {
			addInformationMessage("succes_upload");
			copyFile(event.getFile().getFileName(), event.getFile()
					.getInputstream());
			init();
		} catch (IOException e) {
			addErrorMessage("error_upload");
			e.printStackTrace();
		}
	}
	
	/**
	 * Copy the file to the disk.
	 * @param fileName The name of the file
	 * @param in A InputStream
	 * @throws IOException 
	 */
	private void copyFile(String fileName, InputStream in) throws IOException {

		Path path = Paths.get("C:", "ehairdressing", "temp");
		Files.createDirectories(path);

		try (OutputStream out = new FileOutputStream(new File(path.toString(),
				fileName))) {
			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = in.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}

			parseCSVFileLineByLine(path, fileName);

		}
	}

	/**
	 * Parse the csv file line by line and persists each record
	 * to the DB.
	 * @param path The path of the file
	 * @param fileName The name of the file
	 *
	 */
	private void parseCSVFileLineByLine(Path path, String fileName) {

		try (CSVReader reader = new CSVReader(new FileReader(path.toString()
				+ "\\" + fileName), ';')) {

			String[] record = null;
			String[] split = null;
			while ((record = reader.readNext()) != null) {
				Customer customer = new Customer();
				Address address = new Address();
				split = record[0].split("\\s", 2);
				if(split[0].equalsIgnoreCase("Mª")) {
					split = record[0].split("\\s", 3);
					customer.setName("Mª" + split[1]);
					customer.setSurname(split[2]);
				} else {
					customer.setName(split[0]);
					customer.setSurname(split[1]);
				}
				address.setCity(record[1]);
				customer.setAddress(address);
				customer.setUsername(record[2]);
				customer.setMobilePhone(record[3]);
				customer.setBirthday(record[4]);
				customerService.createCustomer(customer);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		//Getters and setters

	}
	
	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer
	 *            the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the selectedCustomer
	 */
	public Customer getSelectedCustomer() {
		return selectedCustomer;
	}

	/**
	 * @param selectedCustomer
	 *            the selectedCustomer to set
	 */
	public void setSelectedCustomer(Customer selectedCustomer) {
		this.selectedCustomer = selectedCustomer;
	}

	/**
	 * @return the customerList
	 */
	public List<Customer> getCustomers() {
		return customers;
	}

	/**
	 * @param customerList
	 *            the customerList to set
	 */
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

}
