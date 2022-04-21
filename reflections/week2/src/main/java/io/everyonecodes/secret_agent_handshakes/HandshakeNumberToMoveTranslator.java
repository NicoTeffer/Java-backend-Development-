package io.everyonecodes.secret_agent_handshakes;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@ConfigurationProperties("secretagent")
public class HandshakeNumberToMoveTranslator {
    private Set<Handshake> handshakes;

    public void setHandshakes(Set<Handshake> handshakes) {
        this.handshakes = handshakes;
    }

    public Set<Handshake> getHandshakes() {
        return handshakes;
    }

    public String translate(int number) {
        return handshakes.stream()
                .filter(handshake -> handshake.getNumber() == number)
                .map(Handshake::getMove)
                .findFirst().get();
    }
}
