function validateForm() {
    var result = true;
    var ERR_TEXT = "пароль не совпадает";
    var errPass =  document.getElementById("err-pass");
    var pass1 = document.forms[0]["password1"].value;
    var pass2 = document.forms[0]["password2"].value;


    if (pass1 !== pass2) {
        errPass.innerHTML = ERR_TEXT;
        document.forms[0]["password1"].value = "";
        document.forms[0]["password2"].value = "";
        result = false;
    }
    return result;

}





$('.form').find('input, textarea').on('keyup blur focus', function (e) {
  
  var $this = $(this),
      label = $this.prev('label');

	  if (e.type === 'keyup') {
			if ($this.val() === '') {
          label.removeClass('active highlight');
        } else {
          label.addClass('active highlight');
        }
    } else if (e.type === 'blur') {
    	if( $this.val() === '' ) {
    		label.removeClass('active highlight'); 
			} else {
		    label.removeClass('highlight');   
			}   
    } else if (e.type === 'focus') {
      
      if( $this.val() === '' ) {
    		label.removeClass('highlight'); 
			} 
      else if( $this.val() !== '' ) {
		    label.addClass('highlight');
			}
    }

});

$('.tab a').on('click', function (e) {
  
  e.preventDefault();
  
  $(this).parent().addClass('active');
  $(this).parent().siblings().removeClass('active');
  
  target = $(this).attr('href');

  $('.tab-content > div').not(target).hide();
  
  $(target).fadeIn(600);
  
});







particlesJS("particles-js", {
  "particles": {
    "number": {
      "value": 100,
      "density": {
        "enable": true,
        "value_area":1000
      }
    },
    "color": {
      "value": ["#18a27c", "#1fd0a0"]
    },
    
    "shape": {
      "type": "circle",
      "stroke": {
        "width": 0,
        "color": "#fff"
      },
      "polygon": {
        "nb_sides": 20
      },
    },
    "opacity": {
      "value": 0.8,
      "random": false,
      "anim": {
        "enable": false,
        "speed": 1,
        "opacity_min": 0.1,
        "sync": false
      }
    },
    "size": {
      "value": 3,
      "random": true,
      "anim": {
        "enable": false,
        "speed": 40,
        "size_min": 0.1,
        "sync": false
      }
    },
    "line_linked": {
      "enable": true,
      "distance": 80,
      "color": "#1ab188",
      "opacity": 0.9,
      "width": 2
    },
  },
  "interactivity": {
    "detect_on": "canvas",
    "events": {
      "onhover": {
        "enable": true,
        "mode": "grab"
      },
      "onclick": {
        "enable": false
      },
      "resize": true
    },
    "modes": {
      "grab": {
        "distance": 240,
        "line_linked": {
          "opacity": 1
        }
      },
      "bubble": {
        "distance": 600,
        "size": 80,
        "duration": 8,
        "opacity": 6,
        "speed": 3
      },
      "repulse": {
        "distance": 300,
        "duration": 0.4
      },
      "push": {
        "particles_nb": 2
      },
      "remove": {
        "particles_nb": 4
      }
    }
  },
  "retina_detect": true
});