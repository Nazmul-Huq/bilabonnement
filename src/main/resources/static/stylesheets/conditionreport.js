function showConditionReport(int){
    if (int == null){
        document.getElementById("conditionReport").innerHTML = "";
        return;
    }
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function (){
        document.getElementById("conditionReport").innerHTML = this.responseType;
    }
    xhttp.open("GET", "getconditionreport.php?q=" + int);
    xhttp.send();
}
