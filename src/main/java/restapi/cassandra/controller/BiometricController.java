package restapi.cassandra.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.text.ParseException;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import restapi.cassandra.model.BiometricInfoChild;
import restapi.cassandra.repository.BiometricRepository;;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class BiometricController {

	@Autowired
	BiometricRepository biometric_repository;

	@GetMapping("/biometric")
	public List<BiometricInfoChild> getAllVaccine() {
		System.out.println("Get all Vaccine...");

		List<BiometricInfoChild> a = biometric_repository.findAll();
		System.out.println(a);
		return a;
	}

	@GetMapping("biometric/child_details/{rch_child_id}")
	public BiometricInfoChild findById(@PathVariable String rch_child_id) {
		System.out.println("Get Biometric Details - " + rch_child_id);
		BiometricInfoChild a = biometric_repository.findByID(rch_child_id);
		System.out.println(a);
		return a;
	}

	@PostMapping("/biometric/{rch_child_id}/{file}")
	public ResponseEntity<BiometricInfoChild> postBiometric(@PathVariable String rch_child_id,@PathVariable String file) throws ParseException {
		BufferedImage originalImage;
		
		String file_path="/home/hduser/Documents/left_thumb_data/"+file;

		ByteArrayOutputStream imageStream = new ByteArrayOutputStream();
		try {
			originalImage = ImageIO.read(new File(file_path));
			ImageIO.write(originalImage, "jpg", imageStream);
			imageStream.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		byte[] imageInByte = imageStream.toByteArray();
		ByteBuffer buffer = ByteBuffer.wrap(imageInByte);

		// Bio-metric Registration
		BiometricInfoChild a = new BiometricInfoChild();
		a.setId(rch_child_id);
		a.setLeftThumb(buffer);
		BiometricInfoChild _requestBiometricRegistration = biometric_repository.save(a);

		return new ResponseEntity<>(_requestBiometricRegistration, HttpStatus.OK);
	}

}
