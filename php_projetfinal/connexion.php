<?php

function connexion()
{
    $bdd = array();
    $bdd['SGBD'] = 'mysql';
    $bdd['HOST'] = 'devbdd.iutmetz.univ-lorraine.fr';
    $bdd ['PORT'] = '3306';
    $bdd['NOM'] = 'nicolle22u_projetphp';
    $bdd['USER'] = 'nicolle22u_appli';
    $bdd['PASSWORD'] = '_-_-_';

// ========================== // connection avec PDO
    try {
        $objPdo = new PDO($bdd['SGBD'] . ':host=' . $bdd['HOST'] . ';port =' . $bdd['PORT'] . ';dbname=' . $bdd['DB_NAME'],
            $bdd['USER'],
            $bdd['PASSWORD']);

        unset($bdd);

        echo 'Connecté à la base de données'. '<br />';

    } catch (Exception $exception) {
        die($exception->getMessage());
    }
// ==========================
    return $objPdo;
}


?>