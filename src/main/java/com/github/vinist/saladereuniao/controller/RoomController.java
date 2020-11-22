package com.github.vinist.saladereuniao.controller;

import com.github.vinist.saladereuniao.exception.ResourceNotFoundException;
import com.github.vinist.saladereuniao.model.Room;
import com.github.vinist.saladereuniao.repository.RoomRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/room")
public class RoomController {
    
    private final RoomRepository roomRepository;
    
    public RoomController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }
    
    @GetMapping
    public List<Room> getAll() {
        return roomRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Room> getById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        var room = roomRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Room not found:: "+id));
        return ResponseEntity.ok().body(room);
    }
    
    @PostMapping
    public Room createRoom(@Valid @RequestBody Room room){
        return roomRepository.save(room);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable(value = "id") Long id,
                                           @Valid @RequestBody Room room) throws ResourceNotFoundException {
        var roomBd = roomRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Room not found:: "+id));
        
        roomBd.setName(room.getName());
        roomBd.setDate(room.getDate());
        roomBd.setStartHour(room.getStartHour());
        roomBd.setEndHour(room.getEndHour());
        return ResponseEntity.ok(roomRepository.save(roomBd));
    }
    
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        roomRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Room not found:: "+id));
        roomRepository.deleteById(id);
    }
}
