<?php
// On démarre la session
session_start ();

// On détruit les variables de notre session
session_unset ();

// On détruit notre session
session_destroy ();

echo '<meta http-equiv="refresh" content="0;URL=indexxx.php">';

