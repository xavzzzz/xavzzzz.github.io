<?php
session_start();

$_SESSION['url']='sujetsblogs.php';


include('connexionbdd.php');



$req = 'SELECT titresujet FROM SUJET ORDER BY datesujet DESC ';
$result=$objPdo->prepare($req);
$result->execute();



$liste ='<ul>';


foreach($result as $row) {

    $liste.='<li> '.$row['titresujet'].'</li>';
}



$liste.='</ul>';

unset($result);

?>


<html>
<head>
<meta charset="utf-8">
<title>Liste des sites</title>
<link rel="stylesheet" href="style/style.css"> </head>
<body>
<h1>Liste des sujets</h1>
<?php
echo($liste);

if (!isset($_SESSION['login'])) {

    echo '<a href="./connexionboot.php">Connexion</a>';
}
else {

echo " <a onclick=\"return confirm('Vous souhaitez quitter votre session ?');\" href='logout.php'> Déconnexion</a>";}

?> <br />

<?php if(isset($_SESSION['login'])){


    echo '<a href="./ajoutblog.php">Créer un Sujet</a>';

} ?> <br />

</body>


<footer>

    <h2>  Rédacteur connecté </h2>

    <?php  echo $_SESSION['login']; ?>


</footer>

</html>
