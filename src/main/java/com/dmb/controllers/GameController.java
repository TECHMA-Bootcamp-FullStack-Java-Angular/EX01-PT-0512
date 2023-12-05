package com.dmb.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class GameController {

//	@Autowired
//	private GameService gameService;
//
//	@GetMapping("/games")
//	public ResponseEntity<List<Game>> getAllGame() {
//		return ResponseEntity.ok(gameService.getAllGame());
//	}
//
//	@GetMapping("/game/{id}")
//	public ResponseEntity<Game> getOneGame(@PathVariable(name = "id") Long id) { 
//		Optional<Game> entity = gameService.getOneGame(id);
//		if (entity.isPresent()) {
//			return ResponseEntity.ok(entity.get());
//		} else {
//			return ResponseEntity.notFound().build();
//		}
//	}
//	
//	@PostMapping("/game")
//	public ResponseEntity<Game> saveGame(@RequestBody Game entity) {
//		return ResponseEntity.ok(gameService.createGame(entity));
//	}
//	
//	@PutMapping("/game/{id}")
//	public ResponseEntity<Game> updateGame(@PathVariable(name = "id") Long id, @RequestBody Game entity) {
//		Optional<Game> entityOld = gameService.getOneGame(id);
//		if (entityOld.isPresent()) {
//			return ResponseEntity.ok(gameService.updateGame(entity));
//		} else {
//			return ResponseEntity.notFound().build();
//		}
//	}
//	
//	@DeleteMapping("/game/{id}")
//	public ResponseEntity<Void> deleteGame(@PathVariable(name = "id") Long id) {
//		Optional<Game> entity = gameService.getOneGame(id);
//		if (entity.isPresent()) {
//			gameService.deleteGame(id);
//			return ResponseEntity.noContent().build();
//		} else {
//			return ResponseEntity.notFound().build();
//		}
//	}
}
