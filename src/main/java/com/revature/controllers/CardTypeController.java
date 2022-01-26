package com.revature.controllers;

import com.revature.entities.CardType;
import com.revature.exceptions.CardTypeNotFoundException;
import com.revature.services.CardTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cardtype")
public class CardTypeController {
    private final CardTypeService cardTypeService;

    @Autowired
    CardTypeController(CardTypeService cardTypeService) {
        this.cardTypeService = cardTypeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardType> getCardTypeById(@PathVariable Long id) throws CardTypeNotFoundException {
        return new ResponseEntity<CardType>(cardTypeService.findCardTypeById(id), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<CardType>> getAllCardTypes() {
        return new ResponseEntity<List<CardType>>(cardTypeService.findAllCardTypes(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<CardType> addCardType(@RequestBody CardType cardType) {
        return new ResponseEntity<CardType>(cardTypeService.saveCardType(cardType), HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<CardType> editCardType(@RequestBody CardType cardType) {
        return new ResponseEntity<CardType>(cardTypeService.editCardType(cardType), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CardType> deleteCardType(@PathVariable Long id) {
        return new ResponseEntity<CardType>(cardTypeService.deleteCardType(id), HttpStatus.OK);
    }
}
