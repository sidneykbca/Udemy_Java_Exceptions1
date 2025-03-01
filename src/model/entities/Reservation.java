package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exception.DomainException;

public class Reservation {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); /* static para evitar novas instancias de 
	                                                               SimpleDateFormat para outros objetos dessa classe*/
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut){
		if (!checkOut.after(checkIn)) {
			throw new DomainException(" Check-out date must be after check-in.");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}


	public Integer getRoomNumber() {
		return roomNumber;
	}


	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}


	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime(); // retorna a diferença entre as datas em milissegundos
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); // converte o tempo de milissegundos para dias 
	}
	
	public void updateDates(Date checkIn, Date checkOut){
		Date now = new Date();
		if (checkIn.before(now)||checkOut.before(now)) {
			throw new DomainException(" Reservation dates for update must be future dates.");
		}
		if (!checkOut.after(checkIn)) {
			throw new DomainException(" Check-out date must be after check-in.");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "Room " + roomNumber + ", check-in: " + sdf.format(checkIn) + " , check-out: " + sdf.format(checkOut)+
		" , " + duration() + " nights.";
	}
	
}
