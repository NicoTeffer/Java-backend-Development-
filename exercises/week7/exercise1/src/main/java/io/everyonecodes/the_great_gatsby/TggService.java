package io.everyonecodes.the_great_gatsby;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class TggService {

    private final InvitationRepository invitationRepository;
    private final Scanner scanner = new Scanner(System.in);

    public TggService(InvitationRepository invitationRepository) {
        this.invitationRepository = invitationRepository;
    }

    //System.exit(0) <- status 0 parameter is for a message it seems. (citation needed)

    public void run() {
        mainMenu();
    }

    private void mainMenu() {
        label:
        while (true) {
            System.out.println("--------------------------------------------");
            System.out.println("The Great Gatsby Party Invitation Manager");
            System.out.println("MENU");
            System.out.println();
            System.out.println("1.- Invite a person.");
            System.out.println("2.- Show all invitations.");
            System.out.println("3.- Conclude the current party.");
            System.out.println("4.- Exit.");
            System.out.println();
            System.out.println("> Choose one option (1-4): ");
            var option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    inviteMenu();
                    break;
                case 2:
                    showInvitations();
                    break;
                case 3:
                    concludeParty();
                    break;
                case 4:
                    break label;
            }
        }
    }

    private void inviteMenu() {
        System.out.println("--------------------------------------------");
        System.out.println("The Great Gatsby Party Invitation Manager");
        System.out.println("INVITE A PERSON");
        System.out.println();
        System.out.println("> Write the person’s name: ");
        var personName = scanner.nextLine();
        Invitation invitation = new Invitation(personName);
        invitationRepository.save(invitation);
        wasAddedToList(personName);
    }

    private void wasAddedToList(String name) {
        System.out.println("- " + name + " was added to the list.");
    }

    private void showInvitations() {
        System.out.println("--------------------------------------------");
        System.out.println("The Great Gatsby Party Invitation Manager");
        System.out.println("SHOW ALL INVITATIONS");
        System.out.println();
        var invitationList = invitationRepository.findAll();
        if (invitationList.isEmpty()) {
            System.out.println("No invitations yet!");
        } else {
            for (Invitation invitation : invitationList) {
                System.out.println(invitation.getName());
            }
        }
        System.out.println();
        System.out.println("> Press ENTER to continue.");
        scanner.hasNextLine();// Do nothing, it's just to press the ENTER key to proceed.
    }

    public void concludeParty() {
        System.out.println("--------------------------------------------");
        System.out.println("The Great Gatsby Party Invitation Manager");
        System.out.println("CONCLUDE THE CURRENT PARTY");
        System.out.println();
        while (true) {
            System.out.println("> Do you want to conclude the party? (y, N): ");
            var next = scanner.next();
            if (next.equalsIgnoreCase("y")) {
                System.out.println("- The current party was concluded.");
                invitationRepository.deleteAll();
                break;
            } else if (scanner.next().equalsIgnoreCase("n")) {
                System.out.println("- The current party is still ongoing.");
                break;
            } else {
                System.out.println("Please answer with (y, N)");
            }
        }
    }
}

