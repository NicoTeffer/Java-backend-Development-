package io.everyonecodes.steam_purchases;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GameUserRepository extends JpaRepository<GameUser, Long> {
}
