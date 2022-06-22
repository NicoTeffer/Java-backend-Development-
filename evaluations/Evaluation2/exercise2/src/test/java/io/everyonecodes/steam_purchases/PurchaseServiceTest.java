package io.everyonecodes.steam_purchases;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class PurchaseServiceTest {

    @Autowired
    PurchaseService purchaseService;

    @MockBean
    GameRepository gameRepository;

    @MockBean
    GameUserRepository gameUserRepository;

    @MockBean
    SecurityFilterChain securityFilterChain;

    @Test
    void postPurchase() {
        Purchase purchase = new Purchase("testuser","testgame","id123",12.12);
        Mockito.when(purchaseService.postPurchase(purchase)).thenReturn(purchase);

        purchaseService.postPurchase(purchase);

        Mockito.verify(purchaseService).postPurchase(purchase);
    }

    @Test
    void getAllGameUsers() {
        purchaseService.getAllGameUsers();

        Mockito.verify(gameUserRepository).findAll();
    }

    @Test
    void getAllGames() {
        purchaseService.getAllGames();

        Mockito.verify(gameRepository).findAll();
    }
}