<?php
session_start();

function isconnex(){

    if(isset($_SESSION['login'])){
        return 'rédacteur connecté : '. $_SESSION['login'];
    }else{
        return false ;
    }


}

?>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css" />



    <script src="//cdnjs.cloudflare.com/ajax/libs/less.js/2.5.1/less.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

    <title> PHP Blogger - Connexion </title>
</head>
<body>

<div id="main" class="container">
<nav class="navbar navbar-expand-lg navbar-light">
    <a class="navbar-brand" href="indexxx.php"> <img style="height: 100px;" src="phpblogger.png" ></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav" style="">

            <?php
            if(isconnex()== false){
                echo '<a class="nav-item nav-link active" href="connexionboot.php">Connexion</a>';
                echo '<a class="nav-item nav-link disabled" titre="Indisponible mrci de vous connecté" href="#">Ajouter un Blog</a>';
            }else{
                echo " <a class='nav-item nav-link' onclick=\"return confirm('Vous souhaitez quitter votre session ?');\" href='logout.php'> Déconnexion</a>";
                echo '<a class="nav-item nav-link" titre="Indisponible mrci de vous connecté" href="createblog.php">Ajouter un Blog</a>';
            }
            ?>
        </div>
    </div>
</nav>


<?php

//verification et validation du formulaire de connexion


include('connexionbdd.php');


if (isset($_POST['valider'])) {
    $erreur = array();
    $valeur = array();

    if (!isset($_POST['login']) or strlen(trim($_POST['login'])) == 0) {
        $erreur['login'] = 'saisie obligatoire du login';
    } else {
        $valeur['nom'] = trim($_POST['nom']);
    }

    if (!isset($_POST['pwd']) or strlen(trim($_POST['pwd'])) == 0) {
        $erreur['pwd'] = 'saisie obligatoire du mot de passe';
    } else {
        $valeur['pwd'] = trim($_POST['pwd']);
    }

    if (count($erreur) == 0) {



        $stmt = $objPdo->prepare('SELECT COUNT(*) as nb FROM REDACTEUR WHERE motdepasse = ? 
                                        AND (pseudo = ? OR adressemail = ?)');

        $stmt->execute(array(($_POST['pwd']), $_POST['login'], ($_POST['login'])));
        $row = $stmt->fetch();

        if ($row['nb'] == 0) {
            // Le visiteur n'a pas été reconnu comme étant membre de notre site. On utilise alors un petit javascript lui signalant ce fait
            echo '<body onLoad="alert(\'Membre non reconnu...\')">';
            // puis on le redirige vers la page d'accueil



        } else {
            //  echo 'Identifiant reconnu';
            // enreistrement des variables de session
            $_SESSION['login'] = $_POST['login'];
            $_SESSION['pwd'] = $_POST['pwd'];

            // recupération de id redacteur


            $ident = $objPdo->prepare('SELECT idredacteur FROM REDACTEUR WHERE pseudo =?');
            $ident->execute(array($_POST['login']));
            $row = $ident->fetch();


            $_SESSION['id'] = $row['idredacteur'];


            echo '<meta http-equiv="refresh" content="0;URL=indexxx.php">';

        }



    } else {


    }
}

?>

<?php
// verification et validation du formulaire de creation
include('connexionbdd.php');

if (isset($_POST['creer'])) {

    $erreur = array();
    $valeur = array();


if (!isset($_POST['nom']) or strlen(trim($_POST['nom'])) == 0) {
    $erreur['nom'] = 'saisie obligatoire du nom';
} else {
    $valeur['nom'] = trim($_POST['nom']);
}


if (!isset($_POST['prenom']) or strlen(trim($_POST['prenom'])) == 0) {
    $erreur['prenom'] = 'saisie obligatoire du prenom';
} else {
    $valeur['prenom'] = trim($_POST['prenom']);
}


if (!isset($_POST['ad']) or strlen(trim($_POST['ad'])) == 0 or !filter_var($_POST['ad'],FILTER_VALIDATE_EMAIL) ){
    $erreur['ad'] = 'saisie obligatoire d une adresse mail valide';
} else {
    $valeur['ad'] = trim($_POST['ad']);
}

if (!isset($_POST['login']) or strlen(trim($_POST['login'])) == 0) {
    $erreur['login'] = 'saisie obligatoire du login';
} else {
    $valeur['login'] = trim($_POST['login']);
}

if (!isset($_POST['pwd']) or strlen(trim($_POST['pwd'])) == 0) {
    $erreur['pwd'] = 'saisie obligatoire du mot de passe';
} else {
    $valeur['pwd'] = trim($_POST['pwd']);
}

if (count($erreur) == 0) {



//verification membre existant

    $stmt = $objPdo->prepare('SELECT COUNT(*) as nb FROM REDACTEUR WHERE pseudo = ? OR adressemail = ?');

    $stmt->execute(array($_POST['login'], ($_POST['login'])));
    $row = $stmt->fetch();

        if ($row['nb'] == 0) {


        // ajout du membre

        $req = 'INSERT INTO REDACTEUR (nom,prenom,adressemail,motdepasse,pseudo) VALUES(:nom,:prenom,:adressemail,:motdepasse,:pseudo)';
        $insert = $objPdo->prepare($req);
        $insert->execute(array(':nom'=> $_POST['nom'],
        ':prenom'=> $_POST['prenom'],
        ':adressemail'=>$_POST['ad'],
        ':motdepasse'=> $_POST['pwd'],
        ':pseudo'=>$_POST['login']));


try {

$insert->execute();
unset($insert);

}
catch( Exception $exception ) {
die($exception->getMessage()) ; }

            echo '<meta http-equiv="refresh" content="0;URL=indexxx.php">';


} else {

echo '<body onLoad="alert(\'Rédacteur déja existant..\')">';

}
} else {


}
}
?>


<section>
</div>


<?php

    if(isconnex()==true){

        $notconnected = '<h5 > Bonne Connexion :) </h5>';

    }else{
        $notconnected = '    <div class="container col-6" >

        <ul class="nav nav-tabs">
            <li class="active"><a data-toggle="tab" href="#home">Se connecter </a></li>
            <li style="margin-left: 1vw;"><a data-toggle="tab" href="#create">Créer un compte</a></li>
        </ul>';
    }
    echo $notconnected;

?>

        <!-------------------------- FORMULAIRE DE CONNEXION ----------->

        <div class="tab-content">
            <div id="home" class="tab-pane fade in active">
                <form action="connexionboot.php" method="post" class="was-validated">
                    <div class="form-group">
                        <label for="login">Nom d'utilisateur :</label>
                        <input type="text" class="form-control" id="login" placeholder="" name="login" required
                               value="<?php echo $valeur['login'] ?>" />
                       <span class="erreur"><?php echo $erreur['login'] ?></span>
                        <div class="valid-feedback"></div>
                        <div class="invalid-feedback">Entrez votre nom d'utilisateur</div>
                    </div>
                    <div class="form-group">
                        <label for="pwd">Mot de passe :</label>
                        <input type="password" class="form-control" id="pwd" placeholder="" name="pwd" required
                               value="<?php echo $valeur['pwd'] ?>" />
                        <span class="erreur"><?php echo $erreur['pwd'] ?></span>
                        <div class="valid-feedback"></div>
                        <div class="invalid-feedback">Entrez votre mot de passe</div>
                    </div>
                    <button type="submit" class="btn btn-primary" name="valider">Valider</button>
                </form>
            </div>


            <!-------------------------- FORMULAIRE DE CRÉATION  ----------->

            <div id="create"class="tab-pane fade" style="height: 90%">
                <form action="connexionboot.php" method="post" class="was-validated"  >
                    <div class="form-group">
                        <label for="ad" class="control-label">Adresse mail:</label>
                        <input type="email" class="form-control" id="ad" placeholder="" name="ad" required
                               value="<?php echo $valeur['ad'] ?>" />
                        <span class="erreur"><?php echo $erreur['ad'] ?></span>
                        <div class="valid-feedback"></div>
                        <div class="invalid-feedback">Entrez une adresse mail valide</div>
                    </div>
                    <div class="form-group">
                        <label for="nom">Nom:</label>
                        <input type="text" class="form-control" id="nom" placeholder="" name="nom" required
                               value="<?php echo $valeur['nom'] ?>" />
                        <span class="erreur"><?php echo $erreur['nom'] ?></span>
                        <div class="valid-feedback"></div>
                        <div class="invalid-feedback">Entrez votre nom </div>
                    </div>
                    <div class="form-group">
                        <label for="prenom">Prénom:</label>
                        <input type="text" class="form-control" id="prenom" placeholder="" name="prenom" required
                               value="<?php echo $valeur['prenom'] ?>" />
                       <span class="erreur"><?php echo $erreur['prenom'] ?></span>
                        <div class="valid-feedback"></div>
                        <div class="invalid-feedback">Entrez votre prénom</div>
                    </div>
                    <div class="form-group">
                        <label for="login">Nom d'utilisateur:</label>
                        <input type="text" class="form-control" id="login" placeholder="" name="login" required
                               value="<?php echo $valeur['login'] ?>" />
                        <span class="erreur"><?php echo $erreur['login'] ?></span>
                        <div class="valid-feedback"></div>
                        <div class="invalid-feedback">Entrez un nom d'utilisateur</div>
                    </div>
                    <div class="form-group">
                        <label for="pwd">Mots de passe:</label>
                        <input type="password" class="form-control" id="pwd" placeholder="" name="pwd" required
                               value="<?php echo $valeur['pwd'] ?>" />
                        <span class="erreur"><?php echo $erreur['pwd'] ?></span>
                        <div class="valid-feedback"></div>
                        <div class="invalid-feedback">Entrez un mot de passe</div>
                    </div>
                    <button type="submit" class="btn btn-primary" name="creer">Créer</button>

                </form>
            </div>



        </div>
    </div>

</section>


<script>
    // Disable form submissions if there are invalid fields
    (function() {
        'use strict';
        window.addEventListener('load', function() {
            // Get the forms we want to add validation styles to
            var forms = document.getElementsByClassName('needs-validation');
            // Loop over them and prevent submission
            var validation = Array.prototype.filter.call(forms, function(form) {
                form.addEventListener('submit', function(event) {
                    if (form.checkValidity() === false) {
                        event.preventDefault();
                        event.stopPropagation();
                    }

                }, false);
            });
        }, false);
    })();
</script>

<?php

$test = isconnex();

if($test == false){
    echo '<footer> Aucun utilisateur connecté  - <a href="indexxx.php">Acceuil</a></footer>';
}else{
    echo '<footer> ' . $test . '  - <a href="indexxx.php">Acceuil</a></footer>';
}
?>

</body>


</html>


