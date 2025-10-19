# TP DEVOPS

![Java](https://img.shields.io/badge/Java-11-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.7-green)
![Build Status](https://img.shields.io/badge/build-passing-brightgreen)

## 📝 Description

// TODO

## 🏗️ Architecture

- **Backend** : Spring Boot 2.7.x
- **Base de données** : MySQL
- **Build** : Maven
- **Java** : 11

## 🚀 Installation et lancement

### Prérequis

- Java 11+
- Maven 3.6+
- MySQL

### Cloner le projet
```bash
git clone https://github.com/chefm0ha/TP-devops
cd /TP-devops
```

### Compiler et lancer
```bash
# Compiler
mvn clean install

# Lancer l'application
mvn spring-boot:run

# Ou avec le JAR
java -jar target/app.jar
```

L'application sera accessible sur `http://localhost:8080`

## 🧪 Tests
```bash
# Lancer les tests unitaires
mvn test

# Lancer les tests avec coverage
mvn test jacoco:report
```

## 📦 Build Docker
```bash
docker build -t spring-app:latest .
docker run -p 8080:8080 spring-app:latest
```

## 🔧 Configuration

Les configurations se trouvent dans `src/main/resources/application.properties`

Principales propriétés :
```properties
server.port=8080
spring.datasource.url=jdbc:mysql://localhost:3306/db
```

## 📊 DevOps Pipeline

Ce projet utilise une pipeline CI/CD complète :

- **GitHub** : Gestion du code source (Git Flow)
- **Jenkins** : CI/CD automatisé
- **SonarQube** : Analyse de qualité du code
- **Docker** : Containerisation
- **Kubernetes** : Orchestration et déploiement
- **Prometheus + Grafana** : Monitoring

Voir `docs/` pour plus de détails.

## 📄 Documentation

- [Stratégie Git](docs/git-strategy.md)
- [Pipeline CI/CD](docs/pipeline.md) (à créer)
- [Guide de déploiement](docs/deployment.md) (à créer)

## 👥 Équipe

- **Membre 1** : Mohammed Fadlouallah - [Github - chefm0ha](https://github.com/chefm0ha)

- **Membre 2** : Aymane Jamal - [Github - AymaneJamal](https://github.com/AymaneJamal)

## 📅 Historique des versions

- **v1.0.0** (2025-XX-XX) : Version initiale avec pipeline DevOps complète
