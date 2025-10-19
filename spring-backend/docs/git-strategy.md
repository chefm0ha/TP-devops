# Stratégie Git - Convention de branches

## Convention adoptée : Git Flow

Notre projet utilise **Git Flow**, une méthodologie éprouvée pour la gestion des branches.

## Structure des branches

### Branches principales

- **`main`** : Code en production, toujours stable
    - Merge uniquement via Pull Request depuis `develop`
    - Chaque merge = nouvelle version (tag)

- **`develop`** : Branche de développement principale
    - Intégration continue des features
    - Base pour toutes les nouvelles branches

### Branches de support

- **`feature/*`** : Nouvelles fonctionnalités
    - Créées depuis `develop`
    - Nomenclature : `feature/nom-descriptif`
    - Exemple : `feature/devops-setup`, `feature/add-authentication`
    - Merge dans `develop` via Pull Request

- **`hotfix/*`** : Corrections urgentes en production
    - Créées depuis `main`
    - Nomenclature : `hotfix/nom-du-bug`
    - Exemple : `hotfix/security-patch`
    - Merge dans `main` ET `develop`

## Workflow de développement

### Pour une nouvelle fonctionnalité

1. Créer une branche depuis `develop`
```bash
   git checkout develop
   git pull origin develop
   git checkout -b feature/ma-nouvelle-fonctionnalite
```

2. Développer et commiter régulièrement
```bash
   git add .
   git commit -m "feat: description de la modification"
```

3. Pousser la branche
```bash
   git push -u origin feature/ma-nouvelle-fonctionnalite
```

4. Créer une Pull Request sur GitHub : `feature/ma-nouvelle-fonctionnalite` → `develop`

5. Après validation, merger et supprimer la branche

### Pour un hotfix urgent

1. Créer une branche depuis `main`
```bash
   git checkout main
   git pull origin main
   git checkout -b hotfix/nom-du-bug
```

2. Corriger le bug et commiter
```bash
   git add .
   git commit -m "fix: correction du bug critique"
```

3. Merger dans `main` ET `develop`

## Convention de nommage des commits

Nous suivons la convention **Conventional Commits** :

- `feat:` nouvelle fonctionnalité
- `fix:` correction de bug
- `docs:` documentation
- `style:` formatage, missing semi-colons, etc.
- `refactor:` refactoring du code
- `test:` ajout ou modification de tests
- `chore:` maintenance, configuration

**Exemples :**
```
feat: add user authentication
fix: resolve null pointer exception in UserService
docs: update README with installation steps
chore: configure Jenkins pipeline
```

## Politique de merge

- **Rebase** : Pour les features courtes et simples
```bash
  git checkout develop
  git pull origin develop
  git checkout feature/ma-feature
  git rebase develop
```

- **Merge commit** : Pour les features importantes (historique préservé)
    - Via Pull Request sur GitHub
    - Nécessite au moins 1 review (dans un contexte pro)

## Protection des branches

Sur GitHub, nous protégeons les branches `main` et `develop` :
- Require pull request reviews before merging
- Require status checks to pass (CI/CD)
- No direct push to protected branches

## Tags et versions

Chaque release sur `main` est taguée avec un numéro de version :
```bash
git tag -a v1.0.0 -m "Release version 1.0.0"
git push origin v1.0.0
```

Format : **SemVer** (Semantic Versioning)
- v1.0.0 : Major.Minor.Patch
- v1.1.0 : Nouvelle feature (backward compatible)
- v1.0.1 : Bug fix
- v2.0.0 : Breaking change

## Schéma visuel
```
main        o---o---o---o---o (v1.0) (production)
             \       \       \
develop       o---o---o---o---o---o (développement actif)
               \   \       \
feature/x       o---o (merge)
                 \
feature/y         o---o---o (merge)
```

---

**Date de création** : 19/10/2025  
**Auteur** : chefm0ha  