## Règles de gestion

### Utilisateurs

- R1 : Un utilisateur doit avoir une adresse mail
- R2 : Un utilisateur doit avoir un mot de passe
- R3 : Un ulilisteur doit avoir un nom
- R4 : Un utilisateur doit avoir un prénom
- R5 : Un utilisateur doit avoir rôle
- R6 : L'utilisateur peut être un administratueur
- R7 : L'utilisateur peut être un collaborateur

### Administrateurs

- R8 : Un administrateur peut lire un évenement
- R9 : Un administrateur peut créer un évenement
- R10: Un administrateur peut modifier un événement
- R11: Un administrateur peut supprimer un événement
- R11: Un administrateur peut créer un commentaire
- R11: Un administrateur peut lire un commentaire
- R14: Un administrateur peut modifier un commentaire
- R15: Un administrateur peut supprimer un commentaire

### Collaborateurs

- R16: Un collaborateur peut lire un événement
- R17: Un collaborateur peut créer un commentaire
- R18: Un collaborateur peut lire un commentaire
- R19: Un collaborateur peut modifier uniquement un commentaire qui lui appartient
- R20: Un collaborateur peut supprimer uniquement un commentaire qui lui appartient

### évenements

- R21: Un événement doit avoir un intitulé
- R22: Un évenement doit avoir une date de création
- R23: Un événement doit avoir une date de modification
- R24: Un événement doit avoir une description
- R25: Un evenement peut avoir un ou des commentaires

### Commentaires

- R26: Un commentaire doit avoir un auteur
- R27: Un commentaire doit avoir un texte
- R28: Un commentaire doit avoir une date de création
- R29: Un commentaire doit avoir une date de modification