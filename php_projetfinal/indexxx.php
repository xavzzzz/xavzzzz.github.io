
<!DOCTYPE html>
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


    <title>PHP Blogger</title>
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

    <?php
    include('connexionbdd.php');


    //fonction que on utilisera à chaque fois que on imprime un article pour aussi choper le nom et prenom de son redacteur
    function getredactname($idredact,$pdo){

        $redact = 'SELECT nom,prenom FROM REDACTEUR WHERE idredacteur= '.$idredact.'.';
        $q = $pdo->prepare($redact);
        $q->execute();

        foreach ($q as $row){
            $nom = $row['nom'];
            $prenom = $row['prenom'];
        }

        $fullredacteur = $nom." ".$prenom;
        return $fullredacteur;
    }

    function getusername($idredact,$pdo){

        $redact = 'SELECT pseudo FROM REDACTEUR WHERE idredacteur= '.$idredact.'.';
        $q = $pdo->prepare($redact);
        $q->execute();

        foreach ($q as $row){
            return $row['pseudo'];
        }

    }

    function isconnex(){

        if(isset($_SESSION['login'])){
            return 'rédacteur connecté : '. $_SESSION['login'];
        }else{
            return false;
        }


    }

    function connectedcomment(){

        if(isconnex() == true){

            return "faut restez sympa svp :)";
        }else{
            return "Vous devez vous connecté pour écrire un commentaire ou <a href='connexionboot.php'>crée un compte</a>";
        }
    }


    function getcomments($logged,$idsuj,$pdo){

        $commentfromsuj = 'SELECT * FROM REPONSE WHERE idsujet= '.$idsuj.'.';
        $q = $pdo->prepare($commentfromsuj);
        $q->execute();
        $lcdv=$q->fetch();
        if(!$lcdv){
            //par default on ecrit à l'utilisateur qu'il n'y a pas de commentaires
            $allcomments = "Il n'y pas encore de commentaires pour ce sujet.";
        }
        else {
            $allcomments = "";
            //on utilise le for each pour récupérer tout les commentaires associé à un sujet pr apres les return sur la page
            foreach ($q as $row) {

                $allcomments = $allcomments . '
            
             <p style="text-decoration: darkgreen; margin-bottom: 0"><i>'.getusername($logged,$pdo).' à écrit :</i></p>
            <div style="margin-bottom: 1vh"  class="row col-12">
               <textarea class="col-8" style="margin-top: 1vh; height: auto;"   title="'.$row['timestampp'].'" readonly>' . $row['textereponse'] . '</textarea>  
            </div>
            ';
            }
        }


        return $allcomments;
    }



    $prepared = 'SELECT * FROM SUJET ORDER BY datesujet DESC';
    $query = $objPdo->prepare($prepared);
    $query->execute();

    foreach($query as $row) {

        $prepared = 'SELECT nom,prenom FROM REDACTEUR WHERE idredacteur= '. $row['idredacteur'].'.';
        $q = $objPdo->prepare($prepared);
        $q->execute();

        $nom = $q->nom;   $prenom = $q->prenom;
        $fullredacteur = $nom." ".$prenom;

        //Creation dune cle pr donner un id à chaque boutton du blog ex. id = "1-1"
        $read = "{$row['idsujet']}-{$row['idredacteur']}";

        $format = '
         <div style="padding-top: 6vh" class="container col-12">
           <article class="article">
             <header class="header">
         <h1 class="headline">
           ' . $row['titresujet'] . '
        </h1>
         <div class="row col-12">
           <div class=" col-9">
             <span class="author">ÉCRIT PAR <span class="author-name"> <a  title="@'.getusername($row['idredacteur'],$objPdo).'" href="#"> '.getredactname($row['idredacteur'],$objPdo).' </a>
             </span></span>
             <span class="pub-date">le ' . $row['datesujet'] . '</span>
          </div>
                   
           <div class="container col-3">
               <button id="'.$read.'" style="margin-top: 0.2vh; margin-bottom: 2vh; width: 150px;" role="button" class="btn btn-success"
                       data-toggle="collapse"  aria-controls="'.$row['idsujet'].'" aria-expanded="false"
                       href= "#'.$row['idsujet'].'" name="button"><a>lire</a></button>
           </div>
            </div>  
         </header>
         
                             
            <div class="row col-12">
                <div class="collapse multi-collapse" id="'.$row['idsujet'].'">
                    <div style="" class="card card-body">
                        '.$row['textesujet'].'
                        
                        
                        <h4 style="margin-top: 2vh;">Commentaires</h4>                   
                        
                        '.getcomments($row['idredacteur'],$row['idsujet'],$objPdo).'

                
                <form style="padding-top: 4vh;" action="createcomment.php" method="post" class="was-validated">
                   
                    <div class="form-group commentaireform">
     
                        <input type="text" class="form-control" id="sujet" placeholder="" name="sujet" required
                               value="" />
                        <input type="hidden" value="'.$row['idredacteur'].'"  name="idredacteur" 
                        />  
                        <input type="hidden" value="'.$row['idsujet'].'"  name="idsujet" 
                        />      
                           
                        <div class="valid-feedback"></div>
                        <div class="invalid-feedback">'.connectedcomment().'</div>
                    </div>

                    <button type="submit" id="submit" class="btn btn-success" name="creer"> Commenter</button>

                </form>
                    </div>
         </article>
         </div>
       
            <script type="text/javascript">
         $(document).ready(function(){
             $("#'.$read.'").click(function() {
                 if($("#'.$read.'").text()=== "lire"){
                     $("#'.$read.'").text(\'cacher\');
                     $("#'.$row['idsujet'].'").show();
                 }
                 else{
                     $("#'.$read.'").text(\'lire\');
                     $("#'.$row['idsujet'].'").hide();
                 }
             })

         });
     </script>
       
       
       ';
        echo $format;
    }
    ?>
</div>


<?php

$test = isconnex();

    if($test == false){
    echo '<footer> Aucun utilisateur connecté </footer>';
    }else{
    echo '<footer> ' . $test . ' </footer>';
    }
?>
</body>


</html>
