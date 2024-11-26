package com.hostels.controller;

import com.hostels.model.Guest;
import com.hostels.model.GuestLogIn;
import com.hostels.model.GuestLogInResponse;
import com.hostels.model.GuestRegistrationResponse;
import com.hostels.model.ImageEntity;
import com.hostels.repository.GuestRepository;
import com.hostels.repository.ImageRepository;
import com.hostels.repository.SearchRepository;
import com.hostels.service.GuestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class GuestController {

	@Autowired
	private GuestRepository repo;

	@Autowired
	private SearchRepository srepo;
	
	@Autowired
	private	GuestService guestService;

	@Autowired
	private ImageRepository imageRepository;

	@ApiIgnore
	@RequestMapping(value="/")
	public void redirect(HttpServletResponse response) throws IOException {
		response.sendRedirect("/swagger-ui.html");
	}

	@GetMapping("/allGuestDetails")
	@CrossOrigin
	public List<Guest> getAllPosts()	{
		return repo.findAll();
	}

	@GetMapping("/Guest/{guestId}")
	@CrossOrigin
	public Optional<Guest> search(@PathVariable int guestId)	{
		return repo.findByGuestId(guestId);
	}

	@PostMapping("/guestDetails")
	@CrossOrigin
	public ResponseEntity<GuestRegistrationResponse> addGuestDetails(@RequestBody Guest guestDetails)	{
		
		GuestRegistrationResponse grr= guestService.saveGuestDetails(guestDetails);
		return ResponseEntity.status(HttpStatus.OK).body(grr);
	}
	
	@PostMapping("/guestLogIn")
	@CrossOrigin
	public ResponseEntity<GuestLogInResponse> guestLogIn(@RequestBody GuestLogIn guestDetails)	{
		GuestLogInResponse glr = guestService.getGuestStatus(guestDetails);
		
		return ResponseEntity.status(HttpStatus.OK).body(glr);
	}


	@PostMapping("/upload")
	public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file,
			@RequestParam("guestId") String guestId) throws IOException {
		ImageEntity image = new ImageEntity();
		image.setName(file.getOriginalFilename());
		image.setData(file.getBytes());
		image.setContentType(file.getContentType());
		image.setGuestId(guestId);

		imageRepository.save(image);
		return ResponseEntity.status(HttpStatus.OK).body("Image uploaded successfully: " + image.getGuestId());
	}

	@GetMapping("/{id}")
	public ResponseEntity<byte[]> getImage(@PathVariable String id) {
		ImageEntity image = imageRepository.findByGuestId(id).orElseThrow(() -> new RuntimeException("Image not found"));

		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(image.getContentType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + image.getName() + "\"")
				.body(image.getData());
	}

}
