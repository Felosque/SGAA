package sgaa.server.dto;

import java.util.Date;

import sgaa.server.interfaces.Crud;

public class AdoptionDTO implements Crud{
	
	private int id;
	private String mail;
	private int idPet;
	private Date transactionDate;
	
	public AdoptionDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * @param id
	 * @param mail
	 * @param idPet
	 * @param transactionDate
	 */
	public AdoptionDTO(int id, String mail, int idPet, Date transactionDate) {
		super();
		this.id = id;
		this.mail = mail;
		this.idPet = idPet;
		this.transactionDate = transactionDate;
	}
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public int getIdPet() {
		return idPet;
	}


	public void setIdPet(int idPet) {
		this.idPet = idPet;
	}


	public Date getTransactionDate() {
		return transactionDate;
	}


	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	@Override
	public String insert() {
		// TODO Auto-generated method stub
		return "INSERT INTO public.adoption_tab(mail, id_pet, transaction_date) VALUES ('"+mail+"', '"+idPet+"', '"+transactionDate+"');";
	}
	@Override
	public String update() {
		// TODO Auto-generated method stub
		return "UPDATE public.adoption_tab SET id= '"+id+"', mail= '"+mail+"', id_pet= '"+idPet+"', transaction_date= '"+transactionDate+"' where id = "+id+";";
	}
	@Override
	public String delete() {
		// TODO Auto-generated method stub
		return "DELETE from public.adoption_tab where id = "+id+";";
	}
	@Override
	public String findById() {
		// TODO Auto-generated method stub
		return "SELECT id, mail, id_pet, transaction_date FROM public.adoption_tab where id = "+id+";";
	}
	@Override
	public String findAll() {
		// TODO Auto-generated method stub
		return "SELECT id, mail, id_pet, transaction_date FROM public.adoption_tab WHERE mail= '"+ mail +"';";
	}

}
