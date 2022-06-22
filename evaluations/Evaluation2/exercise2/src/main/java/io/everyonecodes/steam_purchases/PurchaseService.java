package io.everyonecodes.steam_purchases;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService {

    private final GameRepository gameRepository;

    private final GameUserRepository gameUserRepository;


    public PurchaseService(GameRepository gameRepository, GameUserRepository gameUserRepository) {
        this.gameRepository = gameRepository;
        this.gameUserRepository = gameUserRepository;
    }

    private Game convertToGame(Purchase purchase) {
        return new Game(purchase.getGameName(), purchase.getIdentifier(), purchase.getPrice());
    }

    private GameUser convertToGameUser(Purchase purchase) {
        return new GameUser(purchase.getUsername());
    }

    private Game saveGame(Game game) {
        return gameRepository.save(game);
    }

    private GameUser saveGameUser(GameUser gameUser) {
        return gameUserRepository.save(gameUser);
    }

    // POST a Purchase to “/purchases” -> processes the Purchase into a User linked with a Game,
    // saves the two of them, and returns the Purchase [for apps only]
    public Purchase postPurchase(Purchase purchase) {
        var game = convertToGame(purchase);
        var user = convertToGameUser(purchase);
        game.getGameUsers().add(user);
        gameUserRepository.save(user);
        gameRepository.save(game);
        return purchase;
    }

    // GET to “/users” -> returns all User entries
    // linked with all the Game entries they have purchased [for admins only]
    public List<GameUser> getAllGameUsers() {
        return gameUserRepository.findAll();
    }

    // GET to “/games” -> returns all Game entries [available for everyone]
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }
}
