# Important

- Est ce que chaque image correspond a une dimension fixe
- Est ce que chaque partie de l'image aura une densité fixe (atevenana)

---

# I. Approche globale

## 1. Reception de l'image

De gauche a droite et de haut en bas :

- Devinez quelle est la couleur de ce pixel

## 2. Calcul de surface

Si c'est une nouvelle couleur :

- je crée cet nouvelle couleur et  
  je somme la couleur

Si c'est deja existant :

- J'ajoute a la somme existant a cette couleur

## 3. Estimation

Ensuite, j'obtiendrais les types de couleurs necessaires et aussi la surface necessaire pour chaque file

Je peut faire en sorte que :  
1px = 0.5cm²  

mais ça dependra de la dimension du resultat voulue.

Pour le temps et le cout :

Cela dependrait de la vitesse de la machine et le cout le prix pour chaque type de fil, la consommation de la machine (en electricité)

---

# II. Modele de données

## 1.

### Modele_Broderie

- Id
- Url_image

## 2.

### Parametre

- Nom
- Valeur

Ex :

| nom         | valeur |
|-------------|--------|
| pixel - mm² | 0.001  |

## 3.

### CouleurDetails

- IdProjet
- CodeExa
- NbPixel
- SurfaceMetreCarre

## 4.

### Machine

- id
- vitesseParCm
- consommationElectriciteParHeure

## 5.

### MachineProjet

- id
- idMachine
- ModeleBroderie
- Date

---

# IV. Risque

a) Qualité / résolution des images  
Risque : Une image de mauvaise qualité (floue, compressée) peut fausser la détection des couleurs.

b) Couleur proche / Melange

c) Le type de tissu peut variée en fonction du projet