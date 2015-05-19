package edu.uoc.rsanchezs.ehairdressing.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import edu.uoc.rsanchezs.ehairdressing.model.Email;
import edu.uoc.rsanchezs.ehairdressing.model.SMS;
import edu.uoc.rsanchezs.ehairdressing.model.Tag;
import edu.uoc.rsanchezs.ehairdressing.service.EmailService;
import edu.uoc.rsanchezs.ehairdressing.service.TagService;
import edu.uoc.rsanchezs.ehairdressing.util.Loggable;

@Named
@RequestScoped
@Loggable
public class EmailView extends AbstractBean implements Serializable {

	private static final long serialVersionUID = -1034019275630954952L;
	
	@Inject
	private EmailService emailService;
	@Inject
	private TagService tagService;
	
	private Email email;
	private Email selectedEmail;
	private List<Email> emails;
	private List<Tag> tags;
	private String tag;
	private Tag newTag;
	private String addresslist;
	
	
	/**
	 * Default constructor
	 */
	public EmailView() {
	}
	
	/**
	 * Method to initialize the fiels.
	 */
	@PostConstruct
	public void init() {
		email = new Email();
		selectedEmail = new Email();
		emails = new ArrayList<Email>();
		emails = emailService.findAllEmails();
		tags = tagService.findAllTags();
		newTag = new Tag();
	}
	
	/**
	 * Creates an Email
	 */
	public String doCreateEmail() {
		email.add(tag);
		if(!tags.contains(tag)){
			newTag.setName(tag);
			tagService.createTag(newTag);
		}
		emailService.createEmail(email);
		addInformationMessage("succes_create_email");
		return "/admin/email/create?faces-redirect=true";
	}
	
	/**
	 * Deletes an Email
	 * @return A outcome String that refresh the page
	 */
	public String doDeleteEmail() {
		emailService.removeEmail(selectedEmail);
		return "/admin/email/view?faces-redirect=true";
	}
	
	/**
	 * Update an Email
	 * @return A outcome String that refresh the page
	 */
	public String doUpdateEmail() {
		emailService.updateEmail(selectedEmail);
		return "/admin/email/view?faces-redirect=true";
	}
	
	/**
	 * 
	 */
	public void doSendEmail() {
		
		InternetAddress[] addresses;
		if (selectedEmail != null) {
			try {
				addresses = InternetAddress.parse(addresslist, true);
				emailService.sendEmail(selectedEmail, addresses);
				addInformationMessage("succes_send_message");

			} catch (AddressException e) {
				addErrorMessage("sintax_error_email_address");

			}
		} else {
			addErrorMessage("email_not_selected");
		}
	}
	
	
	
	//Getters and setters

	/**
	 * @return the email
	 */
	public Email getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(Email email) {
		this.email = email;
	}

	/**
	 * @return the selectedEmail
	 */
	public Email getSelectedEmail() {
		return selectedEmail;
	}

	/**
	 * @return the emails
	 */
	public List<Email> getEmails() {
		return emails;
	}

	/**
	 * @param selectedEmail the selectedEmail to set
	 */
	public void setSelectedEmail(Email selectedEmail) {
		this.selectedEmail = selectedEmail;
	}

	/**
	 * @param emails the emails to set
	 */
	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}

	/**
	 * @return the tags
	 */
	public List<Tag> getTags() {
		return tags;
	}

	/**
	 * @param tags the tags to set
	 */
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	/**
	 * @return the tag
	 */
	public String getTag() {
		return tag;
	}

	/**
	 * @param tag the tag to set
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}

	/**
	 * @return the newTag
	 */
	public Tag getNewTag() {
		return newTag;
	}

	/**
	 * @param newTag the newTag to set
	 */
	public void setNewTag(Tag newTag) {
		this.newTag = newTag;
	}

	/**
	 * @return the addresslist
	 */
	public String getAddresslist() {
		return addresslist;
	}

	/**
	 * @param addresslist the addresslist to set
	 */
	public void setAddresslist(String addresslist) {
		this.addresslist = addresslist;
	}

	
	
	
	
}
