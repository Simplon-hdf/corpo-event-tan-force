import model.Event;
import model.Event;
import model.User;
import model.Comment;
import handler.EventHandler; // Ajout de l'import
import handler.CommentHandler;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        // Création des handlers
        EventHandler eventHandler = new EventHandler();
        CommentHandler commentHandler = new CommentHandler();

        // Création de quelques utilisateurs
        User admin = new User(1, "Chaudard", "paul", "paul.chaudard@gmail.com", "secret");
        User employee1 = new User(2, "Pithivier", "gilbert", "gilbert.pithivie@gmail.com", "secret");
        User employee2 = new User(3, "Tassin", "maurice", "maurice.tassin@gmail.com", "secret");

        admin.getRoles().add("ADMIN");
        employee1.getRoles().add("USER");
        employee2.getRoles().add("USER");

        // Création d'événements
        Event teamBuilding = new Event(
                1,
                "Team Building Annuel Réseau Attila",
                "Une journée pour renforcer la cohésion d'équipe",
                "Forêt de Machecoul",
                admin,
                LocalDateTime.now().plusDays(15)
        );


        Event formation = new Event(
                2,
                "Formation Faire sauter le pont",
                "Formation sur les nouveautés et les  bonnes pratiques du fil rouge sur le bouton rouge",
                "Salle de conférence - Chateau vieux",
                employee1,
                LocalDateTime.now().plusDays(7)
        );

        // Ajout des événements via le handler
        eventHandler.add(teamBuilding);
        eventHandler.add(formation);
        System.out.println("Nombre d'événements ajoutés : " + eventHandler.showAll().size());

        // Annonce de participation aux événements
        System.out.println("\n--- INSCRIPTIONS AUX ÉVÉNEMENTS ---");
        teamBuilding.addParticipant(employee1);
        teamBuilding.addParticipant(employee2);
        formation.addParticipant(admin);
        formation.addParticipant(employee2);

        // Ajout de commentaires
        Comment comment1 = new Comment(1, "J'ai hâte de participer à cet événement !", employee1, LocalDateTime.now());
        Comment comment2 = new Comment(2, "Est-ce que le déjeuner sera fourni ?", employee2, LocalDateTime.now());
        Comment comment3 = new Comment(3, "Je recommande d'apporter votre matériel.", admin, LocalDateTime.now());

        // Ajout de commentaires aux événements
        teamBuilding.addComment(comment1);
        teamBuilding.addComment(comment2);
        formation.addComment(comment3);

        // Gestion des commentaires via le handler
        commentHandler.add(comment1);
        commentHandler.add(comment2);
        commentHandler.add(comment3);

        System.out.println("\n--- COMMENTAIRES ---");
        System.out.println("Nombre total de commentaires : " + commentHandler.showAll().size());

        // Affichage des événements avec leurs participants et commentaires
        System.out.println("\n--- ÉVÉNEMENT : " + teamBuilding.getTitle() + " ---");
        System.out.println("Description : " + teamBuilding.getDescription());
        System.out.println("Lieu : " + teamBuilding.getLocation());
        System.out.println("Date : " + teamBuilding.getCreatedAt()); // Correction ici : getDate() au lieu de getCreationDate()
        System.out.println("Organisateur : " + teamBuilding.getAuthor().getFirstName() + " " + teamBuilding.getAuthor().getLastName());

        System.out.println("\nParticipants :");
        for (User participant : teamBuilding.getParticipants()) {
            System.out.println("- " + participant.getFirstName() + " " + participant.getLastName());
        }

        System.out.println("\nCommentaires :");
        for (Comment comment : teamBuilding.getComments()) {
            System.out.println("- " + comment.getAuthor().getFirstName() + " : " + comment.getContent());
        }

        // Démonstration de mise à jour d'événement
        System.out.println("\n--- MISE À JOUR D'UN ÉVÉNEMENT ---");
        teamBuilding.setLocation("Parc d'activités de Paris");
        eventHandler.update(teamBuilding);

        Event updatedEvent = eventHandler.show(teamBuilding);
        System.out.println("Nouveau lieu du Team Building : " + updatedEvent.getLocation());
    }
}
