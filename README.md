"# SpringIOC-JPA-SpringSecurity"
Ce projet est une application de gestion des patients développée avec Spring Framework, en utilisant Spring IOC (Inversion of Control), Spring Data, et Spring Security.
g
Fonctionnalités :
-> Enregistrement de Patients: Permet d'enregistrer de nouveaux patients.
-> Consultation de Patients: Permet de consulter la liste des patients enregistrés dans la base de données.
-> Authentification et Autorisation: Utilise Spring Security pour gérer l'authentification des utilisateurs et l'accès aux fonctionnalités en fonction des rôles définis.


Configuration:
Clonez ce dépôt sur votre machine locale :

git clone https://github.com/SoulaimaneCherkaoui/SpringIOC-JPA-SpringSecurity.git
Importez le projet dans votre IDE préféré (Eclipse, IntelliJ IDEA, etc.).

Configurez votre base de données MySQL dans le fichier src/main/resources/application.properties. Assurez-vous d'adapter les informations de connexion à votre environnement.

properties:

spring.datasource.url=jdbc:mysql://localhost:3306/nom_base_donnees
spring.datasource.username=votre_nom_utilisateur
spring.datasource.password=votre_mot_de_passe
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
Exécutez les scripts SQL fournis dans le dossier src/main/resources/db pour créer les tables nécessaires dans votre base de données.

Compilez et exécutez l'application :

mvn clean install
mvn spring-boot:run
Accédez à l'application via l'URL suivante : http://localhost:8686

Utilisation
Connectez-vous à l'application en utilisant les identifiants par défaut :

Nom d'utilisateur : user1
Mot de passe : 1234
Explorez les différentes fonctionnalités de gestion des patients, notamment l'enregistrement et la consultation.

Auteurs:

CHERKAOUI Soulaimane
