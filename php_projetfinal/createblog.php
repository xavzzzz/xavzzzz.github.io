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

    <title>PHP Blogger - Créer un article </title>
</head>
<body>

<?php

if (isset($_POST['creer'])) {

    $erreur=array();
    $valeur=array();

    if (!isset($_POST['sujet']) or strlen(trim($_POST['sujet']))==0)
    {
        $erreur['sujet'] = 'saisie obligatoire du sujet';

    } else {
        $valeur['sujet'] = trim($_POST['sujet']);
    }


    if (!isset($_POST['texte']) or strlen(trim($_POST['texte']))==0)
    {
        $erreur['texte'] = 'saisie obligatoire du texte';

    } else {
        $valeur['texte'] = trim($_POST['texte']);
    }


    $valeur['id'] = $_SESSION['id'] ; // avec SESSION

    // $valeur['DATE'] = date('YYYY-MM-DD');



    if (count($erreur)==0) {

        require_once('connexionbdd.php');

        $req = 'INSERT INTO SUJET (idredacteur,titresujet,textesujet,datesujet) VALUES(:idredacteur,:sujet,:texte,:datesujet)';
        $insert = $objPdo->prepare($req);

        $insert->execute(array(':idredacteur'=>$valeur['id'],
            ':sujet'=>$_POST['sujet'],
            ':texte'=>$_POST['texte'],
            ':datesujet'=>date('Y-m-d')));

        echo '<meta http-equiv="refresh" content="0;URL=indexxx.php">';

        exit;


    }
    else {

        echo '<body onLoad="alert(\'Blog non créé..\')">';

    }


}
?>


<section class="container">

    <nav class="navbar navbar-expand-lg navbar-light">
        <a class="navbar-brand" href="indexxx.php"> <img style="height: 100px;" src="phpblogger.png" ></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav" style="">

                <?php
                if(isconnex()== false){
                    echo '<a class="nav-item nav-link" href="connexionboot.php">Connexion</a>';
                    echo '<a class="nav-item nav-link disabled" titre="Indisponible mrci de vous connecté" href="#">Ajouter un Blog</a>';
                }else{
                    echo " <a class='nav-item nav-link' onclick=\"return confirm('Vous souhaitez quitter votre session ?');\" href='logout.php'> Déconnexion</a>";
                    echo '<a class="nav-item nav-link" titre="Indisponible mrci de vous connecté" href="createblog.php">Ajouter un Blog</a>';
                }
                ?>
            </div>
        </div>
    </nav>


    <div class="container col-6" >


            <!-------------------------- FORMULAIRE DE CRÉATION  ----------->

                <form action="createblog.php" method="post" class="was-validated"  >
                    <div class="form-group">
                        <label for="sujet"> Sujet: </label>
                        <input type="text" class="form-control" id="sujet" placeholder="" name="sujet" required
                               value="<?php echo $valeur['sujet'] ?>" />
                        <span class="erreur"><?php echo $erreur['sujet'] ?></span>
                        <div class="valid-feedback"></div>
                        <div class="invalid-feedback">Entrez un sujet</div>
                    </div>
                    <div class="form-group">
                        <label for="texte">Texte :</label>
                        <textarea type="text"  class="form-control form-control-lg" id="texte" placeholder="" name="texte" required
                                  value="<?php echo $valeur['texte'] ?>" rows="5"></textarea>
                        <span class="erreur"><?php echo $erreur['texte'] ?></span>
                        <div class="valid-feedback"></div>
                        <div class="invalid-feedback">Entrez un texte</div>
                    </div>

                    <button type="submit" class="btn btn-primary" name="creer">Créer le blog </button>

                </form>
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


