<?php session_start(); ?>

<html>
<head>
    <meta charset="utf-8">
        <title>Ajout d'un blog</title>
    <link rel="stylesheet" href="style/style.css">
    <?php
       // include('connexionbdd.php');

    if (isset($_POST['ajouter'])) {

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

             echo '<meta http-equiv="refresh" content="0;URL=sujetsblogs.php">';

             exit;


    }
    else {

        echo '<body onLoad="alert(\'Sujet non créé..\')">';

    }


    }
?>

</head>
<body>
<h1>Ajout d'un blog </h1>

<form action="ajoutblog.php" method="post">


<label for="sujet">Sujet :</label>
  <input id="sujet" name="sujet" type="text" size="60" maxlength="60" value="
  <?php echo $valeur['sujet']; ?>" />
<br /> <span class="erreur"><?php echo $erreur['sujet']; ?></span> <br />


<label for="texte"> Texte :</label>
  <input id="texte" name="texte" type="text" size="200" maxlength="200" value="
  <?php echo $valeur['texte']; ?>" />
<br /> <span class="erreur"><?php echo $erreur['texte']; ?></span> <br />


<input type="submit" id="ajouter" name="ajouter" value="Ajouter" />

    <?php echo '<a href="./createuser.php">Annuler</a>'; ?> <br />

</form>
</body>

<footer>

    <h2>  Rédacteur connecté </h2>

    <?php  echo $_SESSION['login']; ?>


</footer>
</html>
