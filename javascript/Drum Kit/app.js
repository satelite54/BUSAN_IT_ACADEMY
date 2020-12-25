var button1 = document.querySelector('button');
button1.addEventListener('click', function(event) {
    alert('클림됨');
})

var btns = document.querySelectorAll('button.drum');

for(var i = 0; i < btns.length; i++) {
    btns[i].addEventListener('click', handleClick);
}

function handleClick() {
    var audio = new Audio('sounds/tom-1.mp3');
    audio.play();
}