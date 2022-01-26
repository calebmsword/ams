package com.revature.services;

import com.revature.entities.CardType;
import com.revature.exceptions.CardTypeNotFoundException;
import com.revature.repositories.CardTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardTypeService {

    private final CardTypeRepository cardTypeRepository;

    @Autowired
    public CardTypeService(CardTypeRepository cardTypeRepository) {
        this.cardTypeRepository = cardTypeRepository;
    }

    public CardType findCardTypeById(Long id) throws CardTypeNotFoundException {
        Optional<CardType> cardTypeOptional = cardTypeRepository.findById(id);
        if (!cardTypeOptional.isPresent()) {
            throw new CardTypeNotFoundException("CardType not found with id: "+id);
        }
        return cardTypeOptional.get();
    }

    public List<CardType> findAllCardTypes() {
        return cardTypeRepository.findAll();
    }

    public CardType saveCardType(CardType cardType) {
        return (CardType) cardTypeRepository.save(cardType);
    }

    public CardType editCardType(CardType cardType) {
        Optional<CardType> cardTypeOptional = cardTypeRepository.findById(cardType.getId());
        if (!cardTypeOptional.isPresent()) {
            new CardTypeNotFoundException("CardType not found with id: "+cardType.getId());
        }
        return (CardType) cardTypeRepository.save(cardType);
    }

    public CardType deleteCardType(Long id) {
        Optional<CardType> cardTypeOptional = cardTypeRepository.findById(id);
        if (!cardTypeOptional.isPresent()) {
            new CardTypeNotFoundException("CardType not found with id: "+id);
        }
        CardType cardType = cardTypeOptional.get();
        cardTypeRepository.deleteById(id);
        return cardType;
    }
}
