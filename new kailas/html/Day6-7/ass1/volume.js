

// for playing audio
function play() {
  document.getElementById("myaudio").play();
}
// for pausing audio
function pause() {
  document.getElementById("myaudio").pause();
}
// for increasing volume
  function VolUp(){
    var audio_element = document.getElementById("myaudio");
            event.preventDefault();
            audio_vol = audio_element.volume;
            if (audio_vol!=1) {
              try {
                  audio_element.volume = audio_vol + 0.02;
              }
              catch(err) {
                  audio_element.volume = 1;
              }

            }
          }
          // for decreasing volume
        function VolDo(){
          var audio_element = document.getElementById("myaudio");
            event.preventDefault();
            audio_vol = audio_element.volume;
            if (audio_vol!=0) {
              try {
                  audio_element.volume = audio_vol - 0.02;
              }
              catch(err) {
                  audio_element.volume = 0;
              }

            }

    }
