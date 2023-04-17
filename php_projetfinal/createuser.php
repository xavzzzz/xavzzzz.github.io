<?php

session_start();
?>

<html>
<head>
    <title>Formulaire de création </title>

    <?php

    echo session_id();

    include('connexionbdd.php');


    if (isset($_POST['creation'])) {

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


// if (isset($_POST['login']) && isset($_POST['pwd'])) {

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

                echo 'Membre créé dans la base';




                try {

                    $insert->execute();
                    unset($insert);

                }
                catch( Exception $exception ) {
                    die($exception->getMessage()) ; }

                    echo '<meta http-equiv="refresh" content="0;URL=login.php">';

            } else {

                echo '<body onLoad="alert(\'Membre déja existant..\')">';

            }
        } else {


        }
    }
    ?>
</head>

<body>
<form action="createuser.php" method="post">

    Votre Nom : <input type="text" name="nom" id="nom"  value="<?php echo $valeur['nom'] ?>" />
    <br /><span class="erreur"><?php echo $erreur['nom'] ?></span> <br />
    <br />

    Votre Prénom : <input type="text" name="prenom" id="prenom"  value="<?php echo $valeur['prenom'] ?>" />
    <br /><span class="erreur"><?php echo $erreur['prenom'] ?></span> <br />
    <br />

    Votre Adresse mail : <input type="text" name="ad" id="ad"  value="<?php echo $valeur['ad'] ?>" />
    <br /><span class="erreur"><?php echo $erreur['ad'] ?></span> <br />
    <br />

    Votre login : <input type="text" name="login" id="login"  value="<?php echo $valeur['login'] ?>" />
    <br /><span class="erreur"><?php echo $erreur['login'] ?></span> <br />
    <br />
    Votre mot de passe : <input type="password" name="pwd" id="pwd  value="<?php echo $valeur['pwd'] ?>" />
    <br /><span class="erreur"><?php echo $erreur['pwd'] ?></span> <br />
    <br />
    <input type="submit" name="creation" id="creation" value="Création">
</form>

</body>
</html>
