# Infrastructure DevOps avec Docker Compose

## Services déployés

Ce projet utilise Docker Compose pour orchestrer l'infrastructure DevOps complète :

### 🔧 Jenkins (port 8080)
- **Rôle** : Serveur CI/CD
- **Image** : jenkins/jenkins:lts
- **Accès** : http://localhost:8080
- **Credentials** : admin / admin123

### 🔍 SonarQube (port 9000)
- **Rôle** : Analyse de qualité du code
- **Image** : sonarqube:lts-community
- **Accès** : http://localhost:9000
- **Credentials** : admin / admin

### 🗄️ PostgreSQL (port 5432)
- **Rôle** : Base de données pour SonarQube
- **Image** : postgres:13-alpine
- **Database** : sonar
- **Credentials** : sonar / sonar

## Commandes utiles

### Démarrer l'infrastructure
```bash
docker-compose up -d
```

### Voir les logs
```bash
# Tous les services
docker-compose logs -f

# Un service spécifique
docker-compose logs -f jenkins
docker-compose logs -f sonarqube
```

### Vérifier le statut
```bash
docker-compose ps
```

### Arrêter l'infrastructure
```bash
docker-compose stop
```

### Redémarrer un service
```bash
docker-compose restart jenkins
```

### Supprimer l'infrastructure
```bash
# Arrêter et supprimer les containers
docker-compose down

# Supprimer aussi les volumes (⚠️ perte de données)
docker-compose down -v
```

### Accéder à un container
```bash
docker-compose exec jenkins bash
docker-compose exec sonarqube bash
```

### Voir l'utilisation des ressources
```bash
docker stats
```

## Volumes persistants

Les données sont stockées dans des volumes Docker :

- `jenkins_home` : Configuration et jobs Jenkins
- `sonarqube_data` : Données SonarQube
- `sonarqube_extensions` : Plugins SonarQube
- `sonarqube_logs` : Logs SonarQube
- `postgresql_data` : Base de données PostgreSQL

## Réseau

Tous les services communiquent via le réseau `devops-network` :
- Jenkins peut accéder à SonarQube via `http://sonarqube:9000`
- SonarQube peut accéder à PostgreSQL via `postgres:5432`

## Troubleshooting

### Jenkins ne démarre pas
```bash
# Vérifier les logs
docker-compose logs jenkins

# Vérifier les permissions
sudo chown -R 1000:1000 jenkins_home/
```

### SonarQube en erreur
```bash
# SonarQube nécessite des configurations système
sudo sysctl -w vm.max_map_count=262144
sudo sysctl -w fs.file-max=65536

# Rendre permanent (Linux)
echo "vm.max_map_count=262144" | sudo tee -a /etc/sysctl.conf
```

### Problème de mémoire
```bash
# Augmenter la mémoire Docker
# Docker Desktop → Settings → Resources → Memory (minimum 4GB)
```

## Healthchecks

Tous les services ont des healthchecks configurés :
- ✅ Jenkins : vérifie l'accès à `/login`
- ✅ SonarQube : vérifie le statut via API
- ✅ PostgreSQL : vérifie avec `pg_isready`

## Backup des données

### Sauvegarder Jenkins
```bash
docker run --rm -v jenkins_home:/data -v $(pwd):/backup \
  alpine tar czf /backup/jenkins-backup.tar.gz /data
```

### Restaurer Jenkins
```bash
docker run --rm -v jenkins_home:/data -v $(pwd):/backup \
  alpine tar xzf /backup/jenkins-backup.tar.gz -C /
```

---

**Date de création** : 19/10/2025  
**Auteur** : chefm0ha