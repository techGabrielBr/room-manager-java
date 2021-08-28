package com.salareuniao.gerenciador.gerenciadorsalareuniao.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.salareuniao.gerenciador.gerenciadorsalareuniao.exception.ResourceNotFoundException;
import com.salareuniao.gerenciador.gerenciadorsalareuniao.model.Room;
import com.salareuniao.gerenciador.gerenciadorsalareuniao.repository.RoomRepository;

import jakarta.validation.Valid;



@RestController @CrossOrigin(origins = "http://localhost:4200")
public class RoomController {

	@Autowired
	private RoomRepository roomRepository;
	
	@GetMapping("/rooms")
	public List<Room> getAllRoomms(){
		return roomRepository.findAll();
	}
	
	@GetMapping("/rooms/{id}")
	public ResponseEntity<Room> getRoomById (@PathVariable(value = "id") long roomId)
	throws ResourceNotFoundException{
		Room room = roomRepository.findById(roomId)
				.orElseThrow(() -> new ResourceNotFoundException("Room Not Found :: id " + roomId));
		return ResponseEntity.ok().body(room);
	}
	
	@PostMapping("/rooms")
	public Room createRoom (@Valid @RequestBody Room room) {
		return roomRepository.save(room);
	}
	
	@PutMapping("/rooms/{id}")
	public ResponseEntity<Room> updateRoom (@PathVariable(value = "id") long roomId, @Valid @RequestBody Room roomReceived) 
			throws ResourceNotFoundException{
		Room room = roomRepository.findById(roomId)
				.orElseThrow(()-> new ResourceNotFoundException("Not Found Room for this id :: " + roomId));
		room.setDate(roomReceived.getDate());
		room.setEndHour(roomReceived.getEndHour());
		room.setName(room.getName());
		room.setStartHour(room.getStartHour());
		final Room roomUpdated = roomRepository.save(room);
		return ResponseEntity.ok(roomUpdated);
	}
	
	@DeleteMapping("/rooms/{id}")
	public Map<String, Boolean> deleteRoom(@PathVariable(value = "id") long roomId) 
			throws ResourceNotFoundException{
		Room room = roomRepository.findById(roomId)
				.orElseThrow(()-> new ResourceNotFoundException("Not Found Room for this id :: " + roomId));
		roomRepository.delete(room);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	
}
