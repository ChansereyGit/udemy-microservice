package com.learning.cards.service.impl;

import com.learning.cards.constants.CardsConstants;
import com.learning.cards.dto.CardsDto;
import com.learning.cards.entity.Cards;
import com.learning.cards.exception.CardAlreadyExistException;
import com.learning.cards.exception.ResourceNotFoundException;
import com.learning.cards.mapper.CardsMapper;
import com.learning.cards.repository.CardsRepository;
import com.learning.cards.service.ICardsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class CardsServiceImpl implements ICardsService {

    private CardsRepository cardsRepository;

    @Override
    public void createCard(String mobileNumber) {
        Optional<Cards> optionalCard = cardsRepository.findByMobileNumber(mobileNumber);
        if(optionalCard.isPresent()) {
            throw new CardAlreadyExistException("Cards already exist with the given mobile number" + mobileNumber);
        }
        cardsRepository.save(createNewCard(mobileNumber));
    }

    @Override
    public CardsDto fetchCard(String mobileNumber) {
        Cards cards = cardsRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Card", "mobile number", mobileNumber));
        return CardsMapper.mapToCardsDto(cards, new CardsDto());
    }

    @Override
    public boolean updateCard(CardsDto cardsDto) {
        Cards cards = cardsRepository.findByCardNumber(cardsDto.getCardNumber())
                .orElseThrow(() -> new ResourceNotFoundException("Card", "card number", cardsDto.getCardNumber()));
        CardsMapper.mapToCards(cardsDto, cards);
        cardsRepository.save(cards);
        return true;
    }

    @Override
    public boolean deleteCard(String mobileNumber) {
        Cards cards = cardsRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Card", "mobile number", mobileNumber));
        cardsRepository.deleteById(cards.getCardId());
        return true;
    }

    private Cards createNewCard(String mobileNumber){
        Cards newCard = new Cards();
        newCard.setMobileNumber(mobileNumber);
        long randomCardNumber = 100000000000L + new Random().nextInt(900000000);
        newCard.setCardNumber(Long.toString(randomCardNumber));
        newCard.setCardType(CardsConstants.CREDIT_CARD);
        newCard.setTotalLimit(CardsConstants.NEW_CARD_LIMIT);
        newCard.setAmountUsed(0);
        newCard.setAvailableAmount(CardsConstants.NEW_CARD_LIMIT);
        return newCard;
    }
}
