package com.hostels.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hostels.model.Guest;
import com.hostels.model.GuestLogIn;
import com.hostels.model.GuestLogInResponse;
import com.hostels.model.GuestRegistrationResponse;
import com.hostels.repository.GuestRepository;

@Service
public class GuestService {

	@Autowired
	private GuestRepository repo;

	public GuestLogInResponse getGuestStatus(GuestLogIn guestDetails) {

		GuestLogInResponse glr= new GuestLogInResponse();

		Optional<Guest> guest = repo.findByemailAndPassword(guestDetails.getEmail(), guestDetails.getPassword());
		if(guest!=null) {
			String status = guest.get().getStatus();
			int guestId = guest.get().getGuestId();

			glr.setEmail(guestDetails.getEmail());
			glr.setGuestId(guestId);
			if(status!=null && status.equalsIgnoreCase("APPROVED")) {
				glr.setStatus("Approved");
			}else {
				glr.setStatus("Failed");
			}

		}else {
			glr.setEmail(guestDetails.getEmail());
			glr.setStatus("Failed");
		}
		// TODO Auto-generated method stub
		return glr;

	}

	public GuestRegistrationResponse saveGuestDetails(Guest guestDetails) {

		GuestRegistrationResponse grr= new GuestRegistrationResponse();
		Optional<Guest> existingGuest = repo.findByEmail(guestDetails.getEmail());

		if (existingGuest.isPresent()) {
			grr.setMessage("Email already exists. Please use a different email.");
			grr.setStatus("Failed");
			grr.setGuestId(existingGuest.get().getGuestId());
			grr.setEmail(existingGuest.get().getEmail());
			grr.setPgName(existingGuest.get().getPgName());
			grr.setRoomNo(existingGuest.get().getRoomNo());
			grr.setRoomSharing(existingGuest.get().getRoomSharing());
		}else {
			List<Guest> guest = repo.findAll();
			int guestId= guest.size() + 1;
			guestDetails.setGuestId(guestId);
			guestDetails.setStatus("Failed");
			repo.save(guestDetails);
			
			grr.setMessage("Guest Registration Sucssfully done.");
			grr.setStatus("Success");
			grr.setGuestId(guestId);
			grr.setEmail(guestDetails.getEmail());
			grr.setPgName(guestDetails.getPgName());
			grr.setRoomNo(guestDetails.getRoomNo());
			grr.setRoomSharing(guestDetails.getRoomSharing());
		}
		return grr;
	}

}
