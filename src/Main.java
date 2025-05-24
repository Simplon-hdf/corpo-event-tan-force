import model.Event;
import model.Event;
import model.User;
import model.Comment;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        User user1 = new User(1, "Chaudard", "paul", "paul.chaudard@gmail.com", "secret");
        User user2 = new User(2, "Pithivier", "gilbert", "gilbert.pithivie@gmail.com", "secret");
        User user3 = new User(3, "Tassin", "maurice", "maurice.tassin@gmail.com", "secret");

        user1.getRoles().add("ADMIN");
        user2.getRoles().add("USER");
        user3.getRoles().add("USER");

        LocalDateTime maintenant = LocalDateTime.now();
        Event evenement = new Event(1, "Séminaire Réseau Attila",
                "Séminaire annuel du réseau pour discuter des objectifs",
                "Forêt de Machecoul", user1, maintenant);

        evenement.addParticipant(user2);
        evenement.addParticipant(user3);

        Comment commentaire1 = new Comment(1, "J'ai hâte d'y participer !", user2, maintenant);
        Comment commentaire2 = new Comment(2, "Est-ce qu'il y aura un buffet ?", user3, maintenant);

        evenement.addComment(commentaire1);
        evenement.addComment(commentaire2);

        System.out.println("Événement : " + evenement.getTitle());
        System.out.println("Description : " + evenement.getDescription());
        System.out.println("Lieu : " + evenement.getLocation());
        System.out.println("Créé par : " + evenement.getAuthor().getFirstName() + " " + evenement.getAuthor().getLastName());
        System.out.println("Nombre de participants : " + evenement.getParticipants().size());
        System.out.println("Nombre de commentaires : " + evenement.getComments().size());

        // Afficher les participants
        System.out.println("\nListe des participants :");
        for (User participant : evenement.getParticipants()) {
            System.out.println("- " + participant.getFirstName() + " " + participant.getLastName() + " (" + participant.getEmail() + ")");
        }

        // Afficher les commentaires
        System.out.println("\nCommentaires :");
        for (Comment commentaire : evenement.getComments()) {
            System.out.println("- " + commentaire.getAuthor().getFirstName() + " " + commentaire.getAuthor().getLastName() + " : " + commentaire.getContent());
        }
    }
}