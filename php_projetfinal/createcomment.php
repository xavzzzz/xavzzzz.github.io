<?php
session_start();
include "connexionbdd.php";

if(isset($_SESSION['login'])){

    //***
    // ajout du commentaire

    $req = 'INSERT INTO REDACTEUR (idsujet,idredacteur,textereponse,timestampp) VALUES(:idsujet,:idredacteur,:textereponse,CURRENT_TIME )';
    $insert = $objPdo->prepare($req);
    $insert->execute(array(':idsujet'=> $_POST['idsujet'],
        ':idredacteur'=> $_POST['idredacteur'],
        ':textereponse'=>$_POST['sujet'],));

    echo '<meta http-equiv="refresh" content="0;URL=indexxx.php">';
}
else{
    echo '<meta http-equiv="refresh" content="0;URL=indexxx.php">';
    echo '<meta http-equiv="refresh" content="0;URL= connexionboot.php">';
}

?>