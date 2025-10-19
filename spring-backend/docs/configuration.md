# Configuration de l'application

## Variables d'environnement

L'application utilise des variables d'environnement pour la configuration sensible.

### Setup initial

1. Copier le fichier d'exemple :
```bash
   cp .env.example .env
```

2. Éditer `.env` avec vos vraies credentials :
```bash
   nano .env  # ou votre éditeur préféré
```

3. **⚠️ IMPORTANT** : Ne JAMAIS committer le fichier `.env` !

### Variables requises

#### Base de données MySQL
```
MYSQL_HOST=localhost
MYSQL_PORT=3306
MYSQL_DATABASE=hobbie_backend_db
MYSQL_USERNAME=root
MYSQL_PASSWORD=your_password
```

#### Cloudinary (Upload d'images)
Obtenez vos credentials sur : https://cloudinary.com/console
```
CLOUDINARY_CLOUD_NAME=your_cloud_name
CLOUDINARY_API_KEY=your_api_key
CLOUDINARY_API_SECRET=your_api_secret
```

#### JWT (Sécurité)
Générez une clé aléatoire forte :
```bash
openssl rand -base64 32
```
```
JWT_SECRET=your_generated_secret
```

#### Email (Gmail SMTP)
1. Activez l'authentification à 2 facteurs sur Gmail
2. Générez un "App Password" : https://myaccount.google.com/apppasswords
```
MAIL_USERNAME=your_email@gmail.com
MAIL_PASSWORD=your_16_char_app_password
```

## Lancer l'application

### En local (développement)
```bash
# Avec Maven
mvn spring-boot:run

# Avec le JAR
mvn clean package
java -jar target/app.jar
```

### Avec Docker Compose (recommandé)
```bash
# Lancer toute l'infrastructure
docker-compose up -d

# Lancer uniquement l'app et MySQL
docker-compose up -d mysql spring-app
```

## Profils Spring Boot

### Développement (par défaut)
```
SPRING_PROFILES_ACTIVE=dev
HIBERNATE_DDL_AUTO=update
```

### Production
```
SPRING_PROFILES_ACTIVE=prod
HIBERNATE_DDL_AUTO=validate
```

## Sécurité

### ✅ Bonnes pratiques
- ✅ Utiliser `.env` pour les credentials
- ✅ `.env` est dans `.gitignore`
- ✅ Fournir `.env.example` sans vrais credentials
- ✅ Utiliser des "App Passwords" Gmail
- ✅ Générer un JWT secret fort et aléatoire
- ✅ Ne jamais committer de credentials dans Git

### ❌ À ne JAMAIS faire
- ❌ Committer le fichier `.env`
- ❌ Hardcoder des credentials dans le code
- ❌ Partager le `.env` par email/Slack
- ❌ Utiliser les mêmes credentials en dev et prod
- ❌ Utiliser des credentials par défaut en production

## Vérification de la configuration
```bash
# Vérifier que les variables sont chargées
docker-compose config

# Tester la connexion MySQL
docker-compose exec mysql mysql -uroot -p${MYSQL_PASSWORD} -e "SHOW DATABASES;"

# Vérifier les logs de l'app
docker-compose logs spring-app
```

---

**⚠️ RAPPEL** : Ne JAMAIS committer de credentials !