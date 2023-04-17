<?php
session_start();

$_SESSION['url'] = 'login.php';

?>


<html>
<head>
    <title>Formulaire d'identification</title>

    <?php


    include('connexionbdd.php');


    if (isset($_POST['connexion'])) {
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


                echo '<meta http-equiv="refresh" content="0;URL=sujetsblogs.php">';

            }



        } else {


        }
    }
    ?>
</head>

<body>
<form action="login.php" method="post">
    Votre login : <input type="text" name="login" id="login"  value="<?php echo $valeur['login'] ?>" />
    <br /><span class="erreur"><?php echo $erreur['login'] ?></span> <br />
    <br />
    Votre mot de passe : <input type="password" name="pwd" id="pwd" value="<?php echo $valeur['pwd'] ?>" />
    <br /><span class="erreur"><?php echo $erreur['pwd'] ?></span> <br />
    <br />
    <input type="submit" name="connexion" id="connexion" value="Connexion">
</form>

</body>
</html>