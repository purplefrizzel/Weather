const close = document.getElementsByClassName("close-button");
let i;

for (i = 0; i < close.length; i++) {
    close[i].onclick = function() {
        const alert = this.parentElement;
        alert.style.opacity = "0";
        setTimeout(function() { alert.style.display = "none" }, 600);
    }
}