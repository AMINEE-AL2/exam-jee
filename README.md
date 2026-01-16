# Projet d'Examen JEE - Gestion des Actions et Dons

## Description

Ce projet est une application web développée avec **Spring Boot** pour la gestion d'actions humanitaires et de dons. L'application permet de gérer des actions caritatives, leurs organisateurs, et les dons associés (en argent ou en biens).

## Technologies Utilisées

- **Java 17**
- **Spring Boot 4.0.1**
- **Spring Data JPA** - Pour la persistance des données
- **Spring Web MVC** - Pour la couche web
- **Thymeleaf** - Moteur de template pour les vues
- **MySQL** - Base de données principale
- **H2 Database** - Base de données en mémoire (pour le développement)
- **Lombok** - Pour réduire le code boilerplate
- **Bootstrap 5.3.8** - Framework CSS pour l'interface utilisateur
- **Maven** - Gestionnaire de dépendances

## Structure du Projet

```
src/
├── main/
│   ├── java/ma/ensam/examen/
│   │   ├── dao/
│   │   │   ├── enteties/          # Entités JPA
│   │   │   │   ├── Action.java
│   │   │   │   ├── ActionStatus.java
│   │   │   │   ├── Don.java
│   │   │   │   ├── DonType.java
│   │   │   │   ├── Evaluation.java
│   │   │   │   └── Organisateur.java
│   │   │   └── repositories/      # Repositories Spring Data
│   │   │       ├── ActionRepository.java
│   │   │       ├── DonRepository.java
│   │   │       └── OrganisateurRepository.java
│   │   ├── service/               # Couche service
│   │   │   ├── DonService.java
│   │   │   ├── DonManager.java
│   │   │   ├── IActionService.java
│   │   │   └── IactionServiceImpl.java
│   │   ├── web/                   # Contrôleurs
│   │   │   ├── ActionController.java
│   │   │   └── DonController.java
│   │   └── ExamenApplication.java # Classe principale
│   └── resources/
│       ├── application.properties # Configuration
│       ├── templates/             # Templates Thymeleaf
│       │   └── dons.html
│       └── static/               # Ressources statiques
└── test/
    └── java/ma/ensam/examen/
        └── ExamenApplicationTests.java
```

## Modèle de Données

### Entités Principales

- **Action** : Représente une action humanitaire
  - `id` : Identifiant unique
  - `description` : Description de l'action
  - `date_creation` : Date de création
  - `montant` : Montant cible
  - `status` : Statut de l'action (enum ActionStatus)
  - `organisateur` : Organisateur de l'action (relation ManyToOne)
  - `dons` : Liste des dons associés (relation OneToMany)

- **Don** : Représente un don
  - `id` : Identifiant unique
  - `titre` : Titre du don
  - `montant` : Montant du don
  - `type` : Type de don (ARGENT ou BIEN)
  - `action` : Action associée (relation ManyToOne)

- **Organisateur** : Représente un organisateur d'actions

## Prérequis

- **JDK 17** ou supérieur
- **Maven 3.6+**
- **MySQL 8.0+** (ou H2 pour le développement)
- Un IDE (IntelliJ IDEA, Eclipse, VS Code, etc.)

## Installation et Configuration

### 1. Cloner le projet

```bash
git clone <url-du-repo>
cd examen
```

### 2. Configuration de la base de données

Modifiez le fichier `src/main/resources/application.properties` selon votre configuration MySQL :

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/examenjee_db?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=votre_mot_de_passe
```

### 3. Créer la base de données

La base de données `examenjee_db` sera créée automatiquement au démarrage si elle n'existe pas (grâce à `createDatabaseIfNotExist=true`).

### 4. Compiler le projet

```bash
mvn clean install
```

### 5. Lancer l'application

```bash
mvn spring-boot:run
```

Ou exécutez directement la classe `ExamenApplication` depuis votre IDE.

## Utilisation

Une fois l'application démarrée, elle sera accessible à l'adresse :

```
http://localhost:8080
```

### Endpoints Principaux

- `/actions` - Liste des actions
- `/ActionForm` - Formulaire d'ajout d'action
- `/addAction` - Ajout d'une nouvelle action
- `/dons` - Gestion des dons

### Données de Test

L'application initialise automatiquement des données de test au démarrage :
- 5 actions en statut PREPARATION
- 12 dons répartis entre les différentes actions (types ARGENT et BIEN)

## Fonctionnalités

- ✅ Gestion des actions humanitaires
- ✅ Gestion des dons (argent et biens)
- ✅ Association d'organisateurs aux actions
- ✅ Interface web avec Thymeleaf et Bootstrap
- ✅ Persistance des données avec JPA/Hibernate
- ✅ Architecture en couches (DAO, Service, Web)

## Développement

### Structure des Couches

- **DAO (Data Access Object)** : Gestion de la persistance avec Spring Data JPA
- **Service** : Logique métier de l'application
- **Web/Controller** : Gestion des requêtes HTTP et rendu des vues

### Commandes Maven Utiles

```bash
# Compiler le projet
mvn compile

# Exécuter les tests
mvn test

# Créer un package JAR
mvn package

# Nettoyer le projet
mvn clean
```

## Auteur

Projet développé dans le cadre d'un examen JEE (Java Enterprise Edition).

## Licence

Ce projet est un projet d'examen académique.
