

function swapPage1(){
  document.getElementById("radial1").style.opacity = 1;
  document.getElementById("radial1").style.transition = "opacity 1s ease";
  document.getElementById("radial2").style.opacity = 0;
  document.getElementById("radial3").style.opacity = 0;
  document.getElementById("explore").style.opacity = 1;
  document.location.reload(true);
}


function swapPage2(){
  document.getElementById("radial2").style.opacity = 1;
  document.getElementById("radial2").style.transition = "opacity 1s ease";
  document.getElementById("radial1").style.opacity = 0;
  document.getElementById("radial1").style.transition = "opacity 1s ease";

}

function swapPage3(){
  document.getElementById("explore").style.opacity = 0 ;
  document.getElementById("explore").style.transition = "opacity 1s ease";
  document.getElementById("radial3").style.opacity = 1;
  document.getElementById("radial3").style.transition = "opacity 1s ease";
  document.getElementById("radial1").style.opacity = 0;
  document.getElementById("radial1").style.transition = "opacity 1s ease";
}

function flow1(){
  document.getElementById("explore").style.opacity = 0 ;
  document.getElementById("explore").style.transition = "opacity 1s ease";


  document.getElementById("area11").style.transform="translate(-54.2%,-96.2%)";
  document.getElementById("area12").style.transform="translate(-54.2%,-96.2%)";
  document.getElementById('area11').style.transition = "0.9s ease";
  document.getElementById('area12').style.transition = "0.9s ease";

  document.getElementById("star1").style.transform="translate(406.8%,-404.5%)";
  document.getElementById("star6").style.transform="translate(-46.5%,-315%)";
  document.getElementById("star9").style.transform="translate(-180%,-460%)";

  document.getElementById('star1').style.width="3.75em";
  document.getElementById('star1').style.height="3.75em";
  document.getElementById('star1').style.transition = "width 0.9s height 0.9s ease";
  document.getElementById('star1').style.transition = "0.9s ease";

  document.getElementById('star6').style.width="3.75em";
  document.getElementById('star6').style.height="3.75em";
  document.getElementById('star6').style.transition = "width 0.9s height 0.9s ease";
  document.getElementById('star6').style.transition = "0.9s ease";

  document.getElementById('star9').style.width="3.75em";
  document.getElementById('star9').style.height="3.75em";
  document.getElementById('star9').style.transition = "width 0.9s height 0.9s ease";
  document.getElementById('star9').style.transition = "0.9s ease";
}


function flow2(){
  document.getElementById("explore").style.opacity = 0 ;
  document.getElementById("explore").style.transition = "opacity 1s ease";

  document.getElementById("area11").style.transform="translate(-54%,-96.2%)";
  document.getElementById("area12").style.transform="translate(38.5%,-124.5%)";
  document.getElementById('area11').style.transition = "0.9s ease";
  document.getElementById('area12').style.transition = "0.9s ease";

  document.getElementById("star4").style.transform="translate(-108%,-162%)";
  document.getElementById("star6").style.transform="translate(-193%,-606.7%)";
  document.getElementById("star9").style.transform="translate(-180%,-255%)";


  document.getElementById('star4').style.width="3.75em";
  document.getElementById('star4').style.height="3.75em";
  document.getElementById('star4').style.transition = "width 0.9s height 0.9s ease";
  document.getElementById('star4').style.transition = "0.9s ease";

  document.getElementById('star6').style.width="3.75em";
  document.getElementById('star6').style.height="3.75em";
  document.getElementById('star6').style.transition = "width 0.9s height 0.9s ease";
  document.getElementById('star6').style.transition = "0.9s ease";

  document.getElementById('star9').style.width="3.75em";
  document.getElementById('star9').style.height="3.75em";
  document.getElementById('star9').style.transition = "width 0.9s height 0.9s ease";
  document.getElementById('star9').style.transition = "0.9s ease";
}


    window.transitionToPage = function(href) {
        document.querySelector('body').style.opacity = 0
        setTimeout(function() {
            window.location.href = href
        }, 500)
    }

    document.addEventListener('DOMContentLoaded', function(event) {
        document.querySelector('body').style.opacity = 1
    })
