function showLocation(int){
    if (int == null){
        document.getElementById("txtHint").innerHTML = null;
        return;
    } else {
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function () {
            if (this.readyState == 4 & this.status == 200){
                document.getElementById("txtHint").innerHTML = this.responseType;
            }
        };
        xmlhttp.open("GET", "getlocation.php?q=" + int, true);
        xmlhttp.send();
    }
}